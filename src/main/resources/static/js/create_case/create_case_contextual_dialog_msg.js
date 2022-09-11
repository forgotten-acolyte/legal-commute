$(document).ready(function(){
    let result = $("#postSubmitted").val();
    if(result){
        // 1. Create the button
        var button = document.createElement("button");
        button.setAttribute("data-target", "#myModal");
        button.setAttribute("data-toggle", "modal");
        button.setAttribute("id", "dynamicButton");
        button.setAttribute("type", "button");
        button.setAttribute("style", "display:none;");

        //2. create the div
        let popupName = getSpecificPopupModal(result);
        var div = document.createElement("div");
        // div.setAttribute("id", "myModal");
        div.setAttribute("th:replace", popupName);
        //append
        var body = document.getElementsByTagName("body")[0];
        body.appendChild(button);
        body.appendChild(div);

        document.getElementById("dynamicButton").click();
    }
});