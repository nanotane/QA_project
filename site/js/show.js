
(function () {

    //VIEW
    var UIService = (function () {

        var applyTemplate = function (template, data) {
            return template
                .replace(/\${userID}/g, data.userID)
                .replace(/\${questionID}/g, data.questionID)
                .replace(/\${qtext}/g, data.qtext)

        };
        var renderResult = function (results) {
            return results.map(function (data) {
                return applyTemplate(resultTemplate, data);
            }).join("");
        };


        var resultTemplate = $("#show-question-template").html();

        return {
            displayQuestion: function (results) {
                var rendering = renderResult(results);
                $("#question-list").html(rendering);
            }
        }
    }());
    //MODEL

    var DataService = (function () {
        var url = document.location.href;
        id = url.split('=')[1];


        var SERVER = "http://localhost:8080";
        var ENDPOINT = "/question/" + id;


        return {
            getQuestion: function () {
                return $.ajax({
                    type: "GET",
                    url: SERVER + ENDPOINT,
                    dataType: "json",
                    contentType: "application/json"
                });
            }
        };
    }());


    //CONTROLLER
    var App = (function () {
        return {
            loadAndDisplayResults: function () {
                var promise = DataService.getQuestion();
                promise.done(function (results) {
                    UIService.displayQuestion(results);
                });
            }
        };
    }());



    $(document).ready(function () {
        App.loadAndDisplayResults();
    });
}());
