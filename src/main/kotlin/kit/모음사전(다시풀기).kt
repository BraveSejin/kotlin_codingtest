package kit

fun main() {
    solution("EIO").also { println(it) }
    solution2("EIO").also { println(it) }
}

private fun solution(word: String): Int {
    val arr = intArrayOf(781, 156, 31, 6, 1)
    var ans = 0
    word.forEachIndexed { index, char ->
        when (char) {
            'A' -> ans += 0 * arr[index] + 1
            'E' -> ans += 1 * arr[index] + 1
            'I' -> ans += 2 * arr[index] + 1
            'O' -> ans += 3 * arr[index] + 1
            'U' -> ans += 4 * arr[index] + 1
        }
    }
    return ans
}


private val aeiou = charArrayOf('A', 'E', 'I', 'O', 'U')
private var cnt = -1 // ""은 -1
private var done = false

private fun solution2(word: String): Int {
    var answer = 0
    dfs(0, "", word)

    return cnt
}

private fun dfs(depth: Int, next: String, target: String) {
    if (depth == 6) {
        return
    }
    cnt += 1
    if (next == target) {
        done = true
        return
    }
    for (c in aeiou) {
        if (done) return
        dfs(depth + 1, next.plus(c), target)
    }

}
