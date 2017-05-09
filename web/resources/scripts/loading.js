
window.onload=function(){
  var a = document.getElementById("loading");
  a.parentNode.removeChild(a);
}
document.write('<div id="loading" style="position:fixed;left:50%;top:50%;margin-left:-width/2;margin-top:-height/2; "><img src="resources/images/loading2.gif"/></div>');
