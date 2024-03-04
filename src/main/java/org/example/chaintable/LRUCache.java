package org.example.chaintable;

import java.util.LinkedHashMap;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/02/21 21:47
 */
public class LRUCache {

    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        // 已经存在, 更新节点到头
        if (cache.containsKey(key)) {
            cache.remove(key);
            // 再次插入会到队尾
            cache.put(key, value);
            return;
        }
        // 不存在
        if (cache.size() == capacity) {
            // 删除最后一个元素
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 插入新元素, 会添加链表尾部
        cache.put(key, value);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
