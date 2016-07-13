/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aircom;
import java.util.Objects;

/**
 *
 * @author Mtilla
 */
public class Food {
    
    //Contains only one private field
    private String foodItem; 
    private int price;
    

    //Constructor:
    public Food(String foodItem, int price) {
        this.foodItem = foodItem;
        this.price= price;
    }
    
    public Food(String foodItem){
        this.foodItem = foodItem;
    }
    
    //Getter n Setter:
    public String getFoodItem() {
        return foodItem;
    }
    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    //OVERRIDDEN Object methods:
    @Override
    public String toString() {
        return foodItem;
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
