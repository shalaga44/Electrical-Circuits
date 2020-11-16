@file:Suppress("UNREACHABLE_CODE")

package lecture_3

import ElectricalCircuits.*

fun main() {
    example2()
}

fun example2() {
    val E1 = 4.volt
    val r1 = 2.Ω

    val R = 4.Ω

    val E2 = 2.volt
    val r2 = 1.Ω

//    println("${E1.value} = I1${r1.value} + ((I1 + I2)${R.value})")
//    println("${E2.value} = I2${r2.value} + ((I1 + I2)${R.value})")

    val a = (r1 + R).value
    val b = R.value
    val e = E1.value
//    println("${a.toInt()} I1 + ${b.toInt()} I2 = ${e.toInt()}")
    val c = R.value
    val d = (r2 + R).value
    val f = E2.value
//    println("${c.toInt()} I1 + ${d.toInt()} I2 = ${f.toInt()}")

    val det = a * d - b * c
    val I1 = ((d * e - b * f) / det).ampere
    val I2 = ((a * f - c * e) / det).ampere
    println("I1= $I1")
    println("I2= $I2")

    val IR: Current = I1 + I2
    println("IR= $IR")
}

fun example1() {
    println("\n> A :Kirchhoff’s Current Law:")
    val I1 = 50.A - 20.A
    println("I1= $I1")
    val I2 = 20.A + 15.A
    println("I2= $I2")
    val I3 = I1 - 120.A
    println("I3= $I3")
    val I4 = 15.A - I3
    println("I4= $I4")
    val I5 = 40.A - 120.A
    println("I5= $I5")

    println("\n> B :Kirchhoff’s Voltage Law:")

//    val E: Voltage = T O D O()
//    val I: Current = T O D O()
//
//    3.V + 6.V + E - 4.V =
//        (I * 2.Ω) + (I * 2.5.Ω) + (I * 1.5.Ω) + (I * 1.5.Ω) + (I * 1)
//
//    3.V + 6.V + E - 4.V =
//        I * (2.Ω + 2.5.Ω + 1.5.Ω + 1.5.Ω + 1.Ω)


}
