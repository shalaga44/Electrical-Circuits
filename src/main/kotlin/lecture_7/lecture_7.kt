package lecture_7

import ElectricalCircuits.*
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt


fun main() {
    example5()
}

fun example5() {

}
fun example4() {
    val L = 120.mH
    val C = 25.µF
    val V = 100.V
    val f = 50.Hz
    val Xl = f * L * TwoPi
    println("Xl=$Xl")
    val Il = V / Xl
    println("Il=$Il")
    val Xc = One / (f * C * TwoPi)
    println("Xc=$Xc")
    val Ic = V / Xc
    println("Ic=$Ic")
    var I: Current = 0.ampere
    if (Il > Ic)
        I = Il - Ic
//    val I = sqrt(Ic.pow(2) + Il.pow(2)).ampere
    else
        I = Ic - Il

    println("I=$I")
    val angle = InverseSine(Il / I)
    println("angle=$angle")
    val Z = V / I
    println("Z=$Z")
    val P = V * I * Cosine(angle)
    println("P=$P")
}

fun example3() {
    val V = 120.V
    val f = 200.Hz
    val I = 2.A
    val powerFactor = 0.6
    val angle = acos(powerFactor)
    val Ir = I * cos(angle)
    val R = V / Ir
    println("R=$R")
    val Ic = I * sin(angle)
//    val Ic = V/Xc
//    val Ic = V / (1 / (f * C * TwoPi))
//    val Ic = V *f * C * TwoPi
    val C: Capacity = Ic / (V * f * TwoPi)
    println("C=$C")
}

fun example2() {
    val C: Capacity = 30.µF
    println(acos(10.0))
    val R = 80.ohm
    val V = 240.volt
    val f = 50.Hz
    val Xc = One / (f * C * TwoPi)
    val Ic = V / Xc
    println("Ic=$Ic")
    val Ir = V / R
    println("Ir=$Ir")
    val I = sqrt(Ir.pow(2) + Ic.pow(2)).ampere
    println("I=$I")
    val angle = InverseTangent(Ic / Ir)
    println("angle=$angle")
    val P = Ir.pow(2) * R
    println("P=$P")
}

fun example1() {
    val R = 20.ohm
    val L = 2.387.mH
    val V = 60.volt
    val f = 1.kHz
    val Ir = V / R
    println("Ir=$Ir")
    println(cos(10.0))
    val Xl = f * L * TwoPi
    val Il = V / Xl
    println("Il=$Il")
    val I = sqrt(Ir.pow(2) + Il.pow(2)).ampere
    println("I=$I")
    val angle = InverseTangent(Il / Ir)
    println("angle=$angle")
    val Z = V / I
    println("Z=$Z")
    val P = Ir.pow(2) * R
    println("P=$P")
}