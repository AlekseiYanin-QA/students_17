import java.util.*;

public class ResultsBoard {
    private final TreeMap<Float, TreeSet<Student>> scoresMap;
    private final Map<String, Student> studentsMap;

    public ResultsBoard() {
        scoresMap = new TreeMap<>();
        studentsMap = new HashMap<>();
    }

    public void addStudent(String name, Float score) {
        // Если студент уже существует, удаляем его старую запись
        if (studentsMap.containsKey(name)) {
            Student existingStudent = studentsMap.get(name);
            scoresMap.get(existingStudent.score()).remove(existingStudent);
            if (scoresMap.get(existingStudent.score()).isEmpty()) {
                scoresMap.remove(existingStudent.score());
            }
        }

        // Создаём нового или обновляем существующего студента
        Student student = new Student(name, score);
        studentsMap.put(name, student);
        scoresMap.putIfAbsent(score, new TreeSet<>(Comparator.comparing(Student::name)));
        scoresMap.get(score).add(student);
    }

    public List<String> top3() {
        List<String> topStudents = new ArrayList<>();
        Iterator<Map.Entry<Float, TreeSet<Student>>> it = scoresMap.descendingMap().entrySet().iterator();

        // Получаем топ-3 студентов
        while (it.hasNext() && topStudents.size() < 3) {
            Map.Entry<Float, TreeSet<Student>> entry = it.next();
            for (Student student : entry.getValue()) {
                if (topStudents.size() < 3) {
                    topStudents.add(student.name());
                } else {
                    break;
                }
            }
        }
        return topStudents;
    }
}