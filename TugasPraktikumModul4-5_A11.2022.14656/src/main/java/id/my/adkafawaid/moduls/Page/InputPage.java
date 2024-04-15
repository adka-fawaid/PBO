package id.my.adkafawaid.moduls.Page;

import id.my.adkafawaid.moduls.Output.*;
import id.my.adkafawaid.moduls.Input.*;
import id.my.adkafawaid.moduls.Data.*;

import static id.my.adkafawaid.moduls.Data.DataPassword.passData;

public class InputPage {
    public String title;
    public int width;
    private final HLine hline;
    private final Space space;
    private final Label label;

    public InputPage(String title, int width){
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
        String judul, username, password;
        String [] category = {"Belum terkategori","Aplikasi web", "Aplikasi mobile", "Akun lainnya"};
        SelectInput categorySelect = new SelectInput("Kategori", category, this.width);
        this.label.text = "Inputan Password Baru";
        this.label.draw();
        Input inputJudul = new Input("Judul Password : ");
        inputJudul.draw();
        judul = inputJudul.getValue();
        Input inputUsername = new Input("Username : ");
        inputUsername.draw();
        username = inputUsername.getValue();
        Input inputPassword = new Input("Password : ");
        inputPassword.draw();
        password = inputPassword.getValue();
        categorySelect.draw();
        int cat = categorySelect.getValue();
        PasswordStore data = new PasswordStore(judul, username, password, cat-1);
        passData.add(data);
        this.label.text = "---- ----";
        this.label.draw();
        this.label.text = "Input password berhasil dibuat";
        this.label.draw();
        drawFooter();
        new MainPage("Aplikasi Password Vault", this.width).draw();
    }

    public void drawFooter(){
        this.space.draw();
        this.hline.draw();
    }
}
