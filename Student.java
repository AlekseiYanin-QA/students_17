record Student(String name, Float score) implements Comparable<Student> {

    @Override
    public int compareTo(Student other) {
        return other.score.compareTo(this.score); // Сортировка по убыванию баллов
    }
}