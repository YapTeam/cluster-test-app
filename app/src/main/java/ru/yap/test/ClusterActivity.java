package ru.yap.test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class ClusterActivity extends AppCompatActivity {

    private static final String CLUSTER_ACTIVITY_STATE_KEY = "android.car.cluster.ClusterActivityState";
    private static final String CLUSTER_UNOBSCURED_RECT = "android.car:InstrumentClusterService.unobscured.rect";

    private ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cluster);

        container = findViewById(R.id.controls_content);

        applyUnobscuredRect();
    }

    @SuppressWarnings("SpellCheckingInspection")
    private void applyUnobscuredRect() {
        final Bundle rectBundle = getIntent().getBundleExtra(CLUSTER_ACTIVITY_STATE_KEY);
        if (rectBundle == null) return;

        final Rect rect = rectBundle.getParcelable(CLUSTER_UNOBSCURED_RECT);
        if (rect == null) return;

        container.setLayoutParams(new FrameLayout.LayoutParams(rect.right - rect.left, rect.bottom - rect.top, Gravity.CENTER));
        container.setVisibility(View.VISIBLE);
    }
}