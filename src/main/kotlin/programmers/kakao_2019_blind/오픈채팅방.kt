fun main() {
    // id와 닉네임을 키 - 해시로 사용하여 저장한다.
    // enter / leave 메세지는 해당 값을 갖는 키로 대체해야한다.

}

//https://school.programmers.co.kr/learn/courses/30/lessons/42888/solution_groups?language=kotlin
// 참조
private fun solution2(record: Array<String>): Array<String> {
    val user = mutableMapOf<String, String>()
    return record.asSequence()
        .map {
            val tokens = it.split(' ')
            when (tokens.first()) {
                "Enter", "Change" -> user += tokens[1] to tokens[2]
            }
            tokens
        }.filter { it.first() != "Change" }
        .map {
            val nick = user[it[1]]
            val ment = when (it[0]) {
                "Enter" -> "님이 들어왔습니다."
                "Leave" -> "님이 나갔습니다."
                else -> throw  IllegalAccessException()
            }
            "$nick$ment"
        }
        .toList()
        .toTypedArray()

}

private fun solution(record: Array<String>): Array<String> {
    val hm = mutableMapOf<String, String>()
    val log = mutableListOf<Pair<String, Int>>()

    record.forEach { message ->
        val tokens = message.split(' ')
        when (tokens.first()) {
            "Enter" -> {
                hm[tokens[1]] = tokens[2]
                log.add(Pair(tokens[1], 0))
            }
            "Leave" -> {
                log.add(Pair(tokens[1], 1))
            }
            "Change" -> {
                hm[tokens[1]] = tokens[2]
            }
        }
    }

    return log.map { it ->
        "${hm[it.first]}님이 ${if (it.second == 0) "들어왔습니다." else "나갔습니다."}"
    }.toTypedArray()

}