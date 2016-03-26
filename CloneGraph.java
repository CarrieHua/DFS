package dfs;

import java.util.HashMap;
import java.util.LinkedList;

import org.omg.CORBA.PUBLIC_MEMBER;

public class CloneGraph {

	//BFS
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;

		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(node, copy);
		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			for (int i = 0; i < cur.neighbors.size(); i++) {
				UndirectedGraphNode next = cur.neighbors.get(i);
				if (!map.containsKey(next)) {
					UndirectedGraphNode copyN = new UndirectedGraphNode(next.label);
					map.put(next, copyN);
					queue.offer(next);
				}
				map.get(cur).neighbors.add(map.get(next));
			}
		}
		return map.get(node);
	}
	
	//DFS
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if (node == null)
			return null;
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
		map.put(node, copy);
		return map.get(node);
	}
	public void dfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {		
		
		for (int i = 0; i < node.neighbors.size(); i ++) {
			UndirectedGraphNode next = node.neighbors.get(i);	
			if (!map.containsKey(next)) {
				UndirectedGraphNode copy = new UndirectedGraphNode(next.label);
				map.put(node, copy);	
				dfs(next, map);
			}
			map.get(node).neighbors.add(map.get(next));
		}
	}
}
