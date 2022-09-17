package kit

fun main() {
   sol()
}

private fun sol(): Int{
    val inputNums = intArrayOf(3,3,3,2,2,2)
    val pickSize =inputNums.size / 2

    return inputNums.toSet().let { it ->
        if (it.size >= pickSize)
            pickSize
        else
            it.size

    }.also { println(it) }
}