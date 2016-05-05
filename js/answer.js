//submit


(function () {

        //VIEW
        var UIService = (function () {

            return{
                displayQuestion: function(answer){
                    var i = 0
                    var template = "<div class='question-container'>" +
                        "<div class='question-content'>" +
                        "<div class ='votes'>" +
                        "<p id='votes'>" + answer[i].votes + "</p>" +
                        "<h6>votes</h6>" +
                        "</div>" +
                        "<div class='post-info'>" +
                        "<h6> posted on </h6>" +
                        "<h6>" + answer[i].post_date + "</h6>" +
                        "<h6> by </h6>" +
                        "<h6>" + answer[i].user_id + "</h6>" +
                        "</div>" +
                        "<div class='tags' id ='" + answer[i].answer_id + "'>"+
                        "<div class='questiontext'>" + answer[i].answertext+"</div>";

                }
            }
        })
    }())
    //MODEL
    var DataService = (function () {
        var SERVER = "http://localhost:8000";
        var ENDPOINT = "/test-data/test.json";

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
    })


    //MODEL
        var DataService = (function () {
            var SERVER = "http://localhost:8000";
            var ENDPOINT = "/test-data/test.json";

            return {
                getAnswer: function () {
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
                    var promise = DataService.getAnswer();
                    promise.done(function (results) {
                        UIService.displayAnswer(results);
                    });
                }
            };
        }());



        $(document).ready(function () {
            App.loadAndDisplayResults();
        });

