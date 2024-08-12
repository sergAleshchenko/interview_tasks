package lightspeed.cloning.shallow_cloners;

import lightspeed.cloning.DeepCloner;
import lightspeed.cloning.ShallowCloner;

import java.util.Map;
import java.util.TreeSet;

public class FastClonerTreeSet implements ShallowCloner {
	@Override
	@SuppressWarnings("unchecked")
	public Object clone(Object t, DeepCloner cloner, Map<Object, Object> clones) {
		TreeSet<?> treeSet = (TreeSet<?>) t;
		TreeSet result = new TreeSet(treeSet.comparator());
		for (Object o : treeSet) {
			result.add(cloner.deepClone(o, clones));
		}
		return result;
	}
}
