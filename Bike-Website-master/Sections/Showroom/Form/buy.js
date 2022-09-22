
        function validate()
       {
       var fna=document.getElementById("fna").value;
       var lna=document.getElementById("lna").value;
       if(fna=="admin"&& lna=="user")
       {
           alert("Succesful");
           window.open("http://127.0.0.1:5501/Sections/Payment.html");
       }
       else
       {
           alert("Enter Required fields");
       }
       
       
       }
       