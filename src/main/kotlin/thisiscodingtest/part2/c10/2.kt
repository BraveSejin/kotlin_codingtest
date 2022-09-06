package thisiscodingtest.part2.c10

fun main() {
    // m은 연산의 개수
    val (n, m) = readln().split(" ").map { it.toInt() }
    // n+1팀 존재
    val parent = Array(n + 1) { it } // 0번 부터 n번팀까지 총 n+1팀

    repeat(m) {
        val (op, a, b) = readln().split(" ").map { it.toInt() }
        if (op == 0) {
            unionParent(parent, a, b)
        } else {
            println(if (findParent(parent, a) == findParent(parent, b)) "YES" else "NO")
        }
    }
}

private fun findParent(parent: Array<Int>, x: Int): Int {
    if (x != parent[x]) {
        parent[x] = findParent(parent, parent[x])
    }
    return parent[x]
}

private fun unionParent(parent: Array<Int>, a: Int, b: Int) {
    if (a > b) {
        parent[a] = findParent(parent, b)
    } else {
        parent[b] = findParent(parent, a)
    }
}