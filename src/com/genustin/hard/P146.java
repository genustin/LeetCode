package com.genustin.hard;

import java.util.HashMap;
import java.util.LinkedList;
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
public class P146 {

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    cache.get(2);       // returns 4
    cache.put(2, 6);
    cache.get(1);
    cache.put(1, 5);
    cache.put(1, 2);
    cache.get(1);
    cache.get(2);
  }
}

class LRUCache {

  private int                     count;
  private int                     capacity;
  private Map<Integer, DLinkNode> cache;
  private DLinkNode head, tail;

  LRUCache(int capacity) {
    this.cache = new HashMap();
    this.capacity = capacity;
    this.count = 0;
  }

  public int get(int key) {
    if (this.cache.containsKey(key)) {
      System.out.println(this.cache.get(key).val);
      return this.cache.get(key).val;

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
      if (count >= capacity) {
        addToHead(newNode);
        removeNode(tail);
      } else {
        addToHead(newNode);
      }
    }
  }

  // move a list node to the head, mark it as the newest
  private void moveToHead(DLinkNode node) {
    removeNode(node);
    addToHead(node);
  }

  private void addToHead(DLinkNode node) {
    if (head == null) {
      head = node;
    }

    if (tail == null) {
      tail = node;
    }

    if (!node.equals(head)) {
      node.next = head;
      node.pre = null;
      head.pre = node;
      head = node;
      ++count;
    }
    cache.put(node.key, node);
  }

  private void removeNode(DLinkNode node) {
    if (!node.equals(head))
      node.pre.next = node.next;
    if (!node.equals(tail))
      node.next.pre = node.pre;

    --count;
  }
}


class DLinkNode {
  int key;
  int val;
  DLinkNode pre;
  DLinkNode next;

  DLinkNode() { }

  DLinkNode(int key, int val) {
    this.key = key;
    this.val = val;
    this.pre = null;
    this.next = null;
  }
}
