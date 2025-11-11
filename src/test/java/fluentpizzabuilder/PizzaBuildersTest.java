package fluentpizzabuilder;

import fluentpizzabuilder.Builders.CustomPizzaBuilder;
import fluentpizzabuilder.Builders.MargheritaBuilder;
import fluentpizzabuilder.Builders.ParmiggianaBuilder;
import fluentpizzabuilder.Builders.ProsciuttoEFunghiBuilder;
import fluentpizzabuilder.entity.Pizza;
import fluentpizzabuilder.enums.DoughType;
import fluentpizzabuilder.enums.SizeType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PizzaBuildersTest {

    @Test
    @DisplayName("Margherita: default toppings and fields are set")
    void margheritaDefaults() {
        Pizza p = new MargheritaBuilder()
                .size(SizeType.MEDIUM)
                .dough(DoughType.NEAPOLITAN)
                .addDefaultToppings()
                .build();

        assertEquals(SizeType.MEDIUM, p.getSize());
        assertEquals(DoughType.NEAPOLITAN, p.getDough());

        List<String> tops = p.getToppings();
        assertTrue(tops.contains("Tomato sauce"));
        assertTrue(tops.contains("Mozzarella"));
        assertTrue(tops.stream().anyMatch(t -> t.toLowerCase().contains("basil")));
    }

    @Test
    @DisplayName("Prosciutto e Funghi: default toppings include ham and mushrooms")
    void prosciuttoEFunghiDefaults() {
        Pizza p = new ProsciuttoEFunghiBuilder()
                .size(SizeType.LARGE)
                .dough(DoughType.CLASSIC)
                .addDefaultToppings()
                .build();

        assertEquals(SizeType.LARGE, p.getSize());
        assertEquals(DoughType.CLASSIC, p.getDough());
        assertTrue(p.getToppings().stream().anyMatch(t -> t.toLowerCase().contains("prosciutto")));
        assertTrue(p.getToppings().stream().anyMatch(t -> t.toLowerCase().contains("mushroom")));
    }

    @Test
    @DisplayName("Parmiggiana defaults contain aubergine")
    void parmiggianaDefaults() {
        Pizza pizza = new ParmiggianaBuilder()
                .size(SizeType.SMALL)
                .dough(DoughType.GLUTENFREE)
                .addDefaultToppings()
                .build();

        assertEquals(SizeType.SMALL, pizza.getSize());
        assertEquals(DoughType.GLUTENFREE, pizza.getDough());
        assertTrue(pizza.getToppings().stream().anyMatch(t -> t.toLowerCase().contains("aubergine")));
        assertTrue(pizza.getToppings().size() >= 2);
    }

    @Test
    @DisplayName("CustomPizzaBuilder allows arbitrary toppings without defaults")
    void customNoDefaults() {
        Pizza p = new CustomPizzaBuilder()
                .size(SizeType.LARGE)
                .dough(DoughType.CLASSIC)
                .add("Tomato sauce")
                .add("Mozzarella")
                .add("Pepperoni")
                .build();

        assertEquals(SizeType.LARGE, p.getSize());
        assertEquals(DoughType.CLASSIC, p.getDough());
        assertEquals(List.of("Tomato sauce", "Mozzarella", "Pepperoni"), p.getToppings());
    }

    @Test
    @DisplayName("Fluent chain returns the same builder type (self types)")
    void selfTypes() {
        MargheritaBuilder b = new MargheritaBuilder()
                .size(SizeType.SMALL)
                .dough(DoughType.NEAPOLITAN)
                .add("X")
                .addDefaultToppings();

        assertNotNull(b);
    }

    @Test
    @DisplayName("Build resets internal builder state (second build is a fresh pizza)")
    void buildResetsState() {
        MargheritaBuilder b = new MargheritaBuilder();

        Pizza first = b.size(SizeType.SMALL)
                .dough(DoughType.CLASSIC)
                .add("One")
                .build();

        Pizza second = b.build();
        assertNotSame(first, second);
        assertEquals(SizeType.SMALL, first.getSize());
        assertEquals(DoughType.CLASSIC, first.getDough());
        assertEquals(List.of("One"), first.getToppings());


        assertTrue(second.getToppings().isEmpty());
        assertNull(second.getSize());
        assertNull(second.getDough());
    }

    @Test
    @DisplayName("toString does not crash on a fully defined pizza")
    void toStringSafe() {
        Pizza p = new CustomPizzaBuilder()
                .size(SizeType.MEDIUM)
                .dough(DoughType.CLASSIC)
                .add("Tomato")
                .build();

        String s = p.toString();
        assertNotNull(s);
        assertFalse(s.isBlank());
        assertTrue(s.contains("CLASSIC"));
        assertTrue(s.contains("MEDIUM"));
    }
}
