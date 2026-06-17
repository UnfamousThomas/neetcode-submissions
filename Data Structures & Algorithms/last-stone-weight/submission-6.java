class Solution {
    public int lastStoneWeight(int[] stones) {
        //We need MAX element first, so reversed order
        Queue<Integer> stonesQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            stonesQueue.add(stone); //prepopulate stone array
        }

        while (stonesQueue.size() > 1) { //keep going until only 1 or 0 stones remain
            int stone1 = stonesQueue.poll();
            int stone2 = stonesQueue.poll();
            // stone1 == stone2 case can be ignored, since polling removes
            //The bgger stone always comes first, so we jsut need to check if stone1 does not equal stone2
            if(stone1 != stone2) {
                stonesQueue.add(stone1 - stone2);
            }
        }

        return stonesQueue.isEmpty() ? 0 : stonesQueue.poll();
    }
}
