package at.stnwtr.aoc2020.day01

import at.stnwtr.aoc2020.shared.Day
import java.nio.file.Files

class Day01 : Day("01") {

    private var lines = Files.readAllLines(inputFilePath).map { it.toInt() }

    override fun part1() {
        outermost@ for (i in lines.indices) {
            val x = lines[i]
            for (j in i until lines.size) {
                val y = lines[j]
                if (x + y == 2020) {
                    println("First Number: $x")
                    println("Second Number: $y")
                    println("Addition: ${x + y}")
                    println("Multiplication: ${x * y}")
                    break@outermost
                }
            }
        }
    }

    override fun part2() {
        outermost@ for (i in lines.indices) {
            val x = lines[i]
            for (j in i until lines.size) {
                val y = lines[j]
                for (k in j until lines.size) {
                    val z = lines[k]
                    if (x + y + z == 2020) {
                        println("First Number: $x")
                        println("Second Number: $y")
                        println("Third Number: $z")
                        println("Addition: ${x + y + z}")
                        println("Multiplication: ${x * y * z}")
                        break@outermost
                    }
                }
            }
        }
    }
}