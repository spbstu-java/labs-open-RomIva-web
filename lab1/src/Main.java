package lab1.src;

import java.util.Scanner;
import lab1.classes.Hero.Hero;
import lab1.classes.Movement.FlyMovement;
import lab1.classes.Movement.TransportMovement;
import lab1.classes.Movement.WalkMovement;
import lab1.classes.Movement.TeleportMovement;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Hero hero = new Hero();
    
    private static final int EXIT_OPTION = 0;
    private static final int WALK_OPTION = 1;
    private static final int TRANSPORT_OPTION = 2;
    private static final int FLY_OPTION = 3;
    private static final int TELEPORT_OPTION = 4;
    private static final int ERROR_INPUT_OPTION = -1;
    
    public static void main(String[] args) {
        try {
            runApplication();
        } finally {
            scanner.close();
        }
    }
    
    private static void runApplication() {
        while (true) {
            printMenu();
            int choice = getMenuChoice();
            if (choice == ERROR_INPUT_OPTION) {
                System.out.println("Неверный ввод! Введите число от " + EXIT_OPTION + " до " + TELEPORT_OPTION + ".");
                continue;
            }

            if (choice == EXIT_OPTION) {
                break;
            }
            
            if (!processMovementChoice(choice)) {
                continue;
            }
            
            if (!processMovementPoints()) {
                continue;
            }
        }
    }
    
    private static void printMenu() {
        System.out.println("\nВыберите способ перемещения");
        System.out.println(WALK_OPTION + " - Пешком");
        System.out.println(TRANSPORT_OPTION + " - Транспорт");
        System.out.println(FLY_OPTION + " - Полет");
        System.out.println(TELEPORT_OPTION + " - Телепортация");
        System.out.println(EXIT_OPTION + " - Выход");
        System.out.print("Ваш выбор: ");
    }
    
    private static int getMenuChoice() {
        String input = scanner.nextLine().trim();
        
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return ERROR_INPUT_OPTION;
        }
    }
    
    private static boolean processMovementChoice(int choice) {
        switch (choice) {
            case WALK_OPTION:
                hero.setMovement(new WalkMovement());
                return true;
            case TRANSPORT_OPTION:
                hero.setMovement(new TransportMovement());
                return true;
            case FLY_OPTION:
                hero.setMovement(new FlyMovement());
                return true;
            case TELEPORT_OPTION:
                hero.setMovement(new TeleportMovement());
                return true;
            case EXIT_OPTION:
                return false;
            default:
                System.out.println("Неизвестная операция! Выбирайте от " + EXIT_OPTION + " до " + TELEPORT_OPTION + ".");
                return false;
        }
    }
    
    private static boolean processMovementPoints() {
        String from = getInputPoint("Введите точку отправления: ");
        if (from == null) return false;
        
        String to = getInputPoint("Введите точку назначения: ");
        if (to == null) return false;
        
        hero.move(from, to);
        return true;
    }
    
    private static String getInputPoint(String prompt) {
        System.out.print(prompt);
        String point = scanner.nextLine().trim();
        
        if (point.isEmpty()) {
            System.out.println("Точка не может быть пустой!");
            return null;
        }
        
        return point;
    }
}