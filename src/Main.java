import controller.AtmController;
import controller.impl.AtmControllerImpl;
import myinterface.AtmAttention;

public class Main {
    public static void main(String[] args) {
        AtmController atmController = new AtmControllerImpl();
        AtmAttention atmAttention = new AtmAttention(atmController);
        atmAttention.pack();
        atmAttention.setVisible(true);
    }
}