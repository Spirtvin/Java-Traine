package Common.Types;

public class Size<T> {
    public T width;
    public T height;

    public Size() {
    }

    public Size(T width, T height) {
        this.width = width;
        this.height = height;
    }
}
