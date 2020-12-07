package at.stnwtr.aoc2020.day07

import at.stnwtr.aoc2020.shared.Day
import java.nio.file.Files

class Bag(val name: String, rawContents: String) {
    val contents = rawContents.split(',', '.')
        .filter { it.isNotBlank() }
        .map { it.trim().split(" ", limit = 2) }
        .filter { it[0] != "no" }
        .map { it[1] to (it[0].toIntOrNull() ?: 0) }
        .toMap()

    companion object {
        fun outerBags(list: List<Bag>, name: String): Set<Bag> {
            val bags = list.filter { it.contents.keys.contains(name) }.toSet()
            val r = bags.flatMap { outerBags(list, it.name) }
            return bags + r
        }

        fun innerBags(list: List<Bag>, name: String): Int {
            return list.first { it.name == name }.contents.map { it.value * innerBags(list, it.key) + it.value }.sum()
        }
    }
}

class Day07 : Day<Int, Int>("07") {
    private val input = Files.readAllLines(inputFilePath)
        .map { it.replace("bag(s)?".toRegex(), "").split("contain") }
        .map { Bag(it[0].trim(), it[1]) }

    override fun first(): Int {
        return Bag.outerBags(input, "shiny gold").size
    }

    override fun second(): Int {
        return Bag.innerBags(input, "shiny gold")
    }
}