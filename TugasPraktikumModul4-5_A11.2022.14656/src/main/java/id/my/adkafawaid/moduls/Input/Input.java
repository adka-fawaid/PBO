package id.my.adkafawaid.moduls.Input;

import java.util.Scanner;

public class Input {
    // ATTRIBUTE
    private String label;
    private Scanner input;
    private String value;

    /* CONSTRUCTOR */
    public Input(String label) {
        this.label = label;
        this.input = new Scanner(System.in);
    }

    /* METHOD */
    public void draw() {
        System.out.print("| " + label);
        value = input.nextLine();
    }

    public String getValue() {
        return value;
    }

    public int getValueInt() {
        return Integer.parseInt(getValue());
    }

    public double getValueDouble() {
        return Double.parseDouble(getValue());
    }
}
