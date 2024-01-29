package hello.itemservice.domain.item;

import lombok.Data;

@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quality;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quality) {
        this.itemName = itemName;
        this.price = price;
        this.quality = quality;
    }
}
