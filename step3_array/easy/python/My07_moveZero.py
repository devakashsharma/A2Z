class Solution:
    def moveZero(self, nums):
        zero = 0

        for i in range(len(nums)):
            if nums[i] != 0:
                nums[zero], nums[i] = nums[i], nums[zero]
                zero += 1

        return nums


sol = Solution()
nums = [1, 2, 3, 0, 4, 5, 0]
print(sol.moveZero(nums))
