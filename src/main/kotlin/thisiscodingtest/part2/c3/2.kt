fun main() {
    // M번 더해서 가장 큰 수 더하기. K번 초과 불가
   sol2()


}

private fun sol2() {
    val (N, M, K) = readLine()!!.split(" ").map { it.toInt() }
    val data = readLine()!!.split(" ").map { it.toInt() }.sorted().reversed()

    val first = data[0]
    val second = data[1]
    var res = 0

    val numChunk = M / (K + 1)
    val numEtc = (M - numChunk * (K + 1))

    val numFirst = K * numChunk
    val numSecond = numChunk + numEtc

    var sumFirst = numFirst * first
    var sumSecond = numSecond * second

    print(sumFirst + sumSecond)
}

private fun sol1() {
    val (N, M, K) = readLine()!!.split(" ").map { it.toInt() }
    val data = readLine()!!.split(" ").map { it.toInt() }.sorted().reversed()

    val first = data[0]
    val second = data[1]
    var res = 0

    var numFirstAdded = 0
    repeat(M) {
        if (numFirstAdded != K) {
            res += first
            numFirstAdded += 1
        } else {
            res += second
            numFirstAdded = 0
        }
    }

    println(res)

}
/**
 * 5 8 3
 * 2 4 5 4 6
 * */