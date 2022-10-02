package kakao_2021_blind
//https://minoflower.tistory.com/39 참고
// https://velog.io/@isntkyu/프로그래머스level-2-메뉴-리뉴얼-DFS로-조합-구하기 여기도 참고해서 다시 풀기
fun main() {

//    solution(arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"), intArrayOf(2, 3, 4))
//    solution(arrayOf("XYZ","XWY","WXA"), intArrayOf(2,3,4))
    solution(arrayOf("ABCD"), intArrayOf(3))
        .also { println(it.toList()) }
}

private val info = hashMapOf<String,Int>()
//course 개의 조합을 메뉴에서 선택해서 Map 형태에 넣어야한다.
private fun solution(orders: Array<String>, course: IntArray): Array<String> {

    val answer = mutableListOf<String>()

    val sortedOrders = Array(orders.size) { "" }
    orders.forEachIndexed { index, s ->
        sortedOrders[index] = s.toCharArray().sorted().joinToString("")
    }
    for (num in course) {
        for (str in sortedOrders)
            dfs(0, num, str, "")
    }

    println(info)
    for (num in course) {
        info.filter { it.key.length == num }.also { localMap ->
            if (localMap.isEmpty()) return@also
            var max = localMap.entries.maxOf { it.value }
            if (max < 2) return@also
            var filteredKeys = localMap.filter { it.value == max }.keys.sorted()
            answer.addAll(filteredKeys)
        }

    }


    return answer.sorted().toTypedArray()
}
//이 동네가 핵심 포인트.. DFS를 이용해서 대상을 선택하는 부분이 익숙치 않다.
// m 개만 선택하게 설계되어있음. 그리고 dfs를 두번 함으로써 선택하는 경우와 선택하지 않는 경우를 분리해뒀따.
private fun dfs(idx: Int, m: Int, str: String, newStr: String){
    println(newStr)
    if (newStr.length == m){
        info.merge(newStr, 1, Integer::sum) // key에 밸류가 없다면 1을 더해주고, 있다면 value += 1 해준다.
        return
    }
    if (idx >= str.length) return
    dfs(idx+1, m, str, newStr + str[idx])
    dfs(idx+1, m, str, newStr )
}