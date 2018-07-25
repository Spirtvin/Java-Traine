package DataStructures.LinkedList;

/**
 * элемент списка
 */
public class ListItem {
    int value;
    ListItem next;
    ListItem prev;

    public ListItem(){
        this.value = 0;
        this.next = null;
        this.prev = null;
    }
    public ListItem(int _value, ListItem _next) {
        this.value = _value;
        this.next = _next;
    }

    public ListItem(int _value, ListItem _next, ListItem _prev) {
        this.value = _value;
        this.next = _next;
        this.prev = _prev;
    }

    public String ToString() {
        return String.format("%d", value);
    }
}
