# Given an array of N integers, left rotate the array by one place.


class Solution:
    def leftRotate(self, li):
        num = li[0]
        for i in range(len(li) - 1):
            li[i] = li[i + 1]
        li[-1] = num
        return li


sol = Solution()
li = [1, 2, 3, 4, 5]
print(sol.leftRotate(li))  # Output: [2, 3, 4, 5, 1]
