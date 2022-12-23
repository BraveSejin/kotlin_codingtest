package programmers.kit

fun main() {

//    solution(3, intArrayOf(1, 99, 99)).also { println(it) }
    solution(6, intArrayOf(7,10)).also { println(it) }
}

private fun solution(n: Int, times: IntArray): Long {
    // left : 가장 짧게 걸리는 경우 -> 그냥 n == 1이라고 가정.
    // right: 시간이 가장 오래걸릴 경우
    // 찾고 싶은 것 : 해당 시간동안 심사관들이 모두 심사할 수 있는지
    // 이 문제에서는 심사관한테 바로 안가고, 더 빠를 것으로 추정되는 줄을 택하는 방법을 기술하지만, 어쩄든 주어진 시간에 심사관이 처리할 수 있는 양이 정해져있음.
    var ans = 0L
    var (left, right) = times.minOf { it }.toLong() to times.maxOf { it } * n.toLong()
    while (left <= right){
        // mid : 주어진 시간
        val mid = (left + right) / 2

        var passed = 0L
        for (time in times){
            passed += mid / time
            if (passed >= n)
                break
        }
        if (passed < n){
            left = mid + 1
        }else{ // 모두 패스시킬 수 있더라도 더 시간을 줄일 수 있음
            ans = mid
            right = mid - 1
        }

    }
    return ans
}