$(document).ready(function checkDifferences() {
    $(".change").each(function () {
        if($(this).find('.row-name td').first().text() != $(this).find('.row-name td').last().text()){
            $(this).find('.row-name td').last().css("color", "red");
        }
        if($(this).find('.row-type td').first().text() != $(this).find('.row-type td').last().text()){
            $(this).find('.row-type td').last().css("color", "red");
        }
        if($(this).find('.row-status td').first().text() != $(this).find('.row-status td').last().text()){
            $(this).find('.row-status td').last().css("color", "red");
        }
        if($(this).find('.row-deadline td').first().text() != $(this).find('.row-deadline td').last().text()){
            $(this).find('.row-deadline td').last().css("color", "red");
        }
        if($(this).find('.row-priority td').first().text() != $(this).find('.row-priority td').last().text()){
            $(this).find('.row-priority td').last().css("color", "red");
        }
        if($(this).find('.row-assigned-person td').first().text() != $(this).find('.row-assigned-person td').last().text()){
            $(this).find('.row-assigned-person td').last(
            ).css("color", "red");
        }
        if($(this).find('.row-related-notification td').first().text() != $(this).find('.row-related-notification td').last().text()){
            $(this).find('.row-related-notification td').last().css("color", "red");
        }
        if($(this).find('.row-description td').first().text() != $(this).find('.row-description td').last().text()){
            $(this).find('.row-description td').last().css("color", "red");
        }
        if($(this).find('.row-archived td').first().text() != $(this).find('.row-archived td').last().text()){
            $(this).find('.row-archived td').last().css("color", "red");
        }
    });
});