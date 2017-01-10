package com.ls.basic.utils;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class ReflectUtil {

    @SuppressWarnings({"unchecked"})
    public static <T> Object getDeclaredField(Class type, Object target, String name) {
        T value = null;
        try {
            Field field = type.getDeclaredField(name);
            boolean accessible = field.isAccessible();
            field.setAccessible(true);
            value = (T) field.get(target);
            field.setAccessible(accessible);
        } catch (NoSuchFieldException e) {
//            LogUtil.e("get filed error:" + name, e);
            KLog.e("Reflect", name, e);
        } catch (IllegalAccessException e) {
//            LogUtil.e("access filed error:" + name, e);
            KLog.e("Reflect", name, e);
        }
        return value;
    }

    @SuppressWarnings({"unchecked"})
    public static void invokeDeclaredMethod(Class type, Object target, String name, Class[] parameterTypes, Object... args) {
        try {
            Method method = type.getDeclaredMethod(name, parameterTypes);
            boolean accessible = method.isAccessible();
            method.setAccessible(true);
            method.invoke(target, args);
            method.setAccessible(accessible);
        } catch (NoSuchMethodException e) {
//            LogUtil.e("could not find declaredMethod:" + name, e);
            KLog.e("Reflect", name, e);
        } catch (InvocationTargetException e) {
//            LogUtil.e("access filed error:" + name, e);
            KLog.e("Reflect", name, e);
        } catch (IllegalAccessException e) {
//            LogUtil.e("access method error:" + name, e);
            KLog.e("Reflect", name, e);
        }
    }

}
