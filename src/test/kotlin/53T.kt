import leetcode.S53
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

open class TestArray {

    @Test
    fun check53() {
        val input = listOf<Int>(-2,1,-3,4,-1,2,1,-5,4).toIntArray()
        val brute = S53.maxSubArrayUsingBruteForce(input)
        val prefix = S53.maxSubArrayUsingPrefixSum(input)
        val kadane = S53.maxSubArrayUsingKadane(input)
        assertEquals(6,brute)
        assertEquals(6,prefix)
        assertEquals(6,kadane)
    }

}
