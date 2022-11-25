package boj.`boj-minimum-spanning-tree`

import kotlin.math.pow
import kotlin.math.sqrt


private fun findParent(parent: IntArray, x: Int): Int {
    if (parent[x] != x)
        parent[x] = findParent(parent, parent[x])
    return parent[x]
}

private fun unionParent(parent: IntArray, a: Int, b: Int) {
    val pa = findParent(parent, a)
    val pb = findParent(parent, b)
    if (pa < pb) {
        parent[pb] = pa
    } else {
        parent[pa] = pb
    }
}

fun main() {

    var ans = 0.0

    val (n, m) = readln().split(" ").map { it.toInt() }
    val parent = IntArray(n + 1) { it }
    // x,y, 몇번째(식별자)
    val dots = mutableListOf<Triple<Int, Int, Int>>()

    repeat(n) { idx ->
        val (x, y) = readln().split(" ").map { it.toInt() }
        dots.add(Triple(x, y, idx + 1))
    }
    repeat(m) { // 이미 연결된 통로
        val (a, b) = readln().split(" ").map { it.toInt() }
        unionParent(parent, a, b)
    }
    // dots를 이용해 edges를 만들자
    val edges = mutableListOf<Triple<Int, Int, Double>>()
    for (dot1 in dots) {
        for (dot2 in dots) {
            if (dot1 == dot2) continue
            val a = dot1.third
            val b = dot2.third


            val len1 = (dot1.first - dot2.first).toDouble().pow(2)//.also { println(it) }
            val len2 = (dot1.second - dot2.second).toDouble().pow(2)//.also { println(it) }
            val len = sqrt(len1 + len2)
            edges.add(Triple(a, b, len))


        }
    }
    edges.sortBy { it.third }
    for (edge in edges) {
        if (findParent(parent, edge.first) != findParent(parent, edge.second)) {
            unionParent(parent, edge.first, edge.second)
            ans += edge.third
        }
    }
    println("%.2f".format(ans))
}