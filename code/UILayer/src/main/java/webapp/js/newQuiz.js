function openPop(){
    document.getElementById("popup").style.display="block";
}

function closePop(option){
    document.getElementById("popup").style.display="none";
    if(option==1){
        document.getElementById("QuestVF").style.display="block";
    }
    else{
        document.getElementById("QuestMultiple").style.display="block";
    }

}
