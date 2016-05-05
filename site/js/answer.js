

//model
var data= JSON.stringify(frm.serializeArray());

var url = document.location.href;
id = url.split('=')[1];

$.ajax({
    type: "POST",
    url: 'http://localhost/8080/questions/answer?for=' + id,
    dataType: "JSON",
    data: {
        o:data
    },
    success: function (data) {
        app.loadAndDisplayResults(data)  
    },
    error: function () {
        alert('Error');
    }
})



//VIEW
var UIService = (function () {

    var applyTemplate = function (template, data) {
        return template
            .replace(/\${userID}/g, data.userID)
            .replace(/\${answerID}/g, data.answerID)
            .replace(/\$atext}/g, data.atext)

    };
    var renderResult = function (results) {
        return results.map(function (data) {
            return applyTemplate(resultTemplate, data);
        }).join("");
    };


var resultTemplate = $("#show-answer-template").html();

    return {
        displayAnswer: function (results) {
            var rendering = renderResult(results);
            $("#answer-list").html(rendering);
        }
    }
}());

//CONTROLLER
var App = (function () {
    return {
        loadAndDisplayResults: function (data) {
            promise.done(function (data) {
                UIService.displayAnswer(results);
            });
        }
    };
}());
