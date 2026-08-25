class LinkedList {
    class Node
    {
        Node next;
        int val;

        private Node(int v)
        {
            val = v;
        }
    }
    Node head;
    Node tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        if (index >= size)
        {
            return -1;
        }
        Node cur = head;
        for (int i = 0; i < index; i++)
        {
            cur = cur.next;
        }
        return cur.val;
    }

    public void insertHead(int val) {
        if (size == 0)
        {
            head = new Node(val);
            tail = head;
            size = 1;
        }
        else
        {
            Node newHead = new Node(val);
            newHead.next = head;
            head = newHead;
            size++;
        }
    }

    public void insertTail(int val) {
        if (size == 0)
        {
            insertHead(val);
            return;
        }
        Node newTail = new Node(val);
        tail.next = newTail;
        tail = newTail;
        size++;
    }

    public boolean remove(int index) {
        if (size == 0 || index >= size)
        {
            return false;
        }
        else if (size == 1)
        {
            head = null;
            tail = null;
            size = 0;
        }
        else if (index == 0)
        {
            head = head.next;
            size--;
        }
        else
        {
            Node cur = head;
            for (int i = 0; i < index-1; i++)
            {
                cur = cur.next;
            }
            if (index == size-1)
            {
                cur.next = null;
                tail = cur;
            }
            else
            {
                cur.next = cur.next.next;
            }
            size--;
        }
        
        return true;
    }

    public ArrayList<Integer> getValues() {
        Node cur = head;
        ArrayList<Integer> values = new ArrayList<>();
        while (cur != null)
        {
            values.add(cur.val);
            cur = cur.next;
        }
        return values;
    }
}
