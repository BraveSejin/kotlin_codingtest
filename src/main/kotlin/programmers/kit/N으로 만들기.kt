package programmers.kit

fun main() {
    solution(5, 12).also { println(it) }
}

private fun solution(N: Int, number: Int): Int {
    var ans = -1
    val dp = Array(9) {
        HashSet<Int>().apply {
            if (it == 0)
                add(0)
            else
                add((N.toString().repeat(it).toInt()))
        }
    }

    for(i in 1 .. 8){
        for (j in 1 until i){ // 이전 집합들
            for (left in dp[j])
                for (right in dp[i - j]){
                    dp[i].add(left + right)
                    dp[i].add(left - right)
                    dp[i].add(left * right)
                    if (right != 0)
                        dp[i].add(left / right)
                }
        }
        if (number in dp[i]) {
            ans = i
            break
        }
    }
//    dp.forEach {
//        println(it)
//    }
    return ans
}