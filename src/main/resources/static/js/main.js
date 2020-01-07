if ($('#tasksAlert').length > 0 || $('#notificationsAlert').length > 0) {
    $('#tasksLabel').append($('#tasksAlert'));
    $('#notificationsLabel').append($('#notificationsAlert'));
}
var actualPage = window.location.href;
if(actualPage.includes("tasks/current-tasks-list") || actualPage.includes("notifications/notification-list")){
    $('.nav-link')[4].classList.add("active");
}else if(actualPage.includes("tasks/all-tasks-list") || actualPage.includes("notifications/archived-notifications")){
    $('.nav-link')[5].classList.add("active");
}else if(actualPage.includes("tasks/archived-tasks") || actualPage.includes("notifications/add-notification")){
    $('.nav-link')[6].classList.add("active");
}else if(actualPage.includes("tasks/add-task")){
    $('.nav-link')[7].classList.add("active");
}