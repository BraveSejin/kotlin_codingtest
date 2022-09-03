fun main() {
    sol2()
}

private fun sol1() {
    var (n, k) = readLine()!!.split(" ").map { it.toInt() }
    var res = 0
    while (n != 1) {
        if (n % k == 0) {
            n /= k
            res += 1
        } else {
            n -= 1
            res += 1
        }
    }
    println(res)
}

private fun sol2() {
    var (n, k) = readLine()!!.split(" ").map { it.toInt() }
    var res = 0

    while (true) {
        val target = (n / k) * k
        res += (n - target) // 나눌수 있거나 0이 될때까지 빼기
        n = target

        // 못나누면
        if (n < k) {
            break
        } else {
            res += 1
            n = target / k
        }

    }
    res += n-1
    println(res)
}