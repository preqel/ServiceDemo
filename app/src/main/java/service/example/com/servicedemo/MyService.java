package service.example.com.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by wyp on 2017/7/14.
 */

public class MyService extends Service {

    @Override
    public void onCreate() {
        Log.d("TAG","OnCreate");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.d("TAG","onStart");
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        Log.d("TAG","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("TAG","onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("TAG","onUnbind");
        return super.onUnbind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("TAG","onBind");
        return null;
    }
}
