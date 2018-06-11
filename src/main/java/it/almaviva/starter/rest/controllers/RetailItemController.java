package it.almaviva.starter.rest.controllers;

import it.almaviva.starter.domain.jpa.entities.RetailItemEntity;
import it.almaviva.starter.rest.commands.RegisterRetailItem;
import it.almaviva.starter.rest.dtos.RetailItemDTO;
import it.almaviva.starter.services.RetailItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/retail-items")
public class RetailItemController {

    @Autowired
    private RetailItemService retailItemService;

    @GetMapping("")
    public ResponseEntity<?> fetchAllRetailItems() {
        List<RetailItemEntity> allRetailItems = retailItemService.getAllRetailItems();
        List<RetailItemDTO> allRetailItemsDTO = allRetailItems.stream()
            .map(RetailItemDTO::fromRetailItemEntity)
            .collect(Collectors.toList());
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(allRetailItemsDTO);
    }

    @PostMapping(value = "", consumes = {"application/json"})
    public ResponseEntity<?> registerRetailItem(@RequestBody RegisterRetailItem command) {
        String title = command.getTitle();
        String description = command.getDescription();
        Integer price = command.getPrice();
        RetailItemEntity insertedRetailItem =
                retailItemService.insertRetailItem(title, description, price);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(RetailItemDTO.fromRetailItemEntity(insertedRetailItem));
    }
}
