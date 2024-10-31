package org.example.Sorting
import org.example.NotifyObservers
import org.example.interfaces.SortingStrategy
class Sorting {
    private var sortingStrategy: SortingStrategy? = null
    fun setSortingStrategy(sortingStrategy: SortingStrategy) {
        NotifyObservers.notifyObservers("Sorting strategy set to ${sortingStrategy.javaClass.simpleName}")
        this.sortingStrategy = sortingStrategy
    }
    fun sort(list: List<Int>): List<Int> {
        NotifyObservers.notifyObservers("Sorting list using ${sortingStrategy!!.javaClass.simpleName}")
        return sortingStrategy!!.sort(list)
    }
}