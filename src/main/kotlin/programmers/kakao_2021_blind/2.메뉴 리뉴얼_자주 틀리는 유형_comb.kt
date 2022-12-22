package programmers.kakao_2021_blind

fun main() {

    solution(arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"), intArrayOf(2, 3, 4))
//    solution(arrayOf("ABCD"), intArrayOf(3))
        .also { println(it.toList()) }
}

//course 개의 조합을 메뉴에서 선택해서 Map 형태에 넣어야한다.

private val info = hashMapOf<String, Int>()

private fun solution(orders: Array<String>, course: IntArray): Array<String> {
    val answer = mutableListOf<String>()

    val sortedOrders = Array(orders.size) { "" }
    orders.forEachIndexed { index, s ->
        sortedOrders[index] = s.toCharArray().sorted().joinToString("")
    }

    for (num in course) {
        val combs = mutableListOf<List<Char>>()
        for (str in sortedOrders) {
            combination(combs, str.toCharArray().toList(), ck = Array<Boolean>(str.length) { false }, 0, num)
        }
        for (comb in combs) {
            info.merge(comb.joinToString(""), 1, Integer::sum)
        }
    }
//    print(info)

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

private fun <T> combination(answer: MutableList<List<T>>, elements: List<T>, ck: Array<Boolean>, start: Int, target: Int) {
    if (target == 0) {
//        answer.addAll(listOf(el.filterIndexed { index, t -> ck[index] }))
        answer.add(elements.filterIndexed { index, t -> ck[index] })
    } else {
        for (i in start until elements.size) {
            ck[i] = true
            combination(answer, elements, ck, i + 1, target - 1)
            ck[i] = false
        }
    }
}