generateLinkForAssignPersonToTask();

function generateLinkForAssignPersonToTask() {
    var url = document.URL.substring(0, document.URL.indexOf("/tasks/task-details"));
    var taskId = new URL(document.URL).searchParams.get("taskId");
    url = url + "/tasks/assign-task?taskId=" + taskId;
    document.getElementById("assignedPerson").setAttribute('href', url);
}