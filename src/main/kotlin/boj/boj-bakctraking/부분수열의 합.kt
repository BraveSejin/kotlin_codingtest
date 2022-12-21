package boj.`boj-bakctraking`

import kotlin.properties.Delegates

private var n by Delegates.notNull<Int>()
private var s by Delegates.notNull<Int>()
private lateinit var data: IntArray
private var ans: Int = 0

fun main() {
    val ns = readln().split(" ").map { it.toInt() }
    n = ns[0]
    s = ns[1]
    data = readln().split(" ").map { it.toInt() }.toIntArray()
//    func(0,0)
//    if (s == 0) ans-- // 공집합은 안
    println(ans)

}

private fun func(depth: Int, acc: Int) {
    if (depth == n ){
        if (acc == s) ans++
        return
    }
    // 현재를 선택하는 경우
    func(depth+1, acc)
    func(depth+1, acc + data[depth])
    // 현재를 선택하지 않는 경우
}
