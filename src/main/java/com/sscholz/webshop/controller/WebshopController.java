package com.sscholz.webshop.controller;

import com.sscholz.webshop.model.CartItem;
import com.sscholz.webshop.model.ShopItem;
import com.sscholz.webshop.service.CartItemService;
import com.sscholz.webshop.service.ShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebshopController {

    @Autowired
    CartItemService cartItemService;
    @Autowired
    ShopItemService shopItemService;

    @GetMapping(value = {"/shop", "shop.html"})
    public String shop(Model model) {
        //list with Items
        List<ShopItem> itemList = shopItemService.getItemList();
        model.addAttribute("shopItemList", itemList);

        return "shop";
    }

    @PostMapping(value = {"/shop", "shop.html"})
    public String submitShopItem(
            @RequestParam(value = "itemId") Integer itemId,
            @RequestParam(value = "quantity") Integer quantity) {

        CartItem cartItem = cartItemService.getCartItemByShopItemId(itemId);
        if (cartItem == null)
            cartItem = new CartItem();

        ShopItem shopItem = shopItemService.getItemById(itemId);
        cartItem.setShopItem(shopItem);
        if (cartItem.getQuantity() != null && cartItem.getQuantity() > 0) {
            Integer oldQty = cartItem.getQuantity();
            cartItem.setQuantity(oldQty+quantity);
        } else {
            cartItem.setQuantity(quantity);
        }

        cartItemService.saveItem(cartItem);

        return "redirect:/shop";
    }

    @GetMapping(value = {"/cart", "cart.html"})
    public String cart(Model model) {
        //list with Items
        List<CartItem> itemList = cartItemService.getItemList();
        model.addAttribute("cartItemList", itemList);

        return "cart";
    }

    @PostMapping(value = {"/cart", "cart.html"})
    public String submitCartDeleteItem(
            @RequestParam(value = "cartItemId") Integer cartItemId,
            @RequestParam(value = "quantity") Integer quantity) {

        CartItem cartItem = cartItemService.getItemById(cartItemId);

        cartItemService.deleteItem(cartItem);

        return "redirect:/cart";
    }

}
