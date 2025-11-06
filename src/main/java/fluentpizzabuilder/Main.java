package fluentpizzabuilder;

import fluentpizzabuilder.enums.DoughType;
import fluentpizzabuilder.enums.SizeType;

public class Main {
    public static void main(String[] args){
        BasePizzaBuilder<MargheritaBuilder> marguerita = new MargheritaBuilder();
        marguerita
                .size(SizeType.MEDIUM)
                .dough(DoughType.NEAPOLITAN)
                .build()
                .toString();
    }
}
