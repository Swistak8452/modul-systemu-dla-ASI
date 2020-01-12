$(document).ready(function checkDifferences() {
    $(".change").each(function () {
        if($(this).find('.row-name td').first().text() != $(this).find('.row-name td').last().text()){
            $(this).find('.row-name td').last().css("color", "red");
        }
        if($(this).find('.row-description td').first().text() != $(this).find('.row-description td').last().text()){
            $(this).find('.row-description td').last().css("color", "red");
        }
        if($(this).find('.row-archived td').first().text() != $(this).find('.row-archived td').last().text()){
            $(this).find('.row-archived td').last().css("color", "red");
        }
    });
});