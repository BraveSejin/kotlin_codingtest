package cheetsheet
private fun binSearch(data: List<Int>, target: Int): Boolean {

    var st = 0
    var end = data.lastIndex

    while (st <= end) {
        val mid = (st + end) / 2

        if (data[mid] < target) {
            st = mid + 1
        } else if (data[mid] > target) { // data[mid] >- target
            end = mid - 1
        } else {
            return true
        }

    }
    return false
}
// target과 같은 값이 처음 나오는 위치
private fun binSearchLower(arr: IntArray, target: Int): Int{
    var left = 0
    var right = arr.lastIndex //+ 1 // 타겟이 너무 커서 못 찾는 경우
    while (left < right){
        val mid = (left + right) / 2

        if (target <= arr[mid]){ // 발견한 경우: right 줄이기
            right = mid
        }else{ // 목표치가 큰경우
            left = mid + 1
        }
    }
    return left
}
private fun binSearchUpper(arr: IntArray, target: Int): Int{
    var left = 0
    var right = arr.lastIndex + 1
    while (left < right){
        val mid = (left + right) / 2
        if (target < arr[mid]){
            right = mid
        }
        else{ // 발견한 경우: left 늘리기
            left = mid + 1
        }
    }
    return right

}
fun main() {
    val test = intArrayOf(1,2,2,3,3,3,4,6,7)
    check(binSearchLower(test,1) == 0)
    check(binSearchLower(test,2) == 1)
    check(binSearchLower(test,3) == 3)
    check(binSearchLower(test,4) == 6)
    check(binSearchLower(test,6) == 7)
    check(binSearchLower(test,7) == 8)

    check(binSearchUpper(test,1) == 1)
    check(binSearchUpper(test,2) == 3)
    check(binSearchUpper(test,3) == 6)
    check(binSearchUpper(test,4) == 7)
    check(binSearchUpper(test,6) == 8)
    check(binSearchUpper(test,7) == 9)

    binSearchLower(test,0).also { println(it) }
    binSearchLower(test,5).also { println(it) } // 5를 6 자리에 넣는다
}