package modul.systemu.asi.frontend.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "TaskHistory")
public class TaskHistory {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "fk_task")
    private Task task;
    @ManyToOne
    @JoinColumn(name = "fk_edited_by_user")
    private User editedBy;
    private long changeNumber;
    @ManyToOne
    @JoinColumn(name = "fk_previous_assigned_user")
    private User previousAssignedPerson;
    @ManyToOne
    @JoinColumn(name = "fk_new_assigned_user")
    private User newAssignedPerson;
    private String previousName;
    private String newName;
    private Date previousDeadline;
    private Date newDeadline;
    private boolean previousArchived;
    private boolean newArchived;
    @ManyToOne
    @JoinColumn(name = "fk_previous_type")
    private Type previousType;
    @ManyToOne
    @JoinColumn(name = "fk_new_type")
    private Type newType;
    @ManyToOne
    @JoinColumn(name = "fk_previous_status")
    private Status previousStatus;
    @ManyToOne
    @JoinColumn(name = "fk_new_status")
    private Status newStatus;
    @ManyToOne
    @JoinColumn(name = "fk_previous_priority")
    private Priority previousPriority;
    @ManyToOne
    @JoinColumn(name = "fk_new_priority")
    private Priority newPriority;
    @Column(name = "previousDescription", columnDefinition = "MEDIUMTEXT")
    private String previousDescription;
    @Column(name = "newDescription", columnDefinition = "MEDIUMTEXT")
    private String newDescription;
    @ManyToOne
    @JoinColumn(name = "fk_previous_related_notification")
    private Notification previousRelatedNotification;
    @ManyToOne
    @JoinColumn(name = "fk_new_related_notification")
    private Notification newRelatedNotification;
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

    public TaskHistory(Task task, User editedBy, long changeNumber,
                       User previousAssignedPerson, User newAssignedPerson,
                       String previousName, String newName, Date previousDeadline, Date newDeadline,
                       boolean previousArchived, boolean newArchived,
                       Type previousType, Type newType, Status previousStatus, Status newStatus,
                       Priority previousPriority, Priority newPriority,
                       String previousDescription, String newDescription,
                       Notification previousRelatedNotification, Notification newRelatedNotification) {
        this.task = task;
        this.changeNumber = changeNumber;
        this.previousAssignedPerson = previousAssignedPerson;
        this.newAssignedPerson = newAssignedPerson;
        this.previousName = previousName;
        this.newName = newName;
        this.previousDeadline = previousDeadline;
        this.newDeadline = newDeadline;
        this.previousArchived = previousArchived;
        this.newArchived = newArchived;
        this.previousType = previousType;
        this.newType = newType;
        this.previousStatus = previousStatus;
        this.newStatus = newStatus;
        this.previousPriority = previousPriority;
        this.newPriority = newPriority;
        this.previousDescription = previousDescription;
        this.newDescription = newDescription;
        this.previousRelatedNotification = previousRelatedNotification;
        this.newRelatedNotification = newRelatedNotification;
        this.changeDateTime = returnDateNow();
    }

    public boolean isPreviousArchived() {
        return previousArchived;
    }

    public void setPreviousArchived(boolean previousArchived) {
        this.previousArchived = previousArchived;
    }

    public boolean isNewArchived() {
        return newArchived;
    }

    public void setNewArchived(boolean newArchived) {
        this.newArchived = newArchived;
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

    public User getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(User editedBy) {
        this.editedBy = editedBy;
    }

    public long getChangeNumber() {
        return changeNumber;
    }

    public void setChangeNumber(long changeNumber) {
        this.changeNumber = changeNumber;
    }

    public User getPreviousAssignedPerson() {
        return previousAssignedPerson;
    }

    public void setPreviousAssignedPerson(User previousAssignedPerson) {
        this.previousAssignedPerson = previousAssignedPerson;
    }

    public User getNewAssignedPerson() {
        return newAssignedPerson;
    }

    public void setNewAssignedPerson(User newAssignedPerson) {
        this.newAssignedPerson = newAssignedPerson;
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

    public Type getPreviousType() {
        return previousType;
    }

    public void setPreviousType(Type previousType) {
        this.previousType = previousType;
    }

    public Type getNewType() {
        return newType;
    }

    public void setNewType(Type newType) {
        this.newType = newType;
    }

    public Status getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(Status previousStatus) {
        this.previousStatus = previousStatus;
    }

    public Status getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Status newStatus) {
        this.newStatus = newStatus;
    }

    public Priority getPreviousPriority() {
        return previousPriority;
    }

    public void setPreviousPriority(Priority previousPriority) {
        this.previousPriority = previousPriority;
    }

    public Priority getNewPriority() {
        return newPriority;
    }

    public void setNewPriority(Priority newPriority) {
        this.newPriority = newPriority;
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

    public Notification getPreviousRelatedNotification() {
        return previousRelatedNotification;
    }

    public void setPreviousRelatedNotification(Notification previousRelatedNotification) {
        this.previousRelatedNotification = previousRelatedNotification;
    }

    public Notification getNewRelatedNotification() {
        return newRelatedNotification;
    }

    public void setNewRelatedNotification(Notification newRelatedNotification) {
        this.newRelatedNotification = newRelatedNotification;
    }

    public Date getChangeDateTime() {
        return changeDateTime;
    }

    public void setChangeDateTime(Date changeDateTime) {
        this.changeDateTime = changeDateTime;
    }
}
