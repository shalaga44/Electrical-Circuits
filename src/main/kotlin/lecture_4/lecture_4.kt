package lecture_4

import ElectricalCircuits.*
import kotlin.math.sqrt

fun main() {
    example1b()
}

fun example1b() {
    val time = 16.milliseconds.value
    val maxValue = 10
    val frequency = 1.0 / time
    println("frequency=${frequency.Hz}")
    val base = time / 2.0
    val areaSqure = base * maxValue
    val averageValueOfWaveform = areaSqure / base
    println("averageValueOfWaveform=${averageValueOfWaveform.A}")
    val r_m_s = sqrt((0..10 step 10).map { it * it }.sum().toDouble())
    println("r.m.s=${r_m_s.A}")
    val formFactor = r_m_s / averageValueOfWaveform
    println("formFactor=$formFactor")
    val peakValue = maxValue / r_m_s
    println("peakValue=$peakValue")
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