package com.yanyuanquan.android.autoindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.renderscript.Type;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by apple on 16/3/22.
 */
public class AutoIndicator extends LinearLayout {
    private Paint paint;
    private Path path;
    private int triangleWidth;
    private int triangleHeight;
    private static final float RADIO_TRIANGLE_WIDTH = 1 / 6F;
    private int initTranslations;
    private int translationX;

    private int mTabVisableCount = 5;
    private List<String> titles;
    private ViewPager viewpager;
    private int currentPosition;


    public AutoIndicator(Context context) {
        this(context, null);
    }

    public AutoIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#ffffffff"));
        paint.setStyle(Paint.Style.FILL);
        paint.setPathEffect(new CornerPathEffect(3));

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.AutoIndicator);
        mTabVisableCount = ta.getInteger(R.styleable.AutoIndicator_visiable_tab_conut, mTabVisableCount);
        ta.recycle();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(initTranslations + translationX, getHeight());
        canvas.drawPath(path, paint);
        canvas.restore();
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        triangleWidth = (int) (w / mTabVisableCount * RADIO_TRIANGLE_WIDTH);
        initTranslations = w / mTabVisableCount / 2 - triangleWidth / 2;
        initTriangle();

    }

    private void initTriangle() {
        triangleHeight = triangleWidth / 2;

        path = new Path();
        path.moveTo(0, 0);
        path.lineTo(triangleWidth, 0);
        path.lineTo(triangleWidth / 2, -triangleHeight);
        path.close();

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount <= 0)
            return;
        for (int i = 0; i < childCount; i++) {
            View v = getChildAt(i);
            LinearLayout.LayoutParams lp = (LayoutParams) v.getLayoutParams();
            lp.weight = 0;
            lp.width = getScreenWidth() / mTabVisableCount;

        }


    }

    /**
     * 指示器跟随手指滚动
     *
     * @param position
     * @param offset
     */
    public void scroll(int position, float offset) {
        int tabWidth = getWidth() / mTabVisableCount;
        translationX = (int) (tabWidth * (offset + position));
        if (getChildCount()-2 == position ) {
            invalidate();
            return;
        }
        if (mTabVisableCount > 1) {
            if (offset > 0 && getChildCount() > mTabVisableCount && (position >= mTabVisableCount - 2)) {
                this.scrollTo((int) ((position - (mTabVisableCount - 2)) * tabWidth + tabWidth * offset), 0);
            }
        } else {
            this.scrollTo((int) (position * tabWidth + tabWidth * offset), 0);
        }

        invalidate();
    }

    public void setTabItemTitles(List<String> titles) {
        if (titles != null && titles.size() > 0) {
            this.removeAllViews();
            this.titles = titles;
            for (String s : titles) {
                addView(getTitleView(s));
            }
        }
    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    public int getScreenWidth() {
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    public void setVisiableTabCount(int count) {
        mTabVisableCount = count;
    }

    public View getTitleView(String title) {
        TextView tv = new TextView(getContext());
        tv.setGravity(Gravity.CENTER);
        tv.setText(title);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        LinearLayout.LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        lp.width = getScreenWidth() / mTabVisableCount;
        tv.setLayoutParams(lp);
        tv.setTextColor(Color.parseColor("#ffffffff"));
        return tv;
    }

    public void setViewPager(ViewPager viewPager, int currentPosition) {
        this.viewpager = viewPager;
        this.currentPosition = currentPosition;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                scroll(position, positionOffset);
                if (listener!=null)
                    listener.onPageScrolled(position,positionOffset,positionOffsetPixels);
                setHighLight(position);
            }

            @Override
            public void onPageSelected(int position) {
                if (listener!=null)
                    listener.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (listener!=null)
                    listener.onPageScrollStateChanged(state);
            }
        });
        viewPager.setCurrentItem(currentPosition);
        setHighLight(currentPosition);
    }

    public interface onPageChangeListener {
        void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);

        void onPageSelected(int position);

        void onPageScrollStateChanged(int state);
    }
    private onPageChangeListener listener;

    public void setOnPageChangeListener(onPageChangeListener listener) {
        this.listener = listener;
    }
    public void setHighLight(int pos){
        reSetTextView();
        View view = getChildAt(pos);
        if (view instanceof TextView){
            ((TextView)view).setTextColor(Color.parseColor("#ffffffff"));
        }
    }

    public void reSetTextView(){
        for (int i =0;i<getChildCount();i++){
            View view = getChildAt(i);
            if (view instanceof TextView){
                ((TextView)view).setTextColor(Color.parseColor("#7700ff00"));
            }
        }
    }

}
