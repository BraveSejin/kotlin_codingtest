import kotlin.math.max
import kotlin.math.min

fun main() {
    solution(
        arrayOf(
            intArrayOf(60, 50),
            intArrayOf(30, 70),
            intArrayOf(60, 30),
            intArrayOf(80, 40),
        )
    ).also { println(it) }
}

private fun solution(sizes: Array<IntArray>): Int {
    var long = 0
    var short = 0
    // 넓이가 작아지는 방법으로 조금씩 늘리자
    sizes.forEach { size ->
        long = max(long, max(size[0], size[1]))
        short = max(short, min(size[0], size[1]))
    }
    return long * short

}