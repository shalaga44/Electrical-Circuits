package ElectricalCircuits

import kotlin.math.pow
import kotlin.reflect.KFunction
import kotlin.reflect.typeOf

@OptIn(ExperimentalStdlibApi::class)

abstract class PhysicalValue(open var value: Double) : Comparable<PhysicalValue> {
    abstract val symbol: String
    override fun toString(): String {
        listOf('p', 'n', 'µ', 'm').zip((12 downTo 3 step 3)).forEach {
            if (value < 10f.pow(-(it.second - 3)))
                return "%.1f ${it.first}$symbol".format(value * 10f.pow(it.second))
        }

        if (value < 1f) return "%.3f $symbol".format(value)

        listOf('T', 'G', 'M', 'k').zip((12 downTo 3 step 3)).forEach {
            if (value >= 10f.pow(it.second))
                return "%.1f ${it.first}$symbol".format(value * 10f.pow(-it.second))
        }
        if (value <= 10f.pow(3)) return "%.1f $symbol".format(value)
        return "!!Bug in PhysicalValueKT::toString ($value $symbol)"
    }

    private val valueConstructor: KFunction<PhysicalValue>
        get() = this::class.constructors.filter { it.parameters.size == 1 }.first { kFunction ->
            kFunction.parameters.any {
                it.index == 0 && it.type == typeOf<Double>() && it.name == "value"
            }
        }

    override fun equals(other: Any?): Boolean = if (other is PhysicalValue) this.value == other.value else false

    //    operator fun times(other: PhysicalValue) = valueConstructor.call(this.value * other.value)
//    operator fun minus(other: PhysicalValue) = valueConstructor.call(this.value - other.value)
//    operator fun plus(other: PhysicalValue) = valueConstructor.call(this.value + other.value)
//    operator fun div(other: PhysicalValue) = valueConstructor.call(this.value / other.value)
//    operator fun rem(other: PhysicalValue) = valueConstructor.call(this.value % other.value)
    operator fun timesAssign(other: PhysicalValue) = run { this.value *= other.value }
    operator fun minusAssign(other: PhysicalValue) = run { this.value -= other.value }
    operator fun plusAssign(other: PhysicalValue) = run { this.value += other.value }
    operator fun divAssign(other: PhysicalValue) = run { this.value /= other.value }
    operator fun remAssign(other: PhysicalValue) = run { this.value %= other.value }
    override fun compareTo(other: PhysicalValue) = value.compareTo(other.value)
    override fun hashCode(): Int = 31 * value.hashCode() + symbol.hashCode()
    fun pow(times: Int): Double = this.value.pow(times)

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