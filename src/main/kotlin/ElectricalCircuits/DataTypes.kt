package ElectricalCircuits

import kotlin.math.PI
import kotlin.math.asin
import kotlin.math.atan
import kotlin.math.cos

class Frequency(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "Hz"
    operator fun times(L: Inductance) = _Frequency_Times_Inductance(this, L)
    operator fun times(C: Capacity) = _Frequency_Times_Capacitane(this, C)
    operator fun times(V: Voltage) = _Frequency_Times_Voltage(this, V)

}

val Number.Hz get() = Frequency(this.toDouble())
val Number.kHz get() = Frequency(this.toKilos().toDouble())


class _Frequency_Times_Capacitane(val frequency: Frequency, val capacity: Capacity) {
    operator fun times(twoPi: TwoPi) = _TwoPi_Times_Frequency_Times_Capacitane(frequency, capacity, twoPi)

}

class _TwoPi_Times_Frequency_Times_Capacitane(
    val frequency: Frequency,
    val capacity: Capacity,
    val twoPi: TwoPi = TwoPi,
) {

}

class _Frequency_Times_Inductance(val frequency: Frequency, val inductance: Inductance) {
    operator fun times(twoPi: TwoPi) = InductiveReactance(frequency, inductance, twoPi)


}

// XL
class InductiveReactance(frequency: Frequency, inductance: Inductance, twoPi: TwoPi = TwoPi) :
    Resistance(twoPi.value * frequency.value * inductance.value) {
}

// Xc
class CapacitiveReactance(frequency: Frequency, capacity: Capacity) :
    Resistance(1.0 / (TwoPi.value * frequency.value * capacity.value)) {
}


class Length(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "m"
}

val Number.m get() = Length(this.toDouble())
val Number.metre get() = Length(this.toDouble())

class Mass(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "kg"

    operator fun times(a: Acceleration): Force = (this.value * a.value).newton
}

val Number.kg get() = Mass(this.toDouble())
val Number.kilogram get() = Mass(this.toDouble())

class Time(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "seconds"

    operator fun times(e: Energy): Power = (this.value * e.value).watt
    operator fun times(I: Current): Charge = (this.value * I.value).coulomb
    operator fun times(P: Power): Energy = (this.value * P.value).joule
}

val Number.s get() = Time(this.toDouble())
val Number.seconds get() = Time(this.toDouble())
val Number.milliseconds get() = Time(this.toDouble() / 1_000)
val Number.hours get() = Time(this.toDouble() * 3_600)


class Force(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "N"

    operator fun div(mass: Mass): Acceleration = (this.value / mass.value).Acceleration
    operator fun div(a: Acceleration): Mass = (this.value / a.value).kg
}

val Number.N get() = Force(this.toDouble())
val Number.newton get() = Force(this.toDouble())

class Charge(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "coulombs"


}

val Number.C get() = Charge(this.toDouble())
val Number.coulomb get() = Charge(this.toDouble())

class Current(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "A"

    operator fun times(R: Resistance): Voltage = (this.value * R.value).volt
    operator fun times(E: Voltage): Power = (this.value * E.value).watt
    operator fun times(time: Time): Charge = (this.value * time.value).coulomb
    operator fun minus(other: Current) = (this.value - other.value).ampere
    operator fun plus(other: Current) = (this.value + other.value).ampere
    operator fun div(other: Current) = (this.value / other.value).ampere
    operator fun div(fV2Pi: _Frequency_Times_Voltage_Times_TwoPi): Capacity =
        (this.value / (fV2Pi.f.value * fV2Pi.V.value * fV2Pi.twoPi.value)).F

    operator fun times(d: Double): Current = (this.value * d).ampere
}

val Number.A get() = Current(this.toDouble())
val Number.ampere get() = Current(this.toDouble())

open class Resistance(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "Ω"

    operator fun times(I: Current): Voltage = (this.value * I.value).volt
    operator fun times(R: Resistance): Resistance = (this.value * R.value).ohm
    operator fun div(R: Resistance): Resistance = (this.value / R.value).ohm
    operator fun minus(other: Resistance) = (this.value - other.value).ohm
    operator fun plus(other: Resistance) = (this.value + other.value).ohm
    fun CurrentDivider(totalCurrent: Current, vararg resistances: Resistance): Current =
        totalCurrent * ((1.0 / (resistances.fold(1.0 / this) { acc, r -> ((1.0 / r) + acc) }) / this))

    fun VoaltageDivider(Vin: Voltage, vararg resistances: Resistance): Voltage =
        (Vin * (this.value / (resistances.fold(this) { acc, r -> acc + r })))

}

val Number.Ω get() = Resistance(this.toDouble())
val Number.ohm get() = Resistance(this.toDouble())

class Inductance(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "H"
    operator fun times(f: Frequency) = _Frequency_Times_Inductance(f, this)

}

val Number.H get() = Inductance(this.toDouble())
val Number.µH get() = Inductance(this.toMicros().toDouble())
val Number.mH get() = Inductance(this.toMillis().toDouble())

class Capacity(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "F"
    operator fun times(f: Frequency) = _Frequency_Times_Capacitane(f, this)


}

val Number.F get() = Capacity(this.toDouble())

//CRTL+SHIFT+U::b5
val Number.µF get() = Capacity(this.toDouble() / 1_000_000)
val Number.microF get() = Capacity(this.toDouble() / 1_000_000)


class Voltage(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "V"

    operator fun div(I: Current): Resistance = (this.value / I.value).ohm
    operator fun div(R: Resistance): Current = (this.value / R.value).ampere
    operator fun times(I: Current): Power = (this.value * I.value).watt
    operator fun times(V: Voltage): Voltage = (this.value * V.value).volt
    operator fun times(d: Double): Voltage = (this.value * d).volt
    operator fun plus(other: Voltage) = (this.value + other.value).volt
    operator fun minus(other: Voltage) = (this.value - other.value).volt
    operator fun times(f: Frequency) = _Frequency_Times_Voltage(f, this)
}

class _Frequency_Times_Voltage(val f: Frequency, val V: Voltage) {
    operator fun times(twoPi: TwoPi) = _Frequency_Times_Voltage_Times_TwoPi(f, V, twoPi)
}

class _Frequency_Times_Voltage_Times_TwoPi(val f: Frequency, val V: Voltage, val twoPi: TwoPi)

val Number.V get() = Voltage(this.toDouble())
val Number.volt get() = Voltage(this.toDouble())

class Conductance(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "S"

}

val Number.S get() = Conductance(this.toDouble())
val Number.simen get() = Conductance(this.toDouble())

class Energy(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "J"

    operator fun times(s: Time): Power = (this.value * s.value).watt
    fun toKiloWattPerHoure(): Double = this.value / 36_00_000
}

val Number.J get() = Energy(this.toDouble())
val Number.joule get() = Energy(this.toDouble())
val Number.kWh get() = Energy(this.toDouble() * 360_000_0)

class Power(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "W"

    operator fun times(time: Time): Energy = (this.value * time.value).joule
    operator fun times(a: Angle): Power = (this.value * a.value).W
}

val Number.W get() = Power(this.toDouble())
val Number.watt get() = Power(this.toDouble())

class Acceleration(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "m/s^2"

    operator fun times(mass: Mass): Force = (this.value * mass.value).newton
}

val Number.Acceleration get() = Acceleration(this.toDouble())

class Velocity(override var value: Double) : PhysicalValue(value) {
    override val symbol: String = "ms"

}

val Number.Velocity get() = Velocity(this.toDouble())

class Angle(override var value: Double) : PhysicalValue(value) {


    override val symbol: String = "°"
}

val Number.Angle get() = Angle(this.toDouble())

object One {
    operator fun div(t: Time): Frequency = (1.0 / t.value).Hz
    operator fun div(PIfC: _TwoPi_Times_Frequency_Times_Capacitane): CapacitiveReactance =
        CapacitiveReactance(PIfC.frequency, PIfC.capacity)
}

object TwoPi {
    operator fun times(fL: _Frequency_Times_Inductance) =
        InductiveReactance(fL.frequency, fL.inductance, this)

    operator fun times(fC: _Frequency_Times_Capacitane) =
        _TwoPi_Times_Frequency_Times_Capacitane(fC.frequency, fC.capacity, this)

    operator fun times(fV: _Frequency_Times_Voltage) =
        _Frequency_Times_Voltage_Times_TwoPi(fV.f, fV.V, this)


    val value = 2 * PI

}

fun InverseTangent(R: Resistance) = Angle(atan(R.value) / PI * 180.0)
fun InverseTangent(I: Current) = Angle(atan(I.value) / PI * 180.0)
fun InverseSine(I: Current) = Angle(asin(I.value) / PI * 180.0)
fun Cosine(a: Angle): Angle = ((cos(a.value * PI / 180.0)) / PI * 180.0).Angle
