fun main() {


}

fun example1() {
    // series
    val V = 24.V
    val I = 3.A
    val R = V / I
    val R0 = 2.ohm
    val R1 = R - R0
    println("R1= $R1")
    val V1 = R0 * I
    println("V1= $V1")
    val P: Power = (V * I)
    val E: Energy = P * 50.hours
    println("Energy= ${E.toKiloWattPerHoure()} kWh")

}

fun example2() {
    // parallel
    val A0 = 11.ampere
    val R1 = 5.ohm
    val A1 = 8.ampere
    val V = R1 * A1
    println("V= $V")
    val R3 = 20.ohm
    val A3 = V / R3
    println("A3= $A3")
    val A2: Current = listOf(A0, A1, A3)
        .sortedByDescending { it.value }
        .reduce { sub, elem -> sub - elem }
    println("A2= $A2")
    val R2 = V / A2
    println("R2= $R2")

}

fun example3() {
    // parallelA
    val R1 = 10.ohm
    val R2 = 20.ohm
    val A2 = 3.ampere
    val V = R2 * A2
    println("V= $V")
    val R3 = 60.ohm
    val A1 = V / R1
    val A3 = V / R3
    val I = A1 + A2 + A3
    println("I= $I")
    val R = V / I
    println("R= $R")

}

fun example4() {
    val A = 4.A
    val V1 = 5.volt
    val V2 = 2.volt
    val V3 = 6.volt
    val V = V1 + V2 + V3
    println("V= $V")

    val R1 = V1 / A
    println("R1= $R1")

    val R2 = V2 / A
    println("R2= $R2")

    val R3 = V3 / A
    println("R3= $R3")

    val R = R1 + R2 + R3
    println("R= $R")
}
