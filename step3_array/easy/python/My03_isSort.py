class Solution:
    def isSorted(self, nums):
        for i in range(len(nums) - 1):
            if nums[i] > nums[i + 1]:
                return -1

        return 1


sol = Solution()
nums = [8, 8, 7, 6, 5]

if sol.isSorted(nums) == -1:
    print("Not sorted")
else:
    print("Sorted")

nums2 = [1, 2, 3, 4, 5]

if sol.isSorted(nums2) == -1:
    print("Not sorted")
else:
    print("Sorted")
