package fluentpizzabuilder;

import fluentpizzabuilder.enums.DoughType;
import fluentpizzabuilder.enums.SizeType;

public class Main {
    public static void main(String[] args){
        Pizzaiolo pizzaiolo = new Pizzaiolo();

        MargheritaBuilder margheritaBuilder = new MargheritaBuilder();
        ParmiggianaBuilder parmiggianaBuilder = new ParmiggianaBuilder();
        ProsciuttoEFunghiBuilder prosciuttoEFunghiBuilder = new ProsciuttoEFunghiBuilder();

        Pizza margherita = pizzaiolo.make(margheritaBuilder, SizeType.LARGE, DoughType.NEAPOLITAN);
        Pizza parmiggiana = pizzaiolo.make(parmiggianaBuilder, SizeType.MEDIUM, DoughType.CLASSIC);
        Pizza prosciuttoEFunghi = pizzaiolo.make(prosciuttoEFunghiBuilder, SizeType.SMALL, DoughType.GLUTENFREE);

        Pizza customPizza = new MargheritaBuilder()
                .size(SizeType.MEDIUM)
                .dough(DoughType.NEAPOLITAN)
                .addDefaultToppings()
                .add("Mushrooms")
                .add("Olives")
                .add("Bacon")
                .build();

        System.out.println(margherita);
        System.out.println(parmiggiana);
        System.out.println(prosciuttoEFunghi);
        System.out.println(customPizza);
    }
}
