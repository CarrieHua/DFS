package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses < 1) {
			return true;
		}
		List<Edge> edges = new ArrayList<>();
		Set<Integer> vertexs = new HashSet<>();
		for (int i = 0; i < numCourses; i++)
			vertexs.add(i);
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
					break;
				}
			}
			vertexs.remove(sink);
			if (sink == -1) {
				return false;
			}

		}
		return true;
	}

	// BFS
	@SuppressWarnings("unchecked")
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		@SuppressWarnings("rawtypes")
		ArrayList[] graph = new ArrayList[numCourses];
		int[] outdegree = new int[numCourses];
		LinkedList<Integer> queue = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < numCourses; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < prerequisites.length; i++) {
			outdegree[prerequisites[i][1]]++;
			graph[prerequisites[i][0]].add(prerequisites[i][1]);
		}

		for (int i = 0; i < outdegree.length; i++) {
			if (outdegree[i] == 0) {// 出度为零，即为sink point
				queue.offer(i);
				count++;
			}
		}
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < graph[cur].size(); i++) {
				outdegree[(int) graph[cur].get(i)]--;
				if (outdegree[(int) graph[cur].get(i)] == 0) {
					queue.offer((int) graph[cur].get(i));
					count++;
				}
			}
		}
		return count == numCourses;
	}

	public boolean canFinish3(int numCourses, int[][] prerequisites) {
		ArrayList[] graph = new ArrayList[numCourses];
		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++)
			graph[i] = new ArrayList<>();
		for (int i = 0; i < prerequisites.length; i++) {
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		}
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(graph, visited, i)) {
				return false;
			}
		}
		return true;
	}

	public boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
		if (visited[course] == true) {
			return false;
		}
		visited[course] = true;
		for (int i = 0; i < graph[course].size(); i++) {
			if (!dfs(graph, visited, (int) graph[course].get(i)))
				return false;
		}
		visited[course] = false;
		return true;
	}

	public static void main(String[] args) {
		CourseSchedule cSchedule = new CourseSchedule();
		int numcourse = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		System.out.println(cSchedule.canFinish2(numcourse, prerequisites));
	}
}
