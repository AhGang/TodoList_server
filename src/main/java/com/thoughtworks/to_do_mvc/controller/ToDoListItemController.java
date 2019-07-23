package com.thoughtworks.to_do_mvc.controller;

import com.thoughtworks.to_do_mvc.entity.ToDoListItem;
import com.thoughtworks.to_do_mvc.repository.ToDoListItemRepository;
import com.thoughtworks.to_do_mvc.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/to-do-lists")
public class ToDoListItemController {

    @Autowired
    private ToDoListService toDoListService;

    @PostMapping
    public ResponseEntity createAItem(@RequestBody ToDoListItem toDoListItem){
        boolean isCreated = toDoListService.addParkingLot(toDoListItem);
        if(isCreated){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Already have the same toDoItem");
        }
    }
    @GetMapping()
    public ResponseEntity getAllToDoListItem(){
        List<ToDoListItem> toDoListItems = toDoListService.getAllToDoListItems();
        return ResponseEntity.status(HttpStatus.OK).body(toDoListItems);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity putAItem(@PathVariable String id){
        ToDoListItem toDoListItem = toDoListService.updateAItem(id);
        return ResponseEntity.status(HttpStatus.OK).body(toDoListItem);

    }
}
