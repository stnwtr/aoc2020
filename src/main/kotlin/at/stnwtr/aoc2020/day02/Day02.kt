package at.stnwtr.aoc2020.day02

import at.stnwtr.aoc2020.shared.Day
import java.nio.file.Files

enum class PasswordPolicy(private val validator: (PasswordLine) -> Boolean) {
    TOBOGGAN_POLICY({ line ->
        line.password.count { it == line.letter } in line.min..line.max
    }),
    SLED_POLICY({ line ->
        (line.password[line.min - 1] == line.letter) xor (line.password[line.max - 1] == line.letter)
    });

    fun check(line: PasswordLine) = validator(line)
}

class PasswordLine(input: String) {
    val min: Int
    val max: Int
    val letter: Char
    val password: String

    init {
        val specPasswordPair = input.trim().split(':')
        val occurrenceLetterPair = specPasswordPair[0].trim().split(' ')
        val occurrencePair = occurrenceLetterPair[0].trim().split('-')

        min = occurrencePair[0].trim().toInt()
        max = occurrencePair[1].trim().toInt()
        letter = occurrenceLetterPair[1].trim()[0]
        password = specPasswordPair[1].trim()
    }

    fun check(policy: PasswordPolicy) = policy.check(this)
}

class Day02 : Day<Int, Int>("02") {
    private val lines = Files.readAllLines(inputFilePath)
        .map { PasswordLine(it) }

    override fun first(): Int {
        return lines.filter { it.check(PasswordPolicy.TOBOGGAN_POLICY) }.size
    }

    override fun second(): Int {
        return lines.filter { it.check(PasswordPolicy.SLED_POLICY) }.size
    }
}