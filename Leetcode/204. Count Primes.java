class Solution {
    /**
     * 204. Count Primes | Easy
     * https://leetcode.com/problems/count-primes/
     * 
     * My Submission Performance
     * Runtime: 36 ms, faster than 29.18% of Java online submissions for Count Primes.
     * Memory Usage: 40.7 MB, less than 5.66% of Java online submissions for Count Primes.
     *
     * Description
     * Count the number of prime numbers less than a non-negative number, n.
     *
     * Example:
     *
     * Input: 10
     * Output: 4
     * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
     */
    
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        Boolean [] isPrime = new Boolean[n];
        int count = 1;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(isPrime[i] == null) {
                for (int j = 2; i*j < n; j++) {
                    isPrime[i*j] = true;
                }
            }
        }
        for (int p = 3; p < isPrime.length; p+=2) {
            if (isPrime[p] == null) {
                count++;
            }
        }
        return count;

        /**
         Memory Efficient but Slow Runtime
         if (n < 3) {
         return 0;
         }

         int count = 1;
         int last = 0;
         ArrayList<Integer> prime = new ArrayList<>();
         boolean isPrime = true;
         prime.add(2);
         for (int i = 3; i < n; i += 2) {
         for (int p: prime) {
         last = p;
         if (i % p == 0) {
         isPrime = false;
         break;
         }
         }
         if (isPrime) {
         for (; last <= Math.sqrt(i); last++) {
         if (i % last == 0) {
         isPrime = false;
         break;
         }
         }
         }
         if (isPrime) {
         count++;
         prime.add(i);
         System.out.println(i);


         }
         isPrime = true;
         }
         return count;
         **/
    }
}