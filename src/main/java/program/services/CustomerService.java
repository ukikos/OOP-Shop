package program.services;

import program.Customer;
import program.Storage;
import program.products.ProductType;

import java.util.*;

public class CustomerService {
    public Map<ProductType, Integer> generateSimpleDesires() {
        ProductService generator = new ProductService();
        HashMap<ProductType, Integer> scaleOfDesires = new HashMap<>();
        int n = (int) (Math.random() * (generator.getCountOfProductTypes() - 3));
        for (int i = 0; i < n; i++) {
            scaleOfDesires.put(generator.getRandomProductType(), (int) (Math.random() * (9 - 3)));
        }
        return scaleOfDesires;
    }

    public void serveCustomer(List<Customer> customers, Storage shop) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer c = iterator.next();
            for (Map.Entry<ProductType, Integer> entry :
                    c.getScaleOfDesires().entrySet()) {
                if (shop.getCountableMap().containsKey(entry.getKey())
                        && entry.getValue() > 0
                        && shop.getCountableMap().get(entry.getKey()).getQuantity() > 0) {
                    int q = shop.getCountableMap().get(entry.getKey()).getPartialWeight();
                    int Q = shop.getCountableMap().get(entry.getKey()).getQuantity();
                    shop.getCountableMap().get(entry.getKey()).setQuantity(q < entry.getValue() ? Q - (entry.getValue() / q + 1) : Q - q);
                } else if (shop.getUncountableMap().containsKey(entry.getKey())
                        && entry.getValue() > 0
                        && shop.getUncountableMap().get(entry.getKey()).getWeight() > 0) {
                    int Q = shop.getUncountableMap().get(entry.getKey()).getWeight();
                    shop.getUncountableMap().get(entry.getKey()).setWeight(Q < entry.getValue() ? 0 : Q - entry.getValue());
                }
            }
            iterator.remove();
        }
    }

    public List<Customer> generateCustomers() {
        List<Customer> list = new LinkedList<>();
        int n = (int) (Math.random() * (10 - 1) + 1);
        for (int i = 0; i < n; i++) {
            list.add(new Customer((int) (Math.random() * (3500 - 500))));
        }
        return list;
    }
}