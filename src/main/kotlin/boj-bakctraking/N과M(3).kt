private val isUsed = BooleanArray(10) { false }
private val arr = IntArray(10) { 0 }

private var n: Int = 0
private var m: Int = 0

private val writer = System.out.bufferedWriter()

fun main() = with(System.`in`.bufferedReader()) {
    val input = readln().split(' ').map { it.toInt() }
        .also {
            n = it[0]
            m = it[1]
        }
    select(0)
    writer.flush()
}

// 어차피 depth에 있는 수 이상의 것만 넣어주기 때문에 굳이 isUsed 쓸필요 없다.
private fun select(depth: Int) {

    if (depth == m) {
        for (i in 0 until m) {
            writer.write("${arr[i]} ")
        }
        writer.write("\n")

        return
    }
    var st = 1
    for (i in 1..n) {
        arr[depth] = i
        select(depth + 1)
    }
}