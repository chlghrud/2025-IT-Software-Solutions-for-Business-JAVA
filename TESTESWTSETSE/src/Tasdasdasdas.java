import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tasdasdasdas {

	static int N;
	static int M;
	static int V;
	static boolean[] visited; // 0 - based
	static List<Integer> answer = new ArrayList<Integer>();
	static List<List<Integer>> adj = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt(); // 정점
		M = scan.nextInt(); // 간선
		V = scan.nextInt(); // 시작

		visited = new boolean[N];

		for (int i = 0; i < N; i++)
			adj.add(new ArrayList<Integer>());

		for (int i = 0; i < M; i++) {
			int from = scan.nextInt() - 1;
			int to = scan.nextInt() - 1;
			adj.get(from).add(to);
			adj.get(to).add(from);
		}
		for (int i = 0; i < N; i++)
			adj.get(i).sort(null);

		dfs(V - 1);

		System.out.println(answer);
	}

	private static void dfs(int from) {
		if (visited[from])
			return;

		answer.add(from + 1);
		visited[from] = true;

		for (int to : adj.get(from)) {
			dfs(to);
		}

	}
}
