class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // This is not actually too hard I think?
        // We have to use a priorityqueue to calculate the distances for each point
        // The question is how to loop through the points I guess?

        //We make a priority queue
        //Where we sort based on each points x and y.
        // Here, there are points a and b.
        // We use the distance function to calculate their distance, and then compare them.
        Queue<int[]> pointQueue =
            new PriorityQueue<>((a, b) -> Integer.compare(distance(b), distance(a)));

        //Go through the points
        for (int[] point : points) {
            pointQueue.add(point);
            //If too many, remove
            if (pointQueue.size() > k) {
                pointQueue.poll();
            }
        }

        //Create result
        int[][] result = new int[k][2];

        //Populate it
        for (int i = 0; i < k; i++) {
            result[i] = pointQueue.poll();
        }

        return result;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
