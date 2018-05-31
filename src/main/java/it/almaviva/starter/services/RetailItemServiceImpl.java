package it.almaviva.starter.services;

import it.almaviva.starter.domain.entities.RetailItem;
import it.almaviva.starter.repositories.RetailItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RetailItemServiceImpl implements RetailItemService {

    @Autowired
    private RetailItemRepository retailItemRepository;

    @Override
    public Long registerRandomRetailItem() {
        String title = "Title " + UUID.randomUUID().toString();
        String description = "Description " + UUID.randomUUID().toString();
        RetailItem randomRetailItem = new RetailItem(title, description);
        return retailItemRepository.save(randomRetailItem).id;
    }
}
