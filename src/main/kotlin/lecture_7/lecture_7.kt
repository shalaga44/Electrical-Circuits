package lecture_7

import kotlin.math.*


fun main() {
    example1()
}

fun example1() {
    val R = 20.0
    val L = 2.387 / 1_000
    val V = 60.0
    val f = 1.0 * 1_000
    val Ir = V / R
    println("Ir=$Ir")
    val Xl = 2.0 * PI * f * L
    val Il = V / Xl
    println("Il=$Il")
    val I = sqrt(Ir.pow(2) + Il.pow(2))
    println("I=$I")
    val angle = tanh(Il / Ir)
    println("angle=${angle / PI * 180}")
    val Z = V / I
    println("Z=$Z")

    val Power = R * Ir.pow(2)
    println("Power=$Power")
}