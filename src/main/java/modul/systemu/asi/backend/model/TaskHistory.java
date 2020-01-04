package modul.systemu.asi.backend.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "TaskHistory")
public class TaskHistory {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "fk_task")
    private Task task;
    private long taskId;
    private long changeNumber;
    private String previousName;
    private String newName;
    private Date previousDeadline;
    private Date newDeadline;
    @Column(name = "previousDescription", columnDefinition = "MEDIUMTEXT")
    private String previousDescription;
    @Column(name = "newDescription", columnDefinition = "MEDIUMTEXT")
    private String newDescription;
    private Date changeDateTime;

    private Date returnDateNow() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, 60);
        return new Date(cal.getTime().getTime());
    }

    public TaskHistory(){
        super();
        this.changeDateTime = returnDateNow();
    }

    public TaskHistory(Task task, long taskId, long changeNumber, String previousName, String newName,
                       Date previousDeadline, Date newDeadline, Set<User> users, Set<Type> types,
                       Set<Status> statuses, Set<Priority> priorities, Set<Notification> notifications,
                       String previousDescription, String newDescription, Date changeDateTime) {
        this.task = task;
        this.taskId = taskId;
        this.changeNumber = changeNumber;
        this.previousName = previousName;
        this.newName = newName;
        this.previousDeadline = previousDeadline;
        this.newDeadline = newDeadline;
        this.users = users;
        this.types = types;
        this.statuses = statuses;
        this.priorities = priorities;
        this.notifications = notifications;
        this.previousDescription = previousDescription;
        this.newDescription = newDescription;
        this.changeDateTime = changeDateTime;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "task_history_notification",
            joinColumns = { @JoinColumn(name = "TASK_HISTORY_ID",
                    nullable = false, updatable = false)},
            inverseJoinColumns = { @JoinColumn(name = "NOTIFICATION_ID",
                    nullable = false, updatable = false)})
    Set<Notification> notifications = new HashSet<>();

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "task_history_priority", joinColumns = {
            @JoinColumn(name = "TASK_HISTORY_ID", nullable = false, updatable = false)},
            inverseJoinColumns = { @JoinColumn(name = "PRIORITY_ID", nullable = false, updatable = false)})
    Set<Priority> priorities = new HashSet<>();

    public Set<Priority> getPriorities() {
        return priorities;
    }

    public void setPriorities(Set<Priority> priorities) {
        this.priorities = priorities;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "task_history_user", joinColumns = {
            @JoinColumn(name = "TASK_HISTORY_ID", nullable = false, updatable = false)},
            inverseJoinColumns = { @JoinColumn(name = "USER_ID", nullable = false, updatable = false)})
    Set<User> users = new HashSet<>();
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "task_history_type", joinColumns = {
            @JoinColumn(name = "TASK_HISTORY_ID", nullable = false, updatable = false)},
            inverseJoinColumns = { @JoinColumn(name = "TYPE_ID", nullable = false, updatable = false)})
    Set<Type> types = new HashSet<>();
    public Set<Type> getTypes() {
        return types;
    }

    public void setTypes(Set<Type> types) {
        this.types = types;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "task_history_status", joinColumns = {
            @JoinColumn(name = "TASK_HISTORY_ID", nullable = false, updatable = false)},
            inverseJoinColumns = { @JoinColumn(name = "STATUS_ID", nullable = false, updatable = false)})
    Set<Status> statuses = new HashSet<>();
    public Set<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<Status> statuses) {
        this.statuses = statuses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public long getChangeNumber() {
        return changeNumber;
    }

    public void setChangeNumber(long changeNumber) {
        this.changeNumber = changeNumber;
    }

    public String getPreviousName() {
        return previousName;
    }

    public void setPreviousName(String previousName) {
        this.previousName = previousName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public Date getPreviousDeadline() {
        return previousDeadline;
    }

    public void setPreviousDeadline(Date previousDeadline) {
        this.previousDeadline = previousDeadline;
    }

    public Date getNewDeadline() {
        return newDeadline;
    }

    public void setNewDeadline(Date newDeadline) {
        this.newDeadline = newDeadline;
    }

    public String getPreviousDescription() {
        return previousDescription;
    }

    public void setPreviousDescription(String previousDescription) {
        this.previousDescription = previousDescription;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public Date getChangeDateTime() {
        return changeDateTime;
    }

    public void setChangeDateTime(Date changeDateTime) {
        this.changeDateTime = changeDateTime;
    }
}
