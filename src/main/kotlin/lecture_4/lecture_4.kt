package lecture_4

import ElectricalCircuits.*
import kotlin.math.*

fun main() {
    example7()
}

fun example7() {
    val coilR = 4.0
    val inductance = 9.55 / 1_000
    val frequency = 50
    val v = 240
    val reactance = 2 * PI * frequency * inductance
    println("reactance=${reactance.ohm}")
    val impedance = sqrt(coilR.pow(2) + reactance.pow(2))
    println("impedance=$impedance")
    val current = v / impedance
    println("current=$current")
    val angle = tanh(reactance / coilR)
    println("angle=${angle / PI * 180}")

}

fun example6() {
    val pdInR = 12.0
    val pdInL = 5.0
    val supplyVoltage = sqrt((pdInR * pdInR) + (pdInL * pdInL))
    println("supplyVoltage=$supplyVoltage")
    val angle = tanh(pdInL / pdInR)
    println("angle=${angle / PI * 180}")
}

fun example5() {
    val capacitiesReactance = 10.0 / 1_000_000
    val frequency = 50
    val Xc = 1.0 / (2 * PI * frequency * capacitiesReactance)
    println("Xc=${Xc.ohm}")
}

fun example4() {
    val inductance = 40.0 / 1_000
    val frequency = 50
    val purelyInductive = 2 * PI * frequency * inductance
    println("purelyInductive=${purelyInductive.ohm}")
    val V = 240
    val current = V / purelyInductive
    println("current=$current")
}

fun example3() {
    val maxValue = 75
    val anglerVelocity = 200 * PI
    val angle = -0.25
    val amplitude = maxValue
    println("amplitude=${amplitude.V}")
    val peakToPeak = 2 * maxValue
    println("peakToPeak=${peakToPeak.V}")
    val r_m_s = 0.707 * maxValue
    println("r.m.s=${r_m_s.V}")
    val periodicTime = 2 * PI / anglerVelocity
    val frequency = 1.0 / periodicTime
    println("frequency=${frequency.Hz}")
    val `phase Angel In Degrees And Minutes Relative To 75 sin 200 PI T` = angle * 180 / PI
    println("bla = $`phase Angel In Degrees And Minutes Relative To 75 sin 200 PI T`")


}

fun example2() {
//    val v = 282.8 * sin(314 * t)
    val maxValue = 282.8
    val anglerVelocity = 314
    val r_m_s = 0.707 * maxValue
    println("r.m.s=${r_m_s.V}")
    val time = 2 * PI / anglerVelocity
    val frequency = 1.0 / time
    println("frequency=${frequency.Hz}")
    val instantaneousValue = maxValue * sin(anglerVelocity * 4.milliseconds.value)
    println("instantaneousValue=${instantaneousValue.V}")
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