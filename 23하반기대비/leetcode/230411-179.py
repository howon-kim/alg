class compare(str):
    def __lt__(self, other):
        return self + other < other + self

class Solution:
    
    def largestNumber(self, nums: List[int]) -> str:
        ret =  ''.join(sorted(map(str, nums), key = compare, reverse = True))
        return '0' if ret[0] == '0' else ret
       
## SUMMARY ##
1. Custom comparison function
	__lt__ always return self < other

2. How sorting works in Python
	When sort in Python it creates the instance of compare class not passing its type 

3. Inheritance in Python
	class Name(inherited type)

4. Sorting in reverse by adding the reverse = True 
