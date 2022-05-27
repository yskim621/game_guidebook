window.addEventListener("load", function(){
	var janggi = document.getElementById("janggi_hover");
	var janggi_data = document.getElementById("janggi_data");



	janggi.addEventListener("click", function(){
		janggi_data.innerHTML = "";
		//ajax 요청 : select
		var url = Helper.basePath + "/api/game/boardgame/janggi";

		//ajax 객체를 생성
		var request = new XMLHttpRequest();

		//요청을 생성
		request.open('get', url, true);


		//요청을 전송
		request.send('');
		// console.log(formData);

		//ajax 요청에 응답이 오면
		request.addEventListener("load", function(e){
			// alert("클릭");
			//console.log(e.target.responseText)
			// 결과를 파싱
			var data = JSON.parse(e.target.responseText);
			// alert(data.result);
			// console.log(data);
			janggi_data.innerHTML = data.result

			document.querySelector('#siteSub').style.display = "none";
			document.querySelectorAll('.mw-jump-link')[0].style.display = "none";
			document.querySelectorAll('.mw-jump-link')[1].style.display = "none";

		});

	});


});

document.querySelector('#janggi_hover').style.display = "none";

function janggiChangeImg(){
	document.querySelector('#janggi').style.display = "none";
	document.querySelector('#janggi_hover').style.display = "block";	
}
  
function janggiShowOriginal() {	
	document.querySelector('#janggi_hover').style.display = "none";
	document.querySelector('#janggi').style.display = "block";
}