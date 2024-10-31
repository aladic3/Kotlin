package org.example.Sorting

import org.example.interfaces.SortingStrategy

class QuickSort: SortingStrategy {
    override fun sort(list: List<Int>): List<Int> {
        if (list.size <= 1) return list
        val pivot = list[list.size / 2]
        val equal = list.filter { it == pivot }
        val less = list.filter { it < pivot }
        val greater = list.filter { it > pivot }
        return sort(less) + equal + sort(greater)
    }
}