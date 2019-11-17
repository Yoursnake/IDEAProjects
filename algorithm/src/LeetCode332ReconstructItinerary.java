/*
Given a list of airline tickets represented by pairs of departure and 
arrival airports [from, to], reconstruct the itinerary in order. All 
of the tickets belong to a man who departs from JFK. Thus, the itinerary 
must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary 
that has the smallest lexical order when read as a single string. For 
example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].

All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.

Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
*/

import java.util.*;

public class LeetCode332ReconstructItinerary {
//	// DFS Top Down: TLE
//	public List<String> findItinerary(List<List<String>> tickets) {
//		List<String> curr = new ArrayList<>();
//		List<List<String>> list = new ArrayList<>();
//
//		curr.add("JFK");
//		findItineraryDFS(tickets, curr, list);
//
//		return list.get(0);
//	}
//
//	private void findItineraryDFS(List<List<String>> tickets, List<String> curr, List<List<String>> list) {
//		if (tickets.size() == 0) {
//			if (list.size() == 0) {
//				list.add(new ArrayList<String>(curr));
//			} else {
//				if (compareTwoTickets(curr, list.get(0)) < 0) {
//					list.set(0, new ArrayList<String>(curr));
//				}
//			}
//			return;
//		}
//
//		String last = curr.get(curr.size() - 1);
//
//		for (int i = 0; i < tickets.size(); i++) {
//			List<String> ticket = tickets.get(i);
//
//			if (ticket.get(0).equals(last)) {
//				curr.add(ticket.get(1));
//				tickets.remove(i);
//				findItineraryDFS(tickets, curr, list);
//				curr.remove(curr.size() - 1);
//				tickets.add(i, ticket);
//			}
//		}
//	}
//
//	private int compareTwoTickets(List<String> t1, List<String> t2) {
//		for (int i = 0; i < t1.size(); i++) {
//			String s1 = t1.get(i);
//			String s2 = t2.get(i);
//
//			if (s1.compareTo(s2) < 0) return -1;
//			else if (s1.compareTo(s2) > 0) return 1;
//		}
//
//		return 0;
//	}

	// DFS Bottom Up: 5ms 81.4%
	private Map<String, PriorityQueue<String>> map = new HashMap<>();

	public List<String> findItinerary(List<List<String>> tickets) {
		List<String> res = new ArrayList<>();

		for (List<String> ticket : tickets) {
			map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
			map.get(ticket.get(0)).offer(ticket.get(1));
		}

		findItineraryDFS("JFK", res);
		return res;
	}

	private void findItineraryDFS(String departPlace, List<String> res) {
		while (map.get(departPlace) != null && !map.get(departPlace).isEmpty()) {
			findItineraryDFS(map.get(departPlace).poll(), res);
		}

		res.add(0, departPlace);
	}
}