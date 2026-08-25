class DynamicArray {
    private int capacity;
    private int[] arr;
    private int tail;
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        tail = 0;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
        if (i > tail)
        {
            tail = i+1;
        }
    }

    public void pushback(int n) {
        if (tail == arr.length)
        {
            resize();
        }
        arr[tail] = n;
        tail++;
    }

    public int popback() {
        tail--;
        return arr[tail];
    }

    private void resize() {
        int[] newArr = new int[arr.length * 2];
        int i = 0;
        for (int n : arr)
        {
            newArr[i] = n;
            i++;
        }
        arr = newArr;
    }

    public int getSize() {
        return tail;
    }

    public int getCapacity() {
        return arr.length;
    }
}
