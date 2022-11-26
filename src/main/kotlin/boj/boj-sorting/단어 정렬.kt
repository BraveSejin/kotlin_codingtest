package boj.`boj-sorting`

fun main() {
    val n = readln().toInt()
    val s = mutableSetOf<String>()
    repeat(n) {
        s.add(readln())
    }
    s.toMutableList().sortedWith(
        comparator = { o1, o2 -> if (o1.length == o2.length) o1.compareTo(o2) else o1.length.compareTo(o2.length) }
    ).forEach { println(it) }

}