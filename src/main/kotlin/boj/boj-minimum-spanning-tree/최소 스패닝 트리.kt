import kotlin.properties.Delegates

private fun findParent(parent: IntArray, x: Int): Int {
    if (parent[x] != x)
        parent[x] = findParent(parent, parent[x])
    return parent[x]
}

private fun unionParent(parent: IntArray, a: Int, b: Int) {
    val pa = findParent(parent, a)
    val pb = findParent(parent, b)
    if (pa < pb){
        parent[pb] = pa
    }else{
        parent[pa] = pb
    }
}

fun main() {
    var res = 0

    var v: Int by Delegates.notNull<Int>()
    var e: Int by Delegates.notNull<Int>()

    readln().split(" ").also {
        v = it[0].toInt()
        e = it[1].toInt()
    }
    val parent = IntArray(v+1){it}
    val edges = mutableListOf<Triple<Int,Int,Int>>()
    repeat(e) {
        val edge = readln().split(" ").map { it.toInt() }
            .let { Triple(it[0],it[1],it[2]) }
        edges.add(edge)

//        if (findParent(parent, a) != findParent(parent,b)) {
//            unionParent(parent,a,b)
//        }
    }
    edges.sortWith(comparator = {e1, e2 -> e1.third - e2.third})
    edges.forEach { edge ->
        val (a,b,c) = edge
        if (findParent(parent,a) != findParent(parent,b)){
            unionParent(parent,a,b)
            res += c
        }
    }
    println(res)
}