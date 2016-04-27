function validateForm() {
    var name = document.forms["regform"]["name"].value;
    var email = document.forms["regform"]["email"].value;
    var password = document.forms["regform"]["password"].value;
    var cpassword = document.forms["regform"]["cpassword"].value;
    var firstname = document.forms["regform"]["firstname"].value;
    var lastname = document.forms["regform"]["lastname"].value;
    var phone = document.forms["regform"]["phone"].value;
    var town = document.forms["regform"]["town"].value;
    var street = document.forms["regform"]["street"].value;
    var streetnumber = document.forms["regform"]["streetnumber"].value;
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    

    if (name == '' || email == '' || password == '' || cpassword == '' || firstname == ''
    	|| lastname == '' || phone == '' || town == '' || street == '' || streetnumber == '') {
    	alert("Моля попълнете всички полета!");
    	return false;
    } else if ((password.length) < 6) {
    	alert("Паролата трябва да е поне 6 символа!");
    	return false;	
    } else if (!(password).match(cpassword)) {
    	alert("Паролите не съвпадат!");
    	return false;
    } else if(!re.test(email)){
    	alert("Невалиден email!");
    	return false;
    } else if(isNaN(streetnumber) || streetnumber <= 0 || streetnumber > 1000){
    	alert("Невалиден номер на улица!");
    	return false;
    } else if(isNaN(phone) || phone < 0){
    	alert("Невалиден телефонен номер!");
    	return false;
    } 
}	