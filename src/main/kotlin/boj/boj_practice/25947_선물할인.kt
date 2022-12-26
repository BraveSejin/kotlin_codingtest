package boj.boj_practice


fun main() {

    var (n, budget, chance) = readln().split(" ").map { it.toInt() }
    val gifts = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    var total = 0L
    var answer = n

    // 결론적으로
    for (i in 0 until n){
        total += gifts[i] / 2 // 일단 할인해서 산다.
        if (i >= chance) //
            total += gifts[i - chance] / 2 // 기존에 할인받았덪거 반납
        if (total > budget){
            answer = i
            break
        } // 구입 못하는 경우 : 인덱스가 정답\\\
    }

    println(answer)

}