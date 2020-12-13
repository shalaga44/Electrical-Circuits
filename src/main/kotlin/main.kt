import java.io.File
import java.io.InputStream
import java.util.*

fun main(args: Array<String>) {
    val inputStream: InputStream = File("collectingofficer.in").inputStream()
    val str = inputStream.bufferedReader().use { it.readText() }.trim()
    val sa = LongestCommonPrefixArray.SuffixArray(str)
    sa.display()
}

object LongestCommonPrefixArray {


    class SuffixArray(var T: IntArray) {
        // ALPHABET_SZ is the default alphabet size, this may need to be much
        // larger if you're using the LCS method with multiple sentinels
        var ALPHABET_SZ = 256
        var N: Int
        lateinit var lcp: IntArray
        var sa: IntArray
        var sa2: IntArray
        var rank: IntArray
        lateinit var tmp: IntArray
        var c: IntArray

        constructor(str: String) : this(toIntArray(str)) {}

        private fun construct() {
            var i: Int
            var p: Int
            var r: Int
            i = 0
            while (i < N) {
                c[T[i].also { rank[i] = it }]++
                ++i
            }
            i = 1
            while (i < ALPHABET_SZ) {
                c[i] += c[i - 1]
                ++i
            }
            i = N - 1
            while (i >= 0) {
                sa[--c[T[i]]] = i
                --i
            }
            p = 1
            while (p < N) {
                r = 0
                i = N - p
                while (i < N) {
                    sa2[r++] = i
                    ++i
                }
                i = 0
                while (i < N) {
                    if (sa[i] >= p) sa2[r++] = sa[i] - p
                    ++i
                }
                Arrays.fill(c, 0, ALPHABET_SZ, 0)
                i = 0
                while (i < N) {
                    c[rank[i]]++
                    ++i
                }
                i = 1
                while (i < ALPHABET_SZ) {
                    c[i] += c[i - 1]
                    ++i
                }
                i = N - 1
                while (i >= 0) {
                    sa[--c[rank[sa2[i]]]] = sa2[i]
                    --i
                }
                sa2[sa[0]] = 0.also { r = it }
                i = 1
                while (i < N) {
                    if (!(rank[sa[i - 1]] == rank[sa[i]] && sa[i - 1] + p < N && sa[i] + p < N && rank[sa[i - 1] + p] == rank[sa[i] + p])) r++
                    sa2[sa[i]] = r
                    ++i
                }
                tmp = rank
                rank = sa2
                sa2 = tmp
                if (r == N - 1) break
                ALPHABET_SZ = r + 1
                p = p shl 1
            }
        }

        // Use Kasai algorithm to build LCP array
        private fun kasai() {
            lcp = IntArray(N)
            val inv = IntArray(N)
            for (i in 0 until N) inv[sa[i]] = i
            var i = 0
            var len = 0
            while (i < N) {
                if (inv[i] > 0) {
                    val k = sa[inv[i] - 1]
                    while (i + len < N && k + len < N && T[i + len] == T[k + len]) len++
                    lcp[inv[i] - 1] = len
                    if (len > 0) len--
                }
                i++
            }
        }

        fun display() {
//            System.out.printf("-----i-----SA-----LCP---Suffix\n")
            for (i in 0 until N) {
                val suffixLen = N - sa[i]
                val suffix = String(T, sa[i], suffixLen)
                if ((lcp[i] > 0) || sa[i] > 0) {
                    println(suffix.length)
                    break
                }
//                System.out.printf("% 7d % 7d % 7d %s\n", i, sa[i], lcp[i], suffix)
            }
        }

        companion object {
            private fun toIntArray(s: String): IntArray {
                val text = IntArray(s.length)
                for (i in 0 until s.length) text[i] = s[i].toInt()
                return text
            }
        }

        // Designated constructor
        init {
            N = T.size
            sa = IntArray(N)
            sa2 = IntArray(N)
            rank = IntArray(N)
            c = IntArray(Math.max(ALPHABET_SZ, N))
            construct()
            kasai()
        }
    }
}