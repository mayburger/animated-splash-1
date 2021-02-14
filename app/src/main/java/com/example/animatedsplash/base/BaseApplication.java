package com.example.animatedsplash.base;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.multidex.MultiDex;
import com.example.animatedsplash.utils.textfont.TypeFactory;
import com.orhanobut.hawk.Hawk;

public class BaseApplication extends Application {
    private static BaseApplication sInstance;
    public static volatile Context applicationContext = null;
    public static volatile Handler applicationHandler = null;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        MultiDex.install(this);
        super.onCreate();
        sInstance = this;
        Hawk.init(this).build();

        applicationContext = getApplicationContext();
        applicationHandler = new Handler(applicationContext.getMainLooper());
        //v2
    }

    public static synchronized BaseApplication getApp() {
        return sInstance;
    }

    private TypeFactory mFontFactory;

    public Typeface getTypeFace(int type) {
        if (mFontFactory == null)
            mFontFactory = new TypeFactory(this);

        switch (type) {
            case Constants.MEDIUM:
                return mFontFactory.getMedium();
            case Constants.BOLD:
                return mFontFactory.getBold();
            case Constants.ITALIC:
                return mFontFactory.getItalic();
            case Constants.BLACK:
                return mFontFactory.getBlack();
            default:
                return mFontFactory.getRegular();
        }
    }


    private interface Constants {
        int REGULAR = 0;
        int MEDIUM = 1;
        int BOLD = 2;
        int ITALIC = 3;
        int BLACK = 4;
    }

    public static BaseApplication getInstance() {
        return sInstance;
    }
}
