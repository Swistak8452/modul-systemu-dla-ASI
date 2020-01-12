generateLinkToAddComment();

function generateLinkToAddComment() {
    var addCommentButton = document.getElementById("add-comment");
    var url = document.URL;
    if(url.includes("task-details")){
        url = url.replace("task-details", "add-comment");
    }else if(url.includes("notification-details")){
        url = url.replace("notification-details", "add-comment");
    }
    addCommentButton.setAttribute("href", url);
}