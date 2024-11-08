import java.util.*;

public class ResultsBoard {
    // TreeMap хранит записи с именами студентов и их средними баллами
    private final TreeMap<Float, Set<String>> scoresMap;

    public ResultsBoard() {
        scoresMap = new TreeMap<>();
    }

    // Метод для добавления студента
    public void addStudent(String name, Float score) {
        if (scoresMap.containsKey(score)) {
            scoresMap.get(score).remove(name);
            if (scoresMap.get(score).isEmpty()) {
                scoresMap.remove(score);
            }
        }

        // Добавляем новую запись
        scoresMap.putIfAbsent(score, new HashSet<>());
        scoresMap.get(score).add(name);
    }

    // Метод для получения 3-х лучших студентов
    public List<String> top3() {
        List<String> topStudents = new ArrayList<>();

        // Используем метод descendingKeySet() для получения в порядке убывания
        for (Float score : scoresMap.descendingKeySet()) {
            // Получаем имена студентов с текущим баллом
            for (String name : scoresMap.get(score)) {
                topStudents.add(name);
                // Если нашли 3 студента, выходим
                if (topStudents.size() == 3) {
                    return topStudents;
                }
            }
        }

        return topStudents; // Возвращаем список студентов
    }
}

