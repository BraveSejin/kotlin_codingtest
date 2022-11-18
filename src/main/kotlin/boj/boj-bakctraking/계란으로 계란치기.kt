package boj.`boj-bakctraking`


private var N = 0
private var ans = 0
private var cnt = 0
lateinit var eggs: Array<Pair<Int, Int>>

fun main() {
    boj.`boj-bakctraking`.N = readln().toInt()
    boj.`boj-bakctraking`.eggs = Array<Pair<Int, Int>>(boj.`boj-bakctraking`.N) {
        val line = readln().split(" ").map { it.toInt() }
        Pair(line[0], line[1])
    }

    boj.`boj-bakctraking`.func(0)
    println(boj.`boj-bakctraking`.ans)

}

// depth번째 계란으로 다른 계란을 친다.
private fun func(depth: Int) {
    if (depth == boj.`boj-bakctraking`.N) {
        boj.`boj-bakctraking`.ans = boj.`boj-bakctraking`.ans.coerceAtLeast(boj.`boj-bakctraking`.cnt)
        return
    }
    if (boj.`boj-bakctraking`.eggs[depth].first <= 0 || boj.`boj-bakctraking`.cnt == boj.`boj-bakctraking`.N - 1) {
        boj.`boj-bakctraking`.func(depth + 1)
        return
    }

    for (target in boj.`boj-bakctraking`.eggs.indices) {
        var curCnt = boj.`boj-bakctraking`.cnt
        // 같은 계란을 때리려 하거나 이미 깨진 경우
        if (target == depth || boj.`boj-bakctraking`.eggs[target].first <= 0) continue
        val curEgg = boj.`boj-bakctraking`.eggs[depth]
        val targetEgg = boj.`boj-bakctraking`.eggs[target]
        boj.`boj-bakctraking`.eggs[depth] = Pair(curEgg.first - targetEgg.second, curEgg.second)
        boj.`boj-bakctraking`.eggs[target] = Pair(targetEgg.first - curEgg.second, targetEgg.second)
        if (boj.`boj-bakctraking`.eggs[depth].first <= 0) boj.`boj-bakctraking`.cnt++
        if (boj.`boj-bakctraking`.eggs[target].first <= 0) boj.`boj-bakctraking`.cnt++
        boj.`boj-bakctraking`.func(depth + 1)
        if (boj.`boj-bakctraking`.eggs[depth].first <= 0) boj.`boj-bakctraking`.cnt--
        if (boj.`boj-bakctraking`.eggs[target].first <= 0) boj.`boj-bakctraking`.cnt--
        boj.`boj-bakctraking`.eggs[depth] = curEgg
        boj.`boj-bakctraking`.eggs[target] = targetEgg
    }

}
