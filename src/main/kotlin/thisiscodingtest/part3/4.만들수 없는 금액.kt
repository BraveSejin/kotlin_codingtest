package thisiscodingtest.part3

fun main() {
    val n = readln().toInt()
    val data = readln().split(" ").map { it.toLong() }.sorted()


    var target = 1L // 타겟보다 작거나 같은 동전이 있다면 타겟을 만들 수 있다.
    for (x in data) {
        if (target < x) break
        target += x
    }
    println(target)
}