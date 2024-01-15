package patterns.facade;

import java.io.File;

/**
 * @author Sergei Aleshchenko
 */
public class Demo {
    public static void main(String[] args) {
        VideoConversionFacade converter =
                new VideoConversionFacade();

        File mp4video = converter.convertVideo(
                "youtubevideo.ogg", "mp4");

    }
}
