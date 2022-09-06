var tempdatadbid = "";

// 加载树形结构评论区
function toloadtopic(data) {
    $(".postion-add-s1").text(data.topicname);
    $(".topiccent").text(data.htnr);
}

function toloadplq(tempdata) {
    for (var i = 0; i < tempdata.length; i++) {
        if (tempdata[i].pid === "" || tempdata[i].pid === null) {
            //
            // console.log(tempdata[i].cid + "x");
            $(".spanbig").append("<li class='spanbig" +
                tempdata[i].cid + "'>" +
                tempdata[i].createname + ":" +
                tempdata[i].plnr + "<button class='hfbtn' onclick='huifu(" +
                tempdata[i].dbid + ")'>回复</button>" + "</li>");
        } else {
            //
            // console.log(tempdata[i].cid);
            $(".spanbig" + tempdata[i].pid)
                .append("<ul><li class='spanbig" +
                    tempdata[i].cid + "'>"
                    + tempdata[i].createname + ":"
                    + tempdata[i].plnr
                    + "<button class='hfbtn' onclick='huifu(" +
                    tempdata[i].dbid + ")'>回复</button>"
                    + "</li></ul>");
        }
    }
}

function huatioff() {
    $("#inputtext").val("");
    $("#tianjiahuati").css({"display": "none"})
}

function comoff() {
    $(".postion-add-s1").text("");
    $(".topiccent").text("");
    $("#PostionAddid").css({"display": "none"});
    $(".spanbiginput").css({"display": "none"});
    $("#inputtext").val("")
    $(".spanbig").children().remove();

}

function huifu(data) {
    $(".spanbiginput").css({"display": "inline-block"});
    // console.log(data)
    tempdatadbid = data;
}

function inputsubmit() {
    // console.log(tempdatadbid)
    // console.log($("#inputtext").val());
    // console.log(topcid)
    var commentcid = null;
    var commentpid = null;
    if (tempdatadbid==='') {
        $.ajax({
            type: "POST",
            url: "/comment/querycidmaxlist",
            data: {"topicid": topcid},
            success: function (data) {
                if (data.length > 0){
                    var idarry = [];
                    for (let i = 0; i < data.length; i++) {
                        idarry[i] = Number(data[i]);
                    }
                    // 获取数组中最大值 number
                    var max = Math.max.apply(null, idarry) + 1;
                    var maxstring = String(max);
                    if (maxstring.length === 1) {
                        maxstring = '000' + maxstring;
                    }
                    if (maxstring.length === 2) {
                        maxstring = '00' + maxstring;
                    }
                    if (maxstring.length === 3) {
                        maxstring = '0' + maxstring;
                    }
                    // console.log(maxstring,"maxstring")
                    savecomment(maxstring, null, $("#inputtext").val(), topcid);
                }else {
                    savecomment('0001', null, $("#inputtext").val(), topcid);
                }
            }
        });
    } else {
        $.ajax({
            type: "POST",
            url: "/comment/querycid",
            data: {"dbid": tempdatadbid, "topicid": topcid},
            success: function (data) {
                // console.log(data, "data")
                if (data.length > 0) {
                    var prefixstring = null;
                    var idarry = [];
                    for (let i = 0; i < data.length; i++) {
                        idarry[i] = Number(data[i].substring(data[i].length - 4, data[i].length))

                        var a = Number(data[i].substring(data[i].length - 4, data[i].length))

                        prefixstring = data[i].substring(0, data[i].length - 4)

                    }
                    // 获取数组中最大值 number
                    var max = Math.max.apply(null, idarry) + 1;
                    var maxstring = String(max);
                    if (maxstring.length === 1) {
                        maxstring = '000' + maxstring;
                    }
                    if (maxstring.length === 2) {
                        maxstring = '00' + maxstring;
                    }
                    if (maxstring.length === 3) {
                        maxstring = '0' + maxstring;
                    }
                    commentcid = prefixstring + maxstring;
                    commentpid = prefixstring;
                    // console.log(prefixstring, "pid")
                    // console.log(commentcid, "cid")
                    savecomment(commentcid, commentpid, $("#inputtext").val(), topcid);
                } else {
                    $.ajax({
                        type: "POST",
                        url: "/comment/querycidone",
                        data: {"dbid": tempdatadbid, "topicid": topcid},
                        success: function (data) {
                            commentcid = data + '0001';
                            commentpid = data;
                            // console.log(commentpid, "pid")
                            // console.log(commentcid, "cid")
                            savecomment(commentcid, commentpid, $("#inputtext").val(), topcid);
                        }
                    });
                }

            }
        });
    }

    $(".spanbiginput").css({"display": "none"});
    // comoff()

    setTimeout(function () {
        $(".spanbig").children().remove();
        ajaxtest(topcid)
    },500);

    // $("#inputtext").val("");
}

function savecomment(cid, pid, plnr, topicid) {
    $.ajax({
        type: "POST",
        url: "/comment/savecomment",
        data: {"cid": cid, "pid": pid, "plnr": plnr, "topicid": topicid},
        success: function () {

        }
    });
}