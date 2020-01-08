function validateUpdatedNotification() {
    var notificationName = $('#notificationName');
    var notificationDescription = $('#notificationDescription');
    var notificationNameValue = notificationName.val();
    var notificationDescriptionValue = notificationDescription.val();
    var notificationNameValidated = false;
    var notificationDescriptionValidated = false;
    if (notificationNameValue != '') {
        notificationNameValidated = true;
        notificationName.removeClass('is-invalid');
        notificationName.addClass('is-valid');
        document.getElementById("invalidNotificationName").style.display = "none";
    } else {
        notificationName.removeClass('is-valid');
        notificationName.addClass('is-invalid');
        document.getElementById("invalidNotificationName").style.display = "block";
    }
    if (notificationDescriptionValue != '') {
        notificationDescriptionValidated = true;
        notificationDescription.removeClass('is-invalid');
        notificationDescription.addClass('is-valid');
        document.getElementById("invalidNotificationDescription").style.display = "none";
    } else {
        notificationDescription.removeClass('is-valid');
        notificationDescription.addClass('is-invalid');
        document.getElementById("invalidNotificationDescription").style.display = "block";
    }
    if (notificationNameValidated && notificationDescriptionValidated) {
        saveNotification(notificationNameValue, notificationDescriptionValue);
    }
}

function saveNotification(notificationNameValue, notificationDescriptionValue) {
    var editedBy = $('#username-of-logged-user').text();
    var getMethodUrl = document.URL.substring(0, document.URL.indexOf("/notifications/update-notification"));
    getMethodUrl += document.getElementById("urlToSaveUpdatedNotification").getAttribute("href");
    getMethodUrl += "?archived=" + false;
    getMethodUrl += "&name=" + notificationNameValue;
    getMethodUrl += "&description=" + notificationDescriptionValue;
    getMethodUrl += "&editorsEmail=" + editedBy;
    getMethodUrl += "&notificationId=" + new URL(document.URL).searchParams.get("notificationId");
    var xhr = new XMLHttpRequest();
    xhr.open("GET", getMethodUrl, true);
    xhr.onreadystatechange = function(){
        if (xhr.readyState == 4 && xhr.status == 200){
            window.location.href = document.URL.substring(0, document.URL.indexOf("/notifications/update-notification")) + "/notifications/notification-list";
        }
    };
    xhr.send();
}