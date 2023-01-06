import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/**
 * 이분탐색으로 풀 경우 jvm으로는 시간초과가 나게 되는것 같다. 자바로는 다른 코드도 다 pq로 풀었다
 * 입출력으로 더 개선할 수도 있는지.. 는 콘솔 입출력 공부를 따로 해야할 것인데 뒤로 미뤄두자.
 */

private data class Beer(val level: Int, val prior: Int)
fun main() {
    val (n,m,k) = readln().split(" ").map { it.toInt() }
    val beers = mutableListOf<Beer>()
    val br = BufferedReader(InputStreamReader(System.`in`))

    var left = Int.MAX_VALUE
    var right = 0

    repeat(k){
        val st = StringTokenizer(br.readLine())
        val priority = st.nextToken().toInt()
        val level = st.nextToken().toInt()
        beers.add(Beer(level = level, prior = priority))
        left = if (left > level) level else left
        right = if (right < level) level else right
    }
    beers.sortBy { it.level}

    var ans = -1
    while (left <= right){
        val mid = (left + right) / 2
        if (total(beers, mid, n) >= m){
            ans = mid
            right = mid - 1
        }else{
            left = mid + 1
        }
    }
    println(ans)
}

private fun total(beers: List<Beer>, level: Int, n: Int): Int{
    var s = 0
    var cnt = 0
    for (beer in beers){
        if (beer.level > level) break
        s += beer.prior
        cnt += 1
    }
    if (cnt != n) return -1
    return s

}