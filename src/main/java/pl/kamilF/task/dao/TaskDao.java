package pl.kamilF.task.dao;

import pl.kamilF.task.model.Task;

import java.util.List;

public interface TaskDao {

    List<Task> findAll();
    void add(Task task);
    Task findById(int id);
    void deleteById(int id);
    List<Task> unfinshed();
    List<Task> finshed();
    void update(Task task);

}
