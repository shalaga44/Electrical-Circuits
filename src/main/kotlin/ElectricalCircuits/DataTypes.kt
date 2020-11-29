package ElectricalCircuits

import kotlin.math.PI

data class Frequency(override val value: Double) : PhysicalValue(value) {
    override fun toString() = "$value Hz"
    operator fun times(l: Inductance) = Frequency_Times_Inductance(this, l)
}

class Frequency_Times_Inductance(val frequency: Frequency, val inductance: Inductance) {
    operator fun times(twoPi: My2PI) = InductiveReactance(frequency, inductance)


}

// XL
class InductiveReactance(frequency: Frequency, inductance: Inductance) :
    Resistance(TwoPi.value * frequency.value * inductance.value) {

}

val Number.Hz get() = Frequency(this.toDouble())
val Number.kHz get() = Frequency(this.toDouble() * 1_000)


data class Length(override val value: Double) : PhysicalValue(value) {
    override fun toString() = "$value m"
}

val Number.m get() = Length(this.toDouble())
val Number.metre get() = Length(this.toDouble())

data class Mass(override val value: Double) : PhysicalValue(value) {
    operator fun times(a: Acceleration): Force = (this.value * a.value).newton
    override fun toString() = "$value kg"
}

val Number.kg get() = Mass(this.toDouble())
val Number.kilogram get() = Mass(this.toDouble())

data class Time(override val value: Double) : PhysicalValue(value) {
    operator fun times(e: Energy): Power = (this.value * e.value).watt
    operator fun times(I: Current): Charge = (this.value * I.value).coulomb
    operator fun times(P: Power): Energy = (this.value * P.value).joule
    override fun toString() = "$value seconds"
}

val Number.s get() = Time(this.toDouble())
val Number.seconds get() = Time(this.toDouble())
val Number.milliseconds get() = Time(this.toDouble() / 1_000)
val Number.hours get() = Time(this.toDouble() * 3_600)


data class Force(override val value: Double) : PhysicalValue(value) {
    operator fun div(mass: Mass): Acceleration = (this.value / mass.value).Acceleration
    operator fun div(a: Acceleration): Mass = (this.value / a.value).kg
    override fun toString() = "$value N"
}

val Number.N get() = Force(this.toDouble())
val Number.newton get() = Force(this.toDouble())

data class Charge(override val value: Double) : PhysicalValue(value) {
    override fun toString() = "$value coulombs"

}

val Number.C get() = Charge(this.toDouble())
val Number.coulomb get() = Charge(this.toDouble())

data class Current(override val value: Double) : PhysicalValue(value) {
    operator fun times(R: Resistance): Voltage = (this.value * R.value).volt
    operator fun times(E: Voltage): Power = (this.value * E.value).watt
    operator fun times(time: Time): Charge = (this.value * time.value).coulomb
    operator fun minus(other: Current) = (this.value - other.value).ampere
    operator fun plus(other: Current) = (this.value + other.value).ampere
    override fun toString() = "$value A"
    operator fun times(d: Double): Current = (this.value * d).ampere
}

val Number.A get() = Current(this.toDouble())
val Number.ampere get() = Current(this.toDouble())

open class Resistance(override val value: Double) : PhysicalValue(value) {
    operator fun times(I: Current): Voltage = (this.value * I.value).volt
    operator fun times(R: Resistance): Resistance = (this.value * R.value).ohm
    operator fun div(R: Resistance): Resistance = (this.value / R.value).ohm
    operator fun minus(other: Resistance) = (this.value - other.value).ohm
    operator fun plus(other: Resistance) = (this.value + other.value).ohm
    override fun toString() = "$value Ω"
    fun CurrentDivider(totalCurrent: Current, vararg resistances: Resistance): Current =
        totalCurrent * ((1.0 / (resistances.fold(1.0 / this) { acc, r -> ((1.0 / r) + acc) }) / this))

    fun VoaltageDivider(Vin: Voltage, vararg resistances: Resistance): Voltage =
        (Vin * (this.value / (resistances.fold(this) { acc, r -> acc + r })))

}

val Number.Ω get() = Resistance(this.toDouble())
val Number.ohm get() = Resistance(this.toDouble())

data class Inductance(override val value: Double) : PhysicalValue(value) {
    operator fun times(f: Frequency) = Frequency_Times_Inductance(f, this)


}

val Number.H get() = Inductance(this.toDouble())
val Number.mH get() = Inductance(this.toDouble() / 1_000)


data class Voltage(override val value: Double) : PhysicalValue(value) {
    operator fun div(I: Current): Resistance = (this.value / I.value).ohm
    operator fun div(R: Resistance): Current = (this.value / R.value).ampere
    operator fun times(I: Current): Power = (this.value * I.value).watt
    operator fun times(V: Voltage): Voltage = (this.value * V.value).volt
    operator fun times(d: Double): Voltage = (this.value * d).volt
    operator fun plus(other: Voltage) = (this.value + other.value).volt
    operator fun minus(other: Voltage) = (this.value - other.value).volt
    override fun toString() = "$value V"
}

val Number.V get() = Voltage(this.toDouble())
val Number.volt get() = Voltage(this.toDouble())

data class Conductance(override val value: Double) : PhysicalValue(value) {
    override fun toString() = "$value S"
}

val Number.S get() = Conductance(this.toDouble())
val Number.simen get() = Conductance(this.toDouble())

data class Energy(override val value: Double) : PhysicalValue(value) {
    operator fun times(s: Time): Power = (this.value * s.value).watt
    fun toKiloWattPerHoure(): Double = this.value / 36_00_000
    override fun toString() = "$value J"
}

val Number.J get() = Energy(this.toDouble())
val Number.joule get() = Energy(this.toDouble())
val Number.kWh get() = Energy(this.toDouble() * 36_00_000)

data class Power(override val value: Double) : PhysicalValue(value) {
    operator fun times(time: Time): Energy = (this.value * time.value).joule
    override fun toString() = "$value W"
}

val Number.W get() = Power(this.toDouble())
val Number.watt get() = Power(this.toDouble())

data class Acceleration(override val value: Double) : PhysicalValue(value) {
    operator fun times(mass: Mass): Force = (this.value * mass.value).newton
    override fun toString() = "$value m/s^2"
}

val Number.Acceleration get() = Acceleration(this.toDouble())

data class Velocity(override val value: Double) : PhysicalValue(value)

val Number.Velocity get() = Velocity(this.toDouble())

class MyOne {
    operator fun div(t: Time): Frequency = (1.0 / t.value).Hz
}

class My2PI {
    operator fun times(fL: Frequency_Times_Inductance) =
        InductiveReactance(fL.frequency, fL.inductance)


    val value = 2 * PI

}

val One = MyOne()
val TwoPi = My2PI()
