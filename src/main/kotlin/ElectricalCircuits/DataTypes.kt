package ElectricalCircuits

data class Frequency(override val value: Double) : PhysicalValue(value) {
    override fun toString() = "$value Hz"
}

val Number.Hz get() = Frequency(this.toDouble())


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
}

val Number.A get() = Current(this.toDouble())
val Number.ampere get() = Current(this.toDouble())

data class Resistance(override val value: Double) : PhysicalValue(value) {
    operator fun times(I: Current): Voltage = (this.value * I.value).volt
    operator fun minus(other: Resistance) = (this.value - other.value).ohm
    operator fun plus(other: Resistance) = (this.value + other.value).ohm
    override fun toString() = "$value Ω"
}

val Number.Ω get() = Resistance(this.toDouble())
val Number.ohm get() = Resistance(this.toDouble())

data class Voltage(override val value: Double) : PhysicalValue(value) {
    operator fun div(I: Current): Resistance = (this.value / I.value).ohm
    operator fun div(R: Resistance): Current = (this.value / R.value).ampere
    operator fun times(I: Current): Power = (this.value * I.value).watt
    operator fun plus(other: Voltage) = (this.value + other.value).volt
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


