package id.my.adkafawaid.moduls.Output;

public class Space {
//ATTRIBUTE
    private int width;

//CONSTRUCTOR
    public Space(int width){
        this.width =  width;
    }

//METHOD
    public void draw() {
    StringBuilder line = new StringBuilder("|");
        for (int i = 0; i < width; i++) {
            line.append(" ");
        }
            line.append("|");
            System.out.println(line);
    }
}
