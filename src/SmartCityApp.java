import java.util.Scanner;
@SuppressWarnings("resource")
public class SmartCityApp {
    public static void main(String[] args) {
        SmartCityGraph cityGraph = new SmartCityGraph();
        LocationTree cityTree = new LocationTree();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Smart City Route Planner ---");
            System.out.println("1. Add Location");
            System.out.println("2. Add Road (Connection)");
            System.out.println("3. Display All Connections");
            System.out.println("4. Show Route (BFS Traversal)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter location name: ");
                    String locName = scanner.nextLine();
                    cityTree.addLocation(locName); // Store in Tree
                    cityGraph.addVertex(locName);  // Map to Graph
                    System.out.println("Location added successfully.");
                    break;
                case 2:
                    System.out.print("Enter source: ");
                    String src = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String dest = scanner.nextLine();
                    cityGraph.addEdge(src, dest);
                    break;
                case 3:
                    cityGraph.displayConnections();
                    break;
                case 4:
                    System.out.print("Enter starting location: ");
                    String start = scanner.nextLine();
                    cityGraph.showRoute(start);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}