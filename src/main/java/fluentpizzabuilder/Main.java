package fluentpizzabuilder;

import fluentpizzabuilder.Builders.CustomPizzaBuilder;
import fluentpizzabuilder.Builders.MargheritaBuilder;
import fluentpizzabuilder.Builders.ParmiggianaBuilder;
import fluentpizzabuilder.Builders.ProsciuttoEFunghiBuilder;
import fluentpizzabuilder.entity.Pizza;
import fluentpizzabuilder.enums.DoughType;
import fluentpizzabuilder.enums.SizeType;

public class Main {
    public static void main(String[] args){
        MargheritaBuilder builder = new MargheritaBuilder();
        ProsciuttoEFunghiBuilder prosciuttoEFunghiBuilder = new ProsciuttoEFunghiBuilder();
        ParmiggianaBuilder parmiggianaBuilder = new ParmiggianaBuilder();
        CustomPizzaBuilder customPizzaBuilder = new CustomPizzaBuilder();

        Pizza margherita = builder
                .size(SizeType.MEDIUM)
                .dough(DoughType.NEAPOLITAN)
                .addDefaultToppings()
                .build();


        Pizza prosciuttoEFunghi = prosciuttoEFunghiBuilder
                .size(SizeType.SMALL)
                .dough(DoughType.GLUTENFREE)
                .addDefaultToppings()
                .build();

        Pizza parmiggiana = parmiggianaBuilder
                .size(SizeType.LARGE)
                .dough(DoughType.CLASSIC)
                .addDefaultToppings()
                .build();

        Pizza customPizza = customPizzaBuilder
                .size(SizeType.SMALL)
                .dough(DoughType.NEAPOLITAN)
                .add("Tomato")
                .add("Mozzarella")
                .add("Bacon")
                .add("Onion")
                .add("Olives")
                .build();


        System.out.println("Pizza is ready! " + margherita);
        System.out.println("Pizza is ready! " + prosciuttoEFunghi);
        System.out.println("Pizza is ready! " + parmiggiana);
        System.out.println("Pizza is ready! " + customPizza);

    }
}
