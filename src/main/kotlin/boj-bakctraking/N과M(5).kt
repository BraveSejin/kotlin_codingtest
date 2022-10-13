private val arr = IntArray(10) { 0 }
private val isUsed = BooleanArray(100001) { false }
private lateinit var line: IntArray

private var n: Int = 0
private var m: Int = 0
fun main() = with(System.`in`.bufferedReader()) {
    val input = readln().split(' ').map { it.toInt() }
        .also {
            n = it[0]
            m = it[1]
        }
    line = readln().split(' ').map { it.toInt() }.sorted().toIntArray()

    select(0)
}

private fun select(depth: Int) {

    if (depth == m) {
        for (i in 0 until m) {
            print("${arr[i]} ")
        }
        println()

        return
    }
    for (i in 1..n) {
        if (isUsed[i]) continue
        isUsed[i] = true
        arr[depth] = line[i - 1]
        select(depth + 1)
        isUsed[i] = false
    }
}

