package pl.kamilF.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.kamilF.task.dao.TaskDao;
import pl.kamilF.task.model.Task;

@Controller
public class TaskController {

    @Autowired
    private TaskDao taskDao;

    @GetMapping("/")
    public String add(){
        return "tasks/add";
    }

    @PostMapping("/all")
    public String addTask(@ModelAttribute Task task){
        taskDao.add(task);
        return "redirect:/all";
    }

    @GetMapping("/all")
    public String all(ModelMap modelMap){
        modelMap.put("tasks", taskDao.findAll());
        return "tasks/all";
    }

    @GetMapping("/isFinish")
    public String isfinish(ModelMap modelMap){
        modelMap.put("tasks", taskDao.finshed());
        return "tasks/isFinish";
    }

    @GetMapping("/isNotFinish")
    public String isNotfinish(ModelMap modelMap){
        modelMap.put("tasks", taskDao.unfinshed());
        return "tasks/isNotFinish";
    }

    @RequestMapping("/tasks/{id}")
    public String getTask(@PathVariable int id,ModelMap modelMap){
        modelMap.put("task",taskDao.findById(id));
        return "tasks/show";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Task task){
        taskDao.update(task);
                return"tasks/all";
    }
}
