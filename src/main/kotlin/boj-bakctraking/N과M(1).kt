
private val visited = BooleanArray(10){false}
private val arr = IntArray(10){0}

private var n: Int = 0
private var m: Int = 0
fun main() = with(System.`in`.bufferedReader()){
    val input= readln().split(' ').map { it.toInt() }
        .also {
            n = it[0]
            m = it[1]
        }
    select(0)
}

private fun select(depth: Int){
    if (depth== m){
        for (i in 0 until m){
            print("${arr[i] }")
        }
        println()

        return
    }
    for (i in 1 .. n){
        if (visited[i]) continue
        arr[depth] = i
        visited[i] = true
        select(depth + 1)
        visited[i] = false
    }
}