function search() {

	var searchParam = $('#searchIn').val();
	
    $.ajax({
        url: '/search/'+searchParam+'?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
//        dataType: 'json',
//        contentType: 'application/json; charset=UTF-8',
//        data: JSON.stringify($('#searchIn').val()),
        success: function (res) {

             console.log(res);

            var sneakers = '';

            for (var i in res) {

                var models = '';

                for(var j in res[i].models){
                    models += '<tr><td>'+res[i].models[j].name + '</td><td><img src="'+res[i].models[j].pathImage+'" alt="'+res[i].models[j].pathImage+'" height="192px" width="150px"></td><td>';
                }

                sneakers += '<tr><td>' + res[i].price + res[i].quantity + '</td><td>';
            }
            document.getElementById('indexResult').innerHTML = sneakers;
        } 

    })

}