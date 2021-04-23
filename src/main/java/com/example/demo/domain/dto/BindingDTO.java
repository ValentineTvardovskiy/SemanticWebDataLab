package com.example.demo.domain.dto;

public class BindingDTO {

    private ItemDTO item;
    private ItemLabelDTO itemLabel;

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public ItemLabelDTO getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(ItemLabelDTO itemLabel) {
        this.itemLabel = itemLabel;
    }

    @Override
    public String toString() {
        return "BindingDTO{" +
                "item=" + item +
                ", itemLabel=" + itemLabel +
                '}';
    }
}
