import java.util.LinkedList;

class HashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + "=" + value + "}";
        }
    }

    private LinkedList<Entry>[] entries;
    private int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        entries = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            entries[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void put(int key, String value) {
        int index = hash(key);
        LinkedList<Entry> bucket = entries[index];
        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry(key, value));
        System.out.println("Inserted " + value + " at index " + index);
    }

    public String get(int key) {
        int index = hash(key);
        for (Entry entry : bucketAt(index)) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }

    public void printTable() {
        System.out.println("Current state of HashTable:");
        for (int i = 0; i < capacity; i++) {
            System.out.println("Bucket " + i + ": " + entries[i]);
        }
    }

    private LinkedList<Entry> bucketAt(int index) {
        return entries[index];
    }
}

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable ht = new HashTable(5); // Create a hash table with 5 buckets.

        // Adding elements where some will intentionally collide.
        ht.put(1, "Alice");
        ht.put(6, "Bob"); // Will collide with Alice at index 1.
        ht.put(11, "Charlie"); // Will also collide at index 1.
        ht.put(3, "Dave");
        ht.put(8, "Eve"); // Will collide with Dave at index 3.

        ht.printTable(); // Print the state of the hash table.

        // Retrieve and print specific entries.
        System.out.println("Value for key 6: " + ht.get(6));
        System.out.println("Value for key 11: " + ht.get(11));
    }
}
