import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecondExercise {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        Collections.addAll(words, "Highload", "High", "«Load", "Highload");

        long count = words.stream()
                .filter(s -> s.equals("High")).count();
        String firstWord = words.stream()
                .findFirst().orElse("0");
        String lastWord = words.stream()
                .reduce((a, b) -> b).orElse("0");

        System.out.println("Сколько раз встречается объект \"High\": " + count);
        System.out.println("Первое место в коллекции: " + firstWord);
        System.out.println("Последнее место в коллекции: " + lastWord);
    }
}
