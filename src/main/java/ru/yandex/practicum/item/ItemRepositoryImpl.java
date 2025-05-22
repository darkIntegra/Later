package ru.yandex.practicum.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private final Map<Long, List<Item>> userItemsMap = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public List<Item> findByUserId(long userId) {
        return userItemsMap.getOrDefault(userId, new ArrayList<>());
    }

    @Override
    public Item save(Item item) {
        long itemId = idGenerator.getAndIncrement();
        item.setId(itemId);

        userItemsMap.computeIfAbsent(item.getUserId(), k -> new ArrayList<>()).add(item);

        return item;
    }

    @Override
    public void deleteByUserIdAndItemId(long userId, long itemId) {
        List<Item> items = userItemsMap.get(userId);
        if (items != null) {
            items.removeIf(item -> item.getId() == itemId);
            if (items.isEmpty()) {
                userItemsMap.remove(userId);
            }
        }
    }
}
