function assignUserToTask() {
    var taskId = new URL(document.URL).searchParams.get("taskId");
    var editorsEmail = $('#username-of-logged-user').text();
    var assignedPersonId = $('#taskAssignedPerson').val();
    var assignPersonUrl = document.URL.substring(0, document.URL.indexOf("/tasks/"));
    assignPersonUrl += "/tasks/assign-user-to-task";
    assignPersonUrl += "?taskId=" + taskId;
    assignPersonUrl += "&editorsEmail=" + editorsEmail;
    assignPersonUrl += "&assignedPersonId=" + assignedPersonId;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", assignPersonUrl, true);
    xhr.onreadystatechange = function(){
        if (xhr.readyState == 4 && xhr.status == 200){
            window.location.href = document.URL.substring(0, document.URL.indexOf("/tasks/")) + "/tasks/current-tasks-list";
        }
    };
    xhr.send();
}