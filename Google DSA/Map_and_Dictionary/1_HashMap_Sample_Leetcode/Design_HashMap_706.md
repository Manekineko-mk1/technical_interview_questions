### LeetCode Problem: Design a HashSet without using any built-in hash table libraries.

#### Problem Statement:
- Design a HashMap without using any built-in hash table libraries.
- Implement the ```MyHashMap``` class:

    1. ```MyHashMap()``` initializes the object with an empty map.
    2. void ```put(int key, int value)``` inserts a ```(key, value)``` pair into the HashMap. If the ```key``` already exists in the map, update the corresponding ```value```.
    3. int ```get(int key)``` returns the ```value``` to which the specified ```key``` is mapped, or ```-1``` if this map contains no mapping for the ```key```.
    4. ```void remove(key)``` removes the ```key``` and its corresponding ```value``` if the map contains the mapping for the ```key.```
 

    4. Example 1:

        - Input
            ```java
            ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
            [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
            ```
        - Output
            ```java
            [null, null, null, 1, -1, null, 1, null, -1]
            ```

        - Explanation
            ```java
            MyHashMap myHashMap = new MyHashMap();
            myHashMap.put(1, 1); // The map is now [[1,1]]
            myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
            myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
            myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
            myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
            myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
            myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
            myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
            ```

        - Constraints:
            ```
            0 <= key <= 10^6
            At most 10^4 calls will be made to add, remove, and contains.
            ```
#### Solution:
**Java Solution:**
```java
class MyHashMap {
    private int[] map;

    public MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map, -1);
    }
    
    public void put(int key, int value) {
        map[key] = value;
    }
    
    public int get(int key) {
        return map[key];        
    }
    
    public void remove(int key) {
        map[key] = -1;      
    }
}

```

**Python Solution:**
```python
class MyHashMap:
    def __init__(self):
        self.map = [-1] * 1000001

    def put(self, key, value):
        self.map[key] = value

    def get(self, key):
        return self.map[key]

    def remove(self, key):
        self.map[key] = -1
```
