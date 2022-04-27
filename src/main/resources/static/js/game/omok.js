window.addEventListener("load", function(){
	var omok = document.getElementById("omok_hover");
	var omok_data = document.getElementById("omok_data");



	omok.addEventListener("click", function(){
		//alert("클릭");
		omok_data.innerHTML = " ";
		//ajax 요청 : select
		var url = Helper.basePath + "/api/game/boardgame/omok";

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
			omok_data.innerHTML = data.result

			document.querySelector('.revenue_unit_info').style.display = "none";
		});

	});


});

document.querySelector('#omok_hover').style.display = "none";

function omokChangeImg(){
	document.querySelector('#omok').style.display = "none";
	document.querySelector('#omok_hover').style.display = "block";	
}
  
function omokShowOriginal() {	
	document.querySelector('#omok_hover').style.display = "none";
	document.querySelector('#omok').style.display = "block";
}
