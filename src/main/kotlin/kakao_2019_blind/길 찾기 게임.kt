package kakao_2019_blind


private data class Node(
    val x: Int,
    val y: Int,
    val num: Int,
    var left: Node? = null,
    var right: Node? = null
) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        val comp = other.y.compareTo(y)
        if (comp == 0)
            return other.x - x
        return comp
    }
}


private class Solution {
    lateinit var answer: Array<IntArray>
    lateinit var root: Node
    var preIndex = 0
    var postIndex = 0

    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        answer = Array(2) { IntArray(nodeinfo.size) }
        val nodeList = mutableListOf<Node>()
        for ((idx, value) in nodeinfo.withIndex()) {
            val node = Node(value[0], value[1], idx + 1)
            nodeList.add(node)
        }
        nodeList.sort()
        root = nodeList.first()
        for (i in 1 until nodeList.size) {
            insertNode(root, nodeList[i])
        }
        preOrder(root)
        postOrder(root)

        return answer
    }

    private fun insertNode(parent: Node, child: Node) {
        if (parent.x > child.x) {
            parent.left?.let {
                insertNode(it, child)
            } ?: run {
                parent.left = child
            }
        } else {
            parent.right?.let {
                insertNode(it, child)
            } ?: run {
                parent.right = child
            }
        }
    }

    private fun preOrder(node: Node) {
        answer[0][preIndex++] = node.num
        node.left?.let { preOrder(it) }
        node.right?.let { preOrder(it) }
    }

    private fun postOrder(node: Node) {
        node.left?.let { postOrder(it) }
        node.right?.let { postOrder(it) }
        answer[1][postIndex++] = node.num
    }

}


fun main() {
    Solution().solution(
        arrayOf(
            intArrayOf(5, 3),
            intArrayOf(11, 5),
            intArrayOf(13, 3),
            intArrayOf(3, 5),
            intArrayOf(6, 1),
            intArrayOf(1, 3),
            intArrayOf(8, 6),
            intArrayOf(7, 2),
            intArrayOf(2, 2),
        )
    ).also {
        it.forEach { it
            println(it.toList())
        }
    }
}


