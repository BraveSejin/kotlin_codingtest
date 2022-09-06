package thisiscodingtest.part2.c5

import java.util.LinkedList
import java.util.Stack

fun main() {
    stackEx()
    queueEx()
//    recurEx()
    println( factorial_iterative(5))
    println( factorial_recursive(5))
}

fun stackEx() {
    println("stack example")
    val stack = Stack<Int>()
    stack.push(5)
    stack.push(2)
    stack.push(3)
    stack.push(7)
    stack.pop()
    stack.push(1)
    stack.push(4)
    stack.pop()
    println(stack)
    println(stack.reversed())

}

private fun queueEx() {
    println("queue example")
    val queue = LinkedList<Int>()
    queue.offer(5)
    queue.offer(2)
    queue.offer(3)
    queue.offer(7)
    queue.poll()
    queue.offer(1)
    queue.offer(4)
    queue.poll()
    println(queue)
    println(queue.reversed())

}

fun recurEx() {
    println("recur func invoked")
    recurEx()
}

fun factorial_iterative(n: Int): Int {
    var result = 1
    for (i in 1..n) result *= i
    return result
}

fun factorial_recursive(n: Int): Int {
    if (n == 1) return 1
    return n * factorial_recursive(n - 1)
}