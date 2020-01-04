package modul.systemu.asi.backend.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "priority")
public class Priority {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "priority")
    private List<Task> tasks = new ArrayList<Task>();
    @OneToMany(mappedBy = "previousPriority")
    private List<TaskHistory> taskHistoriesPreviousPriority = new ArrayList<TaskHistory>();
    @OneToMany(mappedBy = "newPriority")
    private List<TaskHistory> taskHistoriesNewPriority = new ArrayList<TaskHistory>();

    public Priority(){
        super();
    }

    public Priority(long id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    public List<TaskHistory> getTaskHistoriesPreviousPriority() {
        return taskHistoriesPreviousPriority;
    }

    public void setTaskHistoriesPreviousPriority(List<TaskHistory> taskHistoriesPreviousPriority) {
        this.taskHistoriesPreviousPriority = taskHistoriesPreviousPriority;
    }

    public List<TaskHistory> getTaskHistoriesNewPriority() {
        return taskHistoriesNewPriority;
    }

    public void setTaskHistoriesNewPriority(List<TaskHistory> taskHistoriesNewPriority) {
        this.taskHistoriesNewPriority = taskHistoriesNewPriority;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
