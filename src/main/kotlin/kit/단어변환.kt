package kit

import java.util.LinkedList
import java.util.Queue

fun main() {
    solution(
        "hit", "cog", arrayOf(
            "hot",
            "dot",
            "dog",
            "lot",
            "log",
            "cog"
        )
    ).also { println(it) }
}

private fun solution(begin: String, target: String, words: Array<String>): Int {
    val distance = HashMap<String, Int>()
    val allWords = mutableListOf<String>()
        .apply {
            addAll(words)
            add(begin)
        }
    val graph = HashMap<String, MutableList<String>>()
    allWords.forEach { it ->
        graph[it] = mutableListOf()
        distance[it] = 0
    }

    for (i in allWords.indices) {
        for (j in allWords.indices) {
            if (diff(allWords[i], allWords[j]) == 1) {
                graph[allWords[i]]!!.add(allWords[j])
                graph[allWords[j]]!!.add(allWords[i])
            }
        }
    }

    val q: Queue<String> = LinkedList<String>()
    q.add(begin)
    distance[begin] = 0

    while (q.isNotEmpty()) {
        val cur = q.poll()
        println(cur)

        for (word in graph[cur]!!) {
            if (distance[word] == 0) {
                distance[word] = distance[cur]!! + 1
                q.add(word)
                if (word == target) return distance[word]!!
            }
        }
    }


    return 0
}

private fun diff(word1: String, word2: String): Int {
    return word1.filterIndexed { index, c -> c != word2[index] }.count()
}