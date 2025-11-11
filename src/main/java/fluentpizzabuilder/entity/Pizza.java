package fluentpizzabuilder.entity;


import fluentpizzabuilder.enums.DoughType;
import fluentpizzabuilder.enums.PizzaType;
import fluentpizzabuilder.enums.SizeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza {
    private PizzaType type;
    private SizeType size;
    private DoughType dough;
    private List<String> toppings = new ArrayList<>();

    public Pizza(){
        this.toppings = new ArrayList<>();
    };

    public Pizza(PizzaType type, SizeType size, DoughType dough, List<String> toppings) {
        if(type == null) {throw new IllegalArgumentException("The pizza type cannot be null.");}
        if(size == null) {throw new IllegalArgumentException("The pizza size cannot be null.");}
        if(dough == null) {throw new IllegalArgumentException("The pizza dough cannot be null.");}
        if(toppings == null) {throw new IllegalArgumentException("The toppings list cannot be null.");}
        this.type = type;
        this.size = size;
        this.dough = dough;
        this.toppings = toppings;
    }

    public String getType(){
        return type.name();
    }

    public SizeType getSize() {
        return this.size;
    }

    public DoughType getDough() {
        return this.dough;
    }

    public List<String> getToppings(){
        return Collections.unmodifiableList(toppings);
    }


    public void setSize(SizeType size){
        this.size = size;
    }

    public void setDough(DoughType dough){
        this.dough = dough;
    }

   public void addTopping(String topping){
        toppings.add(topping);
   }


    @Override
    public String toString() {
        return "Pizza{" +
                "size=" + size.name() +
                ", dough='" + dough.name() + '\'' +
                ", toppings=" + getToppings() +
                '}';
    }


}
