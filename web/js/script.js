function uerRegistration() {

    var error = document.getElementById("error-text");
    var mobile = document.getElementById("mobile").value;
    console.log(mobile);
    var name = document.getElementById("name").value;
    console.log(name);
    var country = document.getElementById("country").value;
    console.log(country);
    var password = document.getElementById("password").value;
    console.log(password);
    var mobile = document.getElementById("mobile").value;
    console.log(mobile);
    var gender = document.getElementById("male").checked ? "Male" : "Female";
    console.log(gender);

    var obj = {mobile: mobile, name: name, country: country, password: password, gender: gender};

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {
            var respons = JSON.parse(request.responseText);

            if (respons.msg === "success") {
                window.location = "user_login.html";
            } else {
                error.innerHTML = "Mobile number already used!";
            }
        }
    };

    request.open("POST", "User_Registration", true);
    request.setRequestHeader("Content-Type", "application/json");
    request.send(JSON.stringify(obj));

}

function userLogin() {

    var error = document.getElementById("error-text");
    var mobile = document.getElementById("mobile").value;
    console.log(mobile);
    var password = document.getElementById("password").value;
    console.log(password);

    var obj = {mobile: mobile, password: password};

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {
            var respons = JSON.parse(request.responseText);

            if (respons.msg === "success") {
                window.location = "index.html";
            } else {
                error.innerHTML = "Invalid Login Details!";
            }
        }
    };

    request.open("POST", "User_Login", true);
    request.setRequestHeader("Content-Type", "application/json");
    request.send(JSON.stringify(obj));

}

function userLogout() {
    window.location = "User_Logout";
}

function viewUser() {

    var mobile = document.getElementById("mobile");
    var name = document.getElementById("name");
    var country = document.getElementById("country");
    var mobile = document.getElementById("mobile");
    var gender = document.getElementById("gender");
    
    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {
            var respons = JSON.parse(request.responseText);

            if (respons.msg === "success") {
              
            } else {
              
            }
        }
    };

    request.open("GET", "Get_User", true);
    request.send();
  
}