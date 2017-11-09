

function scrollFunc() {

    var date = new Date();
    var line = date.getHours();

    var w = $(window);
    var row = $('tbody').find('tr').eq();

    if (row.length){
        $('html,body').animate({scrollTop: row.offset().top - (w.height()/2)}, 1000 );
    }
}
