class Node{
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {

    private int capacity;
    private Map<Integer, Node> cache;
    private Node right; // MRU
    private Node left; // LRU

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.right = new Node(0,0);
        this.left = new Node(0,0);

        this.right.prev = this.left;
        this.left.next = this.right;
    }

    public void insert(Node node){ // add the node to the right
        Node prev = this.right.prev;
        prev.next = node;
        node.next = this.right;
        this.right.prev = node;
        node.prev = prev;
    }

    public void remove(Node node){ // remove node
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
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
        insert(newNode);
        cache.put(key, newNode);

        if(cache.size() > capacity){
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
