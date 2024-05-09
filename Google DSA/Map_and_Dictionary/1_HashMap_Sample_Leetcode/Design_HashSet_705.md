### LeetCode Problem: Design a HashSet without using any built-in hash table libraries.

#### Problem Statement:
- Implement MyHashSet class:

    1. void add(key) Inserts the value key into the HashSet.
    2. bool contains(key) Returns whether the value key exists in the HashSet or not.
    3. void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 

    4. Example 1:

        - Input
            ```java
            ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
            [[], [1], [2], [1], [3], [2], [2], [2], [2]]
            ```
        - Output
            ```java
            [null, null, null, true, false, null, true, null, false]
            ```

        - Explanation
            ```java
            MyHashSet myHashSet = new MyHashSet();
            myHashSet.add(1);      // set = [1]
            myHashSet.add(2);      // set = [1, 2]
            myHashSet.contains(1); // return True
            myHashSet.contains(3); // return False, (not found)
            myHashSet.add(2);      // set = [1, 2]
            myHashSet.contains(2); // return True
            myHashSet.remove(2);   // set = [1]
            myHashSet.contains(2); // return False, (already removed)
            ```

        - Constraints:
            ```
            0 <= key <= 106
            At most 104 calls will be made to add, remove, and contains.
            ```
#### Solution:
**Java Solution:**
```java
class MyHashSet {
    private boolean[] keyPresence;

    public MyHashSet() {
        keyPresence = new boolean[1000001]; // Set the size to accommodate the maximum key value.
    }

    public void add(int key) {
        keyPresence[key] = true; // Set the boolean at the key index to true to represent the addition of the key.
    }

    public void remove(int key) {
        keyPresence[key] = false; // Set the boolean at the key index to false to represent the removal of the key.
    }

    public boolean contains(int key) {
        return keyPresence[key]; // Return the boolean value at the key index.
    }
}
```

**Python Solution:**
```python
class MyHashSet:

    def __init__(self):
        self.keyPresence=[False]*1000001
        

    def add(self, key: int) -> None:
        self.keyPresence[key]=True
        

    def remove(self, key: int) -> None:
        self.keyPresence[key]=False

    def contains(self, key: int) -> bool:
        return self.keyPresence[key]
```

