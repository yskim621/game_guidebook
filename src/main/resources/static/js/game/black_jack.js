window.addEventListener("load", function(event){
	var black_jack = document.getElementById("blackjack_hover");
	var black_jack_data = document.getElementById("black_jack_data");
	
	
	black_jack.addEventListener("click", function(event){
		//alert("클릭");
		black_jack_data.innerHTML = " ";
		
		//ajax 요청 : select
		var url = Helper.basePath + "/api/game/trumpcard/black_jack";
		
		//ajax 객체를 생성
		var request = new XMLHttpRequest();
		
		//요청을 생성
		request.open('get', url, true);
		
		
		//요청을 전송
		request.send('');
		// console.log(formData);
		
		//ajax 요청에 응답이 오면
		request.addEventListener("load", function(e){
			// 결과를 파싱
			var data = JSON.parse(e.target.responseText);
			black_jack_data.innerHTML = data.result
			
			if(document.querySelectorAll(".image")[0] != null){
				// var blackjackImg = document.getElementById("black_jack").getAttribute("src");
				// document.querySelectorAll(".image")[1].setAttribute("src", blackjackImg);
				$(".no1 > a").replaceWith("<h3>블랙잭은 21 혹은 21에 가장 가까운 숫자를 만들어 딜러보다 높으면 이기는 게임입니다</h3>");
				$(".no1 > h3").attr("style", "font-size: 1.5em")


				var blackjackImgSrc = $("#black_jack").attr("src");
				$(".image > img").attr({"src": blackjackImgSrc, "width": "50%"});

			}
		});
		
	});
	
	
});




function blackjackChangeImg(){
	document.querySelector('#black_jack').style.display = "none";
	document.querySelector('#blackjack_hover').style.display = "block";	
}
  
function blackjackShowOriginal() {	
	document.querySelector('#blackjack_hover').style.display = "none";
	document.querySelector('#black_jack').style.display = "block";
}