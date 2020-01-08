addLinksToTaskDetails();


function addLinksToTaskDetails() {
    var buttons = document.getElementsByClassName("task-details-button");
    for (var i = 0; i < buttons.length; i++) {
        var taskId = buttons[i].getAttribute("taskNumber");
        buttons[i].setAttribute("href", document.URL.substring(0, document.URL.indexOf("/tasks/"))+"/tasks/task-details?taskId="+taskId);
    }
}