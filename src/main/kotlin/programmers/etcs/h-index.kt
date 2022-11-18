import kotlin.concurrent.fixedRateTimer
import kotlin.math.max

fun main() {


    solution(intArrayOf(3, 2, 1, 1, 1, 1))
        .also { println(it) }
    solution(intArrayOf(3, 1, 1, 1, 1))
        .also { println(it) }

}

private fun solution2(citations: IntArray): Int {
    var ans = 0
    citations.sort()
    for (i in citations.indices) {
        // i번째 논문보다 인용횟수가 크거나 같은 논문 개수
        val r = citations[i] // 어떤 논문이 인용된 수
        val h = citations.size - i // r번이상 인용된 논문수
        // i번째 논문의 인용수 >= 해당 논문보다 인용수 크거나 같은 논문편수 인지 체크.
        if (r >= h) {
            ans = h
            break
        }
        //

    }

    return ans
}


// 누적합을 구하고 이진탐색으로 푸는 방식
private fun solution(citations: IntArray): Int {
    var maxRef = citations.maxOf { it }

    val array = IntArray(maxRef + 1) { 0 }


    citations.forEach {
        array[it] += 1
    }
    val refOverCnts = IntArray(maxRef + 1) { 0 }
    for (i in array.indices.drop(1).reversed()) {
        refOverCnts[i] += array[i]
        if (i != 1)
            refOverCnts[i - 1] += refOverCnts[i]
    }

    print(refOverCnts.toList())

    var start = 1
    var end = maxRef
    var ansIdx = 0
    var ans = 0
    while (start <= end) {
        var mid = (start + end) / 2
        var value = refOverCnts[mid]

        if (value >= mid) {
            ans = max(mid, ans)
            start = mid + 1
        } else {
            end = mid - 1
        }
    }


    return ans
}