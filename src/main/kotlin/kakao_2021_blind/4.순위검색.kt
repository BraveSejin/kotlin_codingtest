package kakao_2021_blind

private fun solution(info: Array<String>, query: Array<String>): IntArray {

    val types = arrayOf(
        arrayOf("-", "cpp", "java", "python"),
        arrayOf("-", "backend", "frontend"),
        arrayOf("-", "junior", "senior"),
        arrayOf("-", "chicken", "pizza")
    )
    val L = Array<MutableList<Int>>(108) { mutableListOf() }

    info.forEach { str ->
        val v = IntArray(4)
        val tokens = str.split(" ")
        for (i in 0 until 4) {
            val token = tokens[i]
            v[i] = types[i].indexOf(token)
        }
        val score = tokens.last().toInt()

        for (c1 in intArrayOf(0, v[0]))
            for (c2 in intArrayOf(0, v[1]))
                for (c3 in intArrayOf(0, v[2]))
                    for (c4 in intArrayOf(0, v[3])) {
                        val idx = c1 * 27 + c2 * 9 + c3 * 3 + c4
                        L[idx].add(score)
                    }
    }

    for (i in L.indices) L[i].sort()

    val answer = mutableListOf<Int>()

    // 쿼리
    query.forEach { q ->
        val v = IntArray(4)
        val tokens = q.split(" ")
        v[0] = types[0].indexOf(tokens[0])
        v[1] = types[1].indexOf(tokens[2])
        v[2] = types[2].indexOf(tokens[4])
        v[3] = types[3].indexOf(tokens[6])
        val score = tokens.last().toInt()

        val idx = v[0] * 27 + v[1] * 9 + v[2] * 3 + v[3]
        var (start, end) = Pair(0, L[idx].size - 1)
        while (start <= end) {
            val mid = (start + end) / 2
            if (L[idx][mid] >= score)
                end = mid - 1
            else start = mid + 1
        }

        answer.add(L[idx].size - start)

    }



    return answer.toIntArray()
}