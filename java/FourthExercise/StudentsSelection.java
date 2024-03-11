package FourthExercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsSelection {
    public static void main(String[] args) {
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
        );

        double mediumAge = students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
        System.out.println("Средний возраст студентов мужского пола: " + mediumAge);
        System.out.println("*************************************************************");

        List<Student> getAgenda = students.stream()
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 27)
                .collect(Collectors.toList());
        System.out.println("Повестку могут получить: " );
        for (Student student : getAgenda) {
            System.out.println(student.getName());
        }
    }
}



