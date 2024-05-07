# About

- HashMap is an efficient Data Structure to handle dynamic datasets when direct access to items is crucial.
- HashMap combines the randome access ability with the flexibility of linked lists, offering an efficient way to store and retrieve data using a key-value pair system.
- For example, an university student system may use a HashMap to manage student data, where unique keys will be Student ID and each key will map to a specific value like Student Names.

# Data Structure Highlight

- Dynamic Sizing: Unlike arrays, HashMaps do not require a predefined size, making them more adaptable when the amount of data is unpredictable.
- Efficiency in Access: HashMaps provide quick data retrieval by using hash functions to compute an index from the key, where the corresponding value is stored.
- Key-Value Pair: Data in a HashMap is organized as key-value pairs, allowing direct access to data items without needing to search sequentially.
- Hash Function: The hash function is crucial as it determines the index position for storing values based on the keys, which should be unique to avoid collisions.

# When to Use? (Advantages)
- Fast Lookup Requirements:
    - If the application requires quick lookup, insertion, and deltion. Then, HashMap is good due to their average O(1) time complexity for these operation
- Key-Value Association:
    - When there is a clear key-value relationship, with unique keys that map to specific value. This is common in scenarios like caching, where you retrieve an item using an unique identifier.
- Avoiding Sequential Searches
    - When the dataset is large, and a sequential search would be inefficient, HashMap provides a significant performance advantage.

# When NOT to Use? (Disadvantages)
- Ordering Required:
    - If you need to maintain the order of elements, as in sorted order or insertion order. Then, HashMap is not suitable. Instead, consider TreeMap (for natural ordering) or LinkedHashMap to preserve insertion order.
- Memory Constraints:
    - HashMaps can be memory-intensive because they need to maintain the underlying array structure and additional data for each entry (like linked lists or trees in case of collisions).
- Non-unique Keys:
    - If we cannot guarantee unique keys, then using HashMap could lead to data being overwritten.

# Memory and Computation Considerations:
- Memory Usage:
    - Each entry in a HashMap generally uses more memory than just storing the data values, due to the storage of key-value pairs, hash data, and pointers (in case of handling collisions). Overhead increases with the mechanisms to handle collisions (like linked lists or trees).
- Computation Overhead:
    - While HashMaps offer O(1) access time on average, poor hash functions can lead to many collisions, which might degrade performance to O(n) in the worst case. This makes choosing a good hash function and managing load factors crucial to maintaining efficiency.
- Rehashing Cost:
    - When the capacity of a HashMap needs to be increased (usually when the load factor threshold is crossed), a process called rehashing occurs where the hash table is resized. This can be computationally expensive as every item in the old hash table must be rehashed to the new table.

# Handling Collision
- When two keys hash to the same index, it's called a collision. There are mainly two methods to handle these collisions: chaining and open addressing.
- Chaining:
    - How It Works:
        - In chaining, each slot of the hash table contains a linked list (or another type of list) of entries that hash to the same index. If a collision occurs, the new key-value pair is added to the end of the list at that particular index.
    - Pros:
        - Chaining is simple to implement.
        - It handles collisions well, especially when the number of entries is not known in advance and can vary widely.
        - The linked lists can grow as needed, which means that the hash table can handle a load factor greater than 1 without a significant increase in lookup time.
    - Cons:
        - Memory overhead due to pointers in each list node.
        - Performance can degrade if the lists become too long, which would lead to longer search times within the list.
- Open Addressing:
    - How It Works:
        - Open addressing stores all entries directly in the hash table array. When a collision occurs, the hash table searches for the next available slot (or bucket) using a probing sequence. Common probing methods include linear probing, quadratic probing, and double hashing.
    - Pros:
        - Open addressing eliminates the need for additional memory outside the table (no pointers or external lists).
        - Can be more cache-friendly as everything is stored in the same table.
    - Cons:
        - To avoid excessive collisions, open addressing requires careful management of the load factor, typically kept below 0.7 or 0.8.
        - Clustering of entries can occur, particularly with poor probing strategies, leading to longer search times. Clustering refers to the tendency of entries to become clustered in certain parts of the table, which affects performance.



### Improving the Hash Function
- Improving the hash function can significantly reduce the likelihood of collisions, leading to better performance of the hash table. The simple modulus operation (`key % capacity`) used in the basic hash function is prone to collisions, especially if the keys have patterns that align poorly with the chosen capacity. A more sophisticated hash function can distribute keys more uniformly across the buckets, which is crucial for maintaining the average-case time complexity of \(O(1)\) for operations like insertions, deletions, and lookups.

1. **Multiplication Method:**
   - This method involves using a constant, typically an irrational number, which is multiplied by the key. The fractional part of the result is then used to determine the index for the key.
   - For example:
     ```java
     private int hash(int key) {
         double A = (Math.sqrt(5) - 1) / 2;  // constant between 0 and 1
         return (int)(capacity * (key * A % 1));
     }
     ```

2. **Universal Hashing:**
   - This approach selects a hash function randomly from a carefully designed class of functions at the beginning of the execution. This randomization helps minimize the probability that two distinct keys will collide.
   - A simple universal hash function could look like this:
     ```java
     private int a, b;

     public HashTable(int capacity) {
         this.capacity = capacity;
         entries = new LinkedList[capacity];
         for (int i = 0; i < capacity; i++) {
             entries[i] = new LinkedList<>();
         }
         Random rand = new Random();
         a = rand.nextInt(capacity - 1) + 1;  // 'a' from 1 to capacity-1
         b = rand.nextInt(capacity);          // 'b' from 0 to capacity-1
     }

     private int hash(int key) {
         return (a * key + b) % capacity;
     }
     ```

3. **Using Prime Numbers:**
   - The capacity of the hash table (or the modulus used in the hash function) should ideally be a prime number. This can also help in distributing the keys more uniformly, especially when keys are sequential or have common factors with the table size.
   - Adjusting the capacity to be prime and using a simpler modulus operation could look like:
     ```java
     private int hash(int key) {
         return key % capacity;  // where 'capacity' is chosen to be a prime number
     }
     ```

### Considerations
- **Choice of Hash Function:** The choice of hash function depends on the types and distribution of keys. If keys are known to be random, simpler hash functions might suffice. For more predictable key patterns, a more complex, robust hashing strategy is beneficial.
- **Load Factor and Table Size:** Always consider the load factor and resize the table as necessary. Even the best hash function can perform poorly if the table is too full or too sparse.

By improving the hash function, you reduce the number of collisions, which in turn improves the average access time for operations on the hash table.
