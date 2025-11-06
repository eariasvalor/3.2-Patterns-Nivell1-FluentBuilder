package fluentpizzabuilder;


public class ProsciuttoEFunghiBuilder extends BasePizzaBuilder<ProsciuttoEFunghiBuilder> {
    @Override
    protected ProsciuttoEFunghiBuilder self() {
        return this;
    }

    @Override
    public ProsciuttoEFunghiBuilder addDefaultToppings() {
        return this
                .add("Tomato sauce")
                .add("Mozzarella")
                .add("Prosciutto ham")
                .add("Mushrooms")
                .add("Basil leaves");
    }
}
