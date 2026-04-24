class DynamicArray:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.size = 0
        self.inner_array = [0] * capacity

    def get(self, i: int) -> int:
        return self.inner_array[i]

    def set(self, i: int, n: int) -> None:
        self.inner_array[i] = n

    def pushback(self, n: int) -> None:
        if(self.capacity < self.size+1):
            self.resize()
        self.inner_array[self.size] = n
        self.size = self.size+1

    def popback(self) -> int:
        result = self.inner_array[self.size-1]
        self.inner_array[self.size-1] = 0
        self.size = self.size - 1

        return result

    def resize(self) -> None:
        self.capacity = self.capacity * 2
        new_arr = [0] * self.capacity
        for i in range(self.size):
            new_arr[i] = self.inner_array[i]
        self.inner_array = new_arr

    def getSize(self) -> int:
        return self.size
    
    def getCapacity(self) -> int:
        return self.capacity