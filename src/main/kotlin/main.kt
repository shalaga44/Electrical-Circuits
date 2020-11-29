import ElectricalCircuits.*
import ElectricalCircuits.seconds

fun main() {
//    val t = 10.seconds
////    val f = One / t
//    val f = 1.kHz
//    val L = 40.mH
//    val V = 100.volt
//    val Xl = (f * L) * TwoPi
//    println("Xl=$Xl")
//    val I = V / Xl
//    println("I=$I")
    val C = 10.microF
    println("C=$C")
    val f = 50.Hz
    println("f=$f")
    val Xc = One / (f * C * TwoPi)
    println("Xc=$Xc")

}


//fun force(m: Mass, a: Acceleration) = (m * a).newton
//fun Power(p: Energy, t: Time) = (p * t).watt
//fun Voltage(p: Power, I: Current) = (p / I).volt
//fun Voltage(p: Power, t: Time, i: Current) = (p / t / i).volt
//fun Voltage(p: Power, c: Charge) = (p / c).volt
//
//fun Resistance(V: Voltage, I: Current) = (V / I).ohm
//fun Conductance(I: Current, R: Resistance): Conductance = (I / R).simen
//fun ElectricalEnergy(p: Power, t: Time): Power = (p * t).watt
//

