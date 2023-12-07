package vendingmachine;

import vendingmachine.controller.VedingMachineController;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        VedingMachineController vedingMachineController = new VedingMachineController(new InputView(),
                new OutputView());
        vedingMachineController.run();
    }
}
