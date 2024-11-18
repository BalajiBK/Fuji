package fujiaut.datamodels;

import java.util.ArrayList;
import java.util.List;

public class products_catalog {
    private List<product> products = new ArrayList<>();

    public void addProduct(product item) {
        products.add(item);
    }

    public List<product> getProducts() {
        return products;
    }
}
