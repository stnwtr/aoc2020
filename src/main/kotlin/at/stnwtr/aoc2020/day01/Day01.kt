package at.stnwtr.aoc2020.day01

import at.stnwtr.aoc2020.shared.Day
import java.nio.file.Files

class Day01 : Day<Int, Int>("01") {
    private var lines = Files.readAllLines(inputFilePath).map { it.toInt() }

    override fun first(): Int {
        outermost@ for (i in lines.indices) {
            val x = lines[i]
            for (j in i until lines.size) {
                val y = lines[j]
                if (x + y == 2020) {
                    return x * y
                }
            }
        }
        return -1
    }

    override fun second(): Int {
        outermost@ for (i in lines.indices) {
            val x = lines[i]
            for (j in i until lines.size) {
                val y = lines[j]
                for (k in j until lines.size) {
                    val z = lines[k]
                    if (x + y + z == 2020) {
                        return x * y * z
                    }
                }
            }
        }
        return -1
    }
}