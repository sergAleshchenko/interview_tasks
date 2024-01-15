package patterns.proxy.media_library;

import java.util.HashMap;

/**
 * @author Sergei Aleshchenko
 */
public interface ThirdPartyYouTubeLib {
    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);

}
