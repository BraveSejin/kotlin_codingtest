package programmers

fun main() {
    //
}

private fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
    var answer: IntArray = intArrayOf() // 최고 등수와 최저 등수를 리턴한다.

    // lottos 와 win_nums 에서 같은 개수를 구한다.
    val intersect = lottos.toSet().intersect(win_nums.toSet()).count()
    // 일단 이 만큼은 맞춘 것이다. // zero개만큼 추가로 맞출 수도 있고 틀릴 수도 있다.
    val numZero = lottos.count { it == 0 }
    val bestMatch = intersect + numZero
    return intArrayOf(getRank(bestMatch), getRank(intersect))
}

private fun getRank(numMatch: Int): Int {
    // 1등 ~ 5등 : 7 - numMatch
    // numMatch가 1 이하
    return if (numMatch <= 1) 6
    else 7 - numMatch
}