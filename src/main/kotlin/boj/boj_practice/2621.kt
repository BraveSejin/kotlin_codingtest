package boj.boj_practice


// 색 4개, 색깔별 카드 9장
/*
연속 여부
몇장의 숫자가 같은지,
색이 모두 같은지
*
* */
private enum class Color {
    R, B, Y, G
}

fun main() {
    val colorMap = HashMap<Color, Int>()
    val numberMap = HashMap<Int, Int>()

    repeat(5) {
        readln().split(' ').also { it ->
            colorMap.merge(Color.valueOf(it[0]), 1, Integer::sum)
            numberMap.merge(it[1].toInt(), 1, Integer::sum)
        }
    }

    var ans = 0
    // 1. 모두 같은 색, 숫자의 연속
    if ((colorMap.size == 1) && isCont(numberMap.keys.toList())) {
        ans = ans.coerceAtLeast(numberMap.keys.maxOf { it } + 900)
    }
// 2. 카드 4장의 숫자가 같을 경우
/*
B 3
R 3
B 7
Y 3
G 3
*/
    // 값이 4인 키 가져오기
    else if (numberMap.values.contains(4)) {
        val key = numberMap.filter { it.value == 4 }.keys.first()
        ans = ans.coerceAtLeast(key + 800)
    }
/*
R 5
Y 5
G 7
B 5
Y 7
*/
    else if (3 in numberMap.values && 2 in numberMap.values) {
        val key1 = numberMap.filter { it.value == 3 }.keys.first()
        val key2 = numberMap.filter { it.value == 2 }.keys.first()

        ans = ans.coerceAtLeast(key1 * 10 + key2 + 700)
    }
    //4. 5장의 색이 모두 같은 경우
/*
Y 3
Y 4
Y 6
Y 8
Y 7
*/
    else if (5 in colorMap.values) {
        val key = numberMap.keys.maxOf { it }
        ans = ans.coerceAtLeast(key + 600)
    }
    // 5. 5장 숫자 연속인 경우
    /**
    R 7
    R 8
    G 9
    Y 6
    B 5
     * */

    else if (isCont(numberMap.keys.toList())) {
        val key = numberMap.keys.maxOf { it }
        ans = ans.coerceAtLeast(key + 500)
    }
    // 6. 5장중 3장의 숫자가 같은 경우:

//R 5
//Y 5
//Y 4
//G 9
//B 4
    else if (3 in numberMap.values) {
        val key = numberMap.filter { it.value == 3 }.keys.first()
        ans = ans.coerceAtLeast(key + 400)
    }
    // 7. 두장 두장 숫자 같은 경우
    else if (numberMap.values.count { it == 2 } == 2) {
        val keys = numberMap.filter { it.value == 2 }.keys
        val bigKey = keys.maxOf { it }
        val smallKey = keys.minOf { it }
        ans = ans.coerceAtLeast(bigKey * 10 + smallKey + 300)

    }
    // 8. 두개만 같은 경우
    else if (2 in numberMap.values) {
        val key = numberMap.filter { it.value == 2 }.keys.first()
        ans = ans.coerceAtLeast(key + 200)
    } else {
        ans = ans.coerceAtLeast(numberMap.keys.maxOf { it } + 100)
    }

    println(ans)


}

private fun isCont(list: List<Int>): Boolean {
    if (list.size != 5) return false
    val sorted = list.sorted()
    for (i in 0..3)
        if (sorted[i] + 1 != sorted[i + 1])
            return false

    return true
}