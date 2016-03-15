package com.yanyuanquan.android.mylibrary.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yanyuanquan.android.mylibrary.NetUtil;
import com.yanyuanquan.android.mylibrary.R;

/**
 * @Created by apple on 16/3/10.
 * @description:
 * @projectName:YYQ
 */
public class AutoWebView extends FrameLayout implements View.OnClickListener {

    /**
     * 进度条的位置
     */
    int progressBarPosition = 0;
    /**
     * 当前 是否返回错误
     */
    boolean isError = false;
    ProgressBar progressBar;
    WebView webview;
    TextView retry;

    public AutoWebView(Context context) {
        this(context, null);
    }

    public AutoWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.AutoWebView);
        progressBarPosition = ta.getInt(R.styleable.AutoWebView_progressbarPostion, progressBarPosition);

        LayoutInflater.from(getContext()).inflate(R.layout.autoweb, this);
        progressBar = (ProgressBar) findViewById(R.id.pbar);
        webview = (WebView) findViewById(R.id.webview);
        retry = (TextView) findViewById(R.id.retry);

        WebSettings setting = webview.getSettings();
        setting.setJavaScriptEnabled(true);
        retry.setOnClickListener(this);
    }

    public void loadUrl(String murl) {
        if (!NetUtil.isNetworkAvailable(getContext())) {
            showView(false);
            return;
        }
        initView();
        webview.loadUrl(murl);
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                setProgress(newProgress);
            }
        });

        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                isError = true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                showView(!isError);
            }
        });

    }
    public void reLoad(){
        if (webview!=null){
            webview.reload();
        }
    }
    public WebView getWebview(){
        return webview;
    }
    public void onPase(){
        webview.onPause();
    }
    public void onResume(){
        webview.onResume();
    }

    public void onDestory() {
        webview.stopLoading();
        webview = null;
    }

    private void initView() {
        progressBar.setVisibility(VISIBLE);
        retry.setVisibility(GONE);
        webview.setVisibility(VISIBLE);
    }

    public void showView(boolean success) {
        progressBar.setVisibility(success ? GONE : VISIBLE);
        retry.setVisibility(success ? GONE : VISIBLE);
        webview.setVisibility(success ? VISIBLE : GONE);
        if (call != null && !success) {
            call.onError();
        } else if (call != null) {
            call.onFinsh();
        }
    }

    public void setProgress(int progress) {
        if (progressBar != null)
            progressBar.setProgress(progress);
    }


    @Override
    public void onClick(View v) {
        if (call != null)
            call.onRetry();
    }


    private CallBcak call;


    public void setCallBcak(CallBcak call) {
        this.call = call;
    }

    public interface CallBcak {
        void onError();
        void onRetry();
        void onFinsh();
    }
}
