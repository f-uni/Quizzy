function showAvatarOption(){
    var selector = document.getElementById("image-selector");
    selector.style.display = "block";
    var selection = document.getElementById("selectionButton");
    selection.style.display = "none";
}

function chosenAvatar(op){
    var target = document.getElementById("avatar");
    target.src = "/images/avatar" + op + ".png";
    var selector = document.getElementById("image-selector");
    selector.style.display = "none";
    var selection = document.getElementById("selectionButton");
    selection.style.display = "block";
    selection.style.margin = "auto";
}