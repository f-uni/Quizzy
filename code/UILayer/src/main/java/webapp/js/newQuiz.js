function openPop(){
    document.getElementById("popup").classList.remove("popup-display-none");
    console.log("1");
}
var contatore=0;
function closePop(option){
    contatore++;
    document.getElementById("confirmbutton").style.display="block";
    document.getElementById("popup").classList.add("popup-display-none");
    if(option==1){
        document.getElementById("question").innerHTML+='<div class="question" id="QuestVF">'+
        '<p style="padding:20px"> Question #'+contatore+'</p><textarea class="TextQuestion" rows="4" cols="200"></textarea>'+
        '<fieldset class="rigthAnswer"><legend>Select the right answer:</legend><div><input type="radio" id="1Ans'+ contatore +'" checked />'+
        '<label for="huey">True</label></div><div><input type="radio" id="2Ans'+contatore+'" name="drone" value="dewey" /><label for="dewey">False</label>'+
        '</div></fieldset><button class="delete-button"> Delete </button></div>';
    }
    else{
        document.getElementById("question").innerHTML+='<div>'+
        '<div class="question" id="QuestMultiple"><p style="padding:20px"> Question #'+contatore+'</p>'+
        '<textarea class="TextQuestion" rows="4" cols="200"></textarea><fieldset class="rigthAnswer">'+
        '<legend style="margin-bottom: 10px;">Select the right answer:</legend><div><input type="radio" id="1Ans'+ contatore +'" checked />'+
        '<p class="p-answer"> Answer #1</p><textarea class="TextQuestion other-display" rows="2" cols="100"></textarea>'+
        '</div><div><input type="radio" id="dewey" name="drone" value="2Ans'+ contatore +'" /><p class="p-answer"> Answer #2</p><textarea class="TextQuestion other-display" rows="2" cols="100">'+
        '</textarea></div><div><input type="radio" id="3Ans'+ contatore +'" checked /><p class="p-answer"> Answer #3</p>'+
        '<textarea class="TextQuestion other-display" rows="2" cols="100"></textarea></div><div><input type="radio" id="4Ans'+ contatore +'" name="drone" value="dewey" />'+
        '<p class="p-answer"> Answer #4</p><textarea class="TextQuestion other-display" rows="2" cols="100"></textarea>'+
        '</div></fieldset><button class="delete-button"> Delete</button></div></div>';
    }

}
