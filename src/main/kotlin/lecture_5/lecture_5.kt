package lecture_5

import kotlin.math.*

fun main() {
    example3()
}

fun example3() {
    // Xl > Xc
    // Z = sqrt(R.pow(2) + (Xl - Xc).pow(2))
    // angle = tanh((Xl - Xc)/R)

    // Xc < Xl
    // Z = sqrt(R.pow(2) + (Xc - Xl).pow(2))
    // angle = tanh((Xc - Xl)/R)

    // Xc == Xl
    // Bla Bla Bla Bla

    val R = 5.0
    val L = 120.0 / 1_000
    val C = 100.0 / 1_000_000
    val V = 300.0
    val f = 50.0
    val Xl = 2.0 * PI * f * L
    val Xc = 1.0 / (2 * PI * f * C)
    println("Xc=$Xc")
    println("Xl=$Xl")
    var Z = 0.0
    var angle = 0.0
    if (Xl > Xc) {
        Z = sqrt(R.pow(2) + (Xl - Xc).pow(2))
        angle = tanh((Xl - Xc) / R)

    } else if (Xc > Xl) {
        Z = sqrt(R.pow(2) + (Xc - Xl).pow(2))
        angle = tanh((Xc - Xl) / R)
    }

    println("Z=$Z")
    println("angel=${angle / PI * 180}")


    val I = V / Z
    println("I=$I")
    val impedanceOfR = sqrt(R.pow(2) + Xl.pow(2))
    val VinR = I * impedanceOfR
    println("V in R=$VinR")

    val angleInR = tanh(Xl / R)
    println("angle=${angleInR / PI * 180}")

    val VinC = I * Xc
    println("V in C=$VinC")

}

fun example2() {
    val R = 40.0
    val f = 60
    val I = 3
    val Z = 50.0
    val Xc = sqrt(Z.pow(2) - R.pow(2))
    println("Xc=$Xc")
    val C = 1.0 / (2 * PI * f * Xc)
    println("C=${C / 1_000_000}uF")
    val angle = tanh(Xc / R)
    println("angle=${angle / PI * 180}")
    val pdCrossR = I * R
    println("p.d. in R=$pdCrossR")
    val pdCorrsC = I * Xc
    println("p.d. in R=$pdCorrsC")

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