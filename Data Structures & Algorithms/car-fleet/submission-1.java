class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // todo sort position and speed? Need to process cars in such a way that the car in front
        //  of the one-lane highway is 0th element
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        Deque<Float> arrivals = new ArrayDeque<>();

        for(int i = 0; i < cars.length; i++) {
            int carPosition = cars[i][0];
            int carSpeed = cars[i][1];

            float arrival = (target - carPosition) / (float) carSpeed;
            if(arrivals.isEmpty() || arrivals.getFirst() < arrival) {
                arrivals.push(arrival);
            }
        }
        return arrivals.size();

    }
}
