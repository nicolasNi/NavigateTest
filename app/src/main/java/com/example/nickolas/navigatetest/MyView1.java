package com.example.nickolas.navigatetest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.io.InputStream;

/**
 * Created by nickolas on 2017/2/22.
 */

public class MyView1 extends View {
    private String mtext;
    private int msrc;

    public MyView1(Context context) {
        super(context);
    }

    public MyView1(Context context, AttributeSet attrs) {
        super(context, attrs);

        //方法attrs.getAttributeResourceValue(String nameSpace, String attriName, int default)的nameSpace参数传null即可————
        int textId = attrs.getAttributeResourceValue(null, "Text", 0);
        int imgId = attrs.getAttributeResourceValue(null, "Img", 0);

        //根据传来的id找出字符串，比如示例代码中传入的是@stirng/hello_world
        //这里也可以直接在xml文件中设置字符串的参数但是获取属性值的方法就要相应变成
        //mtext = attrs.getAttributeValue(null, "Text")直接获取传入的字符串
        mtext = getResources().getText(textId).toString();
        msrc = imgId;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(30);

        InputStream is = getResources().openRawResource(msrc);
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        int imgWid = bitmap.getWidth();
        int imgHei = bitmap.getHeight();
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.drawText(mtext,imgWid/3, imgHei/2, paint);
    }
}