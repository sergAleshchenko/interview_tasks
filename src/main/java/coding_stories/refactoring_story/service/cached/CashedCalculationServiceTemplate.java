package coding_stories.refactoring_story.service.cached;

import coding_stories.refactoring_story.dto.CacheItem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public abstract class CashedCalculationServiceTemplate implements CashedCalculationService {
    private final Logger logger = Logger.getLogger(CashedCalculationServiceTemplate.class.getName());
    private final int capacity;
    private final Map<Integer, CacheItem> cacheMap;

    public CashedCalculationServiceTemplate(int capacity) {
        this.capacity = capacity;
        this.cacheMap =  new ConcurrentHashMap<>(capacity);
    }

    protected abstract String performCalculations(int number);

    public String calculate(int number){
        String cachedValue = get(number);

        if (cachedValue != null){
            return cachedValue;
        }

        put(number, performCalculations(number));
        return cacheMap.get(number).getValue();
    }

    private void removeEntry() {
        int entryKeyToBeRemoved = getOldestLFUKey();

        if (cacheMap.containsKey(entryKeyToBeRemoved)){
            cacheMap.remove(entryKeyToBeRemoved);
            logger.info("entry removed:" + entryKeyToBeRemoved);
        }
    }

    private void put(int key, String entry){
        if (isFull()) {
            removeEntry();
        }
        CacheItem cacheItem = cacheMap.getOrDefault(key, new CacheItem());
        cacheItem.setValue(entry);

        if(cacheMap.containsKey(key)){
            cacheItem.setFrequency(cacheItem.getFrequency() + 1);
        } else {
            cacheItem.setFrequency(0);
        }
        logger.info("entry added:" + cacheItem);
        cacheMap.put(key, cacheItem);
    }

    private String get(int key) {
        if(cacheMap.containsKey(key)) {
            CacheItem cacheItem = cacheMap.get(key);
            cacheItem.setFrequency(cacheItem.getFrequency() + 1);
            return cacheItem.getValue();
        }
        return null;
    }

    private int getOldestLFUKey(){
        int minFreq = getMinFrequency();
        int key = 0;
        long minAvailableFrom = Long.MAX_VALUE;
        for(Map.Entry<Integer, CacheItem> entry : cacheMap.entrySet()) {
            if(minFreq <= entry.getValue().getFrequency() &&
                    minAvailableFrom > entry.getValue().getAvailableFrom()) {

                key = entry.getKey();
                minAvailableFrom = entry.getValue().getFrequency();
            }
        }

        return key;
    }

    private int getMinFrequency() {
        int minFreq = Integer.MAX_VALUE;
        for(Map.Entry<Integer, CacheItem> entry : cacheMap.entrySet()) {
            if(minFreq > entry.getValue().getFrequency()) {
                minFreq = entry.getValue().getFrequency();
            }
        }

        return minFreq;
    }

    private boolean isFull() {
        return cacheMap.size() == capacity;
    }

    public Map<Integer, CacheItem> getCache() {
        return cacheMap;
    }

    public void cleanCache() {
        for (int key : cacheMap.keySet()) {
            logger.info("Removing : " + key);
            cacheMap.remove(key);
        }
    }
}
