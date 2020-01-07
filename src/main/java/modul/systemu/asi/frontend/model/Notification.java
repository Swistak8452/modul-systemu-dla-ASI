package modul.systemu.asi.frontend.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Notification")
public class Notification {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date date;
    @Column(name = "description", columnDefinition = "MEDIUMTEXT")
    private String description;
    private boolean archived;
    @OneToMany(mappedBy = "notification")
    private List<NotificationHistory> notificationHistories = new ArrayList<NotificationHistory>();
    @OneToMany(mappedBy = "relatedNotification")
    private List<Task> tasks = new ArrayList<Task>();
    @OneToMany(mappedBy = "previousRelatedNotification")
    private List<TaskHistory> taskHistoriesPreviousRelatedNotification = new ArrayList<TaskHistory>();
    @OneToMany(mappedBy = "newRelatedNotification")
    private List<TaskHistory> taskHistoriesNewRelatedNotification = new ArrayList<TaskHistory>();

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

    public List<TaskHistory> getTaskHistoriesPreviousRelatedNotification() {
        return taskHistoriesPreviousRelatedNotification;
    }

    public void setTaskHistoriesPreviousRelatedNotification(List<TaskHistory> taskHistoriesPreviousRelatedNotification) {
        this.taskHistoriesPreviousRelatedNotification = taskHistoriesPreviousRelatedNotification;
    }

    public List<TaskHistory> getTaskHistoriesNewRelatedNotification() {
        return taskHistoriesNewRelatedNotification;
    }

    public void setTaskHistoriesNewRelatedNotification(List<TaskHistory> taskHistoriesNewRelatedNotification) {
        this.taskHistoriesNewRelatedNotification = taskHistoriesNewRelatedNotification;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<NotificationHistory> getNotificationHistories() {
        return notificationHistories;
    }

    public void setNotificationHistories(List<NotificationHistory> notificationHistories) {
        this.notificationHistories = notificationHistories;
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
