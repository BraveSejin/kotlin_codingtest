package cheetsheet

/**
 * 전반적으로 왼쪽 -> 오른쪽 으로 순회를 하며
 * pre,in,post의 차이는 root를 참조하는 순서라고 보면 된다.
 * [preOrder]:  서브트리 루트 -> 왼쪽 자식 -> 오른쪽 자식
 * [inOrder]: 왼쪽 자식 -> 루트 -> 오른쪽 자식
 * [postOrder]: 왼쪽 자식 -> 오른쪽 자식 -> 루트
 * */
private class BinaryTree<T>(var root: Node<T>? = null) {
    fun rootPreOrder() {
        root?.let { preOrder(it) } ?: run { println("root node를 지정하세요.") }
    }

    fun rootInOrder() {
        root?.let { inOrder(it) } ?: run { println("root node를 지정하세요.") }
    }

    fun rootPostOrder() {
        root?.let { postOrder(it) } ?: run { println("root node를 지정하세요.") }
    }

    private fun preOrder(node: Node<T>) {
        println(node.item)
        node.left?.let {
            preOrder(it)
        }
        node.right?.let {
            preOrder(it)
        }
    }

    private fun inOrder(node: Node<T>) {
        node.left?.let {
            inOrder(it)
        }
        println(node.item)
        node.right?.let {
            inOrder(it)
        }
    }

    private fun postOrder(node: Node<T>) {
        node.left?.let {
            postOrder(it)
        }
        node.right?.let {
            postOrder(it)
        }
        println(node.item)

    }
}

private class Node<T>(val item: T, var left: Node<T>? = null, var right: Node<T>? = null)

fun main() {
    val n1 = Node(1)
    val n2 = Node(2)
    val n3 = Node(3)
    val n4 = Node(4)
    val n5 = Node(5)
    val n6 = Node(6)
    val n7 = Node(7)
    val n8 = Node(8)
    val tree = BinaryTree<Int>()


    n1.left = n2
    n1.right = n3
    n2.left = n4
    n2.right = n5
    n3.left = n6
    n3.right = n7
    n4.left = n8


    tree.root = n1
//    tree.rootPreOrder() // 1 2 4 8 5 3 6 7
//    tree.rootInOrder() // 8 4 2 5 1 6 3 7
//    tree.rootPostOrder() // 8 4 5 2 6 7 3 1
}

