record Student(String name, Float score) implements Comparable<Student> {

    @Override
    public int compareTo(Student other) {
        return this.score.compareTo(other.score); // Сравнение по баллам в порядке возрастания
    }
}
