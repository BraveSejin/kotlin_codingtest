package `boj-bakctraking`


private var N = 0
private var ans = 0
private var cnt = 0
lateinit var eggs: Array<Pair<Int, Int>>

fun main() {
    N = readln().toInt()
    eggs = Array<Pair<Int, Int>>(N) {
        val line = readln().split(" ").map { it.toInt() }
        Pair(line[0], line[1])
    }

    func(0)
    println(ans)

}

// depth번째 계란으로 다른 계란을 친다.
private fun func(depth: Int) {
    if (depth == N) {
        ans = ans.coerceAtLeast(cnt)
        return
    }
    if (eggs[depth].first <= 0 || cnt == N - 1) {
        func(depth + 1)
        return
    }

    for (target in eggs.indices) {
        var curCnt = cnt
        // 같은 계란을 때리려 하거나 이미 깨진 경우
        if (target == depth || eggs[target].first <= 0) continue
        val curEgg = eggs[depth]
        val targetEgg = eggs[target]
        eggs[depth] = Pair(curEgg.first - targetEgg.second, curEgg.second)
        eggs[target] = Pair(targetEgg.first - curEgg.second, targetEgg.second)
        if (eggs[depth].first <= 0) cnt++
        if (eggs[target].first <= 0) cnt++
        func(depth + 1)
        if (eggs[depth].first <= 0) cnt--
        if (eggs[target].first <= 0) cnt--
        eggs[depth] = curEgg
        eggs[target] = targetEgg
    }

}
