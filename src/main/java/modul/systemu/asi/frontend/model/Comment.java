package modul.systemu.asi.frontend.model;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "fk_notification")
    private Notification notification;
    @ManyToOne
    @JoinColumn(name = "fk_task")
    private Task task;
    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User user;
    @Column(name = "text", columnDefinition = "MEDIUMTEXT")
    private String text;
    private Date date;

    private Date returnDateNow() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, 60);
        return new Date(cal.getTime().getTime());
    }

    public Comment(){
        super();
        this.date = returnDateNow();
    }

    public Comment(Notification notification, Task task, User user, String text){
        super();
        this.notification = notification;
        this.task = task;
        this.user = user;
        this.text = text;
        this.date = returnDateNow();
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
