package lab1.classes.Movement;

public class FlyMovement implements MoveMovement {
    @Override
    public void move(String from, String to) {
        System.out.println("Герой использует полёт и летит из " + from + " в " + to);
    }
}