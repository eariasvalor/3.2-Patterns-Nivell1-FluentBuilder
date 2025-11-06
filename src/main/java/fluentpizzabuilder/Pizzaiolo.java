package fluentpizzabuilder;

import fluentpizzabuilder.enums.DoughType;
import fluentpizzabuilder.enums.SizeType;

public class Pizzaiolo {
    public Pizza make(PizzaBuilder<?> builder, SizeType size, DoughType dough) {
        return builder
                .size(size)
                .dough(dough)
                .addDefaultToppings()
                .build();
    }


    public Pizza makeWithExtraCheese(PizzaBuilder<?> builder, SizeType size, DoughType dough) {
        return builder
                .size(size)
                .dough(dough)
                .addDefaultToppings()
                .add("Extra mozzarella")
                .build();
    }
}
