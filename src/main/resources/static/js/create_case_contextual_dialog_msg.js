$(document).ready(function(){
    let result = $("#postSubmitted").val();
    if(result){
        // 1. Create the button
        var button = document.createElement("button");
        button.setAttribute("data-target", "#myModal");
        button.setAttribute("data-toggle", "modal");
        button.setAttribute("id", "dynamicButton");

        // 3. Add event handler
        // button.addEventListener ("click", function() {
        //     alert("did something");
        // });
        let popupName = getSpecificPopupModal(result);

        // let stringHTML = '<div th:include= \"'+popupName+'\" id="myModal">\n' + '</div>';

        var div = document.createElement("div");
        div.setAttribute("id", "myModal");
        div.setAttribute("th:include", popupName);

        var body = document.getElementsByTagName("body")[0];
        body.appendChild(button);
        body.appendChild(div);

        $("#dynamicButton").trigger('click');
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