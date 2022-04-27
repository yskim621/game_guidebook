window.addEventListener("load", function(){
	var chess = document.getElementById("chess_hover");
	var chess_data = document.getElementById("chess_data");



	chess.addEventListener("click", function(){
		//alert("클릭");
		chess_data.innerHTML = " ";
		//ajax 요청 : select
		var url = Helper.basePath + "/api/game/boardgame/chess";

		//ajax 객체를 생성
		var request = new XMLHttpRequest();

		//요청을 생성
		request.open('get', url, true);


		//요청을 전송
		request.send('');

		//ajax 요청에 응답이 오면
		request.addEventListener("load", function(e){
			var data = JSON.parse(e.target.responseText);
			chess_data.innerHTML = data.result


			//document.querySelectorAll(".imageblock")[0].setAttribute("style", "display:inline-block;width:400px;;height:300;");
			document.querySelectorAll(".imageblock")[0].style.display = "none";

			/*
			setTimeout(function() {
				//document.querySelectr('.container_postbtn \#post_button_group').style.display = "none";
				//document.querySelector(".another_category another_category_color_gray").style.display = "none";
				var temp = document.querySelectorAll(".table-wrap");
				for(var index in temp){
					temp[index].style.display = "none";
				}
							document.querySelector(".another_category another_category_color_gray").addEventListener("load", function(e){
				document.querySelector(".another_category another_category_color_gray").style.display = "none";
			});

			}, 5000);
			*/

		});


	});


});

document.querySelector('#chess_hover').style.display = "none";

function chessChangeImg(){
	document.querySelector('#chess').style.display = "none";
	document.querySelector('#chess_hover').style.display = "block";	
}
  
function chessShowOriginal() {	
	document.querySelector('#chess_hover').style.display = "none";
	document.querySelector('#chess').style.display = "block";
}