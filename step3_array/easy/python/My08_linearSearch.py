class Solution:
    def linearSearch(self, nums, val):
        for i in range(len(nums)):
            if nums[i] == val:
                return i
        
        return -1


sol = Solution()
nums = [1, 2, 3, 0, 4, 5, 0]
print(sol.linearSearch(nums, 3))