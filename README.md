# Task S3.01 – Design Patterns (Level 1)

## Description
In this exercise, I implemented the **Builder** design pattern to create a modular and extensible **pizza order management system** in Java.  
The system allows creating different types of pizzas (such as *Margherita*, *Parmiggiana*, *Prosciutto e Funghi*, and *custom pizzas*) with configurable **size**, **dough type**, and **toppings**.  

The Builder pattern makes the creation process **flexible**, **readable**, and **extensible**, allowing new pizza types to be added easily without modifying existing code.

---

## Project Structure
```
3.2-Patterns-Nivell1-FluentBuilder/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── fluentpizzabuilder/
│   │   │       ├── Builders/
│   │   │       │   ├── BasePizzaBuilder.java
│   │   │       │   ├── CustomPizzaBuilder.java
│   │   │       │   ├── MargheritaBuilder.java
│   │   │       │   ├── ParmiggianaBuilder.java
│   │   │       │   └── ProsciuttoEFunghiBuilder.java
│   │   │       ├── entity/
│   │   │       │   └── Pizza.java
│   │   │       ├── enums/
│   │   │       │   ├── DoughType.java
│   │   │       │   ├── PizzaType.java
│   │   │       │   └── SizeType.java
│   │   │       ├── Interface/
│   │   │       │   └── PizzaBuilder.java
│   │   │       └── Main.java
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   └── fluentpizzabuilder/
│       │       └── PizzaBuildersTest.java
│       └── resources/
│
├── .gitignore
├── pom.xml
└── README.md
```

---

## Functionality
The program allows users to build pizzas step by step using a fluent interface.  
Each **builder class** defines a specific pizza type with its own **default toppings**, while the **CustomPizzaBuilder** lets users compose a pizza freely.

### Example of console output
```
Pizza is ready! Pizza{size=MEDIUM, dough=NEAPOLITAN, toppings=[Tomato sauce, Mozzarella, Basil leaves]}
Pizza is ready! Pizza{size=SMALL, dough=GLUTENFREE, toppings=[Tomato sauce, Mozzarella, Prosciutto ham, Mushrooms, Basil leaves]}
Pizza is ready! Pizza{size=LARGE, dough=CLASSIC, toppings=[Tomato sauce, Mozzarella, Aubergine, Grana Padano cheese, Basil leaves]}
Pizza is ready! Pizza{size=SMALL, dough=NEAPOLITAN, toppings=[Tomato, Mozzarella, Bacon, Onion, Olives]}
```

---

## Design Pattern Used: Builder

The **Builder pattern** separates the construction of a complex object (in this case, a `Pizza`) from its representation, allowing the same creation process to produce different representations.

### Key components
| Component | Description |
|------------|--------------|
| `Pizza` | The product class containing the pizza’s attributes: size, dough, and toppings. |
| `PizzaBuilder` | Interface defining the fluent methods for building pizzas. |
| `BasePizzaBuilder` | Abstract base class implementing common builder logic. |
| `MargheritaBuilder`, `ParmiggianaBuilder`, `ProsciuttoEFunghiBuilder` | Concrete builders with predefined default toppings. |
| `CustomPizzaBuilder` | Builder for fully customizable pizzas. |
| `Pizzaiolo` *(optional)* | Director class that orchestrates pizza creation through a builder. This class is not implemented because the use of a fluent builder makes it redundant.|
| `Main` | Demonstrates usage of the pattern by building multiple pizzas and printing them. |

---

## Technical Requirements
- **Java 17** or higher  
- Dependencies:  
  - JUnit 5 (for testing)  

Recommended IDE: **IntelliJ IDEA** or **Eclipse**

---

## Tests
JUnit tests ensure the correct behavior of:
- **Builder chaining** and return types  
- **Default toppings** for each pizza type  
- **Custom pizza creation**  
- **State reset** after each `build()`  
- **Immutability** of toppings list  
