package programmers.kakao_2021_blind




private val hm = hashMapOf<String,Int>()
private lateinit var courseArray: IntArray
private fun solution(orders: Array<String>, course: IntArray): Array<String> {

    courseArray = course
    val answer: MutableList<String> = mutableListOf()

    orders.forEach { order ->
        dfs(order.toCharArray().sorted().joinToString(""), "", 0) // dfs로
    }// 조합으로 풀면 성능이 좀 더 낫다.
    course.forEach { len ->
        val menu = hm.filter { it.key.length == len }
        if (menu.isEmpty()) return@forEach
        val maxOrdered = menu.maxOf { it.value }
        if (maxOrdered == 1) return@forEach
        menu.filter { it.value == maxOrdered }
            .keys.let { answer.addAll(it) }
    }

    return answer.sorted().toTypedArray()
}

private fun dfs(order: String, acc: String, depth: Int){
    if (depth == order.length){
        if (acc.length in courseArray)
            hm.merge(acc, 1, Integer::sum)
        return
    }
    dfs(order, acc, depth + 1)
    dfs(order, acc+order[depth], depth + 1)

}

fun main() {
//    solution(arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"), intArrayOf(2, 3, 4))
//        .also { println(it.toList()) }

    solution(arrayOf("XYZ", "XWY","WXA"), intArrayOf(2, 3, 4))
        .also { println(it.toList()) }
}