/*!
 * DESCRIBE: 后台用户管理添加用户界面js文件
 * 界面日期控件和输入字段值的验证
 * Copyright 2016-2016
 * AUTHOR 刘广飞
 * VERSION 1.0 2016/04/29
 */

/**
 * 页面加载form表单添加验证
 * <p>页面加载form表单添加验证<p>
 * @param 无
 * @return 无
 */
$(function () {

    // 给form添加验证
    $('#addUserForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            // 员工号
            employeeNo: {
                validators: {
                    // 长度验证
                    stringLength: {
                        max: 20,
                        message: CommonMessageUtil.getErrorMessage(CommonMessageUtil.Message_Id_0007, "20")
                    },
                    // 非空验证
                    notEmpty: {
                        message: CommonMessageUtil.Message_Id_0018
                    },
                    // 不能输入中文验证
                    regexp: {
                        regexp: /^[^\u4e00-\u9fa5]{0,}$/,
                        message: CommonMessageUtil.getErrorMessage(CommonMessageUtil.Message_Id_0068)
                    }
                }
            },
            // 用户名
            userName: {
                validators: {
                    // 长度验证
                    stringLength: {
                        max: 30,
                        message: CommonMessageUtil.getErrorMessage(CommonMessageUtil.Message_Id_0007, "30")
                    },
                    // 非空验证
                    notEmpty: {
                        message: CommonMessageUtil.Message_Id_0018
                    }
                }
            },
            // 登录密码验证
            password: {
                validators: {
                    // 密码格式验证
                    regexp: {
                        regexp: /^[a-zA-Z]\w{7,19}$/,
                        message: CommonMessageUtil.getErrorMessage(CommonMessageUtil.Message_Id_0046)
                    },
                    // 非空验证
                    notEmpty: {
                        message: CommonMessageUtil.Message_Id_0018
                    }
                }
            },
            // 身份证号码验证
            idCardNo: {
                validators: {
                    // 身份证号码验证
                    regexp: {
                        regexp: /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/,
                        message: CommonMessageUtil.getErrorMessage(CommonMessageUtil.Message_Id_0054)
                    }
                }
            },
            // 手机号码验证
            cellphoneNo: {
                validators: {
                    // 手机号码验证
                    phone: {
                        country: 'CN',
                    }
                }
            },
            // 电子邮箱验证
            email: {
                validators: {
                    // 邮箱验证
                    emailAddress: {}
                }
            },
            // 用户描述
            userDescription: {
                validators: {
                    // 长度验证
                    stringLength: {
                        max: 20,
                        message: CommonMessageUtil.getErrorMessage(CommonMessageUtil.Message_Id_0007, "20")
                    }
                }
            }
        }
    });
});


/**
 * 页面加载根据用户输入的字段判断数据是否已存在
 * <p>页面加载根据用户输入的字段判断数据是否已存在<p>
 * @param 无
 * @return 无
 */
// $(function () {
//     // 项目路径
//     var basePath = $("#basePath").val();
//
//     // 员工号唯一验证
//     $("#employeeNo").blur(function () {
//         var employeeNo = $("#employeeNo").val();
//         // ajax请求查询信息是否已经存在
//         $.ajax({
//             url: basePath + "/um/usermanage/isexist?employeeNo=" + employeeNo,
//             type: "post",
//             success: function (data) {
//                 if (data.statusModel.code == "1") {
//
//                     $("#employeeNo-ErrMsg").html(CommonMessageUtil.getErrorMessage(CommonMessageUtil.Message_Id_0056));
//                     $("#submit").attr("disabled", true);
//
//                 } else if (data.statusModel.code == "0") {
//
//                     $("#employeeNo-ErrMsg").html("");
//                     $("#submit").attr("disabled", false);
//                 } else {
//
//                     alert("处理错误");
//                     $("#submit").attr("disabled", false);
//                 }
//             }
//         });
//     });
//
//     // 用户名验证唯一
//     $("#userName").blur(function () {
//         var userName = $("#userName").val();
//         // ajax请求查询信息是否已经存在
//         $.ajax({
//             url: basePath + "/um/usermanage/isexist?userName=" + encodeURI(userName),
//             type: "post",
//             success: function (data) {
//                 if (data.statusModel.code == "1") {
//
//                     $("#userName-ErrMsg").html(CommonMessageUtil.getErrorMessage(CommonMessageUtil.Message_Id_0056));
//                     $("#submit").attr("disabled", true);
//
//                 } else if (data.statusModel.code == "0") {
//
//                     $("#userName-ErrMsg").html("");
//                     $("#submit").attr("disabled", false);
//                 } else {
//
//                     alert("处理错误");
//                     $("#submit").attr("disabled", false);
//                 }
//             }
//
//         });
//     });
//
//     // 手机号码验证唯一
//     $("#cellphoneNo").blur(function () {
//         var cellphoneNo = $("#cellphoneNo").val();
//         // ajax请求查询信息是否已经存在
//         $.ajax({
//             url: basePath + "/um/usermanage/isexist?cellphoneNo=" + cellphoneNo,
//             type: "post",
//             success: function (data) {
//                 if (data.statusModel.code == "1") {
//                     $("#cellphoneNo-ErrMsg").html(CommonMessageUtil.getErrorMessage(CommonMessageUtil.Message_Id_0056));
//                     $("#submit").attr("disabled", true);
//                 } else {
//                     $("#cellphoneNo-ErrMsg").html("");
//                     $("#submit").attr("disabled", false);
//                 }
//             }
//         });
//     });
// });