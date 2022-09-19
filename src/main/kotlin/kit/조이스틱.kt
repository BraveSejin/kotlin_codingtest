package kit

import kotlin.math.abs
import kotlin.math.min

fun main() {
    solution("AB").also { println(it) }

}

private fun solution(name: String): Int {

    val changeCount = name.fold(0) { total, c -> total + diff(c) }

    var move = name.length - 1
    // A로 이루어진 청크가 여러개 있을 것임. A가 아닌 모든 알파벳은 한번씩 방문해야함.
    // A가 아닌 알파벳을 발견할 수 있도록 index를 도입한다.
    // 마지막 index 뒷부분에 있는 것을 etc라고 할것임.  i 는 인덱스를 탐색하기 시작한 위치인데
    for (i in name.indices) {

        var index = i + 1
        while (index < name.length && name[index] == 'A') {
            index += 1
        }
        val etc = name.length - index // A가 끊긴 나머지 부분의 길이
        move = min(move, i * 2 + etc) // A 청크 앞부분을 왕복한 후 뒷부분 가기
        move = min(move, etc * 2 + i) // A 청크 뒷부분 먼저 왕복한 후 앞부분 가기

    }

    return changeCount + move
}

private fun diff(target: Char): Int {
    val upperCount = target.code - 'A'.code
    val lowerCount = 'Z'.code.plus(1) - target.code
    return min(upperCount, lowerCount)
}
