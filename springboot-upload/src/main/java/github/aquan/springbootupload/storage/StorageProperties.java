package github.aquan.springbootupload.storage;

import org.springframework.stereotype.Component;

/**
 * @Class StorageProperties
 * @Description Folder location for storing files
 * @Author Aquan
 * @Date 2019.3.12 11:48
 * @Version 1.0
 **/

@Component
public class StorageProperties {

    private String location = "upload";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
