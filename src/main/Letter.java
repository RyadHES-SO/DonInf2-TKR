public class Letter extends Item {

    private String content;


public Letter (String name, String description, String content) {
    super(name, "Contains a riddle");
    this.content = content;

    
 }
 @Override
public void inspect() {
    super.inspect();
    System.out.println("Content: " + content);
}

} 

