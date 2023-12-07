package vendingmachine.controller;

import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.model.Item;
import vendingmachine.model.Items;
import vendingmachine.model.vo.Money;
import vendingmachine.util.InputValidator;
import vendingmachine.util.StringUtil;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VedingMachineController {

    private final InputView inputView;
    private final OutputView outputView;

    public VedingMachineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Money money = initVendingMachineMoney();
        Items items = initItems();
    }

    private Items initItems() {
        while (true) {
            try {
                String itemsInfo = inputView.readItemInformation();
                InputValidator.validateItemsInfo(itemsInfo);
                List<String> items = StringUtil.convertStringToListByItemsDelimiter(itemsInfo);
                return getItemByInput(items);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private static Items getItemByInput(List<String> items) {
        return new Items(items.stream()
                .map(item -> {
                    List<String> itemInfo = StringUtil.convertStringToListByInfoDelimiter(item);
                    InputValidator.validateItemInfo(item);
                    return itemInfo;
                })
                .map(itemInfo -> Item.create(itemInfo.get(0), itemInfo.get(1), itemInfo.get(2)))
                .collect(Collectors.toList()));
    }

    private Money initVendingMachineMoney() {
        while (true) {
            try {
                String amount = inputView.readVendingMachineAmount();
                InputValidator.validateMoney(amount);
                return new Money(StringUtil.convertStringToInteger(amount));
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
