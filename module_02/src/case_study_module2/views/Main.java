package case_study_module2.views;


import case_study_module2.controllers.FuramaController;

import java.io.IOException;

import static case_study_module2.controllers.FuramaController.displayMainMenu;

public class Main {
    public static void main(String[] args) throws IOException {
        FuramaController.displayMainMenu();
    }
}