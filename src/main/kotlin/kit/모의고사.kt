package kit

fun main() {
//    solution(intArrayOf(1,2,3,4,5)).also { println(it.toList()) }
    solution(intArrayOf(1, 3, 2, 4, 2)).also { println(it.toList()) }
}

private fun solution2(answers: IntArray): IntArray {
    val ans1 = intArrayOf(1, 2, 3, 4, 5)
    var ans2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    var ans3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
    var (x, y, z) = Triple(0, 0, 0)
    val cnts = intArrayOf(0, 0, 0)
    for (i in answers) {
        if (i == ans1[x]) cnts[0] += 1
        if (i == ans2[y]) cnts[1] += 1
        if (i == ans3[z]) cnts[2] += 1
        x = if (x < 4) x + 1 else 0
        y = if (y < 7) y + 1 else 0
        z = if (z < 9) z + 1 else 0
    }


    return mutableListOf<Int>()
        .apply {
            val maxVal = cnts.maxOf { it }
            cnts.forEachIndexed { index, i -> if (i == maxVal) add(index + 1) }
        }.toIntArray()

}

private fun solution(answers: IntArray): IntArray {
    val n = answers.size
    var cnts = intArrayOf(0, 0, 0)
    val first = mutableListOf<Int>().apply {
        Array(n / 5 + 1) { intArrayOf(1, 2, 3, 4, 5) }
            .flatMap { it -> it.toList() }
            .take(n)
            .also { addAll(it) }
    }
    val second = mutableListOf<Int>().apply {
        Array(n / 8 + 1) { intArrayOf(2, 1, 2, 3, 2, 4, 2, 5) }
            .flatMap { it -> it.toList() }
            .take(n)
            .also { addAll(it) }
    }

    val third = mutableListOf<Int>().apply {
        Array(n / 10 + 1) { intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5) }
            .flatMap { it -> it.toList() }
            .take(n)
            .also { addAll(it) }
    }
    answers.forEachIndexed { index, i ->
        if (i == first[index]) cnts[0] += 1
        if (i == second[index]) cnts[1] += 1
        if (i == third[index]) cnts[2] += 1
    }
    var answer = mutableListOf<Int>()
    val maxValue = cnts.maxOf { it }
    cnts.forEachIndexed { index, i ->
        if (i == maxValue) answer.add(index + 1)
    }

    return answer.toIntArray()
}
