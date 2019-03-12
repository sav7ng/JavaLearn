package github.aquan.springbootupload.storage;

/**
 * @Class StorageFileNotFoundException
 * @Description TODO
 * @Author Aquan
 * @Date 2019.3.12 17:04
 * @Version 1.0
 **/
public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
