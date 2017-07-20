package service.example.com.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Intent intent ;
    ServiceConnection conn;

    IService iService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        intent = new Intent(this,MyService.class);
        conn = new MyConn();
    }


    private class MyConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iService = (IService) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    ;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:   //启动服务
                     Intent intent  = new Intent(v.getContext(),MyService.class);
                     startService(intent);
                break;
            case R.id.button2:   //绑定服务2232131
                    Intent intent2 = new Intent(v.getContext(), MyService.class);
                    bindService(intent2, conn, Context.BIND_AUTO_CREATE);
                break;
            case R.id.button3:    //取消绑定服务
                unbindService(conn);
                break;
            case R.id.button4:     //取消启动服务
                Intent intent3  = new Intent(v.getContext(),MyService.class  );
                stopService(intent3);
                break;
            //支持可扩展

        }
    }
}
