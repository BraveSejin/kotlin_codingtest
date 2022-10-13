private val arr = IntArray(10) { 0 }
private lateinit var line: IntArray

private var n: Int = 0
private var m: Int = 0
private val isUsed = BooleanArray(10)

private val writer = System.out.bufferedWriter()

fun main() = with(System.`in`.bufferedReader()) {
    val input = readln().split(' ').map { it.toInt() }
        .also {
            n = it[0]
            m = it[1]
        }
    line = readln().split(' ').map { it.toInt() }.sorted().toIntArray()

    select(0)
    writer.flush()
}

private fun select(depth: Int) {

    if (depth == m) {
        for (i in 0 until m) {
            writer.write("${arr[i]} ")
        }
        writer.write("\n")
        return
    }
    var temp = 0
    for (i in 0 until n) {
        if (isUsed[i]) continue
        if (temp == line[i]) continue // 같은 depth에 동일한 number를 넣으려고 하는 경우

        isUsed[i] = true
        arr[depth] = line[i]
        temp = arr[depth]
        select(depth + 1)
        isUsed[i] = false
    }
}