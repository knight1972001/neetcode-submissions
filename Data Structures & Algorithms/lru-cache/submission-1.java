class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node left; // LRU
    private Node right; // MRU

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0); 
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public void insert(Node node){ // add the node to the right
        Node prev = this.right.prev;
        prev.next = node;
        node.next = this.right;
        this.right.prev = node;
        node.prev = prev;
    }

    public void remove(Node node){ // remove the node
        Node prev = node.prev;
        Node next = node.next;

        prev.next = node.next;
        next.prev = node.prev;
    }

    public int get(int key) { 
        if (cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).value;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);


        if (cache.size() > capacity){
            cache.remove(this.left.next.key);
            remove(this.left.next);
        }

    }
}
