addLinksToDetails();


function addLinksToDetails() {
    var buttons = document.getElementsByClassName("details-button");
    for (var i = 0; i < buttons.length; i++) {
        var taskId = buttons[i].getAttribute("id");
        buttons[i].setAttribute("href", document.URL.substring(0, document.URL.indexOf("/tasks/"))+"/tasks/task-details?taskId="+taskId);
    }
}