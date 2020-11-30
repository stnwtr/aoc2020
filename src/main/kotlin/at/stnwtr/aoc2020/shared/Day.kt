package at.stnwtr.aoc2020.shared

abstract class Day {

    protected open fun setUp() {}

    protected open fun beforePart1() {}
    protected abstract fun part1()
    protected open fun afterPart1() {}

    protected open fun beforePart2() {}
    protected abstract fun part2()
    protected open fun afterPart2() {}

    protected open fun tearDown() {}

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