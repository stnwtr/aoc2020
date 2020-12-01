package at.stnwtr.aoc2020

import at.stnwtr.aoc2020.day00.Day00
import at.stnwtr.aoc2020.day01.Day01

fun main() {
    val days = listOf(Day00(), Day01())

    for (index in days.indices) {
        days[index].run()
        if (index != days.size - 1) {
            println()
            println("+---- ---- ---- ---- ---- ---- ---- ---- next day ---- ---- ---- ---- ---- ---- ---- ----+")
            println()
        }
    }
}
