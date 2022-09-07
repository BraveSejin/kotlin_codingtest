fun main() {

sol2()
}

private fun sol2() {
    val n = readln().toInt()
    val data = readln().split(" ").map { it.toInt() }.toMutableList()
    data.sort()
    var res = 0
    var cnt = 0 // 현재 그룹의 사람수
    for (i in data) {
        cnt += 1
        if (cnt >= i) {
            cnt = 0
            res += 1
        }
    }
    println(res)
}

private fun sol1() {
    val n = readln().toInt()
    val fear = Array(n + 1) { 0 }

    readln().split(" ").map { it.toInt() }.forEach { it ->
        fear[it] += 1
    }

    // fear에 몇명 있는지 알 수 있음

    var result = 0
    for (i in 1..n) {
        val cur = fear[i]
        val numGroup = cur / i
        result += numGroup
        val etc = cur % i
        if (i < n)
            fear[i + 1] += etc
    }
    println(result)
}