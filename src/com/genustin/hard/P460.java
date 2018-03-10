package com.genustin.hard;


import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Created by Genustin on 2017/7/28.
 * <p>
 * Design and implement a data structure for Least Frequently Used (LFU) cache.
 * It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set value, or insert the value if the key is not already present.
 * When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item.
 * For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 */

class LFUCache {

  private int                      count;
  private int                      capacity;
  // keep the key-value mapping
  private Map<Integer, Integer>    kvCache;
  // keep the key-node mapping, the node contains a LinkedHashSet, indicate the visit queue, head is the oldest
  private Map<Integer, DLinkNode2> ksCache;
  // keep the node list, indicate frequency queue, head is least frequency
  private DLinkNode2               head, tail;

  LFUCache(int capacity) {
    this.count = 0;
    Math.abs(count);
    this.capacity = capacity;
    this.kvCache = new HashMap<>();
    this.ksCache = new HashMap<>();

    this.head = new DLinkNode2();
    this.tail = new DLinkNode2();
    this.head.next = tail;
    this.tail.prev = head;
  }

  public int get(int key) {
    if (kvCache.containsKey(key)) {
      DLinkNode2 ptr = ksCache.get(key);
      int value = kvCache.get(key);
      push(ptr, key, value);
      System.out.println(value);
      return value;
    } else {
      System.out.println(-1);
      return -1;
    }
  }

  public void put(int key, int value) {
    if (capacity <= 0) return;
    DLinkNode2 ptr;
    if (kvCache.containsKey(key)) {
      ptr = ksCache.get(key);
      push(ptr, key, value);
    } else {
      ptr = head;
      if (isFull()) {
        pop();
        --count;
      }
      push(ptr, key, value);
      ++count;
    }
  }


  //----
  private void push(DLinkNode2 ptr, int key, int value) {
    DLinkNode2 node;
    // Double link
    if (ptr.next == tail) {
      node = new DLinkNode2();
      append(ptr, node);
    } else {
      node = ptr.next;
    }
    node.freqGroup.add(key);

    // kv map
    kvCache.put(key, value);
    // kn map
    if (!ptr.freqGroup.isEmpty())
      ptr.freqGroup.remove(key);
    ksCache.put(key, node);
  }

  void append(DLinkNode2 ptr, DLinkNode2 newNode) {
    //assert append is not happen on tail
    newNode.next = ptr.next;
    newNode.prev = ptr.next.prev;
    ptr.next.prev = newNode;
    ptr.next = newNode;
  }

  private void pop() {
    DLinkNode2 node = head.next;
    int old = 0;
    while (node.freqGroup.isEmpty())
      node = node.next;
    for (int x : node.freqGroup) {
      old = x;
      break;
    }
    weed(old);
  }

  // weed out the key
  private int weed(int key) {
    ksCache.get(key).freqGroup.remove(key);
    ksCache.remove(key);
    return kvCache.remove(key);
  }

  private boolean isEmpty() {
    return count == 0;
  }

  private boolean isFull() {
    return count >= capacity;
  }

}

class DLinkNode2 {
  LinkedHashSet<Integer> freqGroup;
  DLinkNode2             prev, next;

  DLinkNode2() {
    this.freqGroup = new LinkedHashSet<>();
    this.prev = null;
    this.next = null;
  }

}


public class P460 {

  public static void main(String[] args) {
    test1();
    System.out.println("---");
    test2();
    System.out.println("---");
    test3();
  }

  static void test1() {
    LFUCache cache = new LFUCache(2 /* capacity */);

    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    cache.get(2);       // returns -1 (not found)
    cache.get(3);       // returns 3.
    cache.get(3);       // returns 3.
    cache.get(1);       // returns 1.
    cache.put(4, 4);    // evicts key 3.
    cache.get(1);       // returns 1
    cache.get(3);       // returns -1 (not found)
    cache.get(4);       // returns 4
  }

  static void test2() {
    LFUCache cache = new LFUCache(0 /* capacity */);

    cache.get(0);       // returns -1
    cache.put(0, 0);    //
    cache.get(0);       // returns 0
  }

  static void test3() {
    LFUCache cache = new LFUCache(2);
    cache.put(3, 1);
    cache.put(2, 1);
    cache.put(2, 2); // evicts 2, 1
    cache.put(4, 4); // evicts 3, 1
    cache.get(2);    // return 2
  }
}

