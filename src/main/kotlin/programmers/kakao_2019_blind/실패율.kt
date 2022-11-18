package programmers.kakao_2019_blind

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
        val parent = curUserNum + passedUserNum
        val failureRate = if (parent == 0) 0f else curUserNum.toFloat() / parent
        stageFailRatePairs.add(Pair(stage, failureRate))
    }

    // stage A 에 유저 B명이 정체하고 있다면, A-1까지 B를 더해준다.

    stageFailRatePairs.sortWith { o1, o2 ->
        if (o1.second == o2.second) o1.first - o2.first
        else if (o2.second - o1.second > 0) 1
        else -1
    }

    return stageFailRatePairs.map { it.first }.toIntArray()
}


//https://school.programmers.co.kr/learn/courses/30/lessons/42889/solution_groups?language=kotlin
// State라는 클래스를 따로 만들고 다른 원소들로 get 접근자를 설정해서 풀이한 방법

private data class Stage(val level: Int, var pass: Int, var fail: Int) {
    val failRate: Float
        get() = if (fail + pass == 0) 0.0f else fail.toFloat() / (pass + fail)
}


private fun solution2(N: Int, stages: IntArray): IntArray {
    val stageInfoArray = Array<Stage>(N) { Stage(it + 1, 0, 0) }
    for (level in stages) {
        for (i in 0 until level - 1) {
            stageInfoArray[i].pass += 1
        }
        if (level != N+1)
            stageInfoArray[level-1].fail += 1
    }
    stageInfoArray.sortByDescending { it.failRate }
    return stageInfoArray.map { it.level }.toIntArray()
}

fun main() {
//    solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3))
    solution(5, intArrayOf(3, 3, 3, 3))
}