package lab4.src;

import lab4.classes.AverageCalculator;
import lab4.classes.StringTransformer;
import lab4.classes.UniqueSquaresCalculator;
import lab4.classes.CollectionHelper;
import lab4.classes.EvenSumCalculator;
import lab4.classes.StringToMapConverter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Среднее значение: " + AverageCalculator.calculateAverage(numbers));
        
        List<String> strings = Arrays.asList("hello", "world", "java");
        System.out.println("Преобразованные строки: " + StringTransformer.transformStrings(strings));
        
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        System.out.println("Квадраты уникальных элементов: " + UniqueSquaresCalculator.getUniqueSquares(numbersWithDuplicates));
        
        List<String> collection = Arrays.asList("first", "second", "last");
        System.out.println("Последний элемент: " + CollectionHelper.getLastElement(collection));
        
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println("Сумма четных чисел: " + EvenSumCalculator.calculateEvenSum(array));
        
        List<String> stringList = Arrays.asList("apple", "banana", "avocado", "cherry");
        System.out.println("Map из строк: " + StringToMapConverter.convertToMap(stringList));
    }
}