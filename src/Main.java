// Defining ArithmeticExp as an abstract class that declares an evaluate abstract method.
abstract class ArithmeticExp {
    // The evaluate method returns the value of the expression
    public abstract int evaluate();

    // New method to generate the string representation of the expression
    public abstract String toString();
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

    // The toStringRepresentation method returns the string representation of the number
    public String toString() {
        return String.valueOf(value);
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

    // The toStringRepresentation method returns the string representation of the sum expression
    public String toString() {
        return left.toString() + " + " + right.toString();
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

    // The toStringRepresentation method returns the string representation of the product expression
    public String toString() {
        return left.toString() + " * " + right.toString();
    }
}

// The main class
class ArithmeticOperation {
    public static void main(String[] args) {
        // Constructing the expression 3 + 2 * 5 using the new classes
        ArithmeticExp result = new Sum(new Number(3), new Product(new Number(2), new Number(5)));

        

        System.out.println("Arithmetic Expression : " + result.toString());
        System.out.println("Output: " + result.evaluate());
    }
}
