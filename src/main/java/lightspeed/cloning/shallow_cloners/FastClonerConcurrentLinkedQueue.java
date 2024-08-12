package lightspeed.cloning.shallow_cloners;

import lightspeed.cloning.DeepCloner;
import lightspeed.cloning.ShallowCloner;

import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author kostas.kougios
 * 07/01/19 - 20:08
 */
public class FastClonerConcurrentLinkedQueue implements ShallowCloner {
	@SuppressWarnings({"unchecked", "rawtypes"})
	public Object clone(Object t, DeepCloner cloner, Map<Object, Object> clones) {
		ConcurrentLinkedQueue q = (ConcurrentLinkedQueue) t;
		ConcurrentLinkedQueue c = new ConcurrentLinkedQueue();
		for (Object o : q) {
			c.add(cloner.deepClone(o, clones));
		}
		return c;
	}
}
