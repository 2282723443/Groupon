package com.wangwei.groupon.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.wangwei.groupon.config.Constant;

/**
 * 对偏好设置文件的操作
 * 给别人看的 自己不看
 * 1) Context的getSharedPreferences(文件名，模式)
 * 2) activity的getpreference(模式);
 * 3) PrefernaceManager的getDefaultSharedPreferances();
 *    获取preference_包名 偏好设置文件
 *    模式 Context_MODE_PRIVTE;
 * Created by weibaba on 2017/6/15.
 */

public class SPUtil {
      SharedPreferences sp;

    //通过构造器的重载，以不同的方式来获得偏好设置文件

    public SPUtil(Context context, String name){
        sp=context.getSharedPreferences(name,Context.MODE_PRIVATE);

    }
    public SPUtil(Context context){
        sp = PreferenceManager.getDefaultSharedPreferences(context);

    }

    public  boolean isFirst(){

        //TODO getSharedPreferences

        return sp.getBoolean(Constant.FIRST,true);
    }
   public void setFirst(boolean flag){
       SharedPreferences.Editor editor = sp.edit();
       editor.putBoolean(Constant.FIRST,false);
       editor.commit();
   }

}
