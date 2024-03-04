(function(network){
   const serverAddress = 'http://localhost:8080';

  //param없이 보내거나 받을때
  network.connectApi = function(apiUrl, resultFunction){
     $.ajax({
         type : 'POST',
         url  : serverAddress + apiUrl,
         xhrFields : {
            withCredentials: false
         },
         success : resultFunction,
         error : function(request, status , error){
               console.log("connectApi ERROR status222 : " + JSON.stringify(status) + " | error : " + JSON.stringify(error));
         }

     });
   };

   //param추가해서 보낼때나 받을때
    network.sendApi = function(apiUrl,sendData, resultFunction){
      $.ajax({
         type  :'POST',
         url   : serverAddress + apiUrl,
         data  : JSON.stringify(sendData),
         dataType : "json",
         contentType: 'application/json',
         success  : resultFunction,
          error : function(request, status , error){
                console.log("connectApi ERROR status222 : " + JSON.stringify(status) + " | error : " + JSON.stringify(error));
          }

      });
    };
    //form serialize();


      //param추가해서 보낼때나 받을때
        network.sendApi2 = function(apiUrl,sendData, resultFunction){
          $.ajax({
             type  :'POST',
             url   : serverAddress + apiUrl,
             data  : sendData,
               /* xhrFields: {
                             withCredentials: true
                         },*/
             //dataType : "json",
            // contentType: 'application/json',
             success  : resultFunction,
              error : function(request, status , error){
                    console.log("connectApi ERROR status222 : " + JSON.stringify(status) + " | error : " + JSON.stringify(error));
              }

          });
        };
})(network = {})