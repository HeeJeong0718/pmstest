
 $( document ).ready(function() {
      replyDetail();
    });

    function replyDetail(){
       //url을 통해 get방식으로 전달된 파라미터를 js영역에서 추출하는방법
       //1현재위치를찾는다
        const parsedUrl = new URL(window.location.href);
        //2.해당 url에서 searchParams.get해서 id를 추출함
        //**에러 id를 받는데 data부분을 설정안해서 그럼 sendApi로 바꿈
          let param = parsedUrl.searchParams.get("r_id");
          console.log("parma:" + param);
          network.sendApi('/api/reply/detail',{ r_id : param},function(data){
             console.log("data22" + JSON.stringify(data));
              let PetScript = new Object();
              PetScript.detail = data.data;
             //1.script에 핸들바를추가함
            let reply_detail = Handlebars.compile($('#reply_detail').html());
            //2.해당스크립트가 실행이되는 html을찾는다
            $('#content').html(reply_detail(PetScript));
         });

       }
     function update(){
           alert("reply");
           const obj  = {
                r_id : $("#r_id").val(),
                name : $("#name").val(),
                r_contents : $("#r_contents").val()
           }
           alert("obk" + JSON.stringify(obj));
           //const obj 라고 객체를 만들고 obj 를 그대로 건내줘야하는데
           //{obj} 이런식으로 한번 더 묶어버림
           network.sendApi2('/api/reply/update', obj, function(data){
               alert("data:" +JSON.stringify(data));
               if(data.result == 'SUCCESS') {
                   location.href = '/board/board';
               }
          });
    }

    function deletePet(){

               const obj  = {
                    r_id : $("#r_id").val()
               }
               alert("obk" + JSON.stringify(obj));
               //const obj 라고 객체를 만들고 obj 를 그대로 건내줘야하는데
               //{obj} 이런식으로 한번 더 묶어버림
               network.sendApi2('/api/reply/delete', obj, function(data){
                   if(data.result == 'SUCCESS') {
                     alert("삭제되었습니다!");
                       location.href = '/board/board';
                   }
              });
        }


