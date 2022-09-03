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

        let popupName = getSpecificPopupModal(result);

        var div = document.createElement("div");
        div.setAttribute("th:insert", popupName);

        //append
        var body = document.getElementsByTagName("body")[0];
        body.appendChild(button);
        body.appendChild(div);

        document.getElementById("dynamicButton").click();
    }
});

function getSpecificPopupModal(result){
    if(!result)
        return '';

    let popupName = '';

    switch (result){
        case "incorrect":{
            popupName = "/modal_popup/incorrect:: popup";
            break;
        }
        case "duplicate":{
            popupName = "/modal_popup/duplicate_data:: popup";
            break;
        }
        case "saved":{
            popupName = "/modal_popup/saved_successful:: popup";
            break;
        }
        default:
            break;
    }
    return popupName;
}