package program.utils;

import program.Storage;
import program.products.Countable;
import program.products.ProductType;
import program.products.Uncountable;

import java.util.Map;

public class OutputUtils {
    private void printWarehouse(Storage storage) {
        System.out.println("Товар\tКоличество\tВес\tЦена\tСрок годности");
        for (Map.Entry<ProductType, Countable> entry :
                storage.getCountableMap().entrySet()) {
            System.out.println(entry.getKey().toString() + "\t\t" + entry.getValue().getQuantity() + "\t\t" + entry.getValue().getPartialWeight() +
                    "\t\t" + entry.getValue().getPrice() + "\t\t" + entry.getValue().getExpirationDays());
        }
        for (Map.Entry<ProductType, Uncountable> entry :
                storage.getUncountableMap().entrySet()) {
            System.out.println(entry.getKey().toString() + "\tНеКолич\t\t" + entry.getValue().getWeight() +
                    "\t\t" + entry.getValue().getPrice() + "\t\t" + entry.getValue().getExpirationDays());
        }
        System.out.println();
    }

    private void printLine() {
        for (int i = 0; i < 49; i++)
            System.out.print("-");
        System.out.println("-");
    }

    public void printResult(String event, Storage storage) {
        System.out.println(event);
        System.out.println();
        this.printWarehouse(storage);
        this.printLine();
    }

    public void printCustomers(String type, int diff, int after) {
        System.out.println(type + ": " + (diff > 0 ? "+ " : "") + diff + " посетителей");
        System.out.println("Сейчас " + after + " посетителей в супермаркете");
        this.printLine();
    }

    public void printDayPassed() {
        System.out.println("КОНЕЦ РАБОЧЕГО ДНЯ");
        this.printLine();
    }
}
