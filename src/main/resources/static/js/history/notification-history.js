addLinkToNotificationHistory();

function addLinkToNotificationHistory() {
    var notificationHistoryButton = document.getElementById("notification-history-button");
    var url = document.URL.replace("notification-details", "notification-history");
    notificationHistoryButton.setAttribute("href", url);
}