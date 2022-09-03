
$(document).ready(function(){
    $("#myBtn").click(openModalLink());
    // $.get('open.html?id='+id, function(data) {
    //     if(data == 'OK') {
    //         window.open(url);
    //     }
    // }, 'text');
});

function openModalLink(){
    $("#duplicateDataModal").load('/templates/modal_popup/duplicate_data.html', function() {
        $("#duplicateDataModal").dialog("open");
    });
}