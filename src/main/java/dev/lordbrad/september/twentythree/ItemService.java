package dev.lordbrad.september.twentythree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item getItemById(Long id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        return itemOptional.orElse(null);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item updatedItem) {
        // Check if the item exists before updating.
        Optional<Item> existingItemOptional = itemRepository.findById(id);
        if (existingItemOptional.isPresent()) {
            Item existingItem = existingItemOptional.get();
            existingItem.setName(updatedItem.getName());
            existingItem.setDescription(updatedItem.getDescription());
            // Update other fields as needed.
            return itemRepository.save(existingItem);
        }
        return null;
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
