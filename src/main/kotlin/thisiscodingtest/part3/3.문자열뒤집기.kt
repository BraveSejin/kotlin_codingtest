import kotlin.math.min

// 연속된 하나 이상의 수를 잡고 뒤집기. 그렇게 해서 수를 전부 같게 하면 된다.

fun main() {
    val data = readln()
    var current = data[0]
    var numZero = if (current == '0') 1 else 0
    var numOne = if (current == '0') 0 else 1

    for (i in 1..data.lastIndex) {
        val next = data[i]
        if (current == next) continue
        current = next
        if (next == '0') numZero += 1
        else numOne += 1
    }
    println(min(numZero, numOne))
}