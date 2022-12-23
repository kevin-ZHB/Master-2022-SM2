package data;
/**
 * Class Data is a interface for managing data objects.
 */

public interface  Data {


    /**
     * Assign each value in values to corresponding field.
     * @param values the list of values of a data
     */
    public abstract void assignValue(String[] values);
}
