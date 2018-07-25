package DataStructures.LinkedList;

/**
 * linked list
 */
public class LL {
    /**
     * начало списка
     */
    ListItem head;
    /**
     * конец списка
     */
    ListItem tail;
    public LL() {
        head = null;
        tail = null;
    }


    //public  void Add(int value){}


    /**
     * @param value
     */
    public void AddFirst(int value){
        if (head == null) {
            head = new ListItem(value,null,null);
            tail=head;
        } else
            head = new ListItem(value,head,null);

    }

    /**
     * @param value
     */
    public void Delete(int value){}

    /**
     * ищет элемент в списке
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

    /**
     * @return
     */
    public String ToString() {
        String str = "\nOWLL items:\n";
        ListItem current = head;
        while (current != null) {
            str += Integer.toString(current.value) + '\n';
            current = current.next;
        }
        if(head != null)
            str += "head:" + head.ToString() + '\n';
        else
            str += "head:null\n";
        if(tail != null)
            str += "tail:" + tail.ToString() + '\n';
        else
            str += "tail:null\n";
        return str;
    }
}
