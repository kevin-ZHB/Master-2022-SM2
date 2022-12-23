package exception;
/**
 * Customized characteristic exception
 */
public class InvalidCharacteristicException extends Exception {

    /**
     * Field that is being checked
     */
    public String field;

    /**
     * Class constructor 
     */
    public InvalidCharacteristicException(){
        super();
    }

    /**
     * Class constructor specifying field
     * @param field field that is being checked
     */
    public InvalidCharacteristicException(String field){
        super();
        this.field = field;
    }

}
