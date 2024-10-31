package org.example.MediaPlayer

class PlayCommand(private val mediaPlayer: MediaPlayer): Command {
    override fun execute() {
        mediaPlayer.play()
    }
}

class StopCommand(private val mediaPlayer: MediaPlayer): Command {
    override fun execute() {
        mediaPlayer.stop()
    }
}

class PauseCommand(private val mediaPlayer: MediaPlayer): Command {
    override fun execute() {
        mediaPlayer.pause()
    }
}

class ForwardCommand(private val mediaPlayer: MediaPlayer): Command {
    override fun execute() {
        mediaPlayer.forward()
    }
}

class NextCommand(private val mediaPlayer: MediaPlayer): Command {
    override fun execute() {
        mediaPlayer.next()
    }
}