package org.example.map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: xxx
 * @author: rubei
 * @create: 2024/03/26 19:58
 */
// 797
// 图, 所有可能路径
public class AllPathsSourceTarget {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // graph 邻接表
        LinkedList<Integer> trace = new LinkedList<>();
//        int current = graph[0][0];
        traverse(graph, 0, trace);
        return res;
    }

    private void traverse(int[][] graph, int v, LinkedList<Integer> trace){
        trace.addLast(v);
        if (trace.size() == graph.length) {
            // 注意trace类型的引用
            res.add(new LinkedList<>(trace));
        }
        // 递归每个相邻节点
        for (int item : graph[v]) {
            traverse(graph, item, trace);
        }
        // 从路径移出节点
        trace.removeLast();
    }
}
