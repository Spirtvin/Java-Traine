package OOP;

public class Human {
    /**
     * Номер
     */
    public int id;
    /**
     * Имя
     */
    public String name;
    /**
     * Фамилия
     */
    public String surname;
    /**
     * Возрост
     */
    public int age;

    public void Print() {
        String str = String.format("id:%d name:%s surname:%s age:%d", id, name, surname, age);
        System.out.println(str);
    }

    public void Init(Human human) {
        Init(human.id, human.name, human.surname, human.age);
    }

    public void Init(int _id, String _name, String _surname, int _age) {
        name = _name;
        surname = _surname;
        age = _age;
        id = _id;
    }

    public Human() {
        Init(-1, "", "", -1);
    }

    public Human(int _id, String _name, String _surname, int _age) {
        Init(_id, _name, _surname, _age);
    }
}
