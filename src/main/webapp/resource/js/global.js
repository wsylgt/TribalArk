/*!
 * DESCRIBE: 动态改变form表单URL路径、全局方法汇总
 * Copyright 2016-2016 .
 * AUTHOR 王国栋
 * VERSION 1.0 2016/04/25
 */
/**
 * 动态改变form表单URL路径
 * @param propLabel this
 * @param eventName controller层方法路径
 */
var fnDynamicForm = function (propLabel, eventName) {
    var prop = $(propLabel).parents("form");
    /* 获得该页面原始action属性值：根路径/controller类路径 */
    var propForm = prop.attr("action");
    /* 若后缀以eventName结尾表示已是正确路径 */
    if ((propForm.indexOf(eventName) != -1 && propForm.indexOf(eventName) == (propForm.length - eventName.length))
        || propForm.indexOf(eventName + "?") != -1) {
        prop.find(":submit").click();
        return;
    }
    /* 组合正确的action属性值：根路径/controller类路径/方法路径 */
    var toForm = propForm + eventName;
    /* 给action属性赋值，全路径 */
    prop.attr("action", toForm);
    prop.find(":submit").click();
}

/**
 * 自动格式化输入的数字/千位分隔符
 * @param number：role框的value值
 * 使用方法：onchange="this.value=fnNumberFormatter(this.value)"
 */
var fnNumberFormatter = function (number) {
    if (/[^0-9\.]/.test(number)) return "invalid value";
    number = number.replace(/^(\d*)$/, "$1.");
    number = (number + "00").replace(/(\d*\.\d\d)\d*/, "$1");
    number = number.replace(".", ",");
    var re = /(\d)(\d{3},)/;
    while (re.test(number))
        number = number.replace(re, "$1,$2");
    number = number.replace(/,(\d\d)$/, ".$1");
    return number.replace(/^\./, "0.");
}
/**
 * 自动去掉格式化输入的数字/千位分隔符
 * @param number：role框的value值
 * 使用方法：onchange="this.value=fnUndoFormatter(this.value)"
 */
var fnUndoFormatter = function (number) {
    var num = number.replace(/\,/g, '');
    return num;
}

/**
 * 返回顶部特效
 */
function goTopEx() {
    var obj = document.getElementById("goTopBtn");

    function getScrollTop() {
        return document.documentElement.scrollTop + document.body.scrollTop;
    }

    function setScrollTop(value) {
        if (document.documentElement.scrollTop) {
            document.documentElement.scrollTop = value;
        } else {
            document.body.scrollTop = value;
        }
    }

    window.onscroll = function () {
        getScrollTop() > 0 ? obj.style.display = "" : obj.style.display = "none";
    }
    obj.onclick = function () {
        var goTop = setInterval(scrollMove, 10);

        function scrollMove() {
            setScrollTop(getScrollTop() / 1.1);
            if (getScrollTop() < 1) clearInterval(goTop);
        }
    }
}

/**
 * 基于JsonModel Json对像的Ajax提交
 * @param url 请求URl
 * @param data 页面内Form表单的JSON数据
 * @param callback 处理成功的回调方法
 */
var fnAjax = function (url, data, callback) {
    //ajax提交
    $.ajax({
        type: "POST",
        //获取form中的action的路径
        url: url,
        //获取form中绑定的Model对象
        data: data,
        dataType: "json",
        success: function (data) {

            //输入验证错误的时候
            if (data.statusModel.code == "1") {
                for (var errorFieldName in data.errorMap) {
                    $("." + errorFieldName + "-ErrMsg").html(data.errorMap[errorFieldName]);
                }
                //添加失败错误的时候
            } else if (data.statusModel.status == "2") {
                alert(data.statusModel.message);
                //正常的时候
            } else {
                callback(data.content);
            }
        },
        error: function () {
            alert("操作失败，请重新在试！");
        }
    });
};


/**
 *  全部替换
 * @param s1
 * @param s2
 * @returns {string|void|XML}
 */
String.prototype.replaceAll = function (s1, s2) {
    return this.replace(new RegExp(s1, "gm"), s2);
};

/**
 * Format a string
 * It's used to format the error message
 * format('The field must between {key} and {key}', {key:value}) = 'The field must between 10 and 20'
 *
 * @param {String} message
 * @param {Json} parameters
 * @returns {String}
 */
String.prototype.fnFormat = function (parameters) {

    var thisVal = this.toString();
    // console.info(jQuery.type(parameters));
    if ($.isEmptyObject(parameters)) {
        return thisVal;
    }

    for (var key in parameters) {
        var val = parameters[key];
        thisVal = thisVal.replaceAll("{" + key + "}", val);
        thisVal = thisVal.replaceAll("null", "");
    }

    return thisVal;
};