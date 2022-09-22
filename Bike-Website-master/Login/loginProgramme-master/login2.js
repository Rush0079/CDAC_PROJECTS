function validate()
{
var username=document.getElementById("Username").value;
var password=document.getElementById("password").value;
let btn  = document.getElementById("#btn");
if(username=="admin" && password=="user")
{
    alert("Successfull");
    window.open("http://127.0.0.1:5501/Main.html");
}
else
{
    alert("Username And Password is INCORRECT");
    return false;
}


}


