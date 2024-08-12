package lightspeed.cloning.deep_cloners;

import lightspeed.cloning.CloningException;
import lightspeed.cloning.DeepCloner;

import java.util.Map;

/**
 * @author Sergei Aleshchenko
 */
public class IgnoreClassCloner implements DeepCloner {
    public <T> T deepClone(T o, Map<Object, Object> clones) {
        throw new CloningException("Don't call this directly");
    }
}
