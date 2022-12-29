package codeforce

fun main() {
    val T = readln().toInt()
    for (i in 0 until T){
        val input = readln().toInt()
        if (input % 2 == 1){
            println("7${make1(input - 3)}")
        }else{
            println(make1(input))
        }
    }
}

private fun make1(n: Int): String{
    val iter = n / 2
    var s = StringBuilder()
    repeat(iter){
        s.append(1)
    }
    return s.toString()
}