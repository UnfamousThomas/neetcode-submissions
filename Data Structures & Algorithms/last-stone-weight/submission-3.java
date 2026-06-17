class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> stonesQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            stonesQueue.add(stone); //prepopulate stone array
        }

        while (stonesQueue.size() > 1) { //keep going until only 1 or 0 stones remain
            int stone1 = stonesQueue.poll();
            int stone2 = stonesQueue.poll();
            // stone1 == stone2 case can be ignored, since polling removes
            if (stone1 > stone2) {
                // stone2 destroyed
                int newStone = stone1 - stone2;
                stonesQueue.add(newStone);
            }
            if (stone2 > stone1) {
                // stone1 destroyed
                int newStone = stone2 - stone2;
                stonesQueue.add(newStone);
            }
        }
        Integer lastStone = stonesQueue.poll();
        if(lastStone != null) return lastStone;

        return 0;
    }
}
