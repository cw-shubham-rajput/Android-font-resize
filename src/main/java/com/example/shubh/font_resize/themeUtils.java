package com.example.shubh.font_resize;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by shubh on 7/28/2016.
 */
public class themeUtils
{
    private static int cTheme;
    public final static int BLACK = 0;
    public final static int WHITE = 1;

    public static void changeToTheme(Activity activity, int theme)
    {
        cTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (cTheme)
        {
            default:

            case BLACK:
                activity.setTheme(R.style.BlackTheme);
                break;

            case WHITE:
                activity.setTheme(R.style.WhiteTheme);
                break;

        }

    }
}

