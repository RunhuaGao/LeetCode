class NestedIterator(object):

    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self.array = self.flattenArray(nestedList)
        self.index = 0
        

    def next(self):
        """
        :rtype: int
        """
        if self.hasNext():
            value = self.array[self.index]
            self.index+=1
            return value

    def hasNext(self):
        """
        :rtype: bool
        """
        return self.index < len(self.array)
    
    def flattenArray(self,array):
        result = []
        for i in array:
            if i.isInteger():
                result.append(i.getInteger())
            else:
                result.extend(self.flattenArray(i.getList()))
        return result
