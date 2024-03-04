
 $( document ).ready(function() {
      PetDetail();
    });

    function PetDetail(){
       //url을 통해 get방식으로 전달된 파라미터를 js영역에서 추출하는방법
       //1현재위치를찾는다
        const parsedUrl = new URL(window.location.href);
        //2.해당 url에서 searchParams.get해서 id를 추출함
        //**에러 id를 받는데 data부분을 설정안해서 그럼 sendApi로 바꿈
          let param = parsedUrl.searchParams.get("b_id");
          console.log("parma:" + param);
          network.sendApi('/api/board/detail',{ b_id : param},function(data){
             console.log("data22" + JSON.stringify(data));
              let PetScript = new Object();
              PetScript.detail = data.data;
             //1.script에 핸들바를추가함
            let pet_detail = Handlebars.compile($('#pet_detail').html());
            //2.해당스크립트가 실행이되는 html을찾는다
            $('#content').html(pet_detail(PetScript));

            let b_id = $("#b_id").val();
            console.log("b_id??" + b_id);

            network.sendApi('/api/reply/list',{ b_id : b_id },function(data){
               let replyScript = new Object();
               console.log("data22" + JSON.stringify(data));
               replyScript.reply = data.data;
              let member_contents_row = Handlebars.compile($('#member_contents_row').html());

              let member_template = Handlebars.compile($('#member_template').html());
                $('#set_member_template').html(member_template(replyScript)).promise().done(function(){
                      $('#reply').append(member_contents_row(replyScript));
             });
           });
         });

        /* network.sendApi('/api/reply/list',{ b_id : 1 },function(data){
               let replyScript = new Object();
               console.log("data22" + JSON.stringify(data));
               replyScript.reply = data.data;
             console.log("data22" + JSON.stringify(data.data.name));
              let member_contents_row = Handlebars.compile($('#member_contents_row').html());

              let member_template = Handlebars.compile($('#member_template').html());
                $('#set_member_template').html(member_template(replyScript)).promise().done(function(){
                      $('#reply').append(member_contents_row(replyScript));
             });
           });*/
       }
     function update(){
           alert("!!!");
           const obj  = {
                b_id : $("#b_id").val(),
                name : $("#name").val(),
                contents : $("#contents").val()
           }
           alert("obk" + JSON.stringify(obj));
           //const obj 라고 객체를 만들고 obj 를 그대로 건내줘야하는데
           //{obj} 이런식으로 한번 더 묶어버림
           network.sendApi2('/api/board/update', obj, function(data){
               alert("data!!!");
               alert("data:" + data);
               if(data.result == 'SUCCESS') {
                   location.href = '/board/board';
               }
          });
    }

    function deletePet(){

               const obj  = {
                    b_id : $("#b_id").val()
               }
               alert("obk" + JSON.stringify(obj));
               //const obj 라고 객체를 만들고 obj 를 그대로 건내줘야하는데
               //{obj} 이런식으로 한번 더 묶어버림
               network.sendApi2('/api/board/delete', obj, function(data){
                   if(data.result == 'SUCCESS') {
                     alert("삭제되었습니다!");
                       location.href = '/board/board';
                   }
              });
        }


