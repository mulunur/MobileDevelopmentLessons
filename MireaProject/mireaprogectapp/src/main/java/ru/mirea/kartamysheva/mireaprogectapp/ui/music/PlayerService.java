package ru.mirea.kartamysheva.mireaprogectapp.ui.music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import ru.mirea.kartamysheva.mireaprogectapp.R;
import ru.mirea.kartamysheva.mireaprogectapp.ui.music.MusicFragment;

public class PlayerService extends Service {

    private MediaPlayer mediaPlayer;

    public PlayerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        mediaPlayer = MediaPlayer.create(this, R.raw.aphex_twin_avril_14th);
        mediaPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
    }

}