package program;

import com.google.gson.annotations.SerializedName;
import program.products.Countable;
import program.products.ProductType;
import program.products.Uncountable;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    @SerializedName("countable products")
    private Map<ProductType, Countable> countableMap;
    @SerializedName("uncountable products")
    private Map<ProductType, Uncountable> uncountableMap;

    public Storage() {
        countableMap = new HashMap<>();
        uncountableMap = new HashMap<>();
    }

    public void setCountableMap(Map<ProductType, Countable> countableMap) {
        this.countableMap = countableMap;
    }

    public void setUncountableMap(Map<ProductType, Uncountable> uncountableMap) {
        this.uncountableMap = uncountableMap;
    }

    public Map<ProductType, Countable> getCountableMap() {
        return countableMap;
    }

    public Map<ProductType, Uncountable> getUncountableMap() {
        return uncountableMap;
    }
}