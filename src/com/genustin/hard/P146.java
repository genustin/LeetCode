package com.genustin.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Genustin on 2017/7/21.
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * <p>
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */

class LRUCache {

  private int                     count;
  private int                     capacity;
  private Map<Integer, DLinkNode> cache;
  private DLinkNode               head, tail;

  LRUCache(int capacity) {
    this.cache = new HashMap();
    this.capacity = capacity;
    this.count = 0;

    // something learn from this
    // use less NULL make your code clean and easy to handle
    this.head = new DLinkNode();
    this.head.prev = null;

    this.tail = new DLinkNode();
    this.tail.next = null;

    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  public int get(int key) {
    if (this.cache.containsKey(key)) {
      DLinkNode node = this.cache.get(key);
      moveToHead(node);
      System.out.println(node.val);
      return node.val;

    } else {
      System.out.println(-1);
      return -1;
    }
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      DLinkNode node = cache.get(key);
      node.val = value;
      moveToHead(node);
    } else {
      DLinkNode newNode = new DLinkNode(key, value);
      addNode(newNode);
      if (count > capacity) {
        popTail();
      }
    }
  }

  // move a list node to the head, mark it as the newest
  private void moveToHead(DLinkNode node) {
    removeNode(node);
    addNode(node);
  }

  private void addNode(DLinkNode node) {
    node.prev = head;
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
    cache.put(node.key, node);
    ++count;
  }

  private void removeNode(DLinkNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
    cache.remove(node.key);
    --count;
  }

  private DLinkNode popTail() {
    DLinkNode node = tail.prev;
    removeNode(node);
    return node;

  }
}


class DLinkNode {
  int       key;
  int       val;
  DLinkNode prev;
  DLinkNode next;

  DLinkNode() {
  }

  DLinkNode(int key, int val) {
    this.key = key;
    this.val = val;
    this.prev = null;
    this.next = null;
  }
}

public class P146 {

  public static void main(String[] args) {

    test1();
    test2();
  }

  static void test1() {
    LRUCache cache = new LRUCache(2);
    cache.get(2);       // returns 4
    cache.put(2, 6);
    cache.get(1);
    cache.put(1, 5);
    cache.put(1, 2);
    cache.get(1);
    cache.get(2);
  }

  static void test2() {
    LRUCache cache = new LRUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);
    cache.put(3, 3);
    cache.get(2);
    cache.put(4, 4);
    cache.get(1);
    cache.get(3);
    cache.get(4);
  }

}
