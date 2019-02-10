package OOP;

public class Test {
    public void Start() {
        Human human1 = new Human(1, "Ivan", "Ivanov", 20);
        Human human2 = new Human(2, "Ivan", "Petrov", 25);
        Student student = new Student(human1, 1, "5343", 0, 0, 0);
        student.Print();
        Teacher teacher = new Teacher(human2, "Химия", 255);
        teacher.Print();
    }
}
