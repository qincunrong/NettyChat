package com.freddy.chat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.freddy.im.NettyServerDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainServerActivity extends AppCompatActivity  {

    private static final String TAG = "MainServer";

    private TextView mTvServerState;
    private Button mBtnStartServer;
    private static final ExecutorService singleService = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_server);

        mTvServerState = (TextView) findViewById(R.id.tv_serverState);
        mBtnStartServer = (Button) findViewById(R.id.btn_startServer);

        NettyServerDemo.setCallBack(new NettyServerDemo.CallBack(){
            @Override
            public void onStart() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateState();
                    }
                });
            }

            @Override
            public void onStop() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateState();
                    }
                });
            }
        });
        mBtnStartServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleService.submit(new Runnable() {
                    @Override
                    public void run() {
                        NettyServerDemo.start();
                    }
                });

            }
        });
        updateState();
    }

    private void updateState() {
        Log.i(TAG, "updateState==");
        if (NettyServerDemo.isStarted()) {
            mTvServerState.setText("已启动");
        }else {
            mTvServerState.setText("未启动");
        }
    }


}
