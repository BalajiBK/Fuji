package fujiaut.datamodels;

public class product {
//    | item Name                      | Size | Quantity | Total | Category         |
//            | Men's Tech Shell Full-Zip      | XL   | 2        | 50.20 | Men's Outerwear  |
//            | Ladies Modern Stretch Full Zip | XS   | 3        | 41.60 | Ladies Outerwear |

    private String itemName;
    private String size;
    private String quantity;
    private String total;
    private String category;

    public product(String itemName, String size, String quantity, String total, String category) {
        this.itemName = itemName;
        this.size = size;
        this.quantity = quantity;
        this.total = total;
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public String getSize() {
        return size;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getTotal() {
        return total;
    }

    public String getCategory() {
        return category;
    }

}
