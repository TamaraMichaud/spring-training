package com.tamara.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
// ^^ this does all the commented methods; getter, setter, equals, hash, tostring
//@EqualsAndHashCode(of = {"id", "title"}) // << e.g. if multiple fields required but not all
@EqualsAndHashCode(of = "id")
// ^^ below we had this using only the field id... which is done with the above tag. (default is all)
public class ToDoItem {

    // fields //
    private int id;
    private String title;
    private String details;
    private LocalDate deadline;

    // constructor //
    public ToDoItem(String title, String details, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }
//
//    @Override
//    public String toString() {
//        return "ToDoItem{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", details='" + details + '\'' +
//                ", deadline=" + deadline +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof ToDoItem)) return false;
//
//        ToDoItem toDoItem = (ToDoItem) o;
//
//        return id == toDoItem.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return id;
//    }
//
//    // getters and setters (not using lombok because...)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDetails() {
//        return details;
//    }
//
//    public void setDetails(String details) {
//        this.details = details;
//    }
//
//    public LocalDate getDeadline() {
//        return deadline;
//    }
//
//    public void setDeadline(LocalDate deadline) {
//        this.deadline = deadline;
//    }
}

