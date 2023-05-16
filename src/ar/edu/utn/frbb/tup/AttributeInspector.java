package ar.edu.utn.frbb.tup;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AttributeInspector {

    public static Map<String, String> getAttributeInputStrategy(Class clazz){
        Map<String, String> fieldz = new HashMap<>();
        for (Field field :
                clazz.getFields()) {
            fieldz.put(field.getName(), field.getType().getSimpleName());
        }
        return fieldz;
    }

    public static void invokeSetter(Object obj, String propertyName, Object variableValue)
    {
        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(propertyName, obj.getClass());
            Method setter = pd.getWriteMethod();
            try {
                setter.invoke(obj,variableValue);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

    }
 }
