package programmers.kit

fun main() {

//    solution(7, intArrayOf(2,4,7), intArrayOf(1,3,5)).also { println(it) }
//    solution(5, intArrayOf(2,4), intArrayOf(1,3,5)).also { println(it) }
    solution(4, intArrayOf(2, 4), intArrayOf(1, 3)).also { println(it) }
}

private fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
    val array1 = IntArray(n + 2) { 1 }
    val array2 = IntArray(n + 2) { 0 }

    lost.forEach { it -> array1[it] = 0 }
    reserve.forEach { it ->
        if (array1[it] == 0)
            array1[it] = 1
        else
            array2[it] = 1
    }
    for (i in 1..n) {
        if (array1[i] == 0) {
            if (array2[i - 1] == 1) {
                array2[i - 1] = 0
                array1[i] = 1
            } else if (array2[i + 1] == 1) {
                array2[i + 1] = 0
                array1[i] = 1
            }
        }
    }

    return array1.also { println(it.toList()) }.sum() - 2
}

private fun solution2(n: Int, lost: IntArray, reserve: IntArray): Int {

    var answer = n
    var lostSet = lost.toSet() - reserve.toSet()
    var reserveSet = (reserve.toSet() - lost.toSet()) as MutableSet

    for (i in lostSet) {
        println(i)
        when {
            i - 1 in reserveSet -> reserveSet.remove(i - 1)
            i + 1 in reserveSet -> reserveSet.remove(i + 1)

            else -> answer--
        }
    }
    return answer
}