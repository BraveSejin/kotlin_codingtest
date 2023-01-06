import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val (n,m,k) = readln().split(" ").map { it.toInt() }
    val br = BufferedReader(InputStreamReader(System.`in`))
    val beers = mutableListOf<Pair<Int,Int>>()

    repeat(k){
        val st = StringTokenizer(br.readLine())
        val priority = st.nextToken().toInt()
        val level = st.nextToken().toInt()

        beers.add(priority to level)
    }
    beers.sortWith(Comparator{ o1, o2 ->
        o1.second - o2.second
    })

    val pq = PriorityQueue<Int>()
    var sum = 0
    for (beer in beers){
        pq.add(beer.first)
        sum += beer.first
        if (pq.size > n){
            sum -= pq.first()
            pq.poll()
        }
        if (pq.size == n && sum >= m){
            println(beer.second)
            return
        }
    }
    println(-1)
}

