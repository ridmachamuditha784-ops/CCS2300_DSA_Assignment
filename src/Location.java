
public class Location {
    String name;
    Location left, right; // For Binary Search Tree

    public Location(String name) {
        this.name = name;
        this.left = this.right = null;
    }
}
