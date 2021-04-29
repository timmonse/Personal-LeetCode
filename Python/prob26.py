from typing import List


class Solution26:
    def removeDuplicates(self, nums: List[int]) -> int:
        if nums is None or not nums:
            return 0
        prev = nums[0]
        u_index = 0

        for i in range(1, len(nums)):
            num = nums[i]
            if num != prev:
                u_index += 1
                nums[u_index] = num
                prev = num

        return u_index + 1
