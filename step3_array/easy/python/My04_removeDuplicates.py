# Remove duplicates from Sorted array
class Solution:
    def removeDuplicate(self, nums):
        if not nums:
            return 0

        ind = 0
        for i in range(1, len(nums)):
            if nums[i] != nums[ind]:
                ind += 1

                nums[ind] = nums[i]

        return ind + 1


sol = Solution()

nums2 = [1, 2, 3, 4, 4, 5, 5, 5]
unique_count = sol.removeDuplicate(nums2)

print(f"Unique count: {unique_count}")
print(f"Modified array (in-place): {nums2}")
