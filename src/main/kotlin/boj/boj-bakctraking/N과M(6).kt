private val arr = IntArray(10) { 0 }
private val isUsed = BooleanArray(10) { false }
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
            print("${line[arr[i]]} ")
        }
        println()

        return
    }
    val st = if (depth == 0) 0 else arr[depth - 1] + 1
    for (i in st until n) {
        if (isUsed[i]) continue
        isUsed[i] = true
        arr[depth] = i
        select(depth + 1)
        isUsed[i] = false
    }
}