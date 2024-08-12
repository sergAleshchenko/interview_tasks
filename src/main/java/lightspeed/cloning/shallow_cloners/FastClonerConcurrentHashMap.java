package lightspeed.cloning.shallow_cloners;

import lightspeed.cloning.DeepCloner;
import lightspeed.cloning.ShallowCloner;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kostantinos.kougios
 *
 * 18 Oct 2011
 */
public class FastClonerConcurrentHashMap implements ShallowCloner
{
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public Object clone(final Object t, final DeepCloner cloner, final Map<Object, Object> clones) {
		final ConcurrentHashMap<Object, Object> m = (ConcurrentHashMap) t;
		final ConcurrentHashMap result = new ConcurrentHashMap();
		for (final Map.Entry e : m.entrySet()) {
			result.put(cloner.deepClone(e.getKey(), clones), cloner.deepClone(e.getValue(), clones));
		}
		return result;
	}
}
