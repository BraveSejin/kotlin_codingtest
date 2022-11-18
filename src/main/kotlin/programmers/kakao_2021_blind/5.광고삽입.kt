package programmers.kakao_2021_blind

fun main() {
//    solution(
//        "02:03:55", "00:14:15", logs = arrayOf(
//            "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"
//        )
//    ).also { print(it) }
//
//    solution(
//        "00:00:12", "00:00:05", logs = arrayOf(
//            "00:00:01-00:00:04","00:00:02-00:00:05","00:00:04-00:00:10","00:00:04-00:00:06",)
//    ).also { print(it) }

    solution(
        "99:59:59", "25:00:00", logs = arrayOf(
            "69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"
        )
    ).also { print(it) }

}

private fun solution(play_time: String, adv_time: String, logs: Array<String>): String {

    val totalTime = convTimeToSec(play_time)
    val record = IntArray(totalTime + 1) // 현재 시청중인 사람들
    val adTime = convTimeToSec(adv_time)

    logs.forEach { log ->
        val (st, en) = log.split('-')
        val start = convTimeToSec(st)
        val end = convTimeToSec(en)
        record[start] += 1 // 여기부터 한개 증가
        record[end] -= 1 // 여기부터 한개 빠짐
    }

    for (i in 1 until totalTime) {
        record[i] = record[i - 1] + record[i]
    }

    // 누적 가장 많은 부분 계산
    var index = 0
    var mx: Long = record.take(adTime).sum().toLong()
    var curVal = mx

    for (i in 1..totalTime - adTime) {
        curVal = curVal - record[i - 1] + record[i - 1 + adTime]
        if (mx < curVal) {
            mx = curVal
            index = i
        }
    }

    return convSecToTIme(index)
}

private fun convTimeToSec(time: String): Int {
    val (h, m, s) = time.split(':')
    val hour = h.toInt() * 3600
    val minute = m.toInt() * 60
    val sec = s.toInt()
    return hour + minute + sec
}

private fun convSecToTIme(time: Int): String {
    val h = time / 3600
    val etc1 = time % 3600
    val m = etc1 / 60
    val s = etc1 % 60
//    return "${if (h >= 10) h.toString() else "0$h"}:${if (m >= 10) m.toString() else "0$m"}:${if (s >= 10) s.toString() else "0$s"}"
    return String.format("%02d:%02d:%02d", h, m, s)

}