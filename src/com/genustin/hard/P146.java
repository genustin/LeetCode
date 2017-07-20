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

/* TODO: 2017/7/21 performance is too bad, don't relay on the java collection */
class LRUCache {

  private int                     count;
  private int                     capacity;
  private Map<Integer, DLinkNode> cache;
  private LinkedList<DLinkNode>   list;

  LRUCache(int capacity) {
    this.cache = new HashMap();
    this.list = new LinkedList<>();
    this.capacity = capacity;
    this.count = 0;
  }

  public int get(int key) {
    if (cache.containsKey(key)) {
      DLinkNode node = cache.get(key);
      refreshCache(node);
      System.out.println(node.val);
      return node.val;
    } else {
      System.out.println(-1);
      return -1;
    }
  }

  public void put(int key, int value) {
    if (cache.containsKey(key)) {
      DLinkNode old = cache.get(key);
      old.val = value;
      refreshCache(old);
      return;
    }
    DLinkNode node = new DLinkNode(key, value);
    this.cache.put(key, node);
    this.list.addFirst(node);
    this.count++;
    if (this.count > this.capacity) {
      DLinkNode toDel = list.removeLast();
      this.cache.remove(toDel.key);
      this.count--;
    }
  }

  private void refreshCache(DLinkNode node) {
    this.list.remove(node);
    this.list.addFirst(node);
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
