package thisiscodingtest.part3

fun main() {
    val input = readln()
    val (left, right) = input.chunked(input.length/2).map { it.toInt() }.map { it
        var sum = 0
        var temp = it
        while (temp != 0){
            sum += temp  % 10
            temp = temp / 10
        }
        sum
    }
//    println("$left $right")
    if (left == right) println("LUCKY")
    else println("READY")
}