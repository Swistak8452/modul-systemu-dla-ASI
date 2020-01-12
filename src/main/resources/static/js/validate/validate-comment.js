function validateComment() {
    var commentText = $('#commentText');
    var commentTextValue = commentText.val();
    var commentTextValidated = false;
    if (commentTextValue != '') {
        commentTextValidated = true;
        commentText.removeClass('is-invalid');
        commentText.addClass('is-valid');
        document.getElementById("invalidCommentText").style.display = "none";
    } else {
        commentText.removeClass('is-valid');
        commentText.addClass('is-invalid');
        document.getElementById("invalidCommentText").style.display = "block";
    }
    if (commentTextValidated) {
        saveComment(commentTextValue);
    }

}

function saveComment(commentTextValue) {
    var editorsEmail = $('#username-of-logged-user').text();
    var text = commentTextValue;
    var taskId = new URL(document.URL).searchParams.get("taskId");
    var notificationId = new URL(document.URL).searchParams.get("notificationId");
    var getMethodUrl;
    if(notificationId == null && taskId != null) {
        var xhr = new XMLHttpRequest();
        getMethodUrl = document.URL.substring(0, document.URL.indexOf("/tasks/add-comment")) + "/tasks/add-comment-to-task";
        getMethodUrl += "?taskId=" + taskId;
        getMethodUrl += "&text=" + text;
        getMethodUrl += "&editorsEmail=" + editorsEmail;
        xhr.open("GET", getMethodUrl, true);
        xhr.onreadystatechange = function(){
            if (xhr.readyState == 4 && xhr.status == 200){
                window.history.back();
            }
        };
        xhr.send();
    }else if(notificationId != null && taskId == null){
        var xhr = new XMLHttpRequest();
        getMethodUrl = document.URL.substring(0, document.URL.indexOf("/notifications/add-comment")) + "/notifications/add-comment-to-notification";
        getMethodUrl += "?notificationId=" + notificationId;
        getMethodUrl += "&text=" + text;
        getMethodUrl += "&editorsEmail=" + editorsEmail;
        xhr.open("GET", getMethodUrl, true);
        xhr.onreadystatechange = function(){
            if (xhr.readyState == 4 && xhr.status == 200){
                window.history.back();
            }
        };
        xhr.send();
    }
}