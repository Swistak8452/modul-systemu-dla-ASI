function validateTask() {
    var taskName = $('#taskName');
    var taskPriority = $('#taskPriority');
    var taskType = $('#taskType');
    var taskRelatedNotification = $('#taskRelatedNotification');
    var taskAssignedPerson = $('#taskAssignedPerson');
    var taskDescription = $('#taskDescription');
    var taskDeadline = $('#taskDeadline');
    var taskNameValue = taskName.val();
    var taskPriorityValue = taskPriority.val();
    var taskTypeValue = taskType.val();
    var taskRelatedNotificationValue = taskRelatedNotification.val();
    var taskAssignedPersonValue = taskAssignedPerson.val();
    var taskDescriptionValue = taskDescription.val();
    var taskDeadlineValue = taskDeadline.val();
    var taskNameValidated = false;
    var taskTypeValidated = false;
    var taskPriorityValidated = false;
    var taskRelatedNotificationValidated = false;
    var taskAssignedPersonValidated = false;
    var taskDescriptionValidated = false;
    var taskDeadlineValidated = false;
    if (taskNameValue != '') {
        taskNameValidated = true;
        taskName.removeClass('is-invalid');
        taskName.addClass('is-valid');
        document.getElementById("invalidTaskName").style.display = "none";
    } else {
        taskName.removeClass('is-valid');
        taskName.addClass('is-invalid');
        document.getElementById("invalidTaskName").style.display = "block";
    }
    if (taskPriorityValue != '') {
        taskPriorityValidated = true;
        taskPriority.removeClass('is-invalid');
        taskPriority.addClass('is-valid');
        document.getElementById("invalidTaskPriority").style.display = "none";
    } else {
        taskPriority.removeClass('is-valid');
        taskPriority.addClass('is-invalid');
        document.getElementById("invalidTaskPriority").style.display = "block";
    }
    if (taskTypeValue != '') {
        taskTypeValidated = true;
        taskType.removeClass('is-invalid');
        taskType.addClass('is-valid');
        document.getElementById("invalidTaskType").style.display = "none";
    } else {
        taskType.removeClass('is-valid');
        taskType.addClass('is-invalid');
        document.getElementById("invalidTaskType").style.display = "block";
    }
    if (taskRelatedNotificationValue != '') {
        taskRelatedNotificationValidated = true;
        taskRelatedNotification.removeClass('is-invalid');
        taskRelatedNotification.addClass('is-valid');
        document.getElementById("invalidTaskRelatedNotification").style.display = "none";
    } else {
        taskRelatedNotification.removeClass('is-valid');
        taskRelatedNotification.addClass('is-invalid');
        document.getElementById("invalidTaskRelatedNotification").style.display = "block";
    }
    if (taskAssignedPersonValue != '') {
        taskAssignedPersonValidated = true;
        taskAssignedPerson.removeClass('is-invalid');
        taskAssignedPerson.addClass('is-valid');
        document.getElementById("invalidTaskAssignedPerson").style.display = "none";
    } else {
        taskAssignedPerson.removeClass('is-valid');
        taskAssignedPerson.addClass('is-invalid');
        document.getElementById("invalidTaskAssignedPerson").style.display = "block";
    }
    if (taskDescriptionValue != '') {
        taskDescriptionValidated = true;
        taskDescription.removeClass('is-invalid');
        taskDescription.addClass('is-valid');
        document.getElementById("invalidTaskDescription").style.display = "none";
    } else {
        taskDescription.removeClass('is-valid');
        taskDescription.addClass('is-invalid');
        document.getElementById("invalidTaskDescription").style.display = "block";
    }
    if (taskDeadlineValue != '') {
        taskDeadlineValidated = true;
        taskDeadline.removeClass('is-invalid');
        taskDeadline.addClass('is-valid');
        document.getElementById("invalidTaskDeadline").style.display = "none";
    } else {
        taskDeadline.removeClass('is-valid');
        taskDeadline.addClass('is-invalid');
        document.getElementById("invalidTaskDeadline").style.display = "block";
    }
    if (taskNameValidated && taskPriorityValidated && taskTypeValidated && taskRelatedNotificationValidated
        && taskAssignedPersonValidated && taskDescriptionValidated && taskDeadlineValidated) {
        saveTask(taskNameValue, taskPriorityValue, taskTypeValue, taskRelatedNotificationValue,
            taskAssignedPersonValue, taskDescriptionValue, taskDeadlineValue);
    }
}

function saveTask(taskNameValue, taskPriorityValue, taskTypeValue, taskRelatedNotificationValue,
                  taskAssignedPersonValue, taskDescriptionValue, taskDeadlineValue) {
    var editedBy = $('#username-of-logged-user').text();
    var getMethodUrl = document.URL.substring(0, document.URL.indexOf("/tasks/update-task"));
    getMethodUrl += document.getElementById("urlToUpdateTask").getAttribute("href");
    getMethodUrl += "?archived=" + false;
    getMethodUrl += "&deadline=" + taskDeadlineValue;
    getMethodUrl += "&description=" + taskDescriptionValue;
    getMethodUrl += "&name=" + taskNameValue;
    getMethodUrl += "&assignedPersonId=" + taskAssignedPersonValue;
    getMethodUrl += "&priorityId=" + taskPriorityValue;
    getMethodUrl += "&relatedNotificationId=" + taskRelatedNotificationValue;
    getMethodUrl += "&statusId=" + "1";
    getMethodUrl += "&typeId=" + taskTypeValue;
    getMethodUrl += "&editorsEmail=" + editedBy;
    getMethodUrl += "&taskId=" + new URL(document.URL).searchParams.get("taskId");
    //console.log(getMethodUrl);
    var xhr = new XMLHttpRequest();
    xhr.open("GET", getMethodUrl, true);
    xhr.onreadystatechange = function(){
        if (xhr.readyState == 4 && xhr.status == 200){
            window.location.href = document.URL.substring(0, document.URL.indexOf("/tasks/update-task")) + "/tasks/current-tasks-list";
        }
    };
    xhr.send();
}