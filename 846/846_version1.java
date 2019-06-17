class Solution:
    def isNStraightHand(self, hand: List[int], W: int) -> bool:
        if len(hand)%W > 0:return False
        if W==1:return True
        count = {}
        for i in hand:
            count[i] = count.get(i,0)+1
        minNumber,maxNumber = min(hand),max(hand)
        start = minNumber
        while start < maxNumber:
            curr_num = count.get(start,0)
            if curr_num > 0:
                end = start
                while end <=start+W-1:
                    if count.get(end,0)-curr_num<0:
                        return False
                    else:
                        count[end]-=curr_num
                    end+=1
            start+=1
        return sum(count.values())==0
