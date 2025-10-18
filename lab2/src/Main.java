package lab2.src;

import lab2.classes.Invoker;
import lab2.classes.TestClass;

public class Main {
    public static void main(String[] args) {
        TestClass testObject = new TestClass();
        
        System.out.println("Прямой вызов публичных методов:");
        testObject.publicMethod1("тест");
        testObject.publicMethod2(5, 3);
        System.out.println();
        
        System.out.println("Вызов аннотированных методов через рефлексию:");
        Invoker.invokeProtectedAndPrivateMethods(testObject);
    }
}