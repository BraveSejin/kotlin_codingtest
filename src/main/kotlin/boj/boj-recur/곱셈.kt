private var a = 0L
private var b = 0L
private var c = 0L
private fun main() = with(System.`in`.bufferedReader()) {
    readln().split(' ').map { it.toLong() }.also {
        a = it[0]
        b = it[1]
        c = it[2]
    }
    println(func(a,b,c))

}

private fun func(a: Long, b: Long, c: Long): Long {
    if (b == 1L) return a % c

    val half = func(a, b / 2, c)
    val full = half * half % c

    return if (b % 2 == 0L) full
    else full * a % c

}