/**
 * Created by kris on 2016/8/23.
 */
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
            if (data.status == "1") {
                for (var errorFieldName in data.errors) {
                    $("." + errorFieldName + "-ErrMsg").html(data.errors[errorFieldName]);
                }
                //添加失败错误的时候
            } else if (data.status == "2") {
                alert(data.status);
                //正常的时候
            } else {
                callback(data.data);
            }
        },
        error: function () {
            alert("操作失败，请重新在试！");
        }
    });
};
