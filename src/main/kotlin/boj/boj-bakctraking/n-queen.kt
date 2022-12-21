package boj.`boj-bakctraking`

import kotlin.properties.Delegates

private var n by Delegates.notNull<Int>()
private lateinit var isUsed1: BooleanArray
private lateinit var isUsed2: BooleanArray
private lateinit var isUsed3: BooleanArray
private var ans = 0
fun main() {
    n = readln().toInt()
    isUsed1 = BooleanArray(n) // 열
    isUsed2 = BooleanArray(2*n) // 열
    isUsed3 = BooleanArray(2*n) // 열

    selectRow(0)
    println(ans)

}

private fun selectRow(row: Int) {
    if (row == n ) {
        ans += 1
        return
    }
    for (col in 0 until n) {
        if (!isUsed1[col] && !isUsed2[row + col] && !isUsed3[row - col + n - 1]) {
            isUsed1[col] = true
            isUsed2[row + col] = true
            isUsed3[row - col + n - 1] = true
            selectRow(row + 1)
            isUsed1[col] = false
            isUsed2[row + col] = false
            isUsed3[row - col + n - 1] = false
        }
    }

}