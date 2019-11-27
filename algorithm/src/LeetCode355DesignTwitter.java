/*
Design a simplified version of Twitter where users can post tweets, 
follow/unfollow another user and is able to see the 10 most recent 
tweets in the user's news feed. Your design should support the 
following methods:

1. postTweet(userId, tweetId): Compose a new tweet.
2. getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the 
user's news feed. Each item in the news feed must be posted by users 
who the user followed or by the user herself. Tweets must be ordered 
from most recent to least recent.
3. follow(followerId, followeeId): Follower follows a followee.
4. unfollow(followerId, followeeId): Follower unfollows a followee.

Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);
*/

import java.util.*;

// 22ms 95.80%
public class LeetCode355DesignTwitter {
	private Map<Integer, List<Integer>> followMap;	// key: userId value: follow的所有 userId
	private Map<Integer, List<TweetEntry>> postMap;	// key: userId value: post过的所有 tweetEntry，recent发布的在前面
	private int currentTime;

	private class TweetEntry {
		public int time;
		public int tweetId;

		public TweetEntry(int time, int tweetId) {
			this.time = time;
			this.tweetId = tweetId;
		}
	}

	/** Initialize your data structure here. */
	public LeetCode355DesignTwitter() {
		followMap = new HashMap<>();
		postMap = new HashMap<>();
		currentTime = 0;	// 用实数来表示，越大表示越 recent
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		if (!postMap.containsKey(userId)) {
			List<TweetEntry> tmp = new ArrayList<>();
			tmp.add(new TweetEntry(currentTime++, tweetId));
			postMap.put(userId, tmp);
		} else {
			postMap.get(userId).add(0, new TweetEntry(currentTime++, tweetId));
		}
	}

	/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> res = new ArrayList(10);
		int cnt = 0;
		List<Integer> postPeoples = followMap.get(userId);
		if (postPeoples == null) postPeoples = new ArrayList<>();
		else postPeoples = new ArrayList<>(postPeoples);
		postPeoples.add(userId);
		int[] points = new int[postPeoples.size()];	// 每一个 postPeople 都对应一个指针

		while (cnt < 10) {
			int mostRecentIdx = -1;
			int mostRecentTime = -1;
			int mostRecentTweetIdx = -1;

			for (int i = 0; i < postPeoples.size(); i++) {
				if (postMap.get(postPeoples.get(i)) == null || points[i] >= postMap.get(postPeoples.get(i)).size()) continue;

				TweetEntry tweetEntry = postMap.get(postPeoples.get(i)).get(points[i]);
				if (tweetEntry.time > mostRecentTime) {
					mostRecentTime = tweetEntry.time;
					mostRecentTweetIdx = tweetEntry.tweetId;
					mostRecentIdx = i;
				}
			}

			if (mostRecentIdx == -1) break;	// 表明所有 postPeople 都没有 tweetEntry 了
			res.add(mostRecentTweetIdx);
			points[mostRecentIdx]++;	// 加入到 res 中的 list 对应指针加 1
			cnt++;
		}

		return res;
	}

	/** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	public void follow(int followerId, int followeeId) {
		if (followerId == followeeId) return;

		if (!followMap.containsKey(followerId)) {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(followeeId);
			followMap.put(followerId, tmp);
		} else {
			if (followMap.get(followerId).contains(followeeId)) return;
			followMap.get(followerId).add(followeeId);
		}
	}

	/** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	public void unfollow(int followerId, int followeeId) {
		if (followerId == followeeId) return;
		if (!followMap.containsKey(followerId)) return;
		if (!followMap.get(followerId).contains(followeeId)) return;
		followMap.get(followerId).remove(new Integer(followeeId));
	}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */