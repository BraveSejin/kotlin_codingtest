package kakao_2021_blind

fun main() {
    solution("...!@BaT#*..y.abcdefghijklm").also { print(it) }
}

private fun solution(new_id: String): String {
    return new_id.lowercase()
        .filter { it.isLetterOrDigit() || arrayOf('-', '.', '_').contains(it) } // setp 2
        .replace("[.]+[.]".toRegex(), ".")
        .trim('.')
        .let { if (it.isEmpty()) "a" else it }
        .let {
            if (it.length >= 16) {it.take(15).trimEnd('.') } else {it }
        }.let {
            if (it.length <= 2)
                StringBuilder(it).run {
                    while (length < 3) append(it.last())
                    toString()
                }
            else it
        }
}

fun solution2(newId: String) = newId.lowercase()
    .filter { it.isLowerCase() || it.isDigit() || it == '-' || it == '_' || it == '.' }
    .replace("[.]+[.]".toRegex(), ".")
    .removePrefix(".").removeSuffix(".")
    .let { if (it.isEmpty()) "a" else it }
    .let { if (it.length > 15) it.substring(0 until 15) else it }.removeSuffix(".")
    .let {
        if (it.length <= 2)
            StringBuilder(it).run {
                while (length < 3) append(it.last())
                toString()
            }
        else it
    }