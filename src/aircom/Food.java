/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;

import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author User
 */
public class Food {
    
    private String foodItem; 
    //private int price;

    public Food(String foodItem) {
        this.foodItem = foodItem;
    }

    @Override
    public String toString() {
        return foodItem;
    }

     
   
    public String getFoodItem() {
        return foodItem;
    }

   
    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.foodItem);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Food other = (Food) obj;
        if (!Objects.equals(this.foodItem, other.foodItem)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
            
    
            
    

    
}
