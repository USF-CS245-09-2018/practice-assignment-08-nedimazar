public class LinkedList implements List {
    public class Node {
        public Object data;
        public Node next;

        public Node(Object o){
            this.data = o;
            this.next = null;
        }
        public boolean equals(Object o){
            return this.data == o;
        }
    }

    Node head ;
    int size ;

    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    @Override
    public void add(Object obj) throws Exception {
        add(0, obj);
    }

    @Override
    public void add(int pos, Object data) throws Exception {
        if (pos < 0 || pos > size){
            throw new Exception();
        }
        if (pos == 0){
            Node node = new Node(data);
            node.data = data;
            node.next = head;
            head = node;
            size++;
        } else {

            Node previous = get(pos-1);
            Node node = new Node(data);
            node.next = previous.next;
            previous.next = node;
            size++;
        }
    }

    @Override
    public Node get(int pos) throws Exception {
        if(size == 0){
            throw new Exception();
        }
        Node node = head;
        for(int i = 0; i < pos; i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public Object remove(int pos) throws Exception {
        if ( pos < 0 || pos > size){
            throw new Exception();
        }
        if (pos == 0 ){
            Node curr = head;
            head = head.next;
            --size;
            return curr.data;
        } else {
            Node previous = get(pos-1);
            Node curr = previous.next;
            --size;
            return curr.data;
        }
    }

    @Override
    public int size() {
        return size;
    }


}
