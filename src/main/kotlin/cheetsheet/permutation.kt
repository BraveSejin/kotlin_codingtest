



private fun <T> permutation(sub: List<T>,  fin: List<T> = listOf(), r: Int): List<List<T>> { // 선택하고 싶은 r개ㅑ

//    return if (sub.isEmpty()) listOf(fin) // sub에 있는 하나씩 빼서 fin에 추가하는 방식
    return if (r == fin.size) listOf(fin) // sub에 있는 하나씩 빼서 fin에 추가하는 방식 .여기서 sub의
    else sub.flatMap { permutation(sub - it, fin + it, r) }

}

fun main() {
    val list = mutableListOf('a', 'b', 'c', 'd')
    val list2 = permutation(list, r = 2)
    list2.forEach { print("$it ") }
    println()

    val list3 = mutableListOf(1, 2, 3, 4, 5)
    val list4 = permutation(list3, r= 3 )
    list4.forEach { print("$it ") }
    println()

    val str = "abcd"
    val list5 = permutation(str.toList(), r = 3)
    list5.forEach { print("$it ") }
}