package Views;

import controllers.FuramaController;

public class FuramaApp {
    public static void main(String[] args) {
        FuramaController furamaController = new FuramaController();
        furamaController.displayMainMenu();
    }
}
