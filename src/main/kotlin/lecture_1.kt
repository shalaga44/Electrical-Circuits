fun main() {
    val force = 10.kg * 5.Acceleration
    val acceleration = 10.newton / 10.kg
    val mass = 10.newton / 10.Acceleration
    println("$force $acceleration $mass")
    val resistance = 10.volt / 10.ampere
    val voltage = 10.ampere * 10.ohm
    val current = 10.volt / 10.ohm
    val power = 10.ampere * 10.volt
    println("$resistance $voltage $current $power")
    val charge = 10.ampere * 1.seconds
    val energy = 10.watt * 10.seconds
    println("$charge $energy")
}