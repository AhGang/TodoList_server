package com.thoughtworks.to_do_mvc.repository;

import com.thoughtworks.to_do_mvc.entity.ToDoListItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListItemRepository extends JpaRepository<ToDoListItem,String> {

}
