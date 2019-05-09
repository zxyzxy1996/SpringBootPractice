$.ajax({
    url: "/err/getAjaxError",
    type: "POST",
    async: false,
    success: function (data) {
        if (data.status == 200 && data.msg == "OK") {
            alert("success");
        } else {
            alert("Error：" + data.msg);
        }
    },
    error: function (response, ajaxOptions, thrownError) {
        alert("Error");
    }
});