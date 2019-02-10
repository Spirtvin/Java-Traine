package OOP;

public class Student extends Human {
    /**
     * Год обучения.
     */
    public int course;

    /**
     * Номер группы студента
     */
    public String group;

    /**
     * Средний балл студента.
     */
    public double averegeScore;

    /**
     * Посещаемость студента
     */
    public int attendance;

    /**
     * Уровень навыков студента
     */
    public int skill;

    public void learn(Teacher teacher) {

    }

    public void Print() {
        System.out.println("Student:");
        super.Print();
        String str = String.format("course: %d group: %s average Score: %f attendance: %d skill: %d",
                course, group, averegeScore, attendance, skill);
        System.out.println(str);
    }

    public void Init(int _course, String _group,
                     int _averegeScore, int _attendance,
                     int _skill) {
        course = _course;
        group = _group;
        averegeScore = _averegeScore;
        attendance = _attendance;
        skill = _skill;
    }

    public void Init(Human human, int _course,
                     String _group, int _averegeScore,
                     int _attendance, int _skill) {
        super.Init(human);
        Init(_course, _group, _averegeScore, _attendance, _skill);
    }

    public void Init(int _id, String _name,
                     String _surname, int _age,
                     int _course, String _group,
                     int _averegeScore, int _attendance, int _skill) {
        super.Init(_id, _name, _surname, _age);
        Init(_course, _group, _averegeScore, _attendance, _skill);
    }

    public Student() {
        super.Init(-1, "", "", -1);
        Init(-1, "no name", 0, 0, 0);
    }

    public Student(int _course, String _group,
                   int _averegeScore, int _attendance,
                   int _skill) {
        super.Init(-1, "", "", -1);
        Init(_course, _group, _averegeScore, _attendance, _skill);
    }

    public Student(Human human, int _course,
                   String _group, int _averegeScore,
                   int _attendance, int _skill) {
        Init(human, _course, _group, _averegeScore, _attendance, _skill);
    }

    public Student(int _id, String _name, String _surname, int _age,
                   int _course, String _group, int _averegeScore,
                   int _attendance, int _skill) {
        Init(_id, _name, _surname, _age, _course, _group, _averegeScore, _attendance, _skill);
    }
}
