package lightspeed.cloning.deep_cloners;

import lightspeed.cloning.CloningException;
import lightspeed.cloning.IDeepCloner;

import java.util.Map;

/**
 * @author Sergei Aleshchenko
 */
public class NullClassCloner implements IDeepCloner {
    public <T> T deepClone(T o, Map<Object, Object> clones) {
        throw new CloningException("Don't call this directly");
    }
}