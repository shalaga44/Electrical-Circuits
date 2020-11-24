package lecture_3

import ElectricalCircuits.*

fun main() {
    example8()
}

fun example8() {
    val E0 = 4.volt
    val R0 = 2.ohm
    val E1 = 2.volt
    val R1 = 1.ohm
    val R = 4.ohm

    // del R
    val I0 = E0 / R0
    val I1 = E1 / R1
    val Isc = I0 + I1
    println("Isc=$Isc")

    // del E
    val r = (R0 * R1) / (R0 + R1)
    println("r=$r")

    // sum it up
    val IinR = R.CurrentDivider(Isc, r)
    println("I in R=$IinR")

}

fun example7() {
    val E = 10.volt
    val R0 = 2.ohm
    val R1 = 8.ohm
    val R2 = 5.ohm
    val R = 10.ohm

    // del R
    val Isc = E / R0
    println("Isc=$Isc")

    // del E
    val r = (R0 * R1) / (R0 + R1)
    println("r=$r")

    // sum it up
    val IinR = (R + R2).CurrentDivider(Isc, r)
    println("I in R=$IinR")

}

fun example6() {
    val E = 24.volt
//    val R0 = 20.ohm
    val R1 = 5.ohm
    val R2 = 10.ohm
    val R3 = (1.0 + (2.0 / 3.0)).ohm
    val R = 3.ohm

    // del R
    val pd_R2 = R2.VoaltageDivider(E, R1)
    println("P.d. in R2=$pd_R2")

    // del E
    val r = R3 + ((R1 * R2) / (R1 + R2))
    println("r=$r")

    // sum it up
    val IinR = pd_R2 / (r + R)
    println("I in R=$IinR")
}

fun example5() {
    val E = 12.volt
    val r1 = 1.ohm
    val r2 = 5.ohm
    val r3 = 4.ohm

    val R = 0.8.ohm
    //del R
    val I1 = E / (r1 + r2 + r3)
    println("I1=$I1")
    val pd_r3 = I1 * r3
    println("P.d. in r2=$pd_r3")
    // del E
    val newR0 = r1 + r2
    val r = (newR0 * r3) / (newR0 + r3)
    println("r=$r")
    // sum it up
    val IinR = pd_r3 / (R + r)
    println("I in R=$IinR")


}

fun `Thévenin’s theorem`() {
    val R1 = 2.ohm
    val E = 10.volt
    val R2 = 8.ohm
    val R = 10.ohm
    val R3 = 5.ohm

    // del R
    val I1 = E / (R1 + R2)
    println("I=$I1")
    val pd_R2 = I1 * R2
    println("P.d. accros R2=$pd_R2")

    // del E
    val r = R3 + (R1 * R2) / (R1 + R2)
    println("r=$r")

    // sum it up
    val IinR = pd_R2 / (r + R)
    println("I in R=$IinR")
}

fun example4() {
    val E1 = 4.volt
    val r1 = 2.ohm

    val R = 4.ohm

    val E2 = 2.volt
    val r2 = 1.ohm

    // del E2
    val newR0 = (R * r2) / (R + r2)
    val I1 = E1 / (newR0 + r1)
    println("I1=$I1")
    val I2 = R.CurrentDivider(I1, r2)
    println("I2=$I2")
    val I3 = r2.CurrentDivider(I1, R)
    println("I3=$I3")

    // del E1
    val newR1 = (R * r1) / (R + r1)
    val I4 = E2 / (newR1 + r2)
    println("I4=$I4")
    val I5 = R.CurrentDivider(I4, r1)
    println("I5=$I5")
    val I6 = r1.CurrentDivider(I4, R)
    println("I6=$I6")

    // sum it up
    val currentLeft = I1 - I6
    println("currentLeft=$currentLeft")
    val currentRight = I3 - I4
    println("currentRight=$currentRight")
    val currentInR = I2 + I5
    println("currentInR=$currentInR")


}

fun example3() {
    val R1 = 0.5.ohm
    val E1 = 4.volt
    val E2 = 12.volt
    val R2 = 2.ohm
    val R3 = 5.ohm

//    E1 + E2 = (I1 * R1) + (I2 * R2)
    val a = R1.value
    val b = R2.value
    val e = (E1 + E2).value

//    E2 = (I2 * R2) - ((I1 - I2) * R3)
//    E2 = (I2 * R2) - (I1 * R3) - (I2 * R3)
//    E2 = (I2 * (R2+R3)) - (I1 * R3)
    val c = -(R3).value
    val d = (R2 + R3).value
    val f = E2.value

    val det = a * d - b * c
    val I1 = ((d * e - b * f) / det).ampere
    val I2 = ((a * f - c * e) / det).ampere
    println("I1= $I1")
    println("I2= $I2")

    val IR: Current = I1 - I2
    println("IR= $IR")

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







