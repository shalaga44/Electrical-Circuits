package ElectricalCircuits

import kotlin.math.*

abstract class PhysicalValue(open val value: Double) {
    abstract val symbol: String
    override fun toString(): String = when {
        value < 10f.pow(-9) -> "%.1f p$symbol".format(value * 10f.pow(12))
        value < 10f.pow(-6) -> "%.1f n$symbol".format(value * 10f.pow(9))
        value < 10f.pow(-3) -> "%.1f µ$symbol".format(value * 10f.pow(6))
        value < 10f.pow(-1) -> "%.1f m$symbol".format(value * 10f.pow(3))
        value < 1f -> "%.3f $symbol".format(value)
        value >= 10f.pow(12) -> "%.1f T$symbol".format(value * 10f.pow(-12))
        value >= 10f.pow(9) -> "%.1f G$symbol".format(value * 10f.pow(-9))
        value >= 10f.pow(6) -> "%.1f M$symbol".format(value * 10f.pow(-6))
        value >= 10f.pow(3) -> "%.1f k$symbol".format(value * 10f.pow(-3))
        value <= 10f.pow(3) -> "%.1f $symbol".format(value)
        else -> "!!Bug in PhysicalValueKT::toString ($value $symbol) "
    }

//    operator fun plus(other: PhysicalValue) = value + other.value
//    operator fun minus(other: PhysicalValue) = value - other.value
//    operator fun times(other: PhysicalValue) = value * other.value
//    operator fun div(other: PhysicalValue) = value / other.value
//    operator fun rem(other: PhysicalValue) = value % other.value


}

operator fun Double.div(v: PhysicalValue): Double = this / v.value
operator fun Double.rem(v: PhysicalValue): Double = this % v.value
operator fun Double.times(v: PhysicalValue): Double = this * v.value
operator fun Double.minus(v: PhysicalValue): Double = this - v.value
operator fun Double.plus(v: PhysicalValue): Double = this + v.value

fun Number.toTeras() = this.toDouble() * 1_000_000_000_000
fun Number.toGigas() = this.toDouble() * 1_000_000_000
fun Number.toMegas() = this.toDouble() * 1_000_000
fun Number.toKilos() = this.toDouble() * 1_000
fun Number.toMillis() = this.toDouble() / 1_000
fun Number.toMicros() = this.toDouble() / 1_000_000
fun Number.toNonos() = this.toDouble() / 1_000_000_000
fun Number.toPicos() = this.toDouble() / 1_000_000_000_000