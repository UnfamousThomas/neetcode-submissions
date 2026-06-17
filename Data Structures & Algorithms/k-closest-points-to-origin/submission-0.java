class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // This is not actually too hard I think?
        // We have to use a priorityqueue to calculate the distances for each point
        // The question is how to loop through the points I guess?
        Queue<int[]> pointQueue =
            new PriorityQueue<>((a, b) -> Integer.compare(distance(b), distance(a)));

        for (int[] point : points) {
            pointQueue.add(point);
            if (pointQueue.size() > k) {
                pointQueue.poll();
            }
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = pointQueue.poll();
        }

        return result;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
