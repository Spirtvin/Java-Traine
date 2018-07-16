package DataStructures;

import java.util.List;

/**
 * односвязный список
 */
public class OWLL {
    /**
     * начало списка
     */
    ListItem head;

    public OWLL() {
        head = null;
    }

    /**
     * добавлеят элемент в список
     *
     * @param value число для добавления
     */
    public void Add(int value) {
        if (head == null) {
            ListItem item = new ListItem();
            item.value = value;
            head = item;
        } else {
            ListItem current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListItem();
            current.next.value = value;
        }

    }

    /**
     * ищет элемент в списке
     *
     * @param value число для поиска
     * @return ListItem - если элемент найден, null если нет
     */
    public ListItem Search(int value) {
        ListItem current = head;
        while (current.next != null && current.value != value) {
            current = current.next;
        }
        if (current.value == value)
            return current;
        else
            return null;
    }

    public void Delete(int value) {
        //искомый
        ListItem item = Search(value);
        if (item != null) {
            //предыдущий элмент
            ListItem current = head;
            if (current != item) {
                while (current.next != item)
                    current = current.next;
                current.next = item.next;
            }
            else{
                head = current.next;
            }
        }
    }

    public String ToString() {
        String str = "\nOWLL items:\n";
        ListItem current = head;
        while (current != null) {
            str += Integer.toString(current.value) + '\n';
            current = current.next;
        }
        return str;
    }

}
