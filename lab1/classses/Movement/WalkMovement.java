package lab1.classes.Movement;

public class WalkMovement implements MoveMovement {
    @Override
    public void move(String from, String to) {
        System.out.println("Герой ничего не использует и идёт пешком из " + from + " в " + to);
    }
}