package lecture_3

import ElectricalCircuits.A

fun main() {
    example1()
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

//    val E: Voltage = TODO()
//    val I: Current = TODO()
//
//    3.V + 6.V + E - 4.V =
//        (I * 2.Ω) + (I * 2.5.Ω) + (I * 1.5.Ω) + (I * 1.5.Ω) + (I * 1)
//
//    3.V + 6.V + E - 4.V =
//        I * (2.Ω + 2.5.Ω + 1.5.Ω + 1.5.Ω + 1.Ω)


}

