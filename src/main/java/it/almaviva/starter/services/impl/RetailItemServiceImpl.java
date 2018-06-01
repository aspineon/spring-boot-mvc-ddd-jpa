package it.almaviva.starter.services.impl;

import com.google.common.collect.Lists;
import it.almaviva.starter.domain.jpa.entities.RetailItemEntity;
import it.almaviva.starter.repositories.RetailItemRepository;
import it.almaviva.starter.services.RetailItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetailItemServiceImpl implements RetailItemService {

    @Autowired
    private RetailItemRepository retailItemRepository;

    public List<RetailItemEntity> getAllRetailItems() {
        Iterable<RetailItemEntity> retailItems =
                retailItemRepository.findAll();
        return Lists.newArrayList(retailItems);
    }

    public RetailItemEntity insertRetailItem(String title, String description, Integer price) {
        RetailItemEntity retailItem = new RetailItemEntity(title, description, price);
        return retailItemRepository.save(retailItem);
    }
}
