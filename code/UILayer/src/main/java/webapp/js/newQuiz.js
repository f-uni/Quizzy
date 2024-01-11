function confirmData() {
	var data = {
		titolo: document.getElementById("titoloQuiz").value,
		domande: []
	};

	var questions = document.getElementById("questions").getElementsByClassName("question");

	for (let q of questions) {
		if (q.getAttribute("id") === "QuestVF") {
			var domanda = {
				tipo: q.getAttribute("id") === "QuestVF" ? 0 : 1,
				domanda: q.getElementsByClassName("TextQuestion")[0].value,
				rispostaCorretta: q.getElementsByClassName("rigthAnswer")[0].getElementsByTagName("input")[0].checked ? "vero" : "falso"
			};
		} else {
			var risposte=q.getElementsByClassName("TextAnswer");
			var stringheRisposte=[];
			for(let r of risposte){
				stringheRisposte.push(r.value.toString());
			}
			var i=0;
			for( let  r of q.getElementsByClassName("rigthAnswer")[0].getElementsByTagName("input")){
				if(r.checked)
					break;
				i++
			}
			var domanda = {
				tipo: q.getAttribute("id") === "QuestVF" ? 0 : 1,
				domanda: q.getElementsByClassName("TextQuestion")[0].value,
				risposte: stringheRisposte,
				rispostaCorretta:stringheRisposte[i]
			};
		}

		data.domande.push(domanda);
	}
	
	//TODO: inserire controlli
	
	fetch("/home/creaQuiz.jsp",{
		method: "POST",
		headers: {
		  "Content-Type": "application/json",
		},
		body: JSON.stringify(data), 
	}).then((resp)=>{
		console.log(resp.status);
		if(resp.ok)
			;//redirect
		else
			;//errore
	})
}
function openPop(){
    document.getElementById("popup").classList.remove("popup-display-none");
}
var active=0;
var contatore=0;
var questions = [];
var answers = [];
function closePop(option){
    contatore++;
    document.getElementById("confirmbutton").style.display="block";
    document.getElementById("popup").classList.add("popup-display-none");
    if(option==1){
        active++;
        if(active>1){
            contatore--;
            alert("Confirm previous elements before continuing");
            exit;
        }
        document.getElementById("question").innerHTML+='<div class="question" id="QuestVF'+contatore+'">'+
        '<p style="padding:20px"> Question #'+contatore+'</p><input class="TextQuestion" id="InputQ'+contatore+'">'+
        '<fieldset class="rigthAnswer"><legend>Select the right answer:</legend><div><input type="radio" id="1Ans'+ contatore +'" name="answerVF" value="true"  />'+
        '<label for="1Ans'+contatore+'">True</label></div><div><input type="radio" id="2Ans'+contatore+'" name="answerVF" value="false" /><label for="false">False</label>'+
        '</div></fieldset><button class="delete-button"  onclick="deleteQuest()"> Delete </button>'+
        '<button class="delete-button" onclick=saveInput("QuestVF")> Save </button></div>';
    }
    else{
        active++;
        if(active>1){
            contatore--;
            alert("Confirm previous elements before continuing");
            exit;
        }

        document.getElementById("question").innerHTML+='<div><div class="question" id="QuestMultiple'+contatore+'"><p style="padding:20px"> Question #'+contatore+'</p>'+
        '<input class="TextQuestion"id="InputQM'+contatore+'"><fieldset class="rigthAnswer">'+
        '<legend style="margin-bottom: 10px;">Select the right answer:</legend><div><input type="radio" id="1Ans'+ contatore +'" />'+
        '<p class="p-answer"> Answer #1</p><input class="TextQuestion other-display" id="input1'+contatore+'">'+
        '</div><div><input type="radio" id="dewey" name="drone" value="2Ans'+ contatore +'" /><p class="p-answer"> Answer #2</p><input class="TextQuestion other-display" id="input2'+ contatore+'">'+
        '</div><div><input type="radio" id="3Ans'+ contatore +'" /><p class="p-answer"> Answer #3</p>'+
        '<input class="TextQuestion other-display" id="input3'+contatore+'"></div><div><input type="radio" id="4Ans'+ contatore +'" name="drone" value="dewey" />'+
        '<p class="p-answer"> Answer #4</p><input class="TextQuestion other-display" id="input4'+contatore+'">'+
        '</div></fieldset><button class="delete-button" onclick="deleteQuest()"> Delete</button>'+
        '<button class="delete-button" onclick=saveInput("QuestM")> Save </button></div></div>';
        
    }
}


function saveInput(opt){
    active--;
    console.log(contatore);
    var wrap=[];
    if(opt=="QuestVF"){
        wrap.push("true");
        wrap.push("false");
        var quest = document.getElementById("InputQ"+contatore).value;
    }
    else{
        wrap.push(document.getElementById("input1"+contatore).value);
        wrap.push(document.getElementById("input2"+contatore).value);
        wrap.push(document.getElementById("input3"+contatore).value);
        wrap.push(document.getElementById("input4"+contatore).value);
        var quest = document.getElementById("InputQM"+contatore).value;
    }
    console.log(quest)
    questions.push(quest);
    answers.push(wrap);
    console.log(wrap);
    console.log(typeof wrap)
    changeContent(opt);
}


function changeContent(opt){
    var checked = checkOpt(opt);
    if(opt=="QuestVF"){
        document.getElementById("questionWrapped").innerHTML+='<div class="question wrapped" id="'+opt+'Wrapped'+contatore+'">'+
        '<button class="deleteSingleQuestion" onclick="deleteQuest2(this.id)" id="'+ contatore +'"><img class="bin" src="/images/rubbish.png" ></button>'+
        '<p style="padding:20px">Question#'+ contatore +": <br>" + questions[contatore-1].slice(0,-1)+'</p><p class="p-answer">'+
        '</p><p class="p-answer is-padded">Answer:</p><br><p class="p-answer is-padded">&#8226; True</p><br><p class="p-answer is-padded"> &#8226; False</p><br>'+
        '<p class="p-answer is-padded">Right Answer:'+ checked +'</p></div>'
        document.getElementById("question").removeChild(document.getElementById("question").firstChild);
        console.log(questions[contatore]);
    }
    else{
        var ans = answers[contatore-1];
        document.getElementById("questionWrapped").innerHTML+='<div class="question wrapped" id="'+opt+'Wrapped'+contatore+'">'+
        '<button class="deleteSingleQuestion" onclick="deleteQuest2(this.id)" id="'+ contatore +'"><img class="bin" src="/images/rubbish.png" ></button>'+
        '<p style="padding:20px">Question#'+contatore +": <br>" + questions[contatore-1].slice(0,-1) +'</p><p class="p-answer">'+
        '</p><p class="p-answer is-padded">Answer:</p><br><p class="p-answer is-padded">&#8226;'+ ans[0].slice(0,-1)+'<br>'+
        '</p><p class="p-answer is-padded"> &#8226;'+ ans[1].slice(0,-1)+'</p><br>'+
        '</p><p class="p-answer is-padded"> &#8226;'+ ans[2].slice(0,-1)+'</p><br>'+
        '</p><p class="p-answer is-padded"> &#8226;'+ ans[3].slice(0,-1)+'</p><br>'+
        '<p class="p-answer is-padded">Right Answer:'+ checked +'</p></div>'
        document.getElementById("question").removeChild(document.getElementById("question").firstChild);
    }
    
}

function checkOpt(opt){
    var radioCheck;
    document.getElementById(opt+contatore);
    if(opt=="QuestVF"){
        if(document.getElementById("1Ans"+contatore).checked)
        {
            radioCheck = "True";
        }
        else{
            radioCheck = "False";
        }
    }
    else{
        if(document.getElementById("1Ans"+contatore).checked){
            radioCheck = document.getElementById("1Ans"+contatore).value;
        }
        if(document.getElementById("1Ans"+contatore).checked){
            radioCheck = document.getElementById("2Ans"+contatore).value.split(0,-1);
        }
        if(document.getElementById("1Ans"+contatore).checked){
            radioCheck = document.getElementById("3Ans"+contatore).value.split(0,-1);
        }
        else{
            radioCheck = document.getElementById("4Ans"+contatore).value.split(0,-1);
        }
    }
    return radioCheck;
}

function deleteQuest(){
    document.getElementById("question").removeChild(document.getElementById("question").firstChild);
    contatore--;
    active--;
    answers.pop();
    questions.pop();
}

function deleteQuest2(id){
    //remove a selected div
    var wrapped = document.getElementsByClassName("wrapped");
    var ids;
    var element;
    for(var i=0;i<wrapped.length;i++){
        element=wrapped[i]
        var e = element.id;
        if(e.includes(id)){
            ids= element.id;
        }
    }
    document.getElementById("questionWrapped").removeChild(document.getElementById(ids));
    //remove arrays questions and answers
    //removeElement(id);
    //replace tag 
    for(var j=0; j<wrapped.length ; j++)
	{}
}

function removeElement(id){
    var a = answers.slice(0, id-1);
    var b = answers.slice(id,-1);
    var answers = a.concat(b);
    console.log(answers)
}