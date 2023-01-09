package boj.boj_practice


//https://st-lab.tistory.com/285
// 풀이방법: 수열의 각 수를 적절한 위치의 lis에 넣는다.
// lower bound에 넣기 때문에 계속 증가하는 수열을 유지하게 된다.
fun main() {

    val N = readln().toInt()
    val data = readln().split(" ").map { it.toInt() }
    val lis = IntArray(N)

    var lisPos = 0
    lis[0] = data[0]
    for (i in 1 until N) {
        if (lis[lisPos] < data[i]){ // 새로 추가된 것이 큰 경우
            lisPos += 1
            lis[lisPos] = data[i]
        }else{ // 적당한 위치에 넣기.. lower bound
            var (left, right) = 0 to lisPos
            while (left < right){
                val mid = (left + right) / 2
                if (lis[mid] < data[i]){
                    left = mid + 1
                }else{
                    right = mid
                }
            }
            lis[left] = data[i]
        }
    }
    println(lisPos + 1)

}