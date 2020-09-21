package com.legend.study;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

public class InjectViewUtilsJava {

    public static void init(Activity activity){
        Class<? extends Activity> aClass = activity.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(MyButterKinfeJava.class)) {
                MyButterKinfeJava annotation = field.getAnnotation(MyButterKinfeJava.class);
                int id = annotation.value();
                if (id!=0) {
                    View view = activity.findViewById(id);
                    field.setAccessible(true);
                    try {
                        field.set(activity,view);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
