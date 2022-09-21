package kit

import java.util.Stack

fun main() {
    solution("4321", 1).also { println(it) }
}

private fun solution(number: String, k: Int): String {
    val stack = Stack<Char>()
    var remain = k
    number.forEach {
        if (stack.isEmpty()) {
            stack.push(it)
        } else {
            while (stack.isNotEmpty() && stack.peek() < it && remain != 0) {
                stack.pop()//.also { println("pop: $it") }
                remain -= 1
            }
            stack.push(it)
        }
    }
    return stack.dropLast(remain).joinToString("")
}