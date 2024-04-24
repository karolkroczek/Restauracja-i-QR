package com.example.backend.Order;

import com.example.backend.Dish.Dish;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ToString
public class OrderPojo implements Order {
    @Getter
    private List<Dish> dishList = new ArrayList<Dish>();
    int totalValue = 0;


    public OrderPojo(List<Dish> dishList){
        this.dishList = dishList;
        this.totalValue = calculateTotalValue();
    }
    @Override
    public int getTotalValue() {
        return totalValue;
    }
    @Override
    public void addDish(Dish dish){
        dishList.add(dish);
        totalValue += dish.getPrice();
    }
    @Override
    public void removeDish(int id){
        dishList.remove(id);
        totalValue -= dishList.get(id).getPrice();
    }
    @Override
    public void endOrder(){
        totalValue = 0;
        dishList.clear();
    }

    public int calculateTotalValue(){
        for (Dish dish :
                dishList) {
            totalValue += dish.getPrice();
        }
        return totalValue;
    }

}
