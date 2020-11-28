package lecture_7

import kotlin.math.*


fun main() {
    example2()
}

fun example2() {
    val C = 30.0 / 1_000_000
    val R = 80.0
    val V = 240.0
    val f = 50.0
    val Xc = 1.0 / (2 * PI * f * C)
    val Ic = V / Xc
    val Ir = V / R
    val I = sqrt(Ic.pow(2) + Ir.pow(2))
    println("I=$I")
    val angel = tanh(Ic / Ir)
    println("angel=${angel / PI * 180}")
    val Z = V / I
    println("Z=$Z")
    val dissipatedPower = R * Ir.pow(2)
    println("dissipatedPower=$dissipatedPower")
    val apparentPower = V * I
    println("apparentPower=$apparentPower")
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