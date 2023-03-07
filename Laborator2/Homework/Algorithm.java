package newP;
/**
 * Algorithm class is an abstract class that represents an algorithm described by a name and a function that resolves a Problem
 *
 * @author Delia
 */
public abstract class Algorithm {
    protected String name;

    public abstract boolean algorithm(Problem pb, Location l1, Location l2);
}
