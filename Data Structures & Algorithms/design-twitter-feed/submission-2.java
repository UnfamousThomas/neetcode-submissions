class Twitter {
    private Map<Integer, Set<Integer>> follows = new HashMap<>();
    private Map<Integer, List<int[]>> tweets = new HashMap<>();
    private int timestamp = 0;

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        List<int[]> usersTweets = tweets.get(userId);
        if (usersTweets == null) {
            usersTweets = new ArrayList<>();
        }
        usersTweets.add(new int[] {timestamp, tweetId});
        tweets.put(userId, usersTweets);
        timestamp++;
    }

    public List<Integer> getNewsFeed(int userId) {
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        addLatestTweet(userId, heap);
        Set<Integer> followees = follows.get(userId);
        if (followees != null) {
            for (int follow : followees) {
                if (follow == userId)
                    continue;
                addLatestTweet(follow, heap);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (result.size() < 10 && !heap.isEmpty()) {
            int[] tweet = heap.poll();
            result.add(tweet[1]);
            pushNextTweet(tweet[2], tweet[3] - 1, heap);
        }
        return result;
    }

    private void pushNextTweet(int user, int index, Queue<int[]> heap) {
        if (index < 0)
            return;
        List<int[]> userTweets = tweets.get(user);
        int[] userTweet = userTweets.get(index);
        heap.add(new int[] {userTweet[0], userTweet[1], user, index});
    }

    private void addLatestTweet(int userId, Queue<int[]> heap) {
        List<int[]> usersTweets = tweets.get(userId);
        if (usersTweets != null && !usersTweets.isEmpty()) {
            int[] latestTweet = usersTweets.get(usersTweets.size() - 1);
            heap.add(new int[] {latestTweet[0], latestTweet[1], userId, usersTweets.size() - 1});
        }
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> currentFollows = follows.get(followerId);
        if (currentFollows == null) {
            currentFollows = new HashSet<>();
        }
        currentFollows.add(followeeId);
        follows.put(followerId, currentFollows);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> currentFollows = follows.get(followerId);
        if (currentFollows == null)
            return;

        currentFollows.remove(followeeId);
        follows.put(followerId, currentFollows);
    }
}
