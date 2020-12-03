package at.stnwtr.aoc2020.shared

import java.nio.file.Path
import java.nio.file.Paths

abstract class Day(private val level: String) {
    protected val inputFilePath: Path = Paths.get(this::class.java.classLoader.getResource("input${level}")?.toURI()
        ?: throw Error("Could not find Inputfile 'input${level}'"))

    protected abstract fun part1()
    protected abstract fun part2()

    fun run() {
        println("+----+--------+-----+----+")
        println("|     starting day${level}     |")
        println("+----+--------+-----+----+")
        println()

        println("+---- starting part 1 ----+")
        println()

        part1()

        println()
        println("+---- stopping part 1 ----+")
        println()

        println("+---- starting 2 ----+")
        println()

        part2()

        println()
        println("+---- stopping 2 ----+")
        println()

        println("+----+--------+-----+----+")
        println("|     stopping day${level}     |")
        println("+----+--------+-----+----+")
    }
}