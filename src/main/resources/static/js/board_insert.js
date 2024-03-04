 $( document ).ready(function() {
      //1.dom이 완성되면 스크립트로 화면그려줘야지
      PetInsert();
    });


    function PetInsert(){
             //1.script에 핸들바를추가함
            let pet_insert = Handlebars.compile($('#pet_insert').html());
            //2.해당스크립트가 실행이되는 html을찾는다
            $('#content').html(pet_insert);
        };

    function insert(){
     const param = {
            name : $("#name").val(),
            contents : $("#contents").val()
     }
      network.sendApi2('/api/board/insert', param, function(data){
           if(data.result == 'SUCCESS') {
              location.href = '/board/board';
            }
       });
    }


