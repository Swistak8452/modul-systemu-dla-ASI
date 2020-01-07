addLinkToUpdate();
addLinkToHistory();
function addLinkToUpdate() {
    var editButton = document.getElementById("edit-button");
    var url = document.URL.replace("task-details", "update-task");
    editButton.setAttribute("href", url);
}

function addLinkToHistory() {
    var taskHistoryButton = document.getElementById("task-history-button");
    var url = document.URL.replace("task-details", "task-history");
    taskHistoryButton.setAttribute("href", url);
}