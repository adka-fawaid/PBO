package id.my.adkafawaid.moduls.App;

import id.my.adkafawaid.moduls.Data.DataPassword;
import id.my.adkafawaid.moduls.Page.MainPage;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args)throws Exception {
        DataPassword.loadCSVData();
        new MainPage("Aplikasi Password Vault", 70).draw();
    }
}