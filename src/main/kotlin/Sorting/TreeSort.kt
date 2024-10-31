package org.example.Sorting
import org.example.interfaces.SortingStrategy
class TreeSort: SortingStrategy {
    class Node(var value: Int) {
        var left: Node? = null
        var right: Node? = null
    }
    class BinarySearchTree {
        private var root: Node? = null
        fun insert(value: Int) {
            root = insertRec(root, value)
        }
        private fun insertRec(root: Node?, value: Int): Node {
            if (root == null) {
                return Node(value)
            }
            if (value < root.value) {
                root.left = insertRec(root.left, value)
            } else if (value > root.value) {
                root.right = insertRec(root.right, value)
            }
            return root
        }
        fun inOrder(): List<Int> {
            val list = mutableListOf<Int>()
            inOrderRec(root, list)
            return list
        }
        private fun inOrderRec(root: Node?, list: MutableList<Int>) {
            if (root != null) {
                inOrderRec(root.left, list)
                list.add(root.value)
                inOrderRec(root.right, list)
            }
        }
    }
    override fun sort(list: List<Int>): List<Int> {
        val tree = BinarySearchTree()
        for (element in list) {
            tree.insert(element)
        }
        return tree.inOrder()
    }
}