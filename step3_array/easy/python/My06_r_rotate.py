class Solution:
    def reverseList(self, nums, start, end):
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1

    def k_rotate(self, nums, k):
        n = len(nums)
        k = k % n  # handle k > n

        # Step 1: reverse first n - k elements
        self.reverseList(nums, 0, n - k - 1)
        # Step 2: reverse last k elements
        self.reverseList(nums, n - k, n - 1)
        # Step 3: reverse whole array
        self.reverseList(nums, 0, n - 1)

        return nums


sol = Solution()
nums = [1, 2, 3, 4, 5, 6, 7]
print(sol.k_rotate(nums, 3))  # Output: [5, 6, 7, 1, 2, 3, 4]
