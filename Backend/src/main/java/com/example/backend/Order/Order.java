package com.example.backend.Order;

import com.example.backend.Dish.Dish;


public interface Order {
    int getTotalValue();
     void addDish(Dish dish);
     void removeDish(int id);
     void endOrder();
}
