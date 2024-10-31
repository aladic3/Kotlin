package org.example.Sorting

import org.example.interfaces.SortingStrategy

class BubbleSort: SortingStrategy {
    override fun sort(list: List<Int>): List<Int> {
        val mutableList = list.toMutableList()
        for (i in 0 until mutableList.size) {
            for (j in 0 until mutableList.size - 1) {
                if (mutableList[j] > mutableList[j + 1]) {
                    val temp = mutableList[j]
                    mutableList[j] = mutableList[j + 1]
                    mutableList[j + 1] = temp
                }
            }
        }
        return mutableList
    }
}