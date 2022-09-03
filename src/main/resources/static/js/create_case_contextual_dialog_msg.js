$(document).ready(function(){
    let result = $("#postSubmitted").val();
    if(result){
        let popupName = getSpecificPopupModal(result);
        $("#myBtn").attr("data-target","#myModal");
        let stringHTML = '<div th:include= \"'+popupName+'\" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">\n' + '</div>';
        $($.parseHTML(stringHTML)).insertAfter($("#insertAfter" ));
        $("#myBtn").trigger('click');
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