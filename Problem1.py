#I designed a parking lot management system using a MinHeap to efficiently handle available and occupied parking spaces. The MinHeap class manages a priority queue where the smallest number represents the first available space, facilitating quick retrieval and insertion. The ParkingLot class initializes with all spaces available, using the heap to track and allocate spaces. When a space is occupied, it's removed from the heap and added to a set of occupied spaces. When a car leaves, the space is returned to the heap. This approach ensures efficient operations: push and pop operations on the heap have a time complexity of O(logn), while operations on the set are O(1). Overall, the time complexity for parking and leaving operations is O(logn), and space complexity is O(n), where n is the number of spaces.

class MinHeap:
    def __init__(self):
        self.heap = []

    def parent(self, i):
        return (i - 1) // 2

    def left_child(self, i):
        return 2 * i + 1

    def right_child(self, i):
        return 2 * i + 2

    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def push(self, key):
        self.heap.append(key)
        self._heapify_up(len(self.heap) - 1)

    def pop(self):
        if not self.heap:
            return None
        if len(self.heap) == 1:
            return self.heap.pop()
        
        min_val = self.heap[0]
        self.heap[0] = self.heap.pop()
        self._heapify_down(0)
        return min_val

    def _heapify_up(self, i):
        parent = self.parent(i)
        if i > 0 and self.heap[i] < self.heap[parent]:
            self.swap(i, parent)
            self._heapify_up(parent)

    def _heapify_down(self, i):
        min_index = i
        left = self.left_child(i)
        right = self.right_child(i)
        
        if left < len(self.heap) and self.heap[left] < self.heap[min_index]:
            min_index = left
        if right < len(self.heap) and self.heap[right] < self.heap[min_index]:
            min_index = right
        
        if i != min_index:
            self.swap(i, min_index)
            self._heapify_down(min_index)

class ParkingLot:
    def __init__(self, total_spaces):
        self.total_spaces = total_spaces
        self.available_spaces = MinHeap()
        for i in range(1, total_spaces + 1):
            self.available_spaces.push(i)
        self.occupied_spaces = set()

    def park(self):
        if not self.available_spaces.heap:
            return None  # Parking lot is full

        space = self.available_spaces.pop()
        self.occupied_spaces.add(space)
        return space

    def leave(self, space):
        if space in self.occupied_spaces:
            self.occupied_spaces.remove(space)
            self.available_spaces.push(space)
            return True
        return False  # Space was not occupied

    def get_occupied_spaces(self):
        return list(self.occupied_spaces)