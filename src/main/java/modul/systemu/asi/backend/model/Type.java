package modul.systemu.asi.backend.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Type")
public class Type {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToMany(mappedBy = "type")
    private List<Task> tasks = new ArrayList<Task>();
    @OneToMany(mappedBy = "previousType")
    private List<TaskHistory> taskHistoriesPreviousType = new ArrayList<TaskHistory>();
    @OneToMany(mappedBy = "newType")
    private List<TaskHistory> taskHistoriesNewType = new ArrayList<TaskHistory>();

    public Type() {
        super();
    }

    public Type(String name) {
        super();
        this.name = name;
    }

    public List<TaskHistory> getTaskHistoriesPreviousType() {
        return taskHistoriesPreviousType;
    }

    public void setTaskHistoriesPreviousType(List<TaskHistory> taskHistoriesPreviousType) {
        this.taskHistoriesPreviousType = taskHistoriesPreviousType;
    }

    public List<TaskHistory> getTaskHistoriesNewType() {
        return taskHistoriesNewType;
    }

    public void setTaskHistoriesNewType(List<TaskHistory> taskHistoriesNewType) {
        this.taskHistoriesNewType = taskHistoriesNewType;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
