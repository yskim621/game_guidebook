window.addEventListener("load", function(event){
	var bacara = document.getElementById("bacara_hover");
	var bacara_data = document.getElementById("bacara_data");

	bacara.addEventListener("click", function(event){
		//alert("클릭");
		bacara_data.innerHTML = " ";
		//ajax 요청 : select
		var url = Helper.basePath + "/api/game/trumpcard/bacara";
		
		//ajax 객체를 생성
		var request = new XMLHttpRequest();
		
		//요청을 생성
		request.open('get', url, true);
		
		
		//요청을 전송
		request.send('');

		//ajax 요청에 응답이 오면
		request.addEventListener("load", function(e){
			var data = JSON.parse(e.target.responseText);
			bacara_data.innerHTML = data.result

			var bacaraImgSrc = $("#bacara").attr("src");
			$(".image > img").attr("src", bacaraImgSrc);
			$(".image > img").attr("width", "50%");
			document.querySelectorAll(".center")[1].setAttribute("border", 5);
			document.querySelectorAll(".center")[1].setAttribute("style", "text-align: center;");
			document.querySelectorAll(".center")[2].setAttribute("border", 5);
			document.querySelectorAll(".center")[2].setAttribute("style", "text-align: center;");
			
			
		});
		
	});
	
	
});

function bacaraChangeImg(){
	document.querySelector('#bacara').style.display = "none";
	document.querySelector('#bacara_hover').style.display = "block";	
}
  
function bacaraShowOriginal() {	
	document.querySelector('#bacara_hover').style.display = "none";
	document.querySelector('#bacara').style.display = "block";
}
