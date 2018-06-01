package it.almaviva.starter.rest.controllers;

import it.almaviva.starter.domain.description.entities.RetailItem;
import it.almaviva.starter.domain.jpa.entities.RetailItemEntity;
import it.almaviva.starter.rest.commands.RegisterRetailItem;
import it.almaviva.starter.services.RetailItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/retail-items")
public class RetailItemController {

    @Autowired
    private RetailItemService retailItemService;

    @GetMapping("")
    public ResponseEntity<?> fetchAllRetailItems() {
        List<RetailItemEntity> retailItems = retailItemService.getAllRetailItems();
        return ResponseEntity.status(HttpStatus.OK).body(retailItems);
    }

    @PostMapping(value="", consumes={"application/json"})
    public ResponseEntity<?> registerRetailItem(@RequestBody RegisterRetailItem command) {
        String title = command.getTitle();
        String description = command.getDescription();
        Integer price = command.getPrice();
        RetailItem insertedRetailItem =
                retailItemService.insertRetailItem(title, description, price);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedRetailItem);
    }
}
