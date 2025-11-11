package fluentpizzabuilder.Builders;

public class ParmiggianaBuilder extends BasePizzaBuilder<ParmiggianaBuilder> {
    @Override
    protected ParmiggianaBuilder self() {
        return this;
    }

    @Override
    public ParmiggianaBuilder addDefaultToppings() {
        return this
                .add("Tomato sauce")
                .add("Mozzarella")
                .add("Aubergine")
                .add("Grana Padano cheese")
                .add("Basil leaves");
    }

}
