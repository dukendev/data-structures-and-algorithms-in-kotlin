package leetcode

class LeetCode73 {
    companion object {
        //brute force solution
        fun setZeroes(matrix: Array<IntArray>): Unit {
            val zeroRows = hashSetOf<Int>()
            val zeroCols = hashSetOf<Int>()

            val m = matrix.size
            val n = matrix[0].size

            matrix.forEachIndexed { r_i, row  ->
                row.forEachIndexed {  c_i, e ->
                    if(e == 0){
                        zeroRows.add(r_i)
                        zeroCols.add(c_i)
                    }
                }
            }

            for(i in 0..(m-1)){
                for(j in 0..(n-1)){
                    if(zeroRows.contains(i)){
                        matrix[i][j] = 0
                    }
                    if(zeroCols.contains(j)){
                        matrix[i][j] = 0
                    }
                }
            }

        }
    }
}