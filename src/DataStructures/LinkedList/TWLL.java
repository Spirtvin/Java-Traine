package DataStructures.LinkedList;

public class TWLL extends LL {
    /**
     * добавлеят элемент в список
     *
     * @param value число для добавления
     */


    public void AddLast(int value) {
        if (head == null) {
            head = new ListItem(value, null, null);
            tail = head;
        } else {
            ListItem current = head;
            while (current.next != null) {
                current.prev = current;
                current = current.next;
            }
            current.next = new ListItem();
            current.next.value = value;
            current.prev = current;
            tail = current.next;
            tail.prev = current;
        }
    }

    /**
     * удаляет элемент из списка
     *
     * @param value число для удаления
     */
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
                if (item.next != null)
                    item.next.prev = current;
                if (item == tail)
                    tail = current;
            } else {
                head = current.next;
                if (head == null)
                    tail = null;
            }

        }
    }

}
