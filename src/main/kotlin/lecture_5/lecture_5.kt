package lecture_5

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.math.tanh

fun main() {
    example1()
}

fun example1() {
    val R = 25.0
    val C = 45.0 / 1_000_000
    val f = 50
    val v = 240
    val CapavitiveReactance_Xc = 1.0 / (2 * PI * f * C)
    println("Xc=$CapavitiveReactance_Xc")
    val impedance = sqrt(R.pow(2) + CapavitiveReactance_Xc.pow(2))
    println("impedance=$impedance")
    val I = v / impedance
    println("current=$I")
    val angle = tanh(CapavitiveReactance_Xc / R)
    println("angle=${angle / PI * 180}")


}