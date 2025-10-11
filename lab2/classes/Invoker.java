package lab2.classes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invoker {
    public static void invokeAnnotatedMethods(Object obj) {
        java.lang.Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(Repeat.class)) {
                Repeat annotation = method.getAnnotation(Repeat.class);
                int repeatCount = annotation.value();
                method.setAccessible(true);
                System.out.println("Вызов метода: " + method.getName() + ", количество повторов: " + repeatCount);
                for (int i = 0; i < repeatCount; i++) {
                    try {
                        Object[] parameters = createDefaultParameters(method.getParameterTypes());
                        method.invoke(obj, parameters);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        System.err.println("Ошибка при вызове метода " + method.getName() + ": " + e.getMessage());
                    }
                }
                System.out.println();
            }
        }
    }
    
    private static Object[] createDefaultParameters(java.lang.Class<?>[] parameterTypes) {
        Object[] parameters = new Object[parameterTypes.length];
        
        for (int i = 0; i < parameterTypes.length; i++) {
            parameters[i] = getDefaultValue(parameterTypes[i]);
        }
        
        return parameters;
    }
    
    private static Object getDefaultValue(java.lang.Class<?> type) {
        if (type == int.class || type == Integer.class) {
            return 0;
        } else if (type == double.class || type == Double.class) {
            return 0.0;
        } else if (type == boolean.class || type == Boolean.class) {
            return false;
        } else if (type == String.class) {
            return "default";
        } else if (type == char.class || type == Character.class) {
            return ' ';
        } else if (type == long.class || type == Long.class) {
            return 0L;
        } else if (type == float.class || type == Float.class) {
            return 0.0f;
        } else {
            return null;
        }
    }
}