package org.example.twentyfour.april;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/04/15 21:25
 */
public class MyHashMap {

    private Node[] nodes;

    Integer NODE_SIZE = 1200;

    public MyHashMap() {
        nodes = new Node[NODE_SIZE];
    }

    public void put(int key, int value) {
        int slot = key % NODE_SIZE;
        Node node = nodes[slot];
        if(node == null) {
            node = new Node();
            node.setKey(key);
            node.setValue(value);
            nodes[slot] = node;
        } else {
            while (node.key != key && node.next != null) {
                node = node.next;
            }
            if(node.key == key) {
                // 覆盖
                node.value = value;
            } else {
                // 新建
                Node newNode = new Node();
                newNode.setKey(key);
                newNode.setValue(value);
                node.next = newNode;
            }
        }
    }

    public int get(int key) {
        int slot = key % NODE_SIZE;
        Node node = nodes[slot];
        if(node == null) {
            return -1;
        } else {
            while (node.key != key && node.next != null) {
                node = node.next;
            }
            if(node.key == key) {
                return node.value;
            } else {
                return -1;
            }
        }
    }

    public void remove(int key) {
        int slot = key % NODE_SIZE;
        Node node = nodes[slot];
        if(node == null) {
            return;
        } else {
            Node prev = null;
            Node current = node;
            while (current.key != key && current.next != null) {
                prev = current;
                node = current.next;
            }
            if(current.key == key) {
                if(prev == null) {
                    nodes[slot] = prev;
                } else {
                    prev.next = current.next;
                }
            }
        }
    }

    static class Node {
        private Integer key;
        private Integer value;

        private Node next;

        public Integer getKey() {
            return key;
        }

        public Node() {
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,1);
        map.put(2,2);
        map.get(1);
        map.get(3);
        map.put(2,1);
        map.get(2);
        map.remove(2);
        System.out.println(map.get(2));;
    }
}
