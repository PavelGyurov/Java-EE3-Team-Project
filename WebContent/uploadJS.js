function validateForm() { 
	var brand = document.forms["productform"]["brand"].value;
    var model = document.forms["productform"]["model"].value;
    var description = document.forms["productform"]["description"].value;
    var amountInstock = document.forms["productform"]["amountInstock"].value;
    var price = document.forms["productform"]["price"].value;
    var warranty_months = document.forms["productform"]["warranty_months"].value;
    var image = document.forms["productform"]["image"].value;
    
    if (brand == '' || model == '' || description == '' || amountInstock == '' || price == ''
    	|| warranty_months == '' || image == ''){
    	alert("Моля попълнете всички полета!");
    	return false;
    }
    if(isNaN(amountInstock) || amountInstock <= 0){
    	alert("Невалиден брой в наличност!");
    	return false;
    } 
    if(isNaN(warranty_months) || warranty_months <= 0){
    	alert("Невалидна гаранция!");
    	return false;
    } 
    if(isNaN(price) || price <= 0){
    	alert("Невалидна цена!");
    	return false;
    } 
}