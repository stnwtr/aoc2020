package at.stnwtr.aoc2020.shared

abstract class Day {

    open fun setUp() {}

    open fun beforePart1() {}
    abstract fun part1()
    open fun afterPart1() {}

    open fun beforePart2() {}
    abstract fun part2()
    open fun afterPart2() {}

    open fun tearDown() {}

    fun run() {
        setUp()

        beforePart1()
        part1()
        afterPart1()

        beforePart2()
        part2()
        afterPart2()

        tearDown()
    }
}