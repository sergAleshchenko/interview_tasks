package patterns.facade.video_library;

import java.io.File;

/**
 * @author Sergei Aleshchenko
 */
public class AudioMixer {
    public File fix(VideoFile result) {
        System.out.println("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}
