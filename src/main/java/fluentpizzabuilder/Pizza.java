package fluentpizzabuilder;

import pizzabuilder.enums.DoughType;
import pizzabuilder.enums.PizzaType;
import pizzabuilder.enums.SizeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza {
    private PizzaType type;
    private SizeType size;
    private DoughType dough;
    private List<String> toppings;

    public Pizza(){};

    public Pizza(PizzaType type, SizeType size, DoughType dough, List<String> toppings) {
        this.type = type;
        this.size = size;
        this.dough = dough;
        this.toppings = new ArrayList<>();
    }

    public String getType(){
        return type.name();
    }

    public String getSize() {
        return size.name();
    }

    public String getDough() {
        return dough.name();
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
                "type=" + type.name() +
                "size=" + size.name() +
                ", dough='" + dough.name() + '\'' +
                ", toppings=" + getToppings() +
                '}';
    }


}
