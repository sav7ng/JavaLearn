package github.aquan.springbootupload.storage;

/**
 * @Class StorageException
 * @Description TODO
 * @Author Aquan
 * @Date 2019.3.12 11:57
 * @Version 1.0
 **/
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }

}
