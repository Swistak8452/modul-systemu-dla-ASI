package modul.systemu.asi.backend.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column(name = "description", columnDefinition = "MEDIUMTEXT")
    private String description;
    @ManyToOne
    @JoinColumn(name = "fk_assignedPerson")
    private User user;
    @ManyToOne
    @JoinColumn(name = "fk_type")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "fk_status")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "fk_priority")
    private Priority priority;
    @ManyToOne
    @JoinColumn(name = "fk_notification")
    private Notification notification;
    private Date deadline;
    @OneToMany(mappedBy = "task")
    private List<TaskHistory> taskHistories = new ArrayList<TaskHistory>();

    public Task(){
        super();
    }

    public Task(String name, String description, User user, Type type, Status status, Priority priority,
                Notification notification, Date deadline){
        super();
        this.name = name;
        this.description = description;
        this.user = user;
        this.type = type;
        this.status = status;
        this.priority = priority;
        this.notification = notification;
        this.deadline = deadline;
    }

    public List<TaskHistory> getTaskHistories() {
        return taskHistories;
    }

    public void setTaskHistories(List<TaskHistory> taskHistories) {
        this.taskHistories = taskHistories;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
