package com.mypractice.hot.cold.publisher;

import com.mypractice.util.Util;

public class PurchaseOrder {
    private String item;
    private double price;
    private String category;
    private int qty;

    public PurchaseOrder() {
        this.item = Util.faker().commerce().productName();
        this.price = Double.parseDouble(Util.faker().commerce().price());
        this.category = Util.faker().commerce().department();
        this.qty = Util.faker().random().nextInt(1, 10);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "item='" + item + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", qty=" + qty +
                '}';
    }
}
