package com.thoughtworks.to_do_mvc.service;

import com.thoughtworks.to_do_mvc.entity.ToDoListItem;
import com.thoughtworks.to_do_mvc.repository.ToDoListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoListService {
    @Autowired
    private ToDoListItemRepository toDoListItemRepository;

    public void addParkingLot(ToDoListItem toDoListItem) {
        System.out.println(toDoListItem);
        toDoListItemRepository.save(toDoListItem);

    }

    public List<ToDoListItem> getAllToDoListItems() {

        List<ToDoListItem> toDoListItems = toDoListItemRepository.findAll();
        return toDoListItems;


    }
}
