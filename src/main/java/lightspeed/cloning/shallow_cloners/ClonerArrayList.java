package lightspeed.cloning.shallow_cloners;

import lightspeed.cloning.DeepCloner;
import lightspeed.cloning.ShallowCloner;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author kostantinos.kougios
 *
 * 21 May 2009
 */
public class ClonerArrayList implements ShallowCloner
{
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public Object clone(final Object t, final DeepCloner cloner, final Map<Object, Object> clones) {
		ArrayList al = (ArrayList) t;
		int size = al.size();
		ArrayList l = new ArrayList(size);
		for (int i = 0; i < size; i++) {
			l.add(cloner.deepClone(al.get(i), clones));
		}
		return l;
	}

}
