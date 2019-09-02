$(document).ready(function() {
$("#submit1").click(function() {
var username = $("#username").val();

var password = $("#password").val();
var email = $("#email").val();
var mobilenumber = $("#mobilenumber").val();
if (username == '' || password == '' || email == '' || mobilenumber == '') {
alert("Please fill all fields...!!!!!!");
} else if ((password.length) < 8) {
alert("Password should atleast 8 character in length...!!!!!!");
}
else if ((mobilenumber.length) < 8) {
	alert("Mobilenumber should be 10 digits...!!!!!!");
	}
else{
	alert("You have Successfully Registered.....");
}
});
});



/*else if (!(password).match(cpassword)) {
alert("Your passwords don't match. Try again?");
} else {
$.post("register.php", {
name1: name,
email1: email,
password1: password
}, function(data) {
if (data == 'You have Successfully Registered.....') {
$("form")[0].reset();
}
alert(data);
});
}
});
});*/