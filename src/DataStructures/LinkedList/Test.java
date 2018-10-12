package DataStructures.LinkedList;

public class Test {
    public void TestTWLL() {
        TWLL list = new TWLL();
        for (int i = 0; i < 5; i++)
            list.AddFirst(i);
        System.out.print(list.ToString());
        for (int i = 0; i < 5; i++)
            list.Delete(i);
        System.out.print(list.ToString());
    }

    public void TestOWLL() {
        OWLL list = new OWLL();
        list.AddLast(1);
        System.out.print(list.ToString());
        list.AddLast(2);
        System.out.print(list.ToString());
        list.AddLast(3);
        System.out.print(list.ToString());
        ListItem res = list.Search(1);
        list.Delete(3);
        System.out.print(list.ToString());
        list.Delete(2);
        System.out.print(list.ToString());
        list.Delete(0);
        System.out.print(list.ToString());
        list.AddLast(99);
        System.out.print(list.ToString());
    }
}
