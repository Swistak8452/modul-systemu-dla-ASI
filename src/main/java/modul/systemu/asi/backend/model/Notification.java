package modul.systemu.asi.backend.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Notification")
public class Notification {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Date date;
    @Column(name = "description", columnDefinition = "MEDIUMTEXT")
    private String description;
    private boolean archived;
    @OneToMany(mappedBy = "notification")
    private List<NotificationHistory> notificationHistories = new ArrayList<NotificationHistory>();
    @OneToMany(mappedBy = "notification")
    private List<Task> tasks = new ArrayList<Task>();
    @ManyToMany(mappedBy = "notifications")
    private Set<TaskHistory> taskHistories = new HashSet<>();

    public Notification(){
        super();
        this.archived = false;
    }

    public Notification(long id, String name, Date date, String description){
        super();
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.archived = false;
    }

    public Set<TaskHistory> getTaskHistories() {
        return taskHistories;
    }

    public void setTaskHistories(Set<TaskHistory> taskHistories) {
        this.taskHistories = taskHistories;
    }

    public List<NotificationHistory> getNotificationHistories() {
        return notificationHistories;
    }

    public void setNotificationHistories(List<NotificationHistory> notificationHistories) {
        this.notificationHistories = notificationHistories;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
