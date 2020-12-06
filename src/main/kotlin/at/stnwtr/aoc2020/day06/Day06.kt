package at.stnwtr.aoc2020.day06

import at.stnwtr.aoc2020.shared.Day
import java.nio.file.Files

class GroupAnswers(private val rawAnswers: List<String>) {
    fun countAllYes() = rawAnswers.map { it.toSet() }
        .fold(setOf<Char>(), { value, current -> value union current })
        .size

    fun countSharedYes() = rawAnswers.map { it.toSet() }
        .fold("abcdefghijklmnopqrstuvwxyz".toSet(), { value, current -> value intersect current })
        .size
}

class Day06 : Day<Int, Int>("06") {
    private val answers = Files.readString(inputFilePath)
        .trimEnd()
        .split(System.lineSeparator() + System.lineSeparator())
        .map { it.split(System.lineSeparator()) }
        .map { GroupAnswers(it) }

    override fun first(): Int {
        return answers.map { it.countAllYes() }.sum()
    }

    override fun second(): Int {
        return answers.map { it.countSharedYes() }.sum()
    }
}