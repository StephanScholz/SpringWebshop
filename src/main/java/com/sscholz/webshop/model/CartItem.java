package com.sscholz.webshop.model;

import javax.persistence.*;

@Entity
@Table(name = "shop_cart")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "item_id")
    private ShopItem shopItem;

    @Column(name = "item_qty")
    private Integer quantity;

    public CartItem() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ShopItem getShopItem() {
        return shopItem;
    }

    public void setShopItem(ShopItem shopItem) {
        this.shopItem = shopItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer qty) {
        this.quantity = qty;
    }
}
