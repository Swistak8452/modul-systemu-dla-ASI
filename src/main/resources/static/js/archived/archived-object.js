function changeTask() {
    sendChangedTask();
}

function changeNotification() {
    sendChangedNotification();
}

function sendChangedTask() {
    var taskId = new URL(document.URL).searchParams.get("taskId");
    var editorsEmail = $('#username-of-logged-user').text();
    var url = document.URL.substring(0, document.URL.indexOf("/tasks/task-details"));
    url += "/tasks/change-field-archived-in-task";
    url += "?taskId=" + taskId;
    url += "&editorsEmail=" + editorsEmail;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", url, true);
    xhr.onreadystatechange = function(){
        if (xhr.readyState == 4 && xhr.status == 200){
            window.location.href = document.URL.substring(0, document.URL.indexOf("/tasks/")) + "/tasks/current-tasks-list";
        }
    };
    xhr.send();
}

function sendChangedNotification() {
    var notificationId = new URL(document.URL).searchParams.get("notificationId");
    var editorsEmail = $('#username-of-logged-user').text();
    var url = document.URL.substring(0, document.URL.indexOf("/notifications/notification-details"));
    url += "/notifications/change-field-archived-in-notification";
    url += "?notificationId=" + notificationId;
    url += "&editorsEmail=" + editorsEmail;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", url, true);
    xhr.onreadystatechange = function(){
        if (xhr.readyState == 4 && xhr.status == 200){
            window.location.href = document.URL.substring(0, document.URL.indexOf("/notifications/")) + "/notifications/notification-list";
        }
    };
    xhr.send();
}