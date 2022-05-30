window.addEventListener("load", function(){
	var seosda = document.getElementById("seosda_hover");
	var seosda_data = document.getElementById("seosda_data");



	seosda.addEventListener("click", function(){
		//alert("클릭");
		seosda_data.innerHTML = " ";
		//ajax 요청 : select
		var url = Helper.basePath + "/api/game/hwatu/seosda";

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
			// console.log(e.target.responseText)
			// 결과를 파싱
			var data = JSON.parse(e.target.responseText);
			// alert(data.result);
			// console.log(data);
			seosda_data.innerHTML = data.result
			$("div.contents_style ").attr("style", "color: write")


		});

	});


});

document.querySelector('#seosda_hover').style.display = "none";

function seosdaChangeImg(){
	document.querySelector('#seosda').style.display = "none";
	document.querySelector('#seosda_hover').style.display = "block";	
}
  
function seosdaShowOriginal() {	
	document.querySelector('#seosda_hover').style.display = "none";
	document.querySelector('#seosda').style.display = "block";
}

