package lecture_6

import kotlin.math.*


fun main() {
    example3()
}

fun example3() {
//    val QFactorL = Vl / V = IXl / IR = Xl / R = (2 * PI * f * L) / R
//    val QFactorC = Vc / V = IXc / IR = Xc / R = I / (2 * PI * C * R)
//    val QFactorF = (1.0 / R) * sqrt(L / C)
    val L = 80.0 / 1_000
    val C = 0.25 / 1_000_000
    val R = 12.5
    val V = 100

    val f = 1.0 / (2 * PI * sqrt(L * C))
    println("f=$f`")
    val I = V / R
    println("I=$I")
    val Vc = I / (2 * PI * f * C)
    val QFactorF = Vc / V
    println("QFactorF=$QFactorF")

}

fun example2() {
    val I = 100.0 / 1_000_000
    val V = 2.0 / 1_000
    val f = 200 * 1_000
    val L = 50.0 / 1_000_000
    val R = V / I
    println("R=$R")
    val C = 1.0 / ((2 * PI * f).pow(2) * L)
    println("C=$C")
}

fun example1() {
    val coilR = 10
    val L = 125.0 / 1_000
    val C = 60.0 / 1_000_000
    val V = 120
    val f = 1.0 / (2 * PI * sqrt(L * C))
    println("f=$f")
    val I = V / coilR
    println("I=$I")
}