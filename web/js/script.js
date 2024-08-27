function uerRegistration() {
    
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
    
    var jsonObj = JSON.stringify(obj);
    
    console.log(jsonObj);
    
}