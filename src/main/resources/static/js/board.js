
 $( document ).ready(function() {
      PetInfo();
    });

    function PetInfo(){
         let data2 = new Object();
         let memberScript = new Object();
          network.connectApi('/api/board/list',function(data){
             console.log("data22" + JSON.stringify(data));
              memberScript.list =data.data;

            let member_contents_row = Handlebars.compile($('#member_contents_row').html());
            let table_template = Handlebars.compile($('#table_template').html());

            let member_template = Handlebars.compile($('#member_template').html());
              $('#set_member_template').html(member_template(memberScript)).promise().done(function(){
                    $('#list').append(member_contents_row(memberScript));
                    $('#listbody').html(table_template(memberScript));
           });
         });
       }
