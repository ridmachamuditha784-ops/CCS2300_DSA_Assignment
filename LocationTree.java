public class LocationTree {
    // Note: No need to define 'class Location' here because 
    // it already exists in Location.java in your project.
    
    Location root;

    // Method to add a location (BST Insertion)
    public void addLocation(String name) {
        root = insert(root, name);
    }

    private Location insert(Location root, String name) {
        if (root == null) {
            return new Location(name);
        }
        if (name.compareTo(root.name) < 0) {
            root.left = insert(root.left, name);
        } else if (name.compareTo(root.name) > 0) {
            root.right = insert(root.right, name);
        }
        return root;
    }

    // Member 3 Task: Search location in BST
    public boolean searchLocation(String name) {
        return search(root, name);
    }

    private boolean search(Location root, String name) {
        if (root == null) return false;
        if (root.name.equalsIgnoreCase(name)) return true;

        return name.compareToIgnoreCase(root.name) < 0
            ? search(root.left, name)
            : search(root.right, name);
    }
}