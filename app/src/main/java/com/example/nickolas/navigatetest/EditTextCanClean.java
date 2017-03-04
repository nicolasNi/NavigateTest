package com.example.nickolas.navigatetest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

//import android.widget.RelativeLayout;

/**
 * Created by nickolas on 2017/2/20.
 */

public class EditTextCanClean extends RelativeLayout {
    private ImageView bluetooth;
    private ImageView dashboard;
    private ImageView navigation;
    private ImageView wechat;
    private ImageView music;

    private ImageView currentView;
    private ImageView nextView;
    private ImageView previousView;

    public int index;
    private View view;

    public EditTextCanClean(Context context)
    {
        super(context);
    }

    public EditTextCanClean(Context context, AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.mould_layout, this, true);
        bluetooth = (ImageView) view.findViewById(R.id.imageBluetooth);
        dashboard = (ImageView) view.findViewById(R.id.imageDashboard);
        navigation = (ImageView) view.findViewById(R.id.imageNavigation);
        wechat = (ImageView) view.findViewById(R.id.imageWechat);
        music = (ImageView) view.findViewById(R.id.imageMusic);
        index = 0;
        view.setVisibility(View.INVISIBLE);
        getViewsNeedToChange();

        displayWidget();
    }

    public void displayWidget()
    {
        turnTOBig(currentView);
        view.setVisibility(View.VISIBLE);
    }

    public void ok()
    {
        turnTOSmall(currentView);
        view.setVisibility(View.INVISIBLE);
    }

    public void next()
    {
        getViewsNeedToChange();
        turnTOSmall(currentView);
        turnTOBig(nextView);
        if(index == 4)
        {
            index =0;
        }
        else {
            index++;
        }
    }

    public void previous()
    {
        getViewsNeedToChange();
        turnTOSmall(currentView);
        turnTOBig(previousView);
        if(index == 0)
        {
            index = 4;
        }
        else {
            index--;
        }
    }

    private void getViewsNeedToChange()
    {
        switch (index)
        {
            case 0:
                currentView = bluetooth;
                nextView = dashboard;
                previousView = music;
                break;
            case 1:
                currentView = dashboard;
                nextView = navigation;
                previousView = bluetooth;
                break;
            case 2:
                currentView = navigation;
                nextView = wechat;
                previousView = dashboard;
                break;
            case 3:
                currentView = wechat;
                nextView = music;
                previousView = navigation;
                break;
            case 4:
                currentView = music;
                nextView = bluetooth;
                previousView = wechat;
                break;
        }
    }

    private void turnTOBig(ImageView imageView)
    {
        RelativeLayout.LayoutParams params = new LayoutParams(imageView.getWidth()+40,imageView.getHeight()+80);
        params.topMargin = imageView.getTop()-80;
        params.leftMargin = imageView.getLeft();
        imageView.setLayoutParams(params);
    }

    private void turnTOSmall(ImageView imageView)
    {
        RelativeLayout.LayoutParams params = new LayoutParams(imageView.getWidth()-40,imageView.getHeight()-80);
        params.topMargin = imageView.getTop()+80;
        params.leftMargin = imageView.getLeft();
        imageView.setLayoutParams(params);
    }


    public void testBig()
    {
        turnTOBig(currentView);
    }

    public void testSmall()
    {
        turnTOSmall(currentView);
    }
}
