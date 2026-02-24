import java.util.*;

class SmartCityGraph {
    private Map<String, List<String>> adjList = new HashMap<>();

    // Add a location to the graph
    public void addVertex(String locationName) {
        adjList.putIfAbsent(locationName, new LinkedList<>());
    }

    // Add a road between two locations
    public void addEdge(String source, String destination) {
        if (adjList.containsKey(source) && adjList.containsKey(destination)) {
            adjList.get(source).add(destination);
            adjList.get(destination).add(source); // Undirected graph
        } else {
            System.out.println("Error: One or both locations do not exist!");
        }
    }

    // Remove a road
    public void removeEdge(String source, String destination) {
        if (adjList.containsKey(source) && adjList.containsKey(destination)) {
            adjList.get(source).remove(destination);
            adjList.get(destination).remove(source);
        }
    }

    // Display all roads
    public void displayConnections() {
        System.out.println("\n--- City Road Network ---");
        for (String location : adjList.keySet()) {
            System.out.println(location + " is connected to: " + adjList.get(location));
        }
    }

    // Traversal using Queue (Breadth-First Search)
    public void showRoute(String startNode) {
        if (!adjList.containsKey(startNode)) return;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        System.out.print("Discovery Path: ");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " -> ");

            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println("END");
    }
}