package com.tamara.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

// simulate an in-memory db for now
public class ToDoData {

    private static int idValue = 1;

    private final List<ToDoItem> items = new ArrayList<>();
    // ^^ final only stops us from changing "items" from List; we can still modify the contents of the list


    public ToDoData() {

        // mock some dummy data
        addItem(new ToDoItem("first", "description of first", LocalDate.now()));
        addItem(new ToDoItem("second", "info of second", LocalDate.now()));
        addItem(new ToDoItem("third", "third description", LocalDate.now()));


    }

    public List<ToDoItem> getItems(){

        // don't just return the list.  return an immutable list.
        // because, we want this class to be in charge of ALL modifications to the list
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull ToDoItem itemToAdd){
//        if(itemToAdd == null) {
//            throw new NullPointerException("You need to provide an item to add!");
//        }
        // ^^ this again is boilerplate code... better with Lombok (the tag in the signature)
        // ^^ *** BEWARE: spring also has a NonNull - we want the Lombok one.

        itemToAdd.setId(idValue);
        idValue++;
        items.add(itemToAdd);
    }


    public void removeItem(int itemId){

        ListIterator<ToDoItem> itemIterator = items.listIterator();
        while(itemIterator.hasNext()) {
            ToDoItem nextItem = itemIterator.next();
            if(nextItem.getId() == itemId) {
                itemIterator.remove();
                break;
            }
        }
        // ^^ ITEM ITERATOR... is better than a simple for loop (As below) because...?

//        for(ToDoItem item : items) {
//            if(item.getId() == itemId) {
//                items.remove(item);
//            }
//        }
//
        //TODO: ^^ do these both actually return the same result or are we being arrogant?

    }

    public ToDoItem getItem(int id) {
        for(ToDoItem item : items) {
            if(item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    public void updateItem(@NonNull ToDoItem itemToUpdate) {

        ListIterator<ToDoItem> itemIterator = items.listIterator();
        while(itemIterator.hasNext()) {
            ToDoItem nextItem = itemIterator.next();
            if(nextItem.equals(itemToUpdate)) {
                // ^^ BEWARE: we made "equals" compare only the ID values previously... if not, this would never work
                // because presumably the itemToUpdate will always differ from its original... otherwise what's the point?

                itemIterator.set(itemToUpdate);
                break;
            }
        }


    }

}
