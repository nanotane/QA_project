var frm= $(#postform)
var data= JSON.stringify(frm.serializeArray());




$.ajax({
            type: "POST",
            url: "your url with method that accpects the data",
            dataType: "json",
            data: {
                o: data
            },
            success: function (data) {
               alert('Success');

            },
            error: function () {
             alert('Error');
            }
        });
