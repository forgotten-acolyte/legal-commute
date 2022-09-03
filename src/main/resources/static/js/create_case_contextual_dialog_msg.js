$(document).ready(function(){


    $("#myBtn").click(function(){
        $("#exampleModal").load('/Users/trung/Documents/Advanced SWE/backend/legal-commute/src/main/resources/templates/modal_popup/test.html', function() {
            $("#exampleModal").dialog("open");
        });
    });
    // $.get('open.html?id='+id, function(data) {
    //     if(data == 'OK') {
    //         window.open(url);
    //     }
    // }, 'text');
});

function openModalLink(){
    // $("#duplicateDataModal").load('http://localhost:8080/modal/duplicate_data/', function() {
    //     $("#duplicateDataModal").dialog("open");
    // });
}