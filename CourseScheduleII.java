package dfs;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CourseScheduleII {
	//BFS
	public int[] findOrder2(int numCourses, int[][] prerequisites) {
		int[] empty = {};
		ArrayList[] graph = new ArrayList[numCourses];
		int[] outdegree = new int[numCourses];
		int[] res = new int[numCourses];
		int index = numCourses;
		LinkedList<Integer> queue = new LinkedList<>();	
		for (int i = 0; i < numCourses; i ++)
			graph[i] = new ArrayList<>();
		
		for (int i = 0; i < prerequisites.length; i ++) {
			outdegree[prerequisites[i][1]] ++;
			graph[prerequisites[i][0]].add(prerequisites[i][1]);
		}
		
		for (int i = 0; i < outdegree.length; i ++) {
			if (outdegree[i] == 0) {//出度为零，即为sink point
				queue.offer(i);
				res[--index] = i;
				
			}
		}
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < graph[cur].size(); i ++) {
				int pointer = (int) graph[cur].get(i);
				outdegree[pointer] --;
				if (outdegree[pointer] == 0) {
					queue.offer(pointer);
					res[-- index] = pointer;
				}
			}
		}
		if (index == 0) {
			return res;
		}
		return empty;
	}
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] empty = {};
		if (numCourses < 1) {
			return empty;
		}
		List<Edge> edges = new ArrayList<>();
		Set<Integer> vertexs = new HashSet<>();
		LinkedList<Integer> result = new LinkedList<>();
		for (int i = 0; i < numCourses; i++)
			vertexs.add(i);
		int[] res = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			Edge edge = new Edge(prerequisites[i][1], prerequisites[i][0]);
			edges.add(edge);
		}
		while (!vertexs.isEmpty()) {
			Set<Integer> first = new HashSet<>();
			for (Edge edge : edges) {
				first.add(edge.first);
			}
			int sink = -1;

			for (Integer integer : vertexs) {
				if (!first.contains(integer)) {
					sink = integer;
					List<Edge> list = new ArrayList<>();
					for (Edge edge : edges) {
						if (edge.second == sink) {
							list.add(edge);
						}
					}
					for (Edge edge : list) {
						edges.remove(edge);
					}
					result.addFirst(sink);
					break;
				}
			}
			vertexs.remove(sink);
			if (sink == -1) {
				return empty;
			}

		}
		for (int i = 0; i < result.size(); i++)
			res[i] = result.get(i);
		return res;
	}

	public void print(int[] res) {
		for (int i : res) {
			System.out.print(i + "\t");
		}
	}

	public static void main(String[] args) {
		CourseScheduleII cScheduleII = new CourseScheduleII();
		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		cScheduleII.print(cScheduleII.findOrder2(numCourses, prerequisites));
	}
}
