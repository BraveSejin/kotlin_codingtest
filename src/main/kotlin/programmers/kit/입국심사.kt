package programmers.kit

fun main() {

//    solution(3, intArrayOf(1, 99, 99)).also { println(it) }
    solution(6, intArrayOf(7,10)).also { println(it) }
}
// 어떤 시간동안 모든 심사관들이 전부 일하는 것이 가장 빠르게 일을 처리하는 것임
// 경우에 따라 일부만 일할 수 있지만, 그런 경우 나눗셈 연산에 의해서 패스시킨 사람이 0이 되도록 만들 수 있음.

private fun solution(n: Int, times: IntArray): Long {
    var ans = 0L

    var left = times.minOf { it }.toLong()
    var right = times.maxOf {it}.toLong() * n.toLong()



    while (left <= right){
        val mid = (left + right) / 2L
        var passed = 0L
        for (time in times){
            passed += mid / time
        }
        if (passed < n){
            left = mid + 1
        }else{
            right = mid - 1
            ans = mid
        }
    }
    return ans
}