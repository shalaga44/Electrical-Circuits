package ElectricalCircuits

open class PhysicalValue(open val value: Double) {
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
