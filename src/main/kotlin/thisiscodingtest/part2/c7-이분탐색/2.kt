package thisiscodingtest.part2.`c7-이분탐색`

fun main() {
    sol2()
}

private fun sol1() {
    val n = readLine()!!.toInt()
    val have = readLine()!!.split(" ").map { it.toInt() }.sorted()

    val m = readLine()!!.toInt()
    val target = readLine()!!.split(" ").map { it.toInt() }

//    target.forEach { it ->
//        if (bin_search(have, it)) print("yes ")
//        else print("no ")
//    }

    target.forEach {
        if (have.binarySearch(it, comparator = naturalOrder()) < 0) print("no ")
        else print("yes ")
    }
    fun bin_search(list: List<Int>, target: Int): Boolean {
        var start = 0
        var end = list.lastIndex
        var mid = (start + end) / 2


        while (start <= end) {

            if (list[mid] == target)
                return true
            if (list[mid] > target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
            mid = (start + end) / 2

        }
        return false

    }

}

private fun sol2() {
    val n = readLine()!!.toInt()
    val have = readLine()!!.split(" ").map { it.toInt() }.toSet()

    val m = readLine()!!.toInt()
    val target = readLine()!!.split(" ").map { it.toInt() }

    target.forEach { it
        if (it in have) println("yes ")
        else println("no ")
    }
}
