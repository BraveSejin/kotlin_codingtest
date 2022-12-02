package cheetsheet


private data class Player(
    val name: String,
    val score: Int
) : Comparable<Player> {
    override fun compareTo(other: Player): Int {
        return other.score - score
    }
}

//https://www.daleseo.com/java-comparable-comparator/

fun main() {
//    게이머를 점수 기준으로 정렬해보자.
    val names = arrayOf("Alice", "Bob", "Chloe", "Dale", "Eric")
    val scores = intArrayOf(899, 982, 1090, 982, 1018)
//    scores.sort() //java.util.Arrays

    val players = Array<Player>(5) {
        Player(names[it], scores[it])
    }
//    players.sort() // comparable이 없으면 compile error


    /**
     * 정렬 대상 클래스의 코드를 직접 수정할 수 없는 경우, 혹은 이미 존재하고 있는 정렬기준을
     * 살리고 다른 정렬기준으로 정렬하고싶은 경우 : Comparator
     * Comparator 인터페이스의 구현체를 Arrays.sort()나
     * Collections.sort()와 같은 정렬 메서드의 추가 인자로 넘기면
     * 해당 comparator로 정렬된다. 코틀린에선 (sortWith)로 쓰면된다.
     *
     * [sortedBy]는 selector를 이용한다. 내부적으로 compareWith를 사용한다.
     */

    val scoreComparator = Comparator<Player> { p1, p2 -> p1.score.compareTo(p2.score) }
    val nameComparator = Comparator<Player> { p1, p2 -> p1.name.compareTo(p2.name) }

    val compositeComparator = Comparator<Player> { p1, p2 ->
        scoreComparator.compare(p1, p2).let { if (it != 0) it else scoreComparator.compare(p1, p2) }
//        p1.score.compareTo(p2.score).let { if (it != 0) it else p1.name.compareTo(p2.name) }
    }
//    players.sortWith(scoreComparator)
//    println(players.toList())
//    players.sortWith(nameComparator)
//    println(players.toList())

    players.sortedWith(compositeComparator).also { println(it) }

    players.sortWith(compareBy({ it.name }, { it.score })) // 여러 기준으로 정렬
    players.sortedBy { it.score } //sortedWith(compareBy(selector)) 이런 느낌

}