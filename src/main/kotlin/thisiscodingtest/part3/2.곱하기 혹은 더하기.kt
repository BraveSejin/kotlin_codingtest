package thisiscodingtest.part3.`2`

fun main() {
    val data = readln().map { it.digitToInt() }
    // 항에 있는것이 0인 경우: 덧셈 아닌 경우 : 곱셈
    var cur = data[0]
    for (i in 1..data.lastIndex) {
        val right = data[i]
        if (cur <= 1 || right <=1)
            cur += right
        else
            cur *= right
    }
    println(cur)
}