package fluentpizzabuilder;

import fluentpizzabuilder.enums.DoughType;
import fluentpizzabuilder.enums.SizeType;

public abstract class BasePizzaBuilder<T extends BasePizzaBuilder<T>> implements PizzaBuilder {
    protected Pizza pizza = new Pizza();

    protected abstract T self();

    @Override
    public T size(SizeType size) {
        pizza.setSize(size);
        return self();
    }

    @Override
    public T dough(DoughType dough) {
        pizza.setDough(dough);
        return self();
    }

    @Override
    public T add(String topping) {
        pizza.addTopping(topping);
        return self();
    }

    @Override
    public abstract T addDefaultToppings();

    @Override
    public Pizza build() {
        Pizza result = this.pizza;
        this.pizza = new Pizza();
        return result;
    }
}
