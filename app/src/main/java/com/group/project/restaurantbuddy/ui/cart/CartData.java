package com.group.project.restaurantbuddy.ui.cart;

import java.util.ArrayList;
import java.util.List;

public class CartData {

    private static List<String[]> cartData = new ArrayList<>();

    public static void addToCard(String[] newData){
        cartData.add(newData);
    }

    public static List<String[]> getCardData(){
        return cartData;
    }

    public static boolean emptyCard(){
        cartData.clear();
        if (cartData.isEmpty())
            return true;
        return false;
    }

}
