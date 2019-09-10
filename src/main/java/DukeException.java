/**
 * The DukeException class is an extension of the base class Exception
 * that represent exceptions specific to Duke.
 */
public class DukeException extends Exception {
    /**
     * Constructor for DukeException.
     * @param err error message
     */
    public DukeException(String err) {
        super(err);
    }
}
