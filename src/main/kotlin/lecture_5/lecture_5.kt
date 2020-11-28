package lecture_5

import kotlin.math.*

fun main() {
    example4()
}

fun example4() {
    // C = 1.0/ ( (1.0/C0) + (1.0/C1) + (1.0/C2) )
    val V = 40.0
    val f = 20.0 * 1_000
    val R0 = 8

    val R1 = 5
    val Z1 = 130.0 / 1_000_000

    val R2 = 10
    val C = 0.25 / 1_000_000

    val resistance = (R0 + R1 + R2).toDouble()
    println("resistance=$resistance")
    val L = 130.0 / 1_000_000
    val Xl = 2 * PI * f * L
    println("inductanceReactance Xl =$Xl")
    val Xc = 1.0 / (2 * PI * f * C)
    println("capacitanceReactance Xc=$Xc")

    var Z = 0.0
    var angle = 0.0
    if (Xl > Xc) {
        Z = sqrt(resistance.pow(2) + (Xl - Xc).pow(2))
        angle = tanh((Xl - Xc) / resistance)

    } else if (Xc > Xl) {
        Z = sqrt(resistance.pow(2) + (Xc - Xl).pow(2))
        angle = tanh((Xc - Xl) / resistance)
    }
    println("Z=$Z")
    println("angel=${angle / PI * 180}")

    val I = V / Z
    println("I=$I")
    val V0 = I * R0
    println("V0=$V0")
    val V1 = I * Xc
    println("V1=$V1")
    val V2 = I * Z1
    println("V2=$V2")

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