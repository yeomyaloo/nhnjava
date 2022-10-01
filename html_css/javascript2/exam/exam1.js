function validateForm(){

    var x = document.forms["form"]["password"].value;

    if(x == null || x ==""){
        alert("dont blank this field!");
        return false;
    }

}
