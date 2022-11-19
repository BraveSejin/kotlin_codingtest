package programmers.kakao_2022_blind


// 유저, 신고당한 횟수, 신고한 유저들
// 같은 유저가 한 유저한테 여러번 신고해도 1개취급 -> set으로 설정


private fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    val userToReporter = hashMapOf<String, HashSet<String>>()
    val answerMap = hashMapOf<String, Int>()
    id_list.forEach {
        userToReporter[it] = hashSetOf()
        answerMap[it] = 0
    }
    report.forEach {
        val srcDest = it.split(" ")
        val (src, dest) = srcDest[0] to srcDest[1]
        userToReporter[dest]!!.add(src)
    }

    userToReporter.filter { it.value.size >= k } // 처리받는 유저들
        .forEach { it ->
            val user = it.key
            val reporters = it.value
            reporters.forEach { reporter ->
                answerMap[reporter] = answerMap[reporter]!! + 1
            }
        }
    // 유저별로 처리 결과를 받은 메일 횟수

    return id_list.map { answerMap[it]!! }.toIntArray()
}

fun main() {

}