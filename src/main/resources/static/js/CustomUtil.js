var ut = {};


ut.getParam = function(key){
 return new URLSearchParams(location.search).get(key);
}