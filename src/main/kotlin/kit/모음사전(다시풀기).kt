package kit

fun main() {
    solution("AAAE").also { println(it) }
}

private var ans = 0
private var found = false
private fun solution(word: String): Int {
    var answer = 0

    var start = ""
    dfs(start, 0, word)

    return ans
}

private fun dfs(string: String, depth: Int, target: String) {
    println(string)
    if (found) return
    ans += 1
    if (string == target) {
        found = true
        return
    }


    if (depth != 4) {
        dfs(string + "A", depth + 1, target)
        dfs(string + "E", depth + 1, target)
        dfs(string + "I", depth + 1, target)
        dfs(string + "O", depth + 1, target)
        dfs(string + "U", depth + 1, target)
    }


    when (string[depth]) {
        'A' -> dfs(string.replace(string[depth], 'E'), depth, target)
        'E' -> dfs(string.replace(string[depth], 'I'), depth, target)
        'I' -> dfs(string.replace(string[depth], 'O'), depth, target)
        'O' -> dfs(string.replace(string[depth], 'U'), depth, target)
    }


}