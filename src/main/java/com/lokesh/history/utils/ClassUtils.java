package com.lokesh.history.utils;

import java.lang.reflect.InvocationTargetException;

public class ClassUtils {

    public static Object getObjectBasedOnClass(String instrumentToken) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return Class.forName(instrumentToken).getDeclaredConstructor().newInstance();
    }

}
