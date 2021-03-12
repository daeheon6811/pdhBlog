$(document).ready(function () {

    $("#update_button").click(function () {

        $("#title").removeAttr("readonly");
        $("#content").removeAttr("readonly");
        $("#update_button").value("완료");
        if($("update_button").value().equals("완료"))
        {

        }

    });

});
$(document).ready(function () {
    $(".reply-popup").click(function () {
        $(".reply-box").toggle();
    });
});