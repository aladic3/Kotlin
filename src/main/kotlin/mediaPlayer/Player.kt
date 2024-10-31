package mediaPlayer
import org.example.MediaPlayer.Command
import org.example.MediaPlayer.*

 class Player private constructor( private val  playCommand: Command,
     private val stopCommand: Command,
    private val nextCommand: Command,
    private val forwardCommand: Command,
    private val pauseCommand: Command ){

    companion object {
        fun create(): Player {
            val mediaPlayer = MediaPlayer()
            val playCommand = PlayCommand(mediaPlayer)
            val stopCommand = StopCommand(mediaPlayer)
            val nextCommand = NextCommand(mediaPlayer)
            val forwardCommand = ForwardCommand(mediaPlayer)
            val pauseCommand = PauseCommand(mediaPlayer)
            return Player(playCommand, stopCommand, nextCommand, forwardCommand, pauseCommand)
        }
    }

    fun play() {
        playCommand.execute()
    }


     fun stop(){
         stopCommand.execute()
     }

     fun next(){
         nextCommand.execute()
     }
     fun forward() {
         forwardCommand.execute()
     }
     fun pause(){
         pauseCommand.execute()
     }
}
