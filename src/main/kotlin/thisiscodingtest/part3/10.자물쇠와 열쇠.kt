fun main() {
    val key1 = arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 0), intArrayOf(0, 1, 1))
    val lock1 = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))
    val key2 = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))
    val lock2 = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))
    Solution().solution(
        key = key1,
        lock = lock1
    ).also { print(it) }

//    Solution().solution(
//        key = key2,
//        lock = lock2
//    ).also { print(it) }

}
// 실패: 1,7,14, 23 , 25 ~ 31, 33
private fun rotateKey(key: Array<IntArray>): Array<IntArray> {
    val size = key.size
    val result = Array<IntArray>(size) { IntArray(size) { 0 } }

    for (i in 0 until size) {
        for (j in 0 until size) {
            result[j][size - 1 - i] = key[i][j]
        }
    }
    return result
}

private fun checkValid(newBoard: Array<IntArray>, lockSize: Int): Boolean {
    for (i in 0 until lockSize) for (j in 0 until lockSize)
        if (newBoard[lockSize + i][lockSize + j] == 0) return false
    return true
}

private class Solution {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val extendedBoard = Array(3 * lock.size) { IntArray(3 * lock.size) }
            .apply {
                for (i in 0 until lock.size) for (j in 0 until lock.size)
                    this[lock.size + i][lock.size + j] = lock[i][j]
            }
        var prevKey = key
        val keys = Array<Array<IntArray>>(4) {
            prevKey = rotateKey(prevKey)
            prevKey
        }
        keys.forEach { key ->
            for (i in 0 until 2 * lock.size) {
                for (j in 0 until 2 * lock.size) {
                    val newBoard = extendedBoard.map { it.clone() }.toTypedArray()
                    for (a in key.indices) {
                        for (b in key.indices) {

                            newBoard[i + a][j + b] = key[a][b] xor newBoard[i + a][j + b]
                        }
                    }

//                    println("key")
//                    key.forEach { println(it.toList()) }
//                    println("board")
//                    newBoard.forEach { println(it.toList()) }

                    if (checkValid(newBoard, lock.size)) return true

                }
            }
        }


        return false
    }
}