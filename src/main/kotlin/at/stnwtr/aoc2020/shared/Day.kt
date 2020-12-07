package at.stnwtr.aoc2020.shared

import java.nio.file.Path
import java.nio.file.Paths
import kotlin.system.measureTimeMillis

abstract class Day<F, S>(private val level: String) {
    protected val inputFilePath: Path = Paths.get(this::class.java.classLoader.getResource("input${level}")?.toURI()
        ?: throw Error("Could not find Inputfile 'input${level}'"))

    protected abstract fun first(): F
    protected abstract fun second(): S

    fun run() {
        println("+ ---------------- day${level} ----------------")
        println("+-> time: ${
            measureTimeMillis {
                println("| first: ${first()}")
            }
        }")
        println("+-> time: ${
            measureTimeMillis {
                println("| second: ${second()}")
            }
        }")
    }
}