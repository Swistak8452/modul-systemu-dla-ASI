package modul.systemu.asi.frontend.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "status")
    private List<Task> tasks = new ArrayList<Task>();
    @OneToMany(mappedBy = "previousStatus")
    private List<TaskHistory> taskHistoriesPreviousStatus = new ArrayList<TaskHistory>();
    @OneToMany(mappedBy = "newStatus")
    private List<TaskHistory> taskHistoriesNewStatus = new ArrayList<TaskHistory>();

    public Status(){
        super();
    }

    public Status(long id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    public List<TaskHistory> getTaskHistoriesPreviousStatus() {
        return taskHistoriesPreviousStatus;
    }

    public void setTaskHistoriesPreviousStatus(List<TaskHistory> taskHistoriesPreviousStatus) {
        this.taskHistoriesPreviousStatus = taskHistoriesPreviousStatus;
    }

    public List<TaskHistory> getTaskHistoriesNewStatus() {
        return taskHistoriesNewStatus;
    }

    public void setTaskHistoriesNewStatus(List<TaskHistory> taskHistoriesNewStatus) {
        this.taskHistoriesNewStatus = taskHistoriesNewStatus;
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
