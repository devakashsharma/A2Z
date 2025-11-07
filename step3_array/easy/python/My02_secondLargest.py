class Solution:
    def secondLargestElement(self, nums):
        num = list(set(nums))  # remove duplicates
        if len(num) < 2:
            return -1
        num.sort(reverse=True)
        return num[1]
        

sol = Solution()
nums = [8, 8, 7, 6, 5]

print(sol.secondLargestElement(nums))

nums_2 = [10, 10, 10]
print(sol.secondLargestElement(nums_2))