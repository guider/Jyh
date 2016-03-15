package com.yanyuanquan.android.mylibrary;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * @Created by apple on 15/12/18.
 * @description:
 * @projectName:YYQ
 */
public class RoundImageView extends ImageView {

    private float connerRadio;
    private Paint paint;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.RoundImageView);
        connerRadio = ta.getDimensionPixelSize(R.styleable.RoundImageView_zjw_radius, 3);
        ta.recycle();
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null)
            super.onDraw(canvas);
        else {
            Bitmap b = ((BitmapDrawable) drawable).getBitmap();
            Bitmap bitmap = getRoundBitmap(getCompatBitmap(b), connerRadio);
            Rect rectSrc = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            paint.reset();
            paint.setAntiAlias(true);
            canvas.drawBitmap(bitmap, null, rectSrc, paint);
        }

    }

    /**
     * 即决定图片像素点的存储，即用图片查看器看图片属性时候的位深参数。
     * ARGB_4444 每个像素点用2byte表示，A即表示透明度，即ARGB每个属性用4个bits记录
     * 虽然文档推荐换成ARGB_8888,但是有的时候还是需要用这个。- - - -  一切为了内存
     * ARGB_8888 每个像素点4个byte。也就是说，同样的图片，这种方式存储的，会比上边的大一倍
     * ALPHA_8 只是用来记录半透明值，而不记录RGB值，目前没有用到过。
     * （用这个值生成的BItmap可以设置在ImageView上，效果挺有意思的...  但是，compress到disk上，发现文件大小为0）
     * RGB_565 分别用 5个bits 即32位有效值保持R，B，6个bits保存G，则一个像素使用2个byte。没有记录透明层。
     * 因为android中，JPG不会有透明属性，所以JPG类型的文件一般使用RGB_565来存储。
     * 而PNG一般会用ARGB_8888/4444来存储，当然也会有565形式。但是要注意的是PNG在调用Bitmp.compress方法的时候，
     * 因为PNG是无损存储，则quality参数没有用。但是使用JPEG时候，会把透明层部分压缩掉
     */
    private Bitmap getRoundBitmap(Bitmap bitmap, int r) {
        //如果此时图片格式设置为RGB 565则创建的图片圆角无效
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final Rect rect = new Rect(0, 0, getWidth(), getHeight());
        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        //drawRoundRect(RectF rect, float rx, float ry, Paint paint)：
        //使用指定的画笔绘制圆角矩形,其中rect为矩形边界、rx/ry分别为以矩形顶点为(0,0)相对位置圆的x半径、y半径
        // 如果rx !=ry 绘制出来的圆角是椭圆圆角
        canvas.drawRoundRect(rectF, r, r, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }


    private Bitmap getCompatBitmap(Bitmap bitmap) {
        float imageWith = getWidth();
        float imageHeigh = getHeight();
        float bitmapWith = bitmap.getWidth();
        float bitmapHeight = bitmap.getHeight();
        if (imageWith <= bitmapWith && imageHeigh <= bitmapHeight)
            return bitmap;
        float scaleWith = imageWith / bitmapWith;
        float scaleHeight = imageHeigh / bitmapHeight;
        float scale = Math.max(scaleHeight, scaleWith);
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        Bitmap newBitmap = Bitmap.createBitmap(bitmap, 0, 0, (int) bitmapWith, (int) bitmapHeight, matrix, true);
        return newBitmap;
    }


    private Bitmap getRoundBitmap(Bitmap b, float r) {
        Bitmap outbitmap = Bitmap.createBitmap(b.getWidth(), b.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(outbitmap);
        RectF rectF = new RectF(0, 0, getWidth(), getHeight());
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, r, r, paint);
        //画笔模式取相交部分
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(b, null, rectF, paint);
        return outbitmap;
    }


}
