@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {
    private T[] arr;
    private int length = 0;
    private int capacity = 0;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T elem){
        arr[index] = elem;
    }

    public void add(T elem){
        if(length + 1 >= capacity){
            if(capacity == 0) capacity = 1;
            else capacity *=2;
            T[] new_arr = (T[]) new Object[capacity];
            for( int i = 0; i < length; i++){
                new_arr[i] = arr[i];
                arr = new_arr;
            }
        }
        arr[length++] = elem;
    }

    public T removeAt(int rm_index){
        if (rm_index >= length || rm_index < 0) throw new IndexOutOfBoundsException();
        T data = arr[rm_index];
        T[] new_arr = (T[]) new Object[length - 1];
        for (int i = 0, j = 0; i < length; i++, j++){
            if(i == rm_index) j--;
            else new_arr[j] = arr[i];
        }
        arr = new_arr;
        capacity = --length;
        return data;
    }

    public boolean remove(Object obj){
        int index = indexOf(obj);
        if (index == -1) return false;
        removeAt(index);
        return true;
    }

    public int indexOf(Object obj){
        for (int i = 0; i < length; i++){
            if (obj == null){
                if(arr[i] == null) return i;
            } else {
                if(obj.equals(arr[i])) return i;
            }
        }
        return -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return arr[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        if (length == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(length).append("[");
            for (int i = 0; i < length - 1; i++) sb.append(arr[i] + ", ");
            return sb.append(arr[length - 1] + "]").toString();
        }
    }
}



