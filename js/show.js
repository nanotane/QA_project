/**
 * Created by Ivory on 5/4/16.
 */
//function fortune(){
//    $.ajax(
//        {
//            dataType:"json",
//            type:"GET",
//            url:"",
//            cache:false,
//            success:function(response) {
//                $('#fortune_text').html(response);}
//        })
//}
//$(document).ready(function(){fortune();});
(function () {

    //VIEW
    var UIService = (function () {

        return{
            displayQuestion: function(questions){
                var i = 0
                    var template = "<div class='question-container'>" +
                        "<div class='question-content'>" +
                        "<div class ='votes'>" +
                        "<p id='votes'>" + questions[i].votes + "</p>" +
                        "<h6>votes</h6>" +
                        "</div>" +
                        "<div class='question-link'>" +
                        "<h3><a href='" + questions[i].q_link + "' class='hyperlink'>" + questions[i].post_title + "</a></h3>" +
                        "</div>" +
                        "<div class='post-info'>" +
                        "<h6> posted on </h6>" +
                        "<h6>" + questions[i].post_date + "</h6>" +
                        "<h6> by </h6>" +
                        "<h6>" + questions[i].user_id + "</h6>" +
                        "</div>" +
                        "<div class='tags' id ='" + questions[i].q_id + "'>"+
                        "<div class='questiontext'>" + question[i].questiontext+"</div>";

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

