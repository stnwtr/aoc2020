package at.stnwtr.aoc2020.day05

import at.stnwtr.aoc2020.shared.Day
import java.nio.file.Files

class Day05 : Day("05") {
    private val boardingPassIds = Files.readString(inputFilePath)
        .replace('F', '0').replace('B', '1')
        .replace('L', '0').replace('R', '1')
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