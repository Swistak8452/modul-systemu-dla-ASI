addLinksToNotificationDetails();
addLinksToEditNotification();

function addLinksToNotificationDetails() {
    var buttons = document.getElementsByClassName("notification-details-button");
    for (var i = 0; i < buttons.length; i++) {
        var notificationId = buttons[i].getAttribute("notificationNumber");
        buttons[i].setAttribute("href", document.URL.substring(0, document.URL.indexOf("/notifications/"))+"/notifications/notification-details?notificationId="+notificationId);
    }
}

function addLinksToEditNotification() {
    var buttons = document.getElementsByClassName("notification-edit-button");
    for (var i = 0; i < buttons.length; i++) {
        var notificationId = buttons[i].getAttribute("notificationNumber");
        buttons[i].setAttribute("href", document.URL.substring(0, document.URL.indexOf("/notifications/"))+"/notifications/update-notification?notificationId="+notificationId);
    }
}