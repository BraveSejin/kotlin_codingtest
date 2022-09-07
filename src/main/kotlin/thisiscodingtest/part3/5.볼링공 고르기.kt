fun main() {

    var (n, m) = readln().split(" ").map { it.toInt() }
//    val balls = Array(n + 1) { 0 }
    val balls = MutableList<Int>(n + 1) { 0 }

    val data = readln().split(" ").map { it.toInt() }.toMutableList()
    data.forEach {
        balls[it] += 1
    }

    // 1 5 4 3 2 4 5 2
    // 1 2 2 3 4 4 5 5  // 7 + 5 + 5+ 2+ 2
    var results = 0
    for (weight in 1..m) {
        n -= balls[weight]
        results += n * balls[weight]
        println(results)
    }
    println(results)
}