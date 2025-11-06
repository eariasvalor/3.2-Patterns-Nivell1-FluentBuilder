package fluentpizzabuilder;

import fluentpizzabuilder.enums.DoughType;
import fluentpizzabuilder.enums.SizeType;

public interface PizzaBuilder<T extends PizzaBuilder<T>> {
    T size(SizeType size);
    T dough(DoughType dough);
    T add(String topping);
    T addDefaultToppings();
    Pizza build();
}
