package com.cartrack.autodialer.web.task;

import com.cartrack.autodialer.LoggerWrapper;
import com.cartrack.autodialer.domain.Task;
import com.cartrack.autodialer.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * Created by vinner on 13.11.2015.
 */
public class AbstractTaskController {

    protected final LoggerWrapper LOG = LoggerWrapper.get(getClass());

    @Autowired
    private TaskService service;

    public Collection<Task> getAll(){
        LOG.info("getAll tasks");
        return service.getAll();
    }

    public Task get(int id){
        LOG.info("get Task by id: " + id);
        return service.get(id);
    }

    public void delete(int id){
        LOG.info("delete + " + id);
        service.delete(id);
    }

    public Task create(Task task) {
        task.setId(null);
        LOG.info("create " + task);
        return service.save(task);
    }

    public Task update(Task task, int id) {
        task.setId(id);
        LOG.info("update Client + " + task);
        return service.update(task);
    }

    public void start(int id){
        Task task = service.get(id);
        LOG.info("start task " + task.getName());
        service.start(task);
    }
}
