 $( document ).ready(function() {
      //1.dom이 완성되면 스크립트로 화면그려줘야지
      PetInsert();
    });


    function PetInsert(){
             //1.script에 핸들바를추가함
            let pet_insert = Handlebars.compile($('#pet_insert').html());
            //2.해당스크립트가 실행이되는 html을찾는다
            $('#content').html(pet_insert);
                console.log("@22");
             checkEmail('won77kr@hanmail.net');
        };

    function insert(){
     const param = {
            email : $("#email").val(),
            password : $("#password").val()
     }



      network.sendApi2('/api/board/insert', param, function(data){
           if(data.result == 'SUCCESS') {
              location.href = '/wanted/main';
            }
       });
    }

    function checkEmail(email){
       let regex = new RegExp('[a-z0-9]+@[a-z]+\.[a-z]{2,3}');
         console.log(regex.test(email));

        return regex.test(email);
    }

