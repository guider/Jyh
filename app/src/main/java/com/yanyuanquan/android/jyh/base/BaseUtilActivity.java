package com.yanyuanquan.android.jyh.base;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;

import com.yanyuanquan.android.jyh.App;

import java.io.Serializable;

/**
 * Created by apple on 16/3/14.
 */
public class BaseUtilActivity extends Activity{

    protected void intent2Unkonw(String data) {
        intent2Unkonw(Uri.parse(data));
    }

    protected void intent2Unkonw(Uri uri) {
        Intent intent = new Intent();
        intent.setData(uri);
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected void intent2Activity(Class<? extends Activity> cls) {
        intent2Activity(cls, "");
    }

    protected void intent2Activity(Class<? extends Activity> cls, Parcelable p) {
        Intent intent = new Intent(this, cls);
        if (p!=null) {
            intent.putExtra(cls.getName(), p);
        }
        startActivity(intent);
    }

    protected void intent2Activity(Class<? extends Activity> cls, Serializable s) {
        Intent intent = new Intent(this, cls);
        if (s!=null) {
            intent.putExtra(cls.getName(), s);
        }
        startActivity(intent);
    }
    protected void intent2Activity(Class<? extends Activity> cls, String params) {
        Intent intent = new Intent(this, cls);
        if (!TextUtils.isEmpty(params)) {
            intent.putExtra(cls.getName(), params);
        }
        startActivity(intent);
    }

    protected void intent2Activity(Class<? extends Activity> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    protected void intent2Activity(Class<?extends Activity> clz,String param,String simpleParam){
        Intent intent = new Intent(this, clz);
        intent.putExtra(clz.getName(),param);
        intent.putExtra(clz.getSimpleName(), simpleParam);
        startActivity(intent);
    }

    protected void intent2ActivityForResult(Class<? extends Activity> cls, Bundle bundle, @NonNull int requestCode) {
        Intent intent = new Intent(this, cls);
        intent.putExtra(cls.getName(), bundle);
        startActivityForResult(intent, requestCode);
    }

    protected void intent2ActivityForResultCompat(Class<? extends Activity> cls, Bundle bundle, @NonNull int requestCode) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivityForResult(intent, requestCode);
    }

    protected void intent2ActivityForResult(Class<? extends Activity> cls, String parmas, @NonNull int requestCode) {
        Intent intent = new Intent(this, cls);
        if (!TextUtils.isEmpty(parmas)) {
            intent.putExtra(cls.getName(), parmas);
        }
        startActivityForResult(intent, requestCode);
    }

    protected void intent2ActivityForResult(Class<? extends Activity> cls, int requestCode) {
        intent2ActivityForResult(cls, "", requestCode);
    }



    protected <V extends View> V getView(int id){
        return (V) findViewById(id);
    }


    protected void delayedFinsh(){
        delayedFinsh(500);
    }


    protected void delayedFinsh(long timeMilliSecond){
        App.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                BaseUtilActivity.this.finish();
            }
        }, timeMilliSecond);
    }

}
