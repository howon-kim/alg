"""
66. Plus One
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

Runtime: 32 ms, faster than 91.86% of Python3 online submissions for Plus One.
Memory Usage: 13.7 MB, less than 5.31% of Python3 online submissions for Plus One.
"""

class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        index = len(digits) - 1 
        if (len(digits) == 1):
            digits[0] += 1
            if(digits[0] == 10):
                return [1, 0]
            else:
                return digits
        else:
            digits[index] += 1
            while(digits[index] == 10):
                digits[index] =  0
                index -= 1
                if(index < 0):
                    digits[index + 1] = 1
                    digits.append(0)
                else:
                    digits[index] += 1


            return digits
            
        
        """
        index = len(digits) - 1
        result = 0
        answer = []
        for num in digits:
            result += num * (10 ** index)
            index-=1
            
        result+=1
        
        while(result != 0):
            answer = [result % 10] + answer
            result = result // 10
        
        return answer
        """
        