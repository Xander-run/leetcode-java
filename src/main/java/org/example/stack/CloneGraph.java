package org.example.stack;

import org.example.util.graph.Node;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

    private static Map<Node, Node> visted = new HashMap<>();

    public static Node cloneGraph(Node node) {
        if (node == null) return node;
        Node ret = null;
        if (!visted.containsKey(node)) {
            ret = new Node(node.val);
            visted.put(node, ret);
            for (Node neighbors : node.neighbors) {
                ret.neighbors.add(cloneGraph(neighbors));
            }
            return ret;
        } else {
            return visted.get(node);
        }
    }
}
