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
    public  boolean isExistedToDoItem(String name){
        ToDoListItem toDoListItemResult = toDoListItemRepository.findByName(name);
        if(toDoListItemResult!=null){
            return false;
        }
        return true;
    }
    public boolean addParkingLot(ToDoListItem toDoListItem) {
        boolean isExisted = isExistedToDoItem(toDoListItem.getName());
        if(isExisted){
            toDoListItemRepository.save(toDoListItem);
            return true;
        }else{
           return false;
        }

    }

    public List<ToDoListItem> getAllToDoListItems() {

        List<ToDoListItem> toDoListItems = toDoListItemRepository.findAll();
        return toDoListItems;


    }

    public ToDoListItem updateAItem(String id,ToDoListItem item) {

        ToDoListItem toDoListItem = toDoListItemRepository.saveAndFlush(item);
        return item;
    }

    public void deleteAItem(String id) {
        toDoListItemRepository.deleteById(id);
    }
}
