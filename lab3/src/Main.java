package lab3.src;

import lab3.classes.Model.Translator;
import lab3.classes.Exceptions.InvalidFileFormatException;
import lab3.classes.Exceptions.FileReadException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Пример: java lab3.src.Main dictionary.txt");
            return;
        }
        
        String dictionaryFile = args[0];
        Translator translator = new Translator();
        
        try {
            System.out.println("Загрузка словаря из файла: " + dictionaryFile);
            translator.loadDictionary(dictionaryFile);
            System.out.println("Словарь успешно загружен. Записей: " + translator.getDictionary().size());
            
            startInteractiveMode(translator);
            
        } catch (FileReadException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        } catch (InvalidFileFormatException e) {
            System.err.println("Ошибка формата файла: " + e.getMessage());
        }
    }
    
    private static void startInteractiveMode(Translator translator) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Переводчик запущен. Для выхода введите 'exit'");
        
        while (true) {
            System.out.print("Введите текст для перевода: ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            if (input.isEmpty()) {
                continue;
            }
            
            String translation = translator.translate(input);
            System.out.println("Перевод: " + translation);
            System.out.println();
        }
        
        scanner.close();
    }
}