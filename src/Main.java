//The initial program violates object-oriented principles,
//particularly polymorphism, by using a single class (ArithmeticExp) for
//different expressions and resorting to a switch statement for evaluation.
//A more effective approach employs inheritance, utilizing abstract classes to
//create a hierarchy of expression classes. Each subclass, implementing its unique
//evaluate method,adheres to the common interface provided by the abstract
//class, promoting modularity, extensibility, and maintainability in the code.

// Defining  ArithmeticExp as  an abstract class
abstract class ArithmeticExp {

   // returns the value of the expression
    public abstract int evaluate();
}

// Abstract class for binary expressions (Sum and Product)
abstract class BinaryExp extends ArithmeticExp {
    // Two protected fields to store the left and right operands
    protected final ArithmeticExp left;
    protected final ArithmeticExp right;

    // A constructor that takes the left and right operands as parameters
    public BinaryExp(ArithmeticExp left, ArithmeticExp right) {
        this.left = left;
        this.right = right;
    }
}



// A Number class represents a single integer value
class Number extends ArithmeticExp {
    // A private field to store the value
    private final int value;

    // A constructor that takes the value as a parameter
    public Number(int value) {
        this.value = value;
    }

    // The evaluate method returns the value of the number
    public int evaluate() {
        return value;
    }
}

// A Sum class represents an addition of two expressions
class Sum extends BinaryExp {
    // A constructor that takes the left and right operands as parameters
    public Sum(ArithmeticExp left, ArithmeticExp right) {
        super(left, right);
    }

    // The evaluate method returns the sum of the values of the left and right operands
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
}

// A Product class represents a multiplication of two expressions
class Product extends BinaryExp {
    // A constructor that takes the left and right operands as parameters
    public Product(ArithmeticExp left, ArithmeticExp right) {
        super(left, right);
    }

    // The evaluate method returns the product of the values of the left and right operands
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }
}

// The main class
class ArithmeticOperation {
    public static void main(String[] args) {
        // Constructing the expression 3 + 2 * 5 using the new classes
        ArithmeticExp result = new Sum(new Number(3), new Product(new Number(2), new Number(5)));
        // Printing the value of the expression
        System.out.println("Result of the Expression : "+result.evaluate());
    }
}
