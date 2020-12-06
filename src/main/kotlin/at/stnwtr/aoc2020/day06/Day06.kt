package at.stnwtr.aoc2020.day06

import at.stnwtr.aoc2020.shared.Day
import java.nio.file.Files

class GroupAnswers(private val rawAnswers: List<String>) {
    fun countAllYes(): Int {
        return rawAnswers.map { it.toSet() }
            .fold(setOf<Char>(), { value, current -> value + current })
            .size
    }

    fun countSharedYes(): Int {
        return rawAnswers.map { it.toSet() }
            .fold("abcdefghijklmnopqrstuvwxyz".toSet(),
                { value, current -> value intersect current })
            .size
    }
}

class Day06 : Day("06") {
    private val answers = Files.readString(inputFilePath)
        .split(System.lineSeparator() + System.lineSeparator())
        .map { it.split(System.lineSeparator()) }
        .map { GroupAnswers(it) }

    override fun part1() {
        answers.map { it.countAllYes() }
            .fold(0, { value, current -> value + current })
            .also(::println)
    }

    override fun part2() {
        answers.map { it.countSharedYes() }
            .fold(0, { value, current -> value + current })
            .also(::println)
    }
}