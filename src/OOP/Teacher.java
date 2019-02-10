package OOP;

public class Teacher extends Human {
    /**
     * Какой предмет преподаёт
     */
    public String subject;

    /**
     * Всего часов за семестр
     */
    public int numberLectures;

    /**
     * @param student - обучаемый студент
     *                Добавляет 1 балл к уровню навыка студента
     */
    public void teach(Student student) {
        student.skill++;
    }

    public void Print() {
        System.out.println("Teacher:");
        super.Print();
        String str = String.format("subject:%s numberLectures:%d", subject, numberLectures);
        System.out.println(str);
    }

    private void Init(String _name, String _surname,
                      int _age, int _id,
                      String _subject, int _numberLectures) {
        super.Init(_id, _name, _surname, _age);
        subject = _subject;
        numberLectures = _numberLectures;
    }

    private void Init(Human human, String _subject, int _numberLectures) {
        super.Init(human);
        subject = _subject;
        numberLectures = _numberLectures;
    }

    public Teacher() {
        Init("", "", -1, -1, "", -1);
    }

    public Teacher(String _name, String _surname,
                   int _age, int _id,
                   String _subject, int _numberLectures) {
        Init(_name, _surname, _age, _id, _subject, _numberLectures);
    }

    public Teacher(Human human, String _subject, int _numberLectures) {
        Init(human, _subject, _numberLectures);
    }
}

