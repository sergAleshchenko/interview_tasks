package patterns.facade.video_library;

import lombok.Getter;

/**
 * @author Sergei Aleshchenko
 */
@Getter
public class VideoFile {
    private String name;
    private String codecType;

    public VideoFile(String name) {
        this.name = name;
        this.codecType = name.substring(name.indexOf(".") + 1);
    }
}
