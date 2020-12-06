package at.stnwtr.aoc2020.day03

import at.stnwtr.aoc2020.shared.Day
import java.nio.file.Files

const val TREE = '#'

class Forest(private val map: List<String>) {
    private val width = map[0].length

    fun countTrees(speedX: Int, speedY: Int): Int {
        return (map.indices step speedY)
            .map { (it / speedY * speedX) % width to it }
            .filter { map[it.second][it.first] == TREE }
            .count()
    }

    fun countTrees(speed: Pair<Int, Int>) = countTrees(speed.first, speed.second)
}

class Day03 : Day<Int, Long>("03") {
    private val forest = Forest(Files.readAllLines(inputFilePath))

    override fun first(): Int {
        return forest.countTrees(3, 1)
    }

    override fun second(): Long {
        return listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
            .map { forest.countTrees(it) }
            .fold(1L, {value, current -> value * current})
    }
}