package ru.yandex.practicum.item;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getItems(long userId) {
        return itemRepository.findByUserId(userId);
    }

    @Override
    public Item addNewItem(Long userId, Item item) {
        item.setUserId(userId);
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(long userId, long itemId) {
        itemRepository.deleteByUserIdAndItemId(userId, itemId);
    }
}