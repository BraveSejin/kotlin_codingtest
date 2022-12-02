package boj.`boj-binsearch`

fun main()  = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val card = readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
    val m = readLine().toInt()
    val nums = readLine().split(" ").map { it.toInt() }

    // 특정 수의 처음과 마지막 인덱스를 찾으면 된다.
    // 라이브러리로 하면 시간초과날듯
    val sb = StringBuilder()
    nums.forEach {
        sb.append("${upperIndex(card,it) - lowerIndex(card,it)} ")
    }
    println(sb)


}

private fun lowerIndex(data: IntArray, target: Int): Int {
    var st = 0
    var end = data.lastIndex + 1 // 주의!! +1임.
    while (st < end) {
        val mid = (st + end) / 2
        if (data[mid] > target) {
            end = mid
        } else if (data[mid] == target) { // 현재 mid가 가장 왼쪽 위치일 수도 있고, mid가 더 작아도 괜찮을수도 있다
            end = mid
        } else if (data[mid] < target) {
            st = mid + 1
        }
    }
    return st
}

private fun upperIndex(data: IntArray, target: Int): Int {
    var st = 0
    var end = data.lastIndex + 1
    while (st < end) {
        val mid = (st + end) / 2
        if (data[mid] > target) {
            end = mid
        } else if (data[mid] == target) { //mid가 가장 큰 위치일 수도 있고, mid가 더 커져도 될 수 있음.
            st = mid + 1
        } else if (data[mid] < target) {
            st = mid + 1
        }
    }
    return st // 실제 인덱스가 아님!!
}