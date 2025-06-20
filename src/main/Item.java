
public class Item {

    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void inspect() {
        System.out.println("Inspecting " + name + ": " + description);
    }
}