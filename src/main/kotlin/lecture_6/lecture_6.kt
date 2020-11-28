package lecture_6

import kotlin.math.*


fun main() {
    exmaple1()
}

fun exmaple1() {
    val coilR = 10
    val L = 125.0 / 1_000
    val C = 60.0 / 1_000_000
    val V = 120
    val f = 1.0 / (2 * PI * sqrt(L * C))
    println("f=$f")
    val I = V / coilR
    println("I=$I")
}