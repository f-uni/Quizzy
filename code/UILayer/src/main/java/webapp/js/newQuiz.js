//global variables
var active=0;
var contatore=0;

var confirmedQuest = [];
var confirmedAnsw = [];
var confirmedRigthAns = []; 

//opens popups
function openPop(){
    document.getElementById("popup").classList.remove("popup-display-none");
}

//close popups and creates elements with all data saved by the user
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
        '<p style="padding:20px"> Question #'+contatore+'</p><input class="TextQuestion" id="InputQM'+contatore+'">'+
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
        '<legend style="margin-bottom: 10px;">Select the right answer:</legend><div><input type="radio" id="1Ans'+ contatore +'" name="drone"/>'+
        '<p class="p-answer"> Answer #1</p><input class="TextQuestion other-display" id="input1'+contatore+'">'+
        '</div><div><input type="radio"  name="drone" id="2Ans'+ contatore +'" /><p class="p-answer"> Answer #2</p><input class="TextQuestion other-display" id="input2'+ contatore+'">'+
        '</div><div><input type="radio"  name="drone" id="3Ans'+ contatore +'" /><p class="p-answer"> Answer #3</p>'+
        '<input class="TextQuestion other-display" id="input3'+contatore+'"></div><div><input type="radio" id="4Ans'+ contatore +'" name="drone" value="dewey" />'+
        '<p class="p-answer"> Answer #4</p><input class="TextQuestion other-display" id="input4'+contatore+'">'+
        '</div></fieldset><button class="delete-button" onclick="deleteQuest()"> Delete</button>'+
        '<button class="delete-button" onclick=saveInput("QuestM")> Save </button></div></div>';
        
    }
}

//saves data from Input when users confirms 
function saveInput(opt){
    active--;
    changeContent(opt);
}

function swapContent(opt){
    var out = [];
    if(opt=="QuestM"){
    out[1]=document.getElementById("input1"+contatore).value;
    out[2]=document.getElementById("input2"+contatore).value;
    out[3]=document.getElementById("input3"+contatore).value;
    out[4]=document.getElementById("input4"+contatore).value;
    }
    out[0]=document.getElementById("InputQM"+contatore).value;
    return out
}
//Change the place in which the questions are stored
function changeContent(opt){
    var output = swapContent(opt);
    var checked = checkOpt(opt);
    if(opt=="QuestVF"){
        document.getElementById("questionWrapped").innerHTML+='<div class="question wrapped" id="'+opt+'Wrapped'+contatore+'">'+
        '<button class="deleteSingleQuestion" onclick="deleteQuest2(this.id)" id="'+ contatore +'"><img class="bin" src="/images/rubbish.png" ></button>'+
        '<p style="padding:20px" class="titleQ" id="titleQ'+contatore+'">Question#'+ contatore +": <br>" + output[0].slice(0,-1)+'</p><p class="p-answer">'+
        '</p><p class="p-answer is-padded">Answer:</p><br><p class="p-answer is-padded">&#8226; True</p><br><p class="p-answer is-padded"> &#8226; False</p><br>'+
        '<p class="p-answer is-padded is-right ">Right Answer:'+ checked +'</p></div>'
        document.getElementById("question").removeChild(document.getElementById("question").firstChild);
    }
    else{
        document.getElementById("questionWrapped").innerHTML+='<div class="question wrapped" id="'+opt+'Wrapped'+contatore+'">'+
        '<button class="deleteSingleQuestion" onclick="deleteQuest2(this.id)" id="'+ contatore +'"><img class="bin" src="/images/rubbish.png" ></button>'+
        '<p style="padding:20px" class="titleQ" id="titleQ'+contatore+'">Question#'+contatore +": <br>" + output[0]+'</p><p class="p-answer">'+
        '</p><p class="p-answer is-padded">Answer:</p><br><p class="p-answer is-padded" id="ans1"'+ contatore +'>&#8226;'+ output[1]+'<br>'+
        '</p><p class="p-answer is-padded" id="ans2"'+ contatore +'> &#8226;'+ output[2]+'</p><br>'+
        '</p><p class="p-answer is-padded" id="ans3"'+ contatore +'> &#8226;'+ output[3]+'</p><br>'+
        '</p><p class="p-answer is-padded" id="ans4"'+ contatore +'> &#8226;'+ output[4]+'</p><br>'+
        '<p class="p-answer is-padded is-right ">Right Answer:'+ checked +'</p></div>'
        document.getElementById("question").removeChild(document.getElementById("question").firstChild);
    }
    
}

//Checks which answers is checked ad correct, in case is not selected is choosen the last one
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
            radioCheck = document.getElementById("input1"+contatore).value;
        }
        else if(document.getElementById("2Ans"+contatore).checked){
            radioCheck = document.getElementById("input2"+contatore).value;
        }
        else if(document.getElementById("3Ans"+contatore).checked){
            radioCheck = document.getElementById("input3"+contatore).value;
        }
        else if(document.getElementById("4Ans"+contatore).checked){
            radioCheck = document.getElementById("input4"+contatore).value;
        }
        else{
            alert("no answer selected");
        }
    }
    return radioCheck;
}

//Deletes the questions from a button in which the element is not already saved
function deleteQuest(){
    document.getElementById("question").removeChild(document.getElementById("question").firstChild);
    contatore--;
    active--;
}

//Deletes the questions from a button in which the element is already saved
function deleteQuest2(id){
    if(active==1){
        alert("please confirm before deleting elements");
        
    }
    else{
        contatore--;
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
      
      //Change tile of questions
      var quest = document.getElementsByClassName("titleQ");
      var text;
      for(var j=1; j<=(quest.length) ; j++){
          if(j!=ids){
              quest.item(j-1).innerText = "Question#"+j;
          }
      }
    }
   
}

//saves all data in confirmed variables
function confirmAllData(){
    confirmedQuest = document.getElementsByClassName("titleQ");
    confirmedRigthAns = document.getElementsByClassName("is-right");
    var temp = [];
    for(var j=0; j<confirmedRigthAns.length;j++){ 
        for(var i=1;i<5;i++){
            temp[i]=document.getElementById("ans"+i+j);
        }
        confirmedAnsw.push(temp);
    }
}
    