package programmers.kit

fun main() {
    solution(10, 2).also { println(it.toList()) }
    solution(10, 2).also { println(it.toList()) }
    solution(12, 4).also { println(it.toList()) }
    solution(12, 3).also { println(it.toList()) }
}

private fun solution(brown: Int, yellow: Int): IntArray {
    // 노란색 높이 구하기
    var i = 1
    var answer = intArrayOf()

    while (true) {
        if (yellow % i != 0) {
            i += 1
            continue
        }

        var width = yellow / i
        var height = yellow / width


        var brownHeight = height + 2
        var bronWidth = width + 2
        var tempBrownNum = bronWidth * brownHeight - yellow

        if (tempBrownNum == brown) {
            answer = intArrayOf(bronWidth, brownHeight)
            break
        }
        i += 1

    }
    return answer
}