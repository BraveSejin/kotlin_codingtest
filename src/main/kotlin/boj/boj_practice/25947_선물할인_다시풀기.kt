package boj.boj_practice


fun main() {

    var (item, budget, discountCnt) = readln().split(" ").map { it.toInt() }
    val gift = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    var answer = 0
    var sum = 0L
    val discounted = BooleanArray(item)

    // 할인 없이 구매할 수 있는 만큼 구매하기
    for (i in 0 until item) {
        if (sum + gift[i] <= budget) {
            sum += gift[i]
            answer++
        } else {
            var end = true
            for (j in (0..i).reversed()) {
                if (discounted[j]) continue
                if (discountCnt == 0) break
                sum -= gift[j] / 2
                discountCnt --
                discounted[j] = true
                if (sum + gift[i] <= budget){
                    end = false
                    sum += gift[i]
                    answer = i + 1
                    break
                }
            }
            if (end) break
        }
    }

    // 다음 아이템을 할인해서 구매 시도
    // 그래도 안되면 이전 아이템들을 할인한 것으로 생각하고 구매 시도

    println(answer)

}