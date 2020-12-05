package at.stnwtr.aoc2020

import at.stnwtr.aoc2020.day00.Day00
import at.stnwtr.aoc2020.day01.Day01
import at.stnwtr.aoc2020.day02.Day02
import at.stnwtr.aoc2020.day03.Day03
import at.stnwtr.aoc2020.day04.Day04
import at.stnwtr.aoc2020.day05.Day05

fun main() {
    val days = listOf(Day00(), Day01(), Day02(), Day03(), Day04(), Day05())

    for (index in days.indices) {
        days[index].run()
        if (index != days.size - 1) {
            println()
            println("+---- ---- ---- ---- ---- ---- ---- ---- next day ---- ---- ---- ---- ---- ---- ---- ----+")
            println()
        }
    }
}
