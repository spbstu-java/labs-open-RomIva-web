package lab1.classes.Hero;

import lab1.classes.Movement.MoveMovement;
import lab1.classes.Movement.WalkMovement;

public class Hero {
    private MoveMovement movement;
    
    public Hero() {
        this.movement = new WalkMovement();
    }
    
    public void setMovement(MoveMovement movement) {
        this.movement = movement;
    }
    
    public void move(String from, String to) {
        movement.move(from, to);
    }
}