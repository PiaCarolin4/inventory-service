package cl.duocuc.inventoryservice.service;

import cl.duocuc.inventoryservice.model.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryService {
    private static final List<Inventory> inventoryList = new ArrayList<>();

    public List<Inventory> findAll(){
        return inventoryList;
    }
    public Optional<Inventory> findById(String id){
        return inventoryList
                .stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }
    public List<Inventory> findByProductId(String productId){
        return inventoryList
                .stream()
                .filter(i -> i.getProductId().equals(productId))
                .toList();
    }
    public Optional<Inventory> create(Inventory inventory){
        inventoryList.add(inventory);
        return Optional.of(inventory);
    }
    public boolean delete(String id){
        return inventoryList.removeIf(i -> i.getId().equals(id));
    }
    public Optional<Inventory> update(String id, Inventory updated){
        return findById(id).map(inv -> {
            inv.setQuantity(Integer.parseInt(updated.getProductId()));
            inv.setStoreId(updated.getStoreId());
            inv.setQuantity(updated.getQuantity());
            return inv;
        });
    }
    public Optional<Inventory> adjustQuantity(String id, int delta){
        return findById(id).map(inv -> {
            inv.setQuantity(inv.getQuantity() + delta);
            return inv;
        });
    }

}
