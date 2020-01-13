package modul.systemu.asi.frontend.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Worker")
public class User {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String function;
    @Column(unique = true, nullable = false)
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<Comment>();
    @OneToMany(mappedBy = "editedBy")
    private List<NotificationHistory> notificationHistories = new ArrayList<NotificationHistory>();
    @OneToMany(mappedBy = "assignedPerson")
    private List<Task> tasks = new ArrayList<Task>();
    @OneToMany(mappedBy = "editedBy")
    private List<TaskHistory> taskHistoriesEditedBy = new ArrayList<TaskHistory>();
    @OneToMany(mappedBy = "previousAssignedPerson")
    private List<TaskHistory> taskHistoriesPreviousAssigned = new ArrayList<TaskHistory>();
    @OneToMany(mappedBy = "newAssignedPerson")
    private List<TaskHistory> taskHistoriesNewAssigned = new ArrayList<TaskHistory>();

    public User() {
        super();
    }

    public User(String firstName, String lastName, String function, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.function = function;
        this.email = email;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<TaskHistory> getTaskHistoriesEditedBy() {
        return taskHistoriesEditedBy;
    }

    public void setTaskHistoriesEditedBy(List<TaskHistory> taskHistoriesEditedBy) {
        this.taskHistoriesEditedBy = taskHistoriesEditedBy;
    }

    public List<TaskHistory> getTaskHistoriesPreviousAssigned() {
        return taskHistoriesPreviousAssigned;
    }

    public void setTaskHistoriesPreviousAssigned(List<TaskHistory> taskHistoriesPreviousAssigned) {
        this.taskHistoriesPreviousAssigned = taskHistoriesPreviousAssigned;
    }

    public List<TaskHistory> getTaskHistoriesNewAssigned() {
        return taskHistoriesNewAssigned;
    }

    public void setTaskHistoriesNewAssigned(List<TaskHistory> taskHistoriesNewAssigned) {
        this.taskHistoriesNewAssigned = taskHistoriesNewAssigned;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
