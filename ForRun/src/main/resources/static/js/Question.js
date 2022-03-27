// 计时数据
window.onload = function() {
    var i = 0;
    var timer = null;
    var isRunning = false;
    funcStart();
    function $(id) {
        return document.getElementById(id);
    }
    function doubleNumber(num) {
        if (num < 10) {
            return '0' + num;
        } else {
            return num;
        }
    }
    function funcStart() {
        timer = setInterval(function() {
            i++;
            $("sec").innerHTML = doubleNumber(i % 60);
            $("min").innerHTML = doubleNumber(parseInt(i / 60) % 60);
            $("hour").innerHTML = doubleNumber(parseInt(i / 3600) % 60);
        }, 1000)
    }
    function funcPause() {
        clearInterval(timer);
    }
    //重置计时
    $("reset").onclick = function() {
        i = 0;
        clearInterval(timer);
        $("sec").innerHTML = '00';
        $("min").innerHTML = '00';
        $("hour").innerHTML = '00';
        funcStart();
    }
    //开始计时
    $("btn").onclick = function() {
        if (!isRunning) {
            $("btn").innerHTML = "开始";
            funcPause();
            isRunning = true
        } else if(isRunning){
            $("btn").innerHTML = "暂停";
            funcStart();
            isRunning = false;
        }
    }



}

// window.onload =function (){
//
// }


//  // 获得答案数据
// var ins = new Array();//存答案数组
// function getElements() {
//     console.log(gets());
// }
// function gets() {
//     var tags = document.querySelectorAll('.aa');
//     for (var i = 0; i < 20; i++) {
//         ins[i] = tags[i].value;
//     }
//     return ins;
// }



