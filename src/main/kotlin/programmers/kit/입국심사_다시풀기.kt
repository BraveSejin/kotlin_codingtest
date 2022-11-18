package programmers.kit

fun main() {

    solution(3, intArrayOf(1, 99, 99)).also { println(it) }
}

private fun solution(n: Int, times: IntArray): Long {
    var (left, right) = Pair<Long, Long>(1, (times.maxOf { it } * n.toLong())) // 1,4
    var ans = 0L

    while (left <= right) {
        // 1, 4
        var mid = (left + right) / 2 // 1

        val examined = times.fold<Long>(0L) { acc, time ->
            acc + mid / time
        }
        if (examined >= n) {
            ans = mid   // 2
            right = mid - 1 // 1
        } else {
            left = mid + 1 //
        }

    }
    return ans
}