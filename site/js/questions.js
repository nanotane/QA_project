(function(){

	//model
	var DataService = (function () {
		var SERVER = "http://localhost:8080";
		var ENDPOINT = "/questions/top10";
		return {
		     getTopTenProfiles: function (currentUser) {
		         return $.ajax({
		            type: "GET",
		            url: SERVER + ENDPOINT,
		            dataType: "json",
		            contentType: "application/json"
		        });
		    }
		};
	}());

	//view
	var UIService = (function () {

		return{
			displayRecentPosts: function(questions){
				for(var i = 0; i < questions.length; i++){
					var template = "<div class='question-container'>" +
										"<div class='question-content'>" +
											"<div class ='votes'>" +
												"<p id='votes'>" + questions.topTenList[i].votes + "</p>" +
												"<h6>votes</h6>" +
											"</div>" +
											"<div class='question-link'>" +
												"<h3><a href='answer.html?=" + questions.topTenList[i].questionID + "' class='hyperlink'>" + questions.topTenList[i].atext + "</a></h3>" +
											"</div>" +
											"<div class='post-info'>" +
												"<h6> posted on </h6>" +
												"<h6>" + questions.topTenList[i].datePosted + "</h6>" +
												"<h6> by </h6>" +
												"<h6>" + questions.topTenList[i].userID + "</h6>" +
											"</div>";
					$('.contentWrapper').append("</div></div>");
				}
			}
		}
	}())
	
	//controller
	var app = (function(){
		return{
			loadAndDisplayPost: function(){
				var promise = DataService.getTopTenProfiles();
				promise.done(function (results) {
                    UIService.displayRecentPosts(results);
                });
			}
		}
	}())

	$(document).ready(function(){
		app.loadAndDisplayPost()
	})
}())