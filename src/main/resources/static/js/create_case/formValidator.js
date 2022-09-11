let DOMAIN = "http://localhost:8080/create-case/";
//the 3 fields below are exactly mapped to html file names under /templates/modal_popup
//and spring controller
let DUPLICATE = 'duplicate_data';
let OK = 'saved_successful';
let INCORRECT = 'incorrect';

let SUFFIX_ENDPOINT_VALIDATE_FIELD = "validate-field/";
let SUFFIX_ENDPOINT_GET_DYNAMIC_MODAL_CONTENT = "dynamic-modal/";

var globalResponse = "";
var dialogHtmlContent = "";
var buttonHtmlContent = "";
var buttonAndModalId = "modalDialog";
var bootstrapButtonValue = "btn-primary";

// $("#myBtn").click(function (e){
//     e.preventDefault();
//     //
//     // $("#" + buttonAndModalId).modal({
//     //     show: true,
//     //     backdrop: 'static',
//     //     keyboard: true
//     // })
// })


// $(document).ready(function(){
//     $('[data-toggle="tooltip"]').tooltip();
// })

$("form").on("submit",function (e){
    e.preventDefault();
})

/**
 * @param form
 * - construct url
 * - construct params
 * - show modal dialog
 * - call POST request
 * @returns {boolean}
 */
function submittedFieldValidation(form){
    let url = DOMAIN + SUFFIX_ENDPOINT_VALIDATE_FIELD;
    let idCardNumber = $("#idNumber").val();
    let licensePlateNumber = $("#licensePlateNumber").val();
    //if under spring security context, there is a hidden input type csrfToken attached
    // let csrfValue = $("input[name='_csrf']").val();
    let params = {idCardNumber: idCardNumber, licensePlateNumber : licensePlateNumber}
    //call and perform form's submission context
    validateFormAjaxCall(form, url, params);
    getModalContent(globalResponse);
    //show modal
    buildButtonAndDialogThenTriggerClick();

    if (globalResponse === OK){
        form.submit();
    }
}

function nestModalDialogAndShow(){
    buttonHtmlContent = buildButtonToTriggerDialog(buttonAndModalId, bootstrapButtonValue);
    // $("#modalDialog").replaceWith(dialogHtmlContent);
    // $("#dynamicButton").replaceWith(buttonHtmlContent);
    // $("#dynamicButton").click();
    // $("#modalDialog").modal();
    // $("#modalDialog").modal('toggle');
    // $("#modalDialog").dialog('open');
}

/**
 *
 * @param form
 * @param url
 * @param params
 */
function validateFormAjaxCall(form, url, params){
    $.ajaxSetup({async: false});
    $.get(url, params, function (response){
        if (!response)
            return;
        globalResponse = response.toLowerCase();
    }).fail(function (){
        globalResponse = "ERROR";
    });
}

function getModalContent(suffixIndicator){
    $.ajaxSetup({async: false});
    suffixIndicator = suffixIndicator.toLowerCase();
    let url = DOMAIN + SUFFIX_ENDPOINT_GET_DYNAMIC_MODAL_CONTENT;
    let param  = {htmlName : suffixIndicator}
    $.get(url, param, function (response){
        if (!response)
            return;
        dialogHtmlContent = buildDialogModal(buttonAndModalId, response);
        
    }).fail(function () {
        dialogHtmlContent = "ERROR";
    });

    return dialogHtmlContent;
}

function buildButtonAndDialogThenTriggerClick(){

    buttonHtmlContent = buildButtonToTriggerDialog(buttonAndModalId, bootstrapButtonValue);

    //add to body
    var body = document.getElementsByTagName("body")[0];
    body.appendChild(buttonHtmlContent);
    body.appendChild(dialogHtmlContent);

    //trigger
    document.getElementById("dynamicButton").click();
}

function buildButtonToTriggerDialog(buttonAndModalId, bootstrapButtonValue){
    //button division
    var button = document.createElement("button");
    button.setAttribute("data-target", "#" + buttonAndModalId);
    button.setAttribute("data-toggle", "modal");
    button.setAttribute("class", "btn " + bootstrapButtonValue);
    button.setAttribute("id", "dynamicButton");
    button.setAttribute("type", "button");
    button.setAttribute("style", "display:none;");
    // button.setAttribute("style", "visibility: hidden;");
    return button;
}

function buildDialogModal(buttonAndModalId, response){
    //dialog modal devision
    dialogHtmlContent = document.createElement("div");
    dialogHtmlContent.setAttribute("class","modal-fade");
    dialogHtmlContent.setAttribute("id", buttonAndModalId);
    dialogHtmlContent.setAttribute("aria-labelledby", buttonAndModalId + "Label");
    dialogHtmlContent.setAttribute("aria-hidden", true);
    // dialogHtmlContent.setAttribute("style", "visibility: hidden;");
    dialogHtmlContent.setAttribute("role","dialog");
    dialogHtmlContent.setAttribute("tabindex","-1");
    dialogHtmlContent.setAttribute("style", "display:none;");
    dialogHtmlContent.innerHTML = response;

    return dialogHtmlContent;
}