function openPop() {
	document.getElementById("popup").classList.remove("popup-display-none");
	console.log("1");
}
var contatore = 0;
function closePop(option) {
	contatore++;
	document.getElementById("confirmbutton").style.display = "block";
	document.getElementById("popup").classList.add("popup-display-none");

	if (option == 1) {
		document.getElementById("questions").innerHTML += '<div class="question" id="QuestVF">' +
			'<p style="padding:20px"> Question #' + contatore + '</p><textarea class="TextQuestion" rows="4" cols="200"></textarea>' +
			'<fieldsdet class="rigthAnswer"><legend>Select the right answer:</legend><div><input type="radio" id="1Ans' + contatore + '" checked />' +
			'<label for="huey">True</label></div><div><input type="radio" id="2Ans' + contatore + '" name="drone" value="dewey" /><label for="dewey">False</label>' +
			'</div></fieldset><button class="delete-button"> Delete </button></div>';
	} else {
		document.getElementById("questions").innerHTML += '<div>' +
			'<div class="question" id="QuestMultiple"><p style="padding:20px"> Question #' + contatore + '</p>' +
			'<textarea class="TextQuestion" rows="4" cols="200"></textarea><fieldset class="rigthAnswer">' +
			'<legend style="margin-bottom: 10px;">Select the right answer:</legend><div><input type="radio" id="1Ans' + contatore + '" checked />' +
			'<p class="p-answer"> Answer #1</p><textarea class="TextQuestion other-display" rows="2" cols="100"></textarea>' +
			'</div><div><input type="radio" id="dewey" name="drone" value="2Ans' + contatore + '" /><p class="p-answer"> Answer #2</p><textarea class="TextQuestion other-display" rows="2" cols="100">' +
			'</textarea></div><div><input type="radio" id="3Ans' + contatore + '" checked /><p class="p-answer"> Answer #3</p>' +
			'<textarea class="TextQuestion other-display" rows="2" cols="100"></textarea></div><div><input type="radio" id="4Ans' + contatore + '" name="drone" value="dewey" />' +
			'<p class="p-answer"> Answer #4</p><textarea class="TextQuestion other-display" rows="2" cols="100"></textarea>' +
			'</div></fieldset><button class="delete-button"> Delete</button></div></div>';
	}
}

function confirmData() {
	var data = {
		titolo: document.getElementById("titoloQuiz").value,
		domande: []
	};

	var questions = document.getElementById("questions").getElementsByClassName("question");

	for (let q of questions) {
		console.log(q);
		if (q.getAttribute("id") === "QuestVF") {
			var domanda = {
				tipo: q.getAttribute("id") === "QuestVF" ? 0 : 1,
				domanda: q.getElementsByClassName("TextQuestion")[0].value,
				rispostaCorretta: q.getElementsByClassName("rigthAnswer")[0].getElementsByTagName("input")[0].checked ? "vero" : "falso"
			};
		} else {
			var domanda = {
				tipo: q.getAttribute("id") === "QuestVF" ? 0 : 1,
				domanda: q.getElementsByClassName("TextQuestion")[0].value,
				//aggiungere campi
			};
		}

		data.domande.push(domanda);
	}
	console.log(data);
	/*
	fetch("/home/creaQuiz.jsp",{
		method: "POST",
		headers: {
		  "Content-Type": "application/json",
		},
		body: JSON.stringify(data), 
	}).then((resp)=>{
		console.log(resp);
	})*/
}
