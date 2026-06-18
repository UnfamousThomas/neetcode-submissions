class Twitter {
    private Map<Integer, Set<Integer>> follows = new HashMap<>();
    private Map<Integer, List<int[]>> tweets = new HashMap<>();
    private int timestamp = 0;

    public Twitter() {}

    //Posting is easy
    // Just add post to the tweets map, with timestamp and id
    // and increase timestamp
    public void postTweet(int userId, int tweetId) {
        List<int[]> usersTweets = tweets.get(userId);
        if (usersTweets == null) {
            usersTweets = new ArrayList<>();
        }
        usersTweets.add(new int[] {timestamp, tweetId});
        tweets.put(userId, usersTweets);
        timestamp++;
    }

    //By far the hardest part
    // We want to use a heap, where we compare by timestamps. With the newest ones ahead
    // Then, we want to populate this heap, first with our own latest tweet, and then users we follow latest tweet
    // Once we have done that, we need to get 10 tweets from the heap to return
    // For each one we take, we add 1 older tweet from the same user back
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

    //We want to push the next tweet into the heap
    // So we get his tweets, get index tweet and add
    private void pushNextTweet(int user, int index, Queue<int[]> heap) {
        if (index < 0)
            return;
        List<int[]> userTweets = tweets.get(user);
        int[] userTweet = userTweets.get(index);
        heap.add(new int[] {userTweet[0], userTweet[1], user, index});
    }

    //We want to add the latest tweet from a user to the heap
    // So we need to get his tweets, and get the last element if it exists
    private void addLatestTweet(int userId, Queue<int[]> heap) {
        List<int[]> usersTweets = tweets.get(userId);
        if (usersTweets != null && !usersTweets.isEmpty()) {
            int[] latestTweet = usersTweets.get(usersTweets.size() - 1);
            heap.add(new int[] {latestTweet[0], latestTweet[1], userId, usersTweets.size() - 1});
        }
    }

    //Following is easy, just add to the users map
    public void follow(int followerId, int followeeId) {
        Set<Integer> currentFollows = follows.get(followerId);
        if (currentFollows == null) {
            currentFollows = new HashSet<>();
        }
        currentFollows.add(followeeId);
        follows.put(followerId, currentFollows);
    }

    //Unfollowing just removes from the map
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> currentFollows = follows.get(followerId);
        if (currentFollows == null)
            return;

        currentFollows.remove(followeeId);
        follows.put(followerId, currentFollows);
    }
}
