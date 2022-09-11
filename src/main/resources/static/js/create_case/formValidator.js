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
// }
$(document).ready(function () {
    var successfullText = document.getElementById("result").innerText;
    if (successfullText) {
        generateSuccessfulAlertMessage(successfullText);
        // $("#alertMessage").fadeOut();
        // $("#alertMessage").fadeIn();
    }
    if (globalResponse !== OK) {
        $("form").on("submit", function (e) {
            e.preventDefault();
        })
    }
})

function generateSuccessfulAlertMessage(result) {
    // var divContainer = document.getElementsByTagName("container")[0];
    if (!document.getElementById("alertMessage") && result) {
        divElement = document.createElement("div");
        divElement.setAttribute("class", "alert alert-success");
        divElement.setAttribute("role", "alert");
        divElement.setAttribute("id", "alertMessage");
        divElement.innerText = "Data has been saved successfully";
        //push this node to body
        var divContainer = document.getElementById("setMessage");
        divContainer.insertBefore(divElement, divContainer.children[0]);
        $("#alertMessage").fadeIn();
        $("#alertMessage").fadeOut();
        $("#alertMessage").fadeIn();
    }
}

/**
 * @param form
 * - construct url
 * - construct params
 * - show modal dialog
 * - call POST request
 * @returns {boolean}
 */
function submittedFieldValidation(form) {
    let url = DOMAIN + SUFFIX_ENDPOINT_VALIDATE_FIELD;
    let idCardNumber = $("#idNumber").val();
    let licensePlateNumber = $("#licensePlateNumber").val();
    //if under spring security context, there is a hidden input type csrfToken attached
    // let csrfValue = $("input[name='_csrf']").val();
    let params = {idCardNumber: idCardNumber, licensePlateNumber: licensePlateNumber}
    //call and perform form's submission context

    validateFormAjaxCall(form, url, params);
    if (globalResponse === OK) {
        form.submit();
    } else {
        getModalContent(globalResponse);
        //show modal
        buildButtonAndDialogThenTriggerClick();
    }
}

/**
 *
 * @param form
 * @param url
 * @param params
 */
function validateFormAjaxCall(form, url, params) {
    $.ajaxSetup({async: false});
    $.get(url, params, function (response) {
        if (!response)
            return;
        globalResponse = response.toLowerCase();
    }).fail(function () {
        globalResponse = "ERROR";
    });
}

function getModalContent(suffixIndicator) {
    $.ajaxSetup({async: false});
    suffixIndicator = suffixIndicator.toLowerCase();
    let url = DOMAIN + SUFFIX_ENDPOINT_GET_DYNAMIC_MODAL_CONTENT;
    let param = {htmlName: suffixIndicator}
    $.get(url, param, function (response) {
        if (!response)
            return;
        dialogHtmlContent = buildDialogModal(buttonAndModalId, response);

    }).fail(function () {
        dialogHtmlContent = "ERROR";
    });

    return dialogHtmlContent;
}

function buildButtonAndDialogThenTriggerClick() {
    //add to body
    var body = document.getElementsByTagName("body")[0];
    if (!document.getElementById("dynamicButton")) {
        buttonHtmlContent = buildButtonToTriggerDialog(buttonAndModalId, bootstrapButtonValue);
        body.appendChild(buttonHtmlContent);
    }
    if (!document.getElementById(buttonAndModalId)) {
        body.appendChild(dialogHtmlContent);
        $("#" + buttonAndModalId)[0].css({
            'position': 'fixed',
            'top': 0,
            'right': 0,
            'bottom': 0,
            'left': 0,
            'overflow': 'hidden',
            'outline': 0
        })
    }
    //trigger
    document.getElementById("dynamicButton").click();
}

function buildButtonToTriggerDialog(buttonAndModalId, bootstrapButtonValue) {
    //button division
    var button = document.createElement("button");
    button.setAttribute("onclick", "popup();return false;")
    button.setAttribute("class", "btn " + bootstrapButtonValue);
    button.setAttribute("id", "dynamicButton");
    button.setAttribute("type", "button");
    button.setAttribute("style", "display:none;");
    return button;
}

function popup() {
    $("#" + buttonAndModalId).modal('show');
    $("#" + buttonAndModalId).appendTo("body");
    //cheat
    var existingModal = document.getElementsByClassName("modal-backdrop in")[0];
    if (existingModal) {
        existingModal.style.zIndex = "0";
    }

}

function buildDialogModal(buttonAndModalId, response) {
    //dialog modal devision
    dialogHtmlContent = document.createElement("div");
    dialogHtmlContent.setAttribute("class", "modal-fade");
    dialogHtmlContent.setAttribute("id", buttonAndModalId);
    dialogHtmlContent.setAttribute("aria-labelledby", buttonAndModalId + "Label");
    dialogHtmlContent.setAttribute("aria-hidden", true);
    // dialogHtmlContent.setAttribute("style", "visibility: hidden;");
    dialogHtmlContent.setAttribute("role", "dialog");
    dialogHtmlContent.setAttribute("tabindex", "0");
    // dialogHtmlContent.setAttribute("data-backdrop", "false");
    dialogHtmlContent.setAttribute("data-background", "true");
    // // dialogHtmlContent.setAttribute("style", "display: none;")
    // dialogHtmlContent.setAttribute("style", "position: fixed;");
    // dialogHtmlContent.setAttribute("style","top: 0;");
    // dialogHtmlContent.setAttribute("style","right: 0;");
    // dialogHtmlContent.setAttribute("style","bottom: 0;");
    // dialogHtmlContent.setAttribute("style","left: 0;");
    // dialogHtmlContent.setAttribute("style","z-index: 1050;");
    // dialogHtmlContent.setAttribute("style","overflow: hidden;");
    // dialogHtmlContent.setAttribute("style","outline : 0;");

    // $this = dialogHtmlContent;

    dialogHtmlContent.innerHTML = response;

    return dialogHtmlContent;
}