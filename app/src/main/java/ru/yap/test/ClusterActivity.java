package ru.yap.test;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class ClusterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cluster);

        final VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4");
        videoView.setOnCompletionListener(mediaPlayer -> videoView.start());
        videoView.start();
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();

        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        Log.v("cluster_size", "width = " + getWindow().getDecorView().getWidth() + " height = " + getWindow().getDecorView().getHeight());
        Log.v("cluster_size", "width = " + width + " height = " + height);
    }
}