package leetcode

class S53 {
    companion object {

        fun maxSubArrayUsingBruteForce(nums: IntArray): Int {
            var maxSum = 0
            for (i in 0..nums.size - 1) {
                for (j in nums.size- 1 downTo i) {
                    var currentSum = 0
                    for (k in i..j) {
                        currentSum += nums[k]
                        if (currentSum > maxSum) {
                            maxSum = currentSum
                        }
                    }

                }
            }

            return maxSum
        }

        fun maxSubArrayUsingPrefixSum(nums: IntArray) : Int {
            var maxSum = Int.MIN_VALUE
            val prefixSum = IntArray(nums.size)
            prefixSum[0] = nums[0]
            //init prefix sum array
            for (i in 1 until nums.size){
                prefixSum[i] = prefixSum[i -1] + nums[i]
            }

            for (j in 0 until nums.size){
                for (k in j until nums.size){
                    //calculate sum for j to k
                    var currentSum = if(j == 0 )
                        prefixSum[k]
                     else
                         prefixSum[k] - prefixSum[j - 1]
                    if(currentSum > maxSum){
                        maxSum = currentSum
                    }
                }
            }
            return maxSum
        }

        fun maxSubArrayUsingKadane(nums: IntArray) : Int {
            var currentSum = nums[0]
            var maxSum = nums[0]
            for (i in 1 until nums.size){
                currentSum = maxOf(nums[i], currentSum + nums[i])
                maxSum = maxOf(maxSum,currentSum)
            }
            return maxSum
        }

    }
}
