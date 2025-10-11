package lab2.classes;

public class TestClass {
    public void publicMethod1(String text) {
        System.out.println("Публичный метод 1: " + text);
    }
    public int publicMethod2(int a, int b) {
        int result = a + b;
        System.out.println("Публичный метод 2: " + a + " + " + b + " = " + result);
        return result;
    }
    
    @Repeat(3)
    protected void protectedMethod1(String name, int age) {
        System.out.println("Защищенный метод 1: " + name + ", возраст " + age);
    }
    @Repeat(2)
    protected String protectedMethod2() {
        System.out.println("Защищенный метод 2 без параметров");
        return "protected";
    }
    
    @Repeat(4)
    private void privateMethod1(double number) {
        System.out.println("Приватный метод 1: число " + number);
    }
    @Repeat(1)
    private boolean privateMethod2(String text, int count, boolean flag) {
        System.out.println("Приватный метод 2: текст='" + text + "', count=" + count + ", flag=" + flag);
        return !flag;
    }
    
    private void privateMethod3() {
        System.out.println("Этот приватный метод не аннотирован");
    }
}