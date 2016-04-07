(function(){

	//model
	var DataService = (function () {
		var SERVER = "http://localhost:8000";
		var ENDPOINT = "/stack_overflow_clone/js/test.json";
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
											"<div class='tags' id ='" + questions[i].q_id + "'>";
					$('.contentWrapper').append(template);

					for(var j = 0; j < questions[i].post_tags.length; j++){						
						var tag_post = "<div class='tag'>" + questions[i].post_tags[j] + "</div>";
						$("#" + questions[i].q_id).append(tag_post)
					}
					$('.contentWrapper').append("</div></div></div>");
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

