package boj.`boj-bakctraking`

private var L: Int = 0
private var C: Int = 0
private lateinit var al: MutableList<Char>
private lateinit var isUsed: BooleanArray
private lateinit var ans: MutableList<Char>

fun main() {

    // 서로 다른 L개의 알파벳 소문자, 최소 한 개의 모음 + 최소 두 개의 자음. 알파벳순(정렬)
    // C개중에서 L개를 고른다.
    val line1 = readln().split(' ').map { it.toInt() }
    L = line1[0] // L개의 소문자를 골라야함.
    C = line1[1] // C개가 주어짐

    // 암호는 정렬되어 있으므로, 최초에 정렬을 하고 뿝자.
    al = readln().split(' ').map { it.first() }.sorted() as MutableList<Char>
    isUsed = BooleanArray(C)
    ans = MutableList<Char>(C) { ' ' }

    func(0, 0)

}

private fun func(depth: Int, idx: Int) { // depth: 몇 번째 인덱스에 대한 호출인가
    // L - depth : 몇칸 더 가야 완성되는지
    // L - idx : 몇개를 더 고를 수 있는지
    if (depth == L) {
        val temp = ans.take(L).joinToString("")
        val nVowel = temp.count { it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u' }
        val nEtc = L - nVowel
        if (nVowel >= 1 && nEtc >= 2)
            println(temp)
        return
    }
    for (i in idx until C) {
        // 이미 사용한 알파벳은 사용하지 않는다.
        // 이미 이미 사용한 알파벳보다 더 앞에있는 것도 사용하지 않는다.
        if (isUsed[i]) continue

        isUsed[i] = true
        ans[depth] = al[i]
        func(depth + 1, i + 1)
        isUsed[i] = false

    }


}