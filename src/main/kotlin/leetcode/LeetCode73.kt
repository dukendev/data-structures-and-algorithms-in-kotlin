package leetcode

class LeetCode73 {
    companion object {
        //brute force solution
        fun setZeroesBruteForce(matrix: Array<IntArray>): Unit {
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
                    if(zeroRows.contains(i) || zeroCols.contains(j)){
                        matrix[i][j] = 0
                    }
                }
            }

        }
    }

    //optimal solution , better space
    fun setZeroes(matrix: Array<IntArray>): Unit {


        val m = matrix.size
        val n = matrix[0].size

        var col0 = -1

        matrix.forEachIndexed { r_i, row  ->
            row.forEachIndexed {  c_i, e ->
                if(e == 0){
                    matrix[r_i][0] = 0

                    if(c_i != 0){
                        matrix[0][c_i] = 0
                    } else {
                        col0 = 0
                    }
                }
            }
        }



        for(i in 1..(m-1)){
            for(j in 1..(n-1)){
                if(matrix[i][j] != 0){
                    if(matrix[0][j] == 0 || matrix[i][0] == 0){
                        matrix[i][j] = 0
                    }
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (j in 0..(n-1)) {
                matrix[0][j] = 0
            }
        }
        if (col0 == 0) {
            for (i in 0..(m-1)) {
                matrix[i][0] = 0
            }
        }

    }

}