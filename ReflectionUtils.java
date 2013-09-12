package com.pixelduke.javafx.chart;

import javafx.scene.chart.XYChart;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: Pedro
 * Date: 11-09-2013
 * Time: 23:21
 * To change this template use File | Settings | File Templates.
 */
public class ReflectionUtils {

    public static Object forceMethodCall(Class classInstance, String methodName, Object source, Object... params)
    {
        Object returnedObject = null;
        try {
            Method method = classInstance.getDeclaredMethod(methodName);
            method.setAccessible(true);
            returnedObject =  method.invoke(source);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return returnedObject;
    }

    public static Object forceFieldCall(Class classInstance, String fieldName, Object source)
    {
        Object returnedObject = null;
        try
        {
            Field field = classInstance.getDeclaredField(fieldName);
            field.setAccessible(true);
            returnedObject = field.get(source);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return returnedObject;
    }
}
