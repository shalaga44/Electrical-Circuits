package lecture_4

import ElectricalCircuits.*
import kotlin.math.sqrt

fun main() {
    example1a()
}


fun example1a() {
    // a
    val time = 20.milliseconds
    val maxValue = 200
    val frequency = 1 / time.value
    val base = (time.value / 2)
    val r_m_s = sqrt((25..175 step 50).map { it * it }.sum() / 4.0)
    val triangleArea = (1.0 / 2) * base * maxValue
    val averageValueOfWaveform = triangleArea / base
    val formFactor = r_m_s / averageValueOfWaveform
    val peakFactor = maxValue / r_m_s
    println(peakFactor)
}