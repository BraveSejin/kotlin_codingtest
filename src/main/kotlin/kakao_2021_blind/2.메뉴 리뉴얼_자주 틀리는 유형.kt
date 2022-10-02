package kakao_2021_blind

fun main() {

//    solution(arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"), intArrayOf(2, 3, 4))
    solution(arrayOf("ABCD"), intArrayOf(2, 3, 4))
}

//course 개의 조합을 메뉴에서 선택해서 Map 형태에 넣어야한다.
private fun solution(orders: Array<String>, course: IntArray): Array<String> {
    for (t in orders.indices step (1)) {
        val order = orders[t].toCharArray().sorted()
        for (i in 1 until (1 shl order.size)) {
            println(1 shl order.size)
            var menu = ""

            var tmp = i
            for (j in 0 until order.size) {
                if (tmp % 2 == 1) menu += order[j]
                tmp /= 2
            }
            println(menu)
            // 대충 맵에서자장
        }
    }
    return arrayOf()
}