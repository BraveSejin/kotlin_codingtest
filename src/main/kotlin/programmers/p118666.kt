class Solution1 {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val map: MutableMap<String, Int> = mutableMapOf("RT" to 0, "CF" to 0, "JM" to 0, "AN" to 0)
        val scores = arrayOf(-9999, -3, -2, -1, 0, 1, 2, 3)
        survey.forEachIndexed { index, s ->
            val score = scores[choices[index]]
            when (s) {
                "RT" -> map["RT"] = map["RT"]!! - score
                "TR" -> map["RT"] = map["RT"]!! + score
                "CF" -> map["CF"] = map["CF"]!! - score
                "FC" -> map["CF"] = map["CF"]!! + score
                "JM" -> map["JM"] = map["JM"]!! - score
                "MJ" -> map["JM"] = map["JM"]!! + score
                "AN" -> map["AN"] = map["AN"]!! - score
                "NA" -> map["AN"] = map["AN"]!! + score
            }
        }
        val builder = StringBuilder()
        builder.append(if (map["RT"]!! >= 0) "R" else 'T')
        builder.append(if (map["CF"]!! >= 0) "C" else 'F')
        builder.append(if (map["JM"]!! >= 0) "J" else 'M')
        builder.append(if (map["AN"]!! >= 0) "A" else 'N')

        println(map)

        return builder.toString()
    }
}

fun main() {

    val sol = Solution1().solution(
        survey = arrayOf("AN", "CF", "MJ", "RT", "NA"), choices = intArrayOf(5, 3, 2, 7, 5)
    )
    print(sol)
}