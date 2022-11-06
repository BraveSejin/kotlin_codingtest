package kakao_2019_blind

private fun solution(N: Int, stages: IntArray): IntArray {
    // 실패율: 스테이지에 도달했으나 아직 클리어 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
    // 주어진 정보 : 사용자가 현재 멈춰있는 번호
    // stage A의 실패율: A 스테이지에 있는 플레이어 수 /  A ~ N 스테이지에 있는 플레이어 수

    // hashmap : key = 현재 스테이지 value  = 현재 스테이지의 유저 수
    // key를 정렬하고, 특정 키의 밸류 / 그 키 이상의 밸류 sum 하면 구해진다.

    val stageToUser = hashMapOf<Int, Int>()
    stages.forEach {
        stageToUser.merge(it, 1, Integer::sum)
    }
    val passedUsers = IntArray(N + 1)

    stageToUser.forEach { key, value ->
        for (i in 1 until key) {
            passedUsers[i] += value
        }
    }

    // 스테이지별 failure를 구하자
    val stageFailRatePairs = mutableListOf<Pair<Int, Float>>()
    for (stage in 1..N) {
        val passedUserNum = passedUsers[stage]
        val curUserNum = stageToUser.getOrDefault(stage, 0)
        val failureRate = curUserNum.toFloat() / (curUserNum + passedUserNum)
        stageFailRatePairs.add(Pair(stage, failureRate))
    }

    // stage A 에 유저 B명이 정체하고 있다면, A-1까지 B를 더해준다.

    stageFailRatePairs.sortWith{o1, o2 ->
        if (o1.second == o2.second) o1.first - o2.first
        else if (o2.second - o1.second > 0 ) 1
        else -1
    }

    println(stageFailRatePairs)
    return stageFailRatePairs.map { it.first }.toIntArray()
}

fun main() {
    solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3))
}