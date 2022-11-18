
private val arr = IntArray(10) { 0 }

private var n: Int = 0
private var m: Int = 0
fun main() = with(System.`in`.bufferedReader()) {
    val input = readln().split(' ').map { it.toInt() }
        .also {
            n = it[0]
            m = it[1]
        }
    select(0)
}

// 어차피 depth에 있는 수 이상의 것만 넣어주기 때문에 굳이 isUsed 쓸필요 없다.
private fun select(depth: Int) {

    if (depth == m) {
        for (i in 0 until m) {
            print("${arr[i]} ")
        }
        println()

        return
    }
    var st = 1
    if (depth != 0) st = arr[depth - 1]
    for (i in st..n) {
        arr[depth] = i
        select(depth + 1)
    }
}

