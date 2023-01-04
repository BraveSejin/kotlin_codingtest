import java.util.LinkedList
fun main() {
    val S = readln().toInt()
    val dist = Array(S+1){
        IntArray(S+1) {-1}
    }
    val q = LinkedList<Pair<Int,Int>>()
    q.add(1 to 0)
    dist[1][0] = 0
    while (q.isNotEmpty()){
        val (s,c) = q.pop() // BFS형식을 이용해서, S,C랑 물리적으로 인접하지 않아도 됨.
        // 문제 정의상 연산당 비용이 일정하기 때문에 한번 접근한 곳보다 더 빠르게 접근할 수 있는 경우가 없음.
        // 연산이 어떤건 +2 고 어떤건 +3이면 다를 수도!
        if (dist[s][s] == -1){ // 클립보드에 새로 복사
            dist[s][s] = dist[s][c] + 1
            q.add(s to s)
        }
        if (s + c <= S && dist[s+c][c] == -1){ // 클립보드에 있는만큼 더하기
            dist[s+c][c] = dist[s][c] + 1
            q.add(s+c to c)
        }
        if ( s-1 >= 0 && dist[s-1][c] == -1){ // 클립보드에서 하나 빼기
            dist[s-1][c] = dist[s][c] + 1
            q.add(s-1 to c)
        }
    }
//    dist.forEach { it ->
//        println(it.toList())
//    }
    println(dist[S].filter { it != -1 }.minOf { it })
}