package fluentpizzabuilder.Builders;

public class CustomPizzaBuilder extends BasePizzaBuilder<CustomPizzaBuilder> {

    protected CustomPizzaBuilder self() {
        return this;
    }

    public CustomPizzaBuilder addDefaultToppings(){
        return this;
    }
}
