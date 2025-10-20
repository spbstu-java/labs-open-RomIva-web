package lab2.classes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Invoker {
    public static void invokeProtectedAndPrivateMethods(Object obj) {
        java.lang.Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (Modifier.isProtected(modifiers) || Modifier.isPrivate(modifiers)) {
                System.out.println("Найден метод: " + method.getName() + " (модификатор: " + getModifierName(modifiers) + ")");
                int repeatCount = 1;
                if (method.isAnnotationPresent(Repeat.class)) {
                    Repeat annotation = method.getAnnotation(Repeat.class);
                    repeatCount = annotation.value();
                    System.out.println("Аннотация @Repeat(" + repeatCount + ") найдена");
                }
                method.setAccessible(true);

                for (int i = 0; i < repeatCount; i++) {
                    try {
                        System.out.print("Вызов " + (i + 1) + "/" + repeatCount + ": ");
                        Object[] parameters = createDefaultParameters(method.getParameterTypes());
                        Object result = method.invoke(obj, parameters);
                        
                        if (!method.getReturnType().equals(void.class)) {
                            System.out.println("Возвращено: " + result);
                        }
                    } catch (IllegalAccessException | IllegalArgumentException | 
                             InvocationTargetException e) {
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
            return 10;
        } else if (type == double.class || type == Double.class) {
            return 3.14;
        } else if (type == boolean.class || type == Boolean.class) {
            return true;
        } else if (type == String.class) {
            return "string";
        } else if (type == char.class || type == Character.class) {
            return 'A';
        } else if (type == long.class || type == Long.class) {
            return 100L;
        } else if (type == float.class || type == Float.class) {
            return 2.5f;
        } else {
            return null;
        }
    }
    
    private static String getModifierName(int modifiers) {
        if (Modifier.isPrivate(modifiers)) {
            return "private";
        } else if (Modifier.isProtected(modifiers)) {
            return "protected";
        } else if (Modifier.isPublic(modifiers)) {
            return "public";
        } else {
            return "package-private";
        }
    }
}