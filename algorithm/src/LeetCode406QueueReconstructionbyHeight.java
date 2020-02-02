import java.util.*;

class LeetCode406QueueReconstructionbyHeight {
	public int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length == 0) return new int[0][0];

		List<Integer> heights = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<int[]> resList = new ArrayList<>();
		int[][] res = new int[people.length][2];

		for (int[] p : people) {
			if (!map.containsKey(p[0])) {
				map.put(p[0], new ArrayList<>(Arrays.asList(p[1])));
				heights.add(p[0]);
			} else {
				map.get(p[0]).add(p[1]);
			}
		}

		heights.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		for (int height : heights) {
			List<Integer> idxes = map.get(height);
			Collections.sort(idxes);
			for (int idx : idxes) {
				resList.add(idx, new int[] {height, idx});
			}
		}

		for (int i = 0; i < resList.size(); i++) {
			res[i] = resList.get(i);
		}

		return res;
	}
}