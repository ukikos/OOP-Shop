package program.services;

import program.Storage;
import program.Supermarket;
import program.products.Countable;
import program.products.ProductType;
import program.products.Uncountable;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

public class ProductService {
    private final Map<ProductType, Integer> expMap = initExpMap();

    ProductType getRandomProductType() {
        return ProductType.values()[(int) (Math.random() * (ProductType.values().length - 0.5))];
    }

    int getCountOfProductTypes() {
        return ProductType.values().length;
    }

    private int getExpirationDays(ProductType productType) {
        return expMap.get(productType);
    }

    public void decreaseExpirationDays(Supermarket supermarket) {
        Consumer<Map<ProductType, Countable>> countable = countableMap -> {
            for (Countable p : countableMap.values()) {
                p.setExpirationDays(p.getExpirationDays() - 1);
            }
        };
        Consumer<Map<ProductType, Uncountable>> uncountable = uncountableMap -> {
            for (Uncountable p : uncountableMap.values()) {
                p.setExpirationDays(p.getExpirationDays() - 1);
            }
        };
        Consumer<Storage> decreaseExp = storage -> {
            countable.accept(storage.getCountableMap());
            uncountable.accept(storage.getUncountableMap());
        };

        decreaseExp.accept(supermarket.getShop());
        decreaseExp.accept(supermarket.getStock());
    }

    public Storage generateProducts() {
        Storage admission = new Storage();
        Map<ProductType, Countable> countableMap = new HashMap<>();
        Map<ProductType, Uncountable> uncountableMap = new HashMap<>();
        int n = (int) (Math.random() * (10 - 3) + 1);
        for (int i = 0; i < n; i++) {
            ProductType type = this.getRandomProductType();
            countableMap.put(type, new Countable(type.toString(), type, //название, тип
                    (int) (Math.random() * (1000 - 50)),  //цена
                    (int) (Math.random() * (5) + 1),      //вес
                    (int) (Math.random() * (300 - 100)),  //количество
                    this.getExpirationDays(type)    //срок годности
            ));
        }
        n = (int) (Math.random() * (10 - 3) + 1);
        for (int i = 0; i < n; i++) {
            ProductType type = this.getRandomProductType();
            uncountableMap.put(type, new Uncountable(type.toString(), type, //название, тип
                    (int) (Math.random() * (1000 - 50)),    //цена
                    (int) (Math.random() * (300 - 100)),    //вес
                    this.getExpirationDays(type)   // срок годности
            ));
        }
        admission.setCountableMap(countableMap);
        admission.setUncountableMap(uncountableMap);
        return admission;
    }

    private Map<ProductType, Integer> initExpMap() {
        Map<ProductType, Integer> result = new HashMap<>();
        try (FileReader reader = new FileReader("./src/main/resources/products.txt")) {
            Scanner scn = new Scanner(reader);
            String text = "";
            while (scn.hasNextLine()
            ) {
                text = text.concat(scn.nextLine() + "\n");
            }
            String[] parts = text.split("\n");
            for (String s :
                    parts) {
                String[] pair = s.split(" ");
                result.put(ProductType.valueOf(pair[0].toUpperCase()), Integer.parseInt(pair[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}