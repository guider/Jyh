package com.yanyuanquan.android.mylibrary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by apple on 16/3/25.
 */
public abstract class NetWorkChangeReceiver extends BroadcastReceiver {

    private boolean isFistReceiver = true;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)){
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info =manager.getActiveNetworkInfo();
            if (listener == null )
                return;
            if (!isFistReceiver){
                if (info!=null&&info.isAvailable()){
                        listener.onNetWorkConnent();
                }else {
                    listener.onNetWorkDisConnect();
                }
            }else {
                isFistReceiver =false;
            }
        }
    }


    public interface NetWorkChangeListener{
        void onNetWorkConnent();
        void onNetWorkDisConnect();
    }
    protected NetWorkChangeListener listener;

    public void setNetWorkChangeListener(NetWorkChangeListener listener) {
        this.listener = listener;
    }
}
