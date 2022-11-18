private lateinit var sampleDraw: MutableList<Pair<Int, Int>>

fun main() {
    val answer = mutableListOf<String>()

    sampleDraw = mutableListOf()
    readln()

    val sampleLine = readln()
    var sampleX = 0
    var sampleY = 0
    sampleLine.split(" ").forEachIndexed { index, s ->
        when (s.toInt()) {
            1 -> sampleX += 1
            2 -> sampleY += 1
            3 -> sampleX -= 1
            4 -> sampleY -= 1
        }
        sampleDraw.add(Pair(sampleX, sampleY))
    }
    sampleDraw.sortWith { o1, o2 ->
        if (o1.first == o2.first) {
            o2.second - o1.second
        } else o2.first - o1.first
    }

    val N = readln().toInt()
    repeat(N) {

        val localDraw = mutableListOf<Pair<Int, Int>>()
        val line = readln()
        var curX = 0
        var curY = 0

        line.split(" ").forEach {
            when (it.toInt()) {
                1 -> curX += 1
                2 -> curY += 1
                3 -> curX -= 1
                4 -> curY -= 1
            }
            localDraw.add(Pair(curX, curY))
        }
        localDraw.sortWith { o1, o2 ->
            if (o1.first == o2.first) {
                o2.second - o1.second
            } else o2.first - o1.first
        }
        if (chk(localDraw))
            answer.add(line)
    }

    println(answer.size)
    answer.forEach {
        println(it)
    }
}


private fun chk(localDraw: List<Pair<Int, Int>>): Boolean {
    val diffX = sampleDraw[0].first - localDraw[0].first
    val diffY = sampleDraw[0].second - localDraw[0].second
    for (i in 1 until localDraw.lastIndex) {
        if (diffX != sampleDraw[i].first - localDraw[i].first) return false
        if (diffY != sampleDraw[i].second - localDraw[i].second) return false
    }
    return true
}