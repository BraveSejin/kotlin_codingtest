package boj.boj_practice

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    // 5개의 수가 주어질 때, 이 중 적어도 3개로 나누어 지는 가장 작은 자연수
    // 3개로 나누어 지는 수중 가장 큰 수는 뭐지? 1 ~ 100 1만 안쪽일 것 같음
    // a,b,c 의 공배수여야 하는데 a*b*c  *( [abc > 0] 또는 1)
    // 이러면 가장 작은 공배수의 극악의 경우. 커봤자 100 * 99 * 98
    var ans = 0
    for (target in 4 .. 100 * 99 * 98){
        var cnt = 0
        for (num in input){
            if (target % num == 0)
                cnt ++
        }
        if (cnt >= 3){
            ans = target
            break
        }
    }

    println(ans)
}