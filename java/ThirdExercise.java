import java.util.*;

public class ThirdExercise {
    public static void main(String[] args) {
        List<String> symbols = new ArrayList<>();
        Collections.addAll(symbols,  "f10", "a15", "f2", "f4", "f5", "b54", "a16");
        // Вариант1
        symbols.stream()
                .sorted()
                .forEach(s -> System.out.println(s));

        //Вариант 2. Если мы рассматриваем F10 не как цифру F c 1.0, а как F с числом 10
        Collections.sort(symbols, (s1, s2) -> {
            String alhpabet1 = s1.replaceAll("\\d", "");
            String alphabet2 = s2.replaceAll("\\d", "");
            if (!alhpabet1.equals(alphabet2)) {
                return alhpabet1.compareTo(alphabet2);
            } else {
                return Integer.parseInt(s1.replaceAll("[^0-9]", ""))
                - Integer.parseInt(s2.replaceAll("[^0-9]", ""));
            }
        });

        String[] array = new String[symbols.size()];
        symbols.toArray(array);

        System.out.println(Arrays.toString(array));
}
}
