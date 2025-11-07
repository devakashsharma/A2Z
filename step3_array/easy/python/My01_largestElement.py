class Solution:
    def largestElement(self, nums):
        num = max(nums)
        print(nums)
        print(f"Largest number among them is: {num}")
        
sol = Solution()
nums = [3, 3, 6, 1]

sol.largestElement(nums)