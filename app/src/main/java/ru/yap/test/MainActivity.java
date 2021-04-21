package ru.yap.test;

import androidx.appcompat.app.AppCompatActivity;

import android.car.Car;
import android.car.CarAppFocusManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        startActivity(new Intent(this, ClusterActivity.class));

        final Car car = Car.createCar(this, (Handler) null);

        final CarAppFocusManager appFocusManager = (CarAppFocusManager) car.getCarManager(Car.APP_FOCUS_SERVICE);
        appFocusManager.requestAppFocus(CarAppFocusManager.APP_FOCUS_TYPE_NAVIGATION, new CarAppFocusManager.OnAppFocusOwnershipCallback() {
            @Override
            public void onAppFocusOwnershipLost(int i) {

            }

            @Override
            public void onAppFocusOwnershipGranted(int i) {

            }
        });
    }
}