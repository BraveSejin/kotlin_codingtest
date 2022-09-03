fun main() {
    val N = readLine()!!.toInt()
    // 3이 하나라도 포함되는 경우
    // 00 ~ 59라면 : 3 13 23 33 43 53 .. 6개
    var num_3_in_hour = 0
    for (i in 0..N) {
        for (j in 0..59) {
            for (k in 0..59) {
                if (i.toString().contains('3') || j.toString().contains('3') || k.toString().contains('3'))
                    num_3_in_hour += 1
            }
        }
    }
    println(num_3_in_hour)


}