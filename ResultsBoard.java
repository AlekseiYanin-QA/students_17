import java.util.*;

public class ResultsBoard {
    private final TreeMap<Float, TreeSet<Student>> scoresMap;

    public ResultsBoard() {
        scoresMap = new TreeMap<>();
    }

    public void addStudent(String name, Float score) {
        Student student = new Student(name, score);

        // Удаляем существующие записи, если есть
        scoresMap.values().forEach(set -> set.remove(student));

        // Добавляем запись
        scoresMap.putIfAbsent(score, new TreeSet<>());
        scoresMap.get(score).add(student);
    }

    public List<String> top3() {
        List<String> topStudents = new ArrayList<>();

        // Получаем записи с наивысшим баллом
        for (int i = 0; i < 3; i++) {
            Map.Entry<Float, TreeSet<Student>> entry = scoresMap.pollLastEntry(); // Получаем запись с наивысшим баллом
            if (entry != null) {
                TreeSet<Student> students = entry.getValue();
                Student student = students.pollLast(); // Получаем студента с высшим баллом
                if (student != null) {
                    topStudents.add(student.name());
                }
                // Если в наборе студентов больше нет студентов, удаляем запись
                if (students.isEmpty()) {
                    scoresMap.remove(entry.getKey());
                }
            } else {
                break; // Если нет студентов, выходим
            }
        }

        return topStudents; // Возвращаем список студентов
    }
}
