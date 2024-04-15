package id.my.adkafawaid.moduls.Page;

import id.my.adkafawaid.moduls.Output.*;
import id.my.adkafawaid.moduls.Data.*;

import static id.my.adkafawaid.moduls.Data.DataPassword.passData;

public class ListPasswordPage {
    public String title;
    public int width;
    private final HLine hline;
    private final Space space;
    private final Label label;

    public ListPasswordPage(String title, int width){
        this.width = width;
        this.title = title;
        this.hline = new HLine(width);
        this.space = new Space(width);
        this.label = new Label(title.toUpperCase(), width);
    }

    public void draw() throws Exception{
        this.drawHeader();
        this.space.draw();
        this.drawContent();
    }
    public void drawHeader(){
        this.hline.draw();
        this.space.draw();
        this.label.draw();
        this.space.draw();
        this.hline.draw();
    }

    private void drawContent() throws Exception{
        this.label.text = "Terdapat " + passData.size()+ " tersimpan.";
        this.label.draw();
        this.label.text = "---- ---- ----";
        this.label.draw();
        //proses mendapatkan kata terpanjang, agar ukuran column dapat seragam.
        //sekalipun textnya panjang(opsional).
        int col = 0;
        for(PasswordStore password:passData){
            col = (password.name.length()>col)? password.name.length() : col;
            col = (password.username.length()>col)? password.username.length() : col;
            col = (password.getCategory().length()>col)? password.getCategory().length() : col;
        }
        col++;
        for(PasswordStore password : passData){
            this.label.text = ("| "+ password.name + " ".repeat(col-password.name.length()) +
                    "| "+ password.username + " ".repeat(col-password.username.length())+
                    "| "+ password.getCategory() + " ".repeat(col-password.getCategory().length()) +"|");
            this.label.draw();
        }
        drawFooter();
        new MainPage("Aplikasi Password Vault", this.width).draw();
    }


    public void drawFooter(){
        this.space.draw();
        this.hline.draw();
    }
}
