package modul.systemu.asi.backend.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String function;
    @Column(unique = true, nullable = false)
    private String email;
    @OneToMany(mappedBy = "user")
    private List<NotificationHistory> notificationHistories = new ArrayList<NotificationHistory>();
    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<Task>();
    @ManyToMany(mappedBy = "users")
    private List<TaskHistory> taskHistories = new ArrayList<TaskHistory>();

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

    public List<TaskHistory> getTaskHistories() {
        return taskHistories;
    }

    public void setTaskHistories(List<TaskHistory> taskHistories) {
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
