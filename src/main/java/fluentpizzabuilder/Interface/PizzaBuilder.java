package fluentpizzabuilder.Interface;

import fluentpizzabuilder.entity.Pizza;
import fluentpizzabuilder.enums.DoughType;
import fluentpizzabuilder.enums.SizeType;

public interface PizzaBuilder<T extends PizzaBuilder<T>> {
    public T size(SizeType size);
    public T dough(DoughType dough);
    public T add(String topping);
    public T addDefaultToppings();
    public Pizza build();
}
