
var url = document.URL.substring(0, document.URL.indexOf("/tasks/task-details"));
url = url + "/notifications/notification-details?notificationId=";
url = url + document.getElementById("relatedNotificationLink").getAttribute("relatedNotificationId");
document.getElementById("relatedNotificationLink").setAttribute('href', url);