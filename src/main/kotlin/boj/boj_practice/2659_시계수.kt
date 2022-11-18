// 시계수 : 카드 숫자를 시계방향으로 읽어서 만들어지는 네자리 수중 가장 작은 수
// 답 : 모든 시계수 중에서 몇 번쨰로 작은 시계수인지 출력

fun main() {
    // 전체 시계수 1111 ~ 9999 // 0이 들어올 수 없음.
    // 입력의 시계수 (X)
    // indexOf (X)
    // X - 1111
    // 1122 - 1111 = 11
    // 전체 시계수를 만드는 로직

    val line = readln().split(' ').map { it.toInt() }.toMutableList()
    line.addAll(line.take(3))
    val set = HashSet<Int>()
    for (i in 0..3) {
        set.add(line.subList(i, i + 4).joinToString("").toInt())
    }
    val curClock = set.minOf { it }

    var seq = 0
    for (i in 1111..9999) {
        if (i.toString().contains('0')) continue
        if (getClock(i) != i) continue
        seq += 1
        if (i == curClock)
            break
    }
    println(seq)
}

private fun getClock(num: Int): Int {
    val temp = num.toString()
    val ttemp = temp + temp.take(3)
    val set = HashSet<Int>()
    for (i in 0..3) {
        set.add(ttemp.substring(i, i + 4).toInt())
    }
    return set.minOf { it }
}