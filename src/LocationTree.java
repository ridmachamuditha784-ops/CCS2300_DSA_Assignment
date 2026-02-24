
public class LocationTree {
	Location root;

    // add location 
    public void addLocation(String name) {
        root = insert(root, name);
    }

    private Location insert(Location root, String name) {
        if (root == null) return new Location(name);
        if (name.compareTo(root.name) < 0) root.left = insert(root.left, name);
        else if (name.compareTo(root.name) > 0) root.right = insert(root.right, name);
        return root;
    }
}
