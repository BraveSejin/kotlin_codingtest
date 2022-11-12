package kakao_2019_blind

//참고: https://yline.tistory.com/43
private fun solution(relation: Array<Array<String>>): Int {

    val keyFiledSet = mutableListOf<Int>()
    val rowLen = relation.size
    val colLen = relation[0].size

    for (i in 1 until (1 shl colLen)) {

        if (keyFiledSet.any { (i and it) == it }) continue // 7을 넣을 차례에, 이미 3이 들어가 있는경우 0111, 0011: 7을 넣지 말아야한다.
        if (isUnique(i, relation, rowLen, colLen))
            keyFiledSet.add(i)

    }
    return keyFiledSet.size
}

private fun isUnique(index: Int, relation: Array<Array<String>>, rowLen: Int, colLen: Int): Boolean {
    val hs = HashSet<String>()
    for (row in 0 until rowLen) {
        val dataBuilder = StringBuilder()
        for (col in 0 until colLen) {
            if (index and (1 shl col) != 0) {
                dataBuilder.append(relation[row][col]) // 선택한 열에 해당하는 값을 추가
            }
        }
        val data = dataBuilder.toString()
        if (hs.contains(data)) return false
        else hs.add(data)
    }
    return true
}
fun main() {
    solution(
        arrayOf(
            arrayOf("100", "ryan", "music", "2"),
            arrayOf("200", "apeach", "math", "2"),
            arrayOf("300", "tube", "computer", "3"),
            arrayOf("400", "con", "computer", "4"),
            arrayOf("500", "muzi", "music", "3"),
            arrayOf("600", "apeach", "music", "2")
        )
    ).also { println(it) }
}

