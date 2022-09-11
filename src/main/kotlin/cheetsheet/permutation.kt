private fun <T> permute(sub: List<T>, fin: List<T> = listOf()): List<List<T>> {
    return if (sub.isEmpty()) listOf(fin) // sub에 있는 하나씩 빼서 fin에 추가하는 방식
    else sub.flatMap { permute(sub - it, fin + it)}

}

fun main() {
    val intList = listOf(1)
    val intResult = permute(intList).also { println(it) }
}