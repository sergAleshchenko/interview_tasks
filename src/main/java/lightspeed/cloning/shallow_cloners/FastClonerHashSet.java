package lightspeed.cloning.shallow_cloners;

import lightspeed.cloning.DeepCloner;
import lightspeed.cloning.ShallowCloner;

import java.util.HashSet;
import java.util.Map;

/**
 * @author kostantinos.kougios
 *
 * 21 May 2009
 */
public class FastClonerHashSet implements ShallowCloner
{
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public Object clone(final Object t, final DeepCloner cloner, final Map<Object, Object> clones) {
		final HashSet al = (HashSet) t;
		final HashSet l = new HashSet();
		for (final Object o : al)
		{
			l.add(cloner.deepClone(o, clones));
		}
		return l;
	}
}
