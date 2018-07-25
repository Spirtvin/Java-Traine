package DataStructures.LinkedList;

/**
 * односвязный список
 */
public class OWLL extends LL {

    public void AddLast(int value) {
        if (head == null) {
            ListItem item = new ListItem();
            item.value = value;
            head = item;
            tail = item;
        } else {
            ListItem current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListItem();
            current.next.value = value;
            tail = current.next;
        }

    }

    /**
     * @param value
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
                if (item == tail)
                    tail = current;
            } else {
                head = current.next;
                if(head==null)
                    tail = null;
            }
        }
    }

}