package org.example

import org.example.interfaces.Subject
import org.example.interfaces.Observer

object NotifyObservers: Subject {
    private val observers = mutableListOf<Observer>()
    init {
        registerObserver(Display)
        registerObserver(Logger)
    }

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers(message: String) {
        observers.forEach { it.update(message) }
    }
}