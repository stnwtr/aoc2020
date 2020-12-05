package at.stnwtr.aoc2020.day05

import at.stnwtr.aoc2020.shared.Day
import java.nio.file.Files

class Day05 : Day("05") {
    private fun String.replace(replacements: Map<Char, Char>): String {
        var new = this
        replacements.forEach { (from, to) -> new = new.replace(from, to) }
        return new
    }

    private val boardingPassIds = Files.readString(inputFilePath)
        .replace(mapOf('F' to '0', 'B' to '1', 'L' to '0', 'R' to '1'))
        .split(System.lineSeparator())
        .map { it.substring(0, 7).toInt(2) to it.substring(7).toInt(2) }
        .map { it.first * 8 + it.second }

    override fun part1() {
        println(boardingPassIds.maxOrNull())
    }

    override fun part2() {
        val min = boardingPassIds.minOrNull()!!
        val max = boardingPassIds.maxOrNull()!!

        println((min..max).sum() - boardingPassIds.sum())
    }
}