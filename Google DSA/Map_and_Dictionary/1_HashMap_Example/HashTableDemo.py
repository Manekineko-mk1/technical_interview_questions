class HashTable:
    def __init__(self, capacity):
        self.capacity = capacity
        self.table = [[] for _ in range(capacity)]
    
    def hash(self, key):
        return key % self.capacity
    
    def put(self, key, value):
        index = self.hash(key)
        bucket = self.table[index]
        for item in bucket:
            if item[0] == key:
                item[1] = value
                return
        bucket.append([key, value])
        print(f"Inserted {value} at index {index}")
    
    def get(self, key):
        index = self.hash(key)
        bucket = self.table[index]
        for item in bucket:
            if item[0] == key:
                return item[1]
        return None
    
    def print_table(self):
        print("Current state of HashTable:")
        for i, bucket in enumerate(self.table):
            print(f"Bucket {i}: {bucket}")

class HashTableDemo:
    def run_demo():
        ht = HashTable(5)  # Create a hash table with 5 buckets.
        
        # Adding elements where some will intentionally collide.
        ht.put(1, "Alice")
        ht.put(6, "Bob")  # Will collide with Alice at index 1.
        ht.put(11, "Charlie")  # Will also collide at index 1.
        ht.put(3, "Dave")
        ht.put(8, "Eve")  # Will collide with Dave at index 3.

        ht.print_table()  # Print the state of the hash table.

        # Retrieve and print specific entries.
        print("Value for key 6: " + ht.get(6))
        print("Value for key 11: " + ht.get(11))

if __name__ == "__main__":
    HashTableDemo.run_demo()
