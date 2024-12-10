package com.yp.wcUtil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Utils {


    @SuppressLint("ClickableViewAccessibility")
    public static void hideSoftInput(final Context context, View view) {

        final InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);

        view.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (((Activity) context).getCurrentFocus() != null) {
                        if (((Activity) context).getCurrentFocus().getWindowToken() != null) {
                            imm.hideSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                        }
                    }
                }
                return false;
            }
        });
    }

    public static String null2Empty(String pStr) {
        String str = "";
        if (!TextUtils.isEmpty(pStr)) {
            if ("null".equals(pStr)) {
                str = "";
            } else {
                str = pStr;
            }
        }
        return str;
    }

    public static <T> boolean isListEmpty(List<T> pList) {
        if (null == pList || pList.isEmpty()) {
            return true;
        }
        return false;
    }


    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+除1和4的任意数
     * 17+除9的任意数
     * 147
     */
    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }


    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

}
