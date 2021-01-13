package program.products;

public class Countable {
    private String name;
    private ProductType productType;
    private int price, partialWeight, quantity, expirationDays;
    transient private boolean isDiscounted = false;

    public Countable(String name, ProductType productType, int price, int partialWeight, int quantity, int expirationDays) {
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.partialWeight = partialWeight;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPartialWeight() {
        return partialWeight;
    }

    public void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }
}
