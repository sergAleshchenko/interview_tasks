package lightspeed.cloning.shallow_cloners;

import lightspeed.cloning.DeepCloner;
import lightspeed.cloning.ShallowCloner;

import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Fast Cloner for LinkedHashSet
 * 
 * @author Tobias Weimer
 */
public class FastClonerLinkedHashSet implements ShallowCloner
{
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public Object clone(final Object t, final DeepCloner cloner, final Map<Object, Object> clones) {
		final LinkedHashSet<?> al = (LinkedHashSet) t;
		final LinkedHashSet l = new LinkedHashSet();
		for (final Object o : al)
		{
			l.add(cloner.deepClone(o, clones));
		}
		return l;
	}
}
