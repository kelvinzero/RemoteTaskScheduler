$(window).onloadend(tableScript());

function tableScript() {
    var w = (window);
    var line = new Date().getHours() * 2;
    var table = $('table');
    var row = table.find('tr').removeClass('active').eq(10).addClass('active');

    if(row.length){
        $('html,body').animate({scrollTop: row.offset().top - (w.height()/2)}, 1000 );
    }

}