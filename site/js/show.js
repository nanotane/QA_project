(function () {

    //VIEW
    var UIService = (function () {

        return{
            displayQuestion: function(questions){
                var template ="</br><h4>" + questions.question[0].userID + "</h4></br></br>" +
                              "<h5>" + questions.question[0].qtext + "</h5>";         
                $('.contentWrapper').append(template);
            }
        }
    }());
    //MODEL

    var DataService = (function () {
        var url = document.location.href;
        id = url.split('=')[1];


        var SERVER = "http://localhost:8080";
        var ENDPOINT = "/questions/" + id;

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
