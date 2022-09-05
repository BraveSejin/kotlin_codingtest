package thisiscodingtest.part2.c6

import java.util.Collections
import java.util.LinkedList


fun main() {
//    sol2()
//    sol3()
    sol4()
}

private fun sol2() {
    val n = readLine()!!.toInt()
    val array = Array(n) {
        readln().toInt()
    }
    println(array.sortedWith(reverseOrder()))
}

private fun sol3() {
    val n = readLine()!!.toInt()

    val array = Array(n) {
        val line = readln().split(" ")
        Pair<String, Int>(line.first(), line[1].toInt())

    }

    array.sortWith(Comparator { o1, o2 ->
        o1.second - o2.second
    })
    array.map { it -> it.first }.forEach {
        print("$it ")
    }
}

private fun sol4() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val A = readln().split(" ").map { it.toInt() }.toMutableList()
    val B = readln().split(" ").map { it.toInt() }.toMutableList()
    // B에서 가장 큰것들을 A의 가장 작은들과 스왑하면 된다.
    A.sort() // 1234
    B.sortWith(reverseOrder()) // 4321

    println(A.subList(k, A.size).sum() + B.subList(0, k).sum())
}

