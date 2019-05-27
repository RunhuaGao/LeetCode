class NestedIterator(object):

    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self.stack = []
        # initialize the stack 
        index = len(nestedList) - 1
        while index >= 0:
            self.stack.append(nestedList[index])
            index-=1
        

    def next(self):
        """
        :rtype: int
        """
        return self.stack.pop().getInteger()

    def hasNext(self):
        """
        :rtype: bool
        """
        while self.stack:
            top = self.stack[-1]
            if top.isInteger(): return True
            self.stack.pop()
            restList = top.getList()
            index = len(restList) - 1
            while index >=0:
                self.stack.append(restList[index])
                index-=1
        return False
