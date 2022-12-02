fun main() {
    val n = readln().toInt()
    val data = readln().split(" ").map { it.toInt() }.toMutableList()
    val M = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }

    // nums 의 수들이 data 에 존재하는지 찾으면 됨.

    data.sort()
    nums.forEach { target ->

        if (binSearch(data, target)) {
            println(1)
        } else {
            println(0)
        }
    }

}

private fun binSearch(data: List<Int>, target: Int): Boolean {

    var st = 0
    var end = data.lastIndex

    while (st <= end) {
        val mid = (st + end) / 2

        if (data[mid] < target) {
            st = mid + 1
        } else if (data[mid] > target) { // data[mid] >- target
            end = mid - 1
        } else {
            return true
        }

    }
    return false
}