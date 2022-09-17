package kit

fun main() {
    solution_dfs(intArrayOf(1, 1, 1, 1), 2).also { println(it) }
}
// 타겟넘버를 만드는 경우의 수.
// 더하고 뺴다 보면 - 1000 ~ 1000 까지의 숫자들이 나올 것임.

private fun solution(numbers: IntArray, target: Int): Int {
    var leaves = mutableListOf<Int>(0)
    // 전부 다 양수인 경우, 하나만 음수인 경우, 두개만 음수인 경우..
    numbers.forEach { it ->
        val temp = mutableListOf<Int>()
        for (leaf in leaves) {
            temp.add(leaf + it)
            temp.add(leaf - it)
        }
        leaves = temp
    }

    return leaves.count { it == target }
}

private fun solution_dfs(numbers: IntArray, target: Int): Int {
    return dfs(numbers, target, 0)
}

private fun dfs(numbers: IntArray, target: Int, depth: Int): Int {
    var ans = 0
    if (depth == numbers.size) {
        if (numbers.sum() == target)
            return 1
        else return 0
    } else {
        ans += dfs(numbers, target, depth +1)
        numbers[depth] *= -1
        ans += dfs(numbers, target, depth +1)
        return ans
    }


}

