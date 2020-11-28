package lecture_6

import kotlin.math.*


fun main() {
    example2()
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