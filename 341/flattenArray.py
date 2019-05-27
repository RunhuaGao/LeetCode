def flattenArrayIter(array):
    result = []
    while array:
        curr = array.pop()
        if type(curr) == int:
            result.append(curr)
        else:
            for i in curr:
                array.append(i)  # decrease the depth of nested list by one
    return result


def flattenArrayRecur(array):
    result = []
    for i in array:
        if type(i) == int:
            result.append(i)
        else:
            result.extend(flattenArrayRecur(i))
    return result


