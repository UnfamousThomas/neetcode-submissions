class Node:
    def __init__(self, value):
        self.value = value
        self.nextNode = None

    def setNext(self, node: Node):
        self.nextNode = node

class LinkedList:
    
    def __init__(self):
        self.size = 0
        self.head = None
        self.tail = None
    
    def get(self, index: int) -> int:
        if self.size < index + 1:
            return -1
        current = self.head
        for _ in range(index):
            current = current.nextNode
        return current.value
        

    def insertHead(self, val: int) -> None:
        node = Node(val)
        if self.head is not None:
            node.setNext(self.head)
        else:
            self.tail = node
        self.head = node
        self.size += 1
        

    def insertTail(self, val: int) -> None:
        node = Node(val)
        if self.tail is not None:
            self.tail.setNext(node)
        else:
            self.head = node
        self.tail = node
        self.size += 1

    def remove(self, index: int) -> bool:
        if index >= self.size or self.head is None:
            return False

        if index == 0:
            self.head = self.head.nextNode
            if self.head is None:  # list became empty
                self.tail = None
            self.size -= 1
            return True
        
        current = self.head
        for _ in range(index - 1):
            current = current.nextNode

        to_remove = current.nextNode
        current.nextNode = to_remove.nextNode

        if to_remove == self.tail:
            self.tail = current
        
        self.size -= 1

        return True

    def getValues(self) -> List[int]:
        values = []
        current = self.head
        while current:
            values.append(current.value)
            current = current.nextNode
        return values
