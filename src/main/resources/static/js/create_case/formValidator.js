
// let DOMAIN = "http://localhost:8080";
let DOMAIN = "localhost:8080/create-case";

/**
 *
 * @param form
 * - construct url
 * - construct params
 * - show modal dialog
 * - call POST request
 * @returns {boolean}
 */
function submittedFieldValidation(form){

    let url = DOMAIN + '/validate-field';
    let idCardNumber = $("#idNumber").val();
    let licensePlateNumber = $("#licensePlateNumber").val();


    //if under spring security context, there is a hidden input type csrfToken attached
    // let csrfValue = $("input[name='_csrf']").val();
    let params = {idCardNumber: idCardNumber, licensePlateNumber : licensePlateNumber}

    //call and perform form's submission context
    callRestApi(form, url, params);
}

function callRestApi(form, url, params){
    $.post(url, params, function (response){
        if (!response)
            return;
        if (response === "OK"){
            form.submit();
        }else if(response === "DUPLICATED"){
            //show modal dialog
            showModalDialog("WARNING", "duplicate data");
            // alert("The" + params['licensePlateNumber'] + "LPN already exists ");
        }else{
            showModalDialog("error", "unknown response from server");
        }
    }).fail(function (){
       showModalDialog("Error ", "Cant connect to server");
    });
}

function showModalDialog(title, message){
    $("#modalTitle").text(title);
    $("#modalBody").text(message);
    //show modal dialog
    $("#modalDialog").modal();
}