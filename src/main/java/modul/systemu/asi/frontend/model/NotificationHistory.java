package modul.systemu.asi.frontend.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "notificationHistory")
public class NotificationHistory {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_notification")
    private Notification notification;
    @ManyToOne
    @JoinColumn(name = "fk_edited_by")
    private User editedBy;
    private Long changeNumber;
    private String previousName;
    private String newName;
    private Date previousDate;
    private Date newDate;
    @Column(name = "previousDescription", columnDefinition = "MEDIUMTEXT")
    private String previousDescription;
    @Column(name = "newDescription", columnDefinition = "MEDIUMTEXT")
    private String newDescription;
    private boolean previousArchived;
    private boolean newArchived;
    private Date changeDateTime;

    private Date returnDateNow() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, 60);
        return new Date(cal.getTime().getTime());
    }

    public NotificationHistory(){
        super();
        this.changeDateTime = returnDateNow();
    }

    public NotificationHistory(Notification notification, User editedBy, long changeNumber,
                               String previousName, String newName, Date previousDate,
                               Date newDate, String previousDescription, String newDescription,
                               boolean previousArchived, boolean newArchived){
        super();
        this.notification = notification;
        this.editedBy = editedBy;
        this.changeNumber = changeNumber;
        this.previousName = previousName;
        this.newName = newName;
        this.previousDate = previousDate;
        this.newDate = newDate;
        this.previousDescription = previousDescription;
        this.newDescription = newDescription;
        this.previousArchived = previousArchived;
        this.newArchived = newArchived;
        this.changeDateTime = returnDateNow();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public User getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(User editedBy) {
        this.editedBy = editedBy;
    }

    public Long getChangeNumber() {
        return changeNumber;
    }

    public void setChangeNumber(Long changeNumber) {
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

    public Date getPreviousDate() {
        return previousDate;
    }

    public void setPreviousDate(Date previousDate) {
        this.previousDate = previousDate;
    }

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
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

    public Date getChangeDateTime() {
        return changeDateTime;
    }

    public void setChangeDateTime(Date changeDateTime) {
        this.changeDateTime = changeDateTime;
    }
}
