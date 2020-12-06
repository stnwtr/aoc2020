package at.stnwtr.aoc2020.shared

import java.nio.file.Path
import java.nio.file.Paths

abstract class Day<F, S>(private val level: String) {
    protected val inputFilePath: Path = Paths.get(this::class.java.classLoader.getResource("input${level}")?.toURI()
        ?: throw Error("Could not find Inputfile 'input${level}'"))

    protected abstract fun first(): F
    protected abstract fun second(): S

    fun run() {
        println("+ ---------------- day${level} ----------------")
        println("| first: ${first()}")
        println("| second: ${second()}")
    }
}