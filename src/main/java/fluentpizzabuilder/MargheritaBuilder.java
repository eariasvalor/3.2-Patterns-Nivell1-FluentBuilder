package fluentpizzabuilder;

public class MargheritaBuilder extends BasePizzaBuilder<MargheritaBuilder> {
    @Override
    protected MargheritaBuilder self() {
        return this;
    }

    @Override
    public MargheritaBuilder addDefaultToppings() {
        return this
                .add("Tomato sauce")
                .add("Mozzarella")
                .add("Basil leaves");
    }

}
