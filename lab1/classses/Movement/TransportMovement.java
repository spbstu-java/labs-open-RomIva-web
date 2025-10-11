package lab1.classes.Movement;

public class TransportMovement implements MoveMovement {
    @Override
    public void move(String from, String to) {
        System.out.println("Герой использует средство передвижения для перемещения из " + from + " в " + to);
    }
}