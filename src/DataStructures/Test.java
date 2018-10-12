package DataStructures;

import Generator.Generator;

public abstract class Test extends Generator {
    //<editor-fold desc="Fields">
    /**
     * структура данных для тестирования
     */
    public DataStructure structure;
    //</editor-fold>

    //<editor-fold desc="Constructors">
    public Test(DataStructure _structure) {
        structure = _structure;
    }

    public Test() {
        structure = null;
    }
    //</editor-fold>

    //<editor-fold desc="Methods">
    /**
     * @return
     */
    public abstract boolean PushFront();

    /**
     * @return
     */
    public abstract boolean PushBack();

    /**
     * @return
     */
    public abstract boolean PopFront();

    /**
     * @return
     */
    public abstract boolean PopBack();

    /**
     * @return
     */
    public abstract boolean IsEmpty();

    /**
     * Проверка на то что не полный
     *
     * @return
     */
    public abstract boolean IsFull();

    /**
     * @return
     */
    public abstract boolean Clear();

    /**
     * проеврка поиска в структуре
     *
     * @return
     */
    public abstract boolean Search();

    public void Start() {
        System.out.println("Structure:" + this.structure.getClass().getName());
        System.out.println("________________");
        System.out.println("Push front:" + PushFront());
        System.out.println("Push Back:" + PushBack());
        System.out.println("Pop Front:" + PopFront());
        System.out.println("Pop Back:" + PopBack());
        System.out.println("Is Empty:" + IsEmpty());
        System.out.println("Is Full:" + IsFull());
        System.out.println("Clear:" + Clear());
        System.out.println("Search:" + Search());
        System.out.println("________________");
    }
    //</editor-fold>

}
