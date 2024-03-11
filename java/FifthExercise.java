import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FifthExercise {
    public static void main(String[] args) {
        List<String> logins = new ArrayList<>(Arrays.asList("fififif", "djhfjhf", "peinfnf123", "fissjsj"));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите логин. \n*Для завершения программы оставьте поле пустым и нажмите Enter: ");
            String login = scanner.nextLine();
            logins.add(login);
            if (login.isEmpty()) {
                break;
            }
        }
            logins.stream()
                    .filter(login -> login.startsWith("f"))
                    .forEach(System.out::println);
        }
    }

