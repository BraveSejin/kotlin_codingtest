package examples

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    numbers.reduce { total, num -> total + num }.also { println(it) }
    numbers.fold(0) { total, num -> total + num }.also { println(it) }
}