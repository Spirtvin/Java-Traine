package Common.Generic;

public class Helper<T> {
    final Class<T> genericClass;

    public Helper(Class<T> genericType) {
        this.genericClass = genericType;
    }

    public String GetType() {
        return genericClass.getName();
    }
}
