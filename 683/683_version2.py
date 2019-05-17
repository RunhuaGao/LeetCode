class Solution:
    def kEmptySlots(self, flowers: List[int], k: int) -> int:
        # version 2: Bucket
        size = len(flowers)
        if size==0 | k>=size: # corner case test
            return -1
        k+=1
        bucket_size = (size+k-1)//k # calculate the number of bucket, this is to compress the status
        low_bucket = [float("inf")]*bucket_size
        high_bucket = [-float("inf")]*bucket_size
        for i in range(size):
            flower_pos = flowers[i]
            bucket_pos = flowers[i]//k
            day = i+1
            if flower_pos < low_bucket[bucket_pos]:
                low_bucket[bucket_pos] = flower_pos
                if bucket_pos > 0 and high_bucket[bucket_pos-1]==flower_pos-k:
                    return day
            if flower_pos > high_bucket[bucket_pos]:
                high_bucket[bucket_pos] = flower_pos
                if bucket_pos < bucket_size-1 and low_bucket[bucket_pos+1]==flower_pos+k:
                    return day
        return -1