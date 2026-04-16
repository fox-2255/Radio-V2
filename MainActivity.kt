package com.xdev.myradio

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

class MainActivity : AppCompatActivity() {

    private var exoPlayer: ExoPlayer? = null
    private val STREAM_URL = "http://rmnwebcaster.freeddns.org:8000/ifmmanila"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playBtn: Button = findViewById(R.id.playBtn)

        // Initialize ExoPlayer
        exoPlayer = ExoPlayer.Builder(this).build()

        playBtn.setOnClickListener {
            val mediaItem = MediaItem.fromUri(STREAM_URL)
            exoPlayer?.setMediaItem(mediaItem)
            exoPlayer?.prepare()
            exoPlayer?.play()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        exoPlayer?.release()
        exoPlayer = null
    }
}
