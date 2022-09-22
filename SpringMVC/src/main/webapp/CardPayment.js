
window.addEventListener('DOMContentLoaded',()=>{

    document.querySelector('#cn').addEventListener('blur',()=>{
        document.querySelector('#cvv').disabled = false;
        document.querySelector('#cvv').addEventListener('blur',()=>{
            document.querySelector('#dt').disabled = false;
        });
        document.querySelector('#dt').addEventListener('blur',()=>{
            document.querySelector('#btn').disabled = false;
        });
      /*  document.querySelector('#dt').addEventListener('blur',()=>{
            document.querySelector('#otp').disabled = false;
            alert("OTP is sent to your registered Email-id.");
            document.querySelector('#btn').disabled = false;
        }); */
        document.querySelector('#btn').addEventListener('click',()=>{
            alert("Payment Recieved");
        });
    });
});