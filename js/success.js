/**
 * Created by Ivory on 4/21/16.
 */
function tiao() {
    clearInterval(mytime);
    window.open("index.html","_self");
}

setTimeout("tiao()",5000);

function changeSec() {
    $('myspan').innerText=$('myspan').innerText-1;
}

function $(id) {
    return document.getElementById(id);
}
var mytime = setInterval("changeSec()",1000);