window.addEventListener("load", function(){
	var go = document.getElementById("go_hover");
	var go_data = document.getElementById("go_data");



	go.addEventListener("click", function(){
		//alert("클릭");
		go_data.innerHTML = " ";
		//ajax 요청 : select
		var url = Helper.basePath + "/api/game/boardgame/go";

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
			go_data.innerHTML = data.result

		});

	});


});

document.querySelector('#go_hover').style.display = "none";

function goChangeImg(){
	document.querySelector('#go').style.display = "none";
	document.querySelector('#go_hover').style.display = "block";	
}
  
function goShowOriginal() {	
	document.querySelector('#go_hover').style.display = "none";
	document.querySelector('#go').style.display = "block";
}