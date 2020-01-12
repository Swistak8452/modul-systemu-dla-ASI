package modul.systemu.asi.frontend.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "description", columnDefinition = "MEDIUMTEXT")
    private String description;
    @ManyToOne
    @JoinColumn(name = "fk_assigned_person")
    private User assignedPerson;
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
    @JoinColumn(name = "fk_related_notification")
    private Notification relatedNotification;
    private Date deadline;
    private boolean archived;
    @OneToMany(mappedBy = "task")
    private List<Comment> comments = new ArrayList<Comment>();
    @OneToMany(mappedBy = "task")
    private List<TaskHistory> taskHistories = new ArrayList<TaskHistory>();

    public Task(){
        super();
    }

    public Task(String name, String description, User assignedPerson, Type type,
                Status status, Priority priority,
                Notification relatedNotification, Date deadline, boolean archived){
        super();
        this.name = name;
        this.description = description;
        this.assignedPerson = assignedPerson;
        this.type = type;
        this.status = status;
        this.priority = priority;
        this.relatedNotification = relatedNotification;
        this.deadline = deadline;
        this.archived = archived;
    }


    public void setId(long id) {
        this.id = id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<TaskHistory> getTaskHistories() {
        return taskHistories;
    }

    public void setTaskHistories(List<TaskHistory> taskHistories) {
        this.taskHistories = taskHistories;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssignedPerson() {
        return assignedPerson;
    }

    public void setAssignedPerson(User assignedPerson) {
        this.assignedPerson = assignedPerson;
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

    public Notification getRelatedNotification() {
        return relatedNotification;
    }

    public void setRelatedNotification(Notification relatedNotification) {
        this.relatedNotification = relatedNotification;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
