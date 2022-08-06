package cheetsheet

//https://alpharodun.tistory.com/42 반복문 깔끔 정리

//fun main() = with(System.`in`.bufferedReader()) {
//    // 정수 하나 읽기
//    val num = readLine().toInt()
//
//    // 공백 기준으로 읽기
//    val nums = readLine().split(" ").map { it.toInt() }
//
//    // 문자열 을 char 배열로 받기
//    val char = readLine().toCharArray
//}

//fun main() = with(System.`in`.bufferedReader()) {
//    // 기본
//    print("hello")
//
//    // bufferedWriter
//    val sout = BufferedWriter(OutputStreamWriter(System.out))
//    sout.appendLine()
//    sout.flush()
//    sout.close();
//
//    // 더 짧은 bufferedWriter
//    val bw = System.out.bufferedWriter()
//
//    //템플릿
//    val s = "abc"
//    println("$s.length is ${s.length}") // prints "abc.length is 3"
//}

//val arr = intArrayOf(1, 2, 3)
//val arr = IntArray(4) { it }
//// 내용물을 전체 확인하는 코드
//print(arr.contentToString()) // 결과 [0, 1, 2, 3]
//
//val arr = IntArray(4) { it * 2}
//// 내용물을 전체 확인하는 코드
//print(arr.contentToString()) // 결과 [0, 2, 4, 6]
//
//val booleanArray = Array(n) {
//    BooleanArray(m) { false }
//}
//booeleanArray[1][2] = true
//
//val arr = Array(h) {
//    Array(n) {
//        readLine().split(" ").map { it.toInt() }.toIntArray()
//    }
//}
//
//var list = listOf(1, 2, 3)
//list = list + 4
//print(list)
//
//val numbers = mutableListOf(1, 2, 3, 4)
//val stack = MutableList<Int>(4) { it }
//
//// stack.push(5)
//numbers.add(5)
//
//// stack.pop()
//numbers.removeLast()
//
//// stack.peek()
//numbers.last()
//
//// 비어있는지 확인
//numbers.isEmpty()
//
//// 내용물이 있는지 확인
//numbers.isNotEmpty()
//
////크기
//numbers.size
//
//val que = LinkedList<Int>()
//que.offer(3)
//que.poll()
//que.peek()
//
//import kotlin.collections.ArrayDeque
//
//val deque = ArrayDeque<Int>()ections.ArrayDeque
//
//// 아래 함수들은 모두 first last 모두 가지고 있지만 생략
//        deque.addLast(1) // exception 반환
//deque.offerFirst(2) // exception 반환 X
//
//deque.removeFirst() // exception 반환
//deque.pollLast() // exception 반환 X
//
//deque.peekFirst()
//deque.peekLast()