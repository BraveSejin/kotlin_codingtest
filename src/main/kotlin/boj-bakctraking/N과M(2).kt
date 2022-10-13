private val isUsed = BooleanArray(10) { false }
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
    if (depth != 0) st = arr[depth - 1] + 1
    for (i in st..n) {
//        if (isUsed[i]) continue
        arr[depth] = i
//        isUsed[i] = true
        select(depth + 1)
//        isUsed[i] = false
    }
}


private fun select2(from: Int, depth: Int) {
    if (depth == m) {
        for (i in 0 until m) {
            print("${arr[i]} ")
        }
        println()
        return
    }
    for (i in from..n) {
        arr[depth] = i
        select2(i + 1, depth + 1)
    }
}