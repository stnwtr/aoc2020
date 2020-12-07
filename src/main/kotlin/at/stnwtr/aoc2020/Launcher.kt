package at.stnwtr.aoc2020

import at.stnwtr.aoc2020.day00.Day00
import at.stnwtr.aoc2020.day01.Day01
import at.stnwtr.aoc2020.day02.Day02
import at.stnwtr.aoc2020.day03.Day03
import at.stnwtr.aoc2020.day04.Day04
import at.stnwtr.aoc2020.day05.Day05
import at.stnwtr.aoc2020.day06.Day06
import at.stnwtr.aoc2020.day07.Day07

fun main() {
    val days = listOf(
        Day00(), Day01(), Day02(), Day03(), Day04(), Day05(), Day06(),
        Day07()
    )

    for (index in days.indices) {
        days[index].run()
    }
}
