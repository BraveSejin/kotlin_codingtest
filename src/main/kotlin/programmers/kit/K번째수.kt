package programmers.kit


fun main() {
    val ar1 = intArrayOf(1,5,2,6,3,7,4)
    val ar2 = arrayOf(intArrayOf(2,5,3), intArrayOf(4,4,1), intArrayOf(1,7,3))
    solution(ar1,ar2).also { println(it.toList()) }
}

private fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
    var answer = IntArray(commands.size) { 0 }
    commands.forEachIndexed { index, cmd ->
        val (i, j, k) = cmd

        answer[index] = array.slice(i-1..j-1).sorted()[k-1]
    }

    return answer
}