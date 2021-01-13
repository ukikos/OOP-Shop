package program.products;

public enum ProductType {
    ALCOHOL,
    BREAD,
    CHEESE,
    CLOTHES,
    DRINK,
    FISH,
    MEAT,
    MILK,
    PAPERS,
    SAUSAGE,
    SEAFOOD,
    SPICES,
    SWEETIES,
    TOILETRY,
    VEGETABLES;

    @Override
    public String toString() {
        return this.name();
    }
}
