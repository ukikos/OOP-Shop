package program.products;

public class Uncountable {
    private String name;
    private ProductType productType;
    private int price, weight, expirationDays;
    transient private boolean isDiscounted;

    public Uncountable(String name, ProductType productType, int price, int weight, int expirationDays) {
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.weight = weight;
        this.expirationDays = expirationDays;
    }

    public ProductType getProductType() {
        return productType;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getExpirationDays() {
        return expirationDays;
    }

    public void setExpirationDays(int expirationDays) {
        this.expirationDays = expirationDays;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }
}
