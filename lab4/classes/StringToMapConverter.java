package lab4.classes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringToMapConverter {
    public static Map<Character, String> convertToMap(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toMap(
                        s -> s.charAt(0), // ключ - первый символ
                        s -> s.length() > 1 ? s.substring(1) : "", // значение - оставшиеся символы
                        (existing, replacement) -> existing // обработка дубликатов ключей
                ));
    }
}