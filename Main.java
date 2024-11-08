import java.util.List;

public class Main {
    public static void main(String[] args) {

        ResultsBoard rb = new ResultsBoard();

        rb.addStudent("Алексей", 90.0f);
        rb.addStudent("Мария", 85.0f);
        rb.addStudent("Сергей", 92.0f);
        rb.addStudent("Дмитрий", 90.0f);
        rb.addStudent("Елена", 88.0f);
        rb.addStudent("Иван", 90.0f);
        rb.addStudent("Андрей", 75.0f);
        rb.addStudent("Виктор", 98.0f);

        List<String> topStudents = rb.top3();

        System.out.println("Топ 3 студента:");
        for (String student : topStudents) {
            System.out.println(student);
        }
    }
}