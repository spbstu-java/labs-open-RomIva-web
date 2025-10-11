package lab1.classes.Movement;

public class TeleportMovement implements MoveMovement {
    @Override
    public void move(String from, String to) {
        System.out.println("Герой использует телепортацию из " + from + " в " + to);
    }
}