package com.genustin.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by wayne on 18/03/10
 * <p>
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class P347 {

  public List<Integer> topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    // construct the frequent, with Map.Entry(key, freq)
    for (int key : nums) {
      map.put(key, map.getOrDefault(key, 0) + 1);
    }

    // sort by the freq with reverse order
    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap
        = new PriorityQueue<>(map.size(), (o1, o2) -> o2.getValue() - o1.getValue());
    for (Map.Entry iter : map.entrySet()) {
      maxHeap.offer(iter);
    }

    // construct the answer
    List<Integer> answer = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      answer.add(maxHeap.poll().getKey());
    }

    return answer;
  }

}
