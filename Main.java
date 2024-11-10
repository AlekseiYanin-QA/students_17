import java.util.List;

public class Main {
    public static void main(String[] args) {

        ResultsBoard rb = new ResultsBoard();

        rb.addStudent("Ivan", 3.0f);
        rb.addStudent("Maria", 4.0f);
        System.out.println(rb.top3()); // -> [Maria, Ivan]
        rb.addStudent("Vlad", 5.0f);
        System.out.println(rb.top3()); // -> [Vlad, Maria, Ivan]
        rb.addStudent("Anton", 4.5f);
        System.out.println(rb.top3()); // -> [Vlad, Anton, Maria]
        rb.addStudent("Daria", 1.5f);
        System.out.println(rb.top3()); // -> [Vlad, Anton, Maria]
        rb.addStudent("Vasiliy", 5.0f);
        System.out.println(rb.top3()); // -> [Vlad, Vasiliy, Anton] или [Vasiliy, Vlad, Anton]

        rb.addStudent("Vlad", 3.5f); // Обновление Vlad с новым баллом
        System.out.println(rb.top3()); // ->  [Vasiliy, Anton, Maria]

        List<String> topStudents = rb.top3();

        System.out.println("\nТоп 3 студента:");
        for (String student : topStudents) {
            System.out.println(student); // ->  [Vasiliy, Anton, Maria]
        }
    }
}