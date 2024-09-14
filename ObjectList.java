public class ObjectList {
    private Object[] object;
    private int total;

    public ObjectList(int size) {
        object = new Object[size];
        total = 0;
    }

    public boolean add(Object obj) {
        if (isFull()) {
            return false;
        }
        object[total++] = obj;
        return true;
    }

    public boolean isEmpty() {
        return total == 0;
    }

    public boolean isFull() {
        return total == object.length;
    }

    public Object getObject(int index) {
        if (index < 0 || index >= total) {
            return null;
        }
        return object[index];
    }

    public int getTotal() {
        return total;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        for (int i = index; i < total - 1; i++) {
            object[i] = object[i + 1];
        }
        total--;
        return true;
    }
}
