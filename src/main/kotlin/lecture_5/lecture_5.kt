package lecture_5

import kotlin.math.*

fun main() {
    example2()
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