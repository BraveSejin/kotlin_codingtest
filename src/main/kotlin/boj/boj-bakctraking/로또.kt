package boj.`boj-bakctraking`

private val reader = System.`in`.bufferedReader()
private val writer = System.out.bufferedWriter()
private val arr = IntArray(6)
lateinit var line: MutableList<Int>

fun main() {
    while (true) {
        line = reader.readLine().split(' ').map { it.toInt() }.toMutableList()
        val k = line[0]
        if (k == 0) break
        val set = line.takeLast(k)

        func(0, k)
        writer.write("\n")
        writer.flush()
    }

}

private fun func(depth: Int, k: Int) {
    if (depth == 6) {
        for (i in 0 until 6){
            writer.write("${line[arr[i]+1]} ")
        }
        writer.write("\n")
        return
    }

    val st = if (depth == 0) 0 else arr[depth-1] + 1
    for (i in st until k){
        arr[depth] = i
        func(depth+1, k)
    }

}

