package kit

fun main() {
    val parti = arrayOf("leo", "kiki", "eden")
    val comp = arrayOf("eden", "kiki")
    solution(parti,comp).also { println(it) }
}

private fun solution(participant: Array<String>, competion: Array<String>): String {
    val map = HashMap<String, Int>()
    participant.forEach {
        if (map.containsKey(it)) {
            map[it] = map[it]!! + 1
        } else {
            map[it] = 1
        }
    }
    competion.forEach {
        map[it] = map[it]!! - 1
    }
    return map.filter { it.value == 1 }.map { it.key }.first()

}