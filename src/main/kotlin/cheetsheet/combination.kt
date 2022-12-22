package cheetsheet

//el: 조합을 구할 원본 원소들
//ck: 이미 선택된 원소인지 확인
// start: 탐색 시작 인덱스
// target: 구하는 원소의 개수
private fun <T> combination(answer: MutableList<List<T>>, elements: List<T>, ck: BooleanArray, start: Int, target: Int) {
    if (target == 0) {
//        answer.addAll(listOf(el.filterIndexed { index, t -> ck[index] }))
        answer.add(elements.filterIndexed { index, t -> ck[index] })
    } else {
        for (i in start until elements.size) {
            ck[i] = true
            combination(answer, elements, ck, i + 1, target - 1)
            ck[i] = false
        }
    }
}

fun main() {
    val arr = listOf(1,2,3,4,5)
    val answer = mutableListOf<List<Int>>()
    combination(answer, arr, BooleanArray(arr.size), 0,1)
    answer.forEach { print(it) }
}