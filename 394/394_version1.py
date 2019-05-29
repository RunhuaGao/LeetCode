class Solution:
    def decodeString(self, s: str) -> str:
        if s=="":
            return s
        # store the current string
        stack = []
        # store the repeat times
        operator = []
        curr_pos = 0
        while curr_pos < len(s):
            curr_cha = s[curr_pos]
            # special case: push the repeat times into stack
            if curr_cha.isdigit():
                end = curr_pos+1
                while s[end].isdigit():
                    end+=1
                operator.append(s[curr_pos:end])
                curr_pos = end
                continue
            elif curr_cha == "]":
                temp = ""
                repeat_times = int(operator.pop())
                while stack[-1]!="[":
                    temp = stack.pop() + temp
                stack.pop()
                stack.append(temp*repeat_times)
            else:
                stack.append(curr_cha)
            curr_pos+=1
        return "".join(stack)
