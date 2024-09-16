package spring_27_questions;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Sergei Aleshchenko
 */
@Component
public class BannerLoader implements ResourceLoaderAware {

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("#ResourceLoaderAware");

        Resource resource = resourceLoader.getResource("file:H:\\IDEA_PROJECTS\\Learning\\banner.txt");

        try {
            InputStream stream = resource.getInputStream();

            BufferedReader bf = new BufferedReader(new InputStreamReader(stream));
            String line = bf.readLine();

            while (line != null) {
                System.out.println(line);
                line = bf.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
