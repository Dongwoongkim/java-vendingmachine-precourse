package vendingmachine.controller;

import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.model.Item;
import vendingmachine.model.Items;
import vendingmachine.model.vo.Money;
import vendingmachine.model.vo.Name;
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
        // TODO : 잔돈 생성

        // TODO : 잔돈 정보 출력

        Items items = initItems();
        Money insertMoney = initInsertMoney();

        while (true) {
            showInsertMoney(insertMoney);
            Item item = initBuyItem(items);

            if (insertMoney.isLessThanAmount(items.getLowestAmount()) || !item.isPurchaseAble()) {
                showInsertMoney(insertMoney);
                // TODO : 잔돈 출력

                break;
            }

            item.purchase();
            insertMoney.decrease(item.getAmount());
        }
    }

    private void showInsertMoney(Money insertMoney) {
        outputView.printVendingMachineInsertMoney(insertMoney.getAmount());
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

    private Money initInsertMoney() {
        while (true) {
            try {
                String amount = inputView.readInsertMoney();
                InputValidator.validateMoney(amount);
                return new Money(StringUtil.convertStringToInteger(amount));
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Item initBuyItem(Items items) {
        while (true) {
            try {
                String itemName = inputView.readBuyItem();
                InputValidator.validateBuyItemName(itemName);
                Name buyItemName = Name.create(itemName);
                return items.getBuyItem(buyItemName);
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
}
