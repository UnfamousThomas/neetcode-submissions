class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int rowLength = matrix[0].length;
        int right = matrix.length * rowLength - 1;

        while (right >= left) {
            int middle = (left + right) / 2;
            int row = middle / rowLength;
            int col = middle % rowLength;

            int element = matrix[row][col];

            if(element == target) {
                return true;
            }
            if(element > target) {
                //Element is too big, need to shift left
                right = middle - 1;
            }
            if(element < target) {
                //Element is too small, need to shift right
                left = middle + 1;
            }
        }
        return false;
    }
}
