public class Key extends Item {
    private Location targetLocation;  // La location que cette clé déverrouille

    public Key(String name, String description, Location targetLocation) {
        super(name, "Can unlock a location.");
        this.targetLocation = targetLocation;
    }

    public Location getTargetLocation() {
        return targetLocation;
    }

    public void use() {
        if (targetLocation.getState()) {
            System.out.println("The location \"" + targetLocation.getName() + "\" is already unlocked.");
        } else {
            targetLocation.unlock();
            System.out.println("You unlocked: " + targetLocation.getName());
        }
    }
    @Override
public void inspect() {
    super.inspect();
    System.out.println("This key unlocks: " + targetLocation.getName());
}

    
}
