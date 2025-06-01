package main;

public class Key extends Item {
    private Location KeyLocation;


public Key (String name, String description, Location KeyLocation) {
    super(name, description);
    this.KeyLocation = KeyLocation; 
 }

 public void use() {
    KeyLocation.unlock();
    System.out.println("Vous avez déverrouillé : " + KeyLocation.getName());
}
    
}
