// 共同错误信息函数对象
var CommonMessageUtil = {

    // 信息id
    Message_Id_0001:"只能为false",
    Message_Id_0002:"只能为true",
    Message_Id_0003:"必须小于或等于{0}",
    Message_Id_0004:"必须大于或等于{0}",
    Message_Id_0005:"数字的值超出了允许范围(只允许在{0}位整数和{1}位小数范围内)",
    Message_Id_0006:"需要是一个将来的时间",
    Message_Id_0007:"最大不能超过{0}",
    Message_Id_0008:"最小不能小于{0}",
    Message_Id_0009:"不能为null",
    Message_Id_0010:"必须为null",
    Message_Id_0011:"需要是一个过去的时间",
    Message_Id_0012:"需要匹配正则表达式",
    Message_Id_0013:"个数必须在{0}和{1}之间",
    Message_Id_0014:"不合法的信用卡号码",
    Message_Id_0015:"不是一个合法的电子邮件地址",
    Message_Id_0016:"长度需要在{0}和{1}之间",
    Message_Id_0018:"不能为空",
    Message_Id_0019:"需要在{0}和{1}之间",
    Message_Id_0020:"可能有不安全的HTML内容",
    Message_Id_0022:"需要是一个合法的URL",
    Message_Id_0023:"请输入有效的日期",
    Message_Id_0024:"请输入比开始日期大的日期",
    Message_Id_0025:"请输入比开始日期小的日期",
    Message_Id_0038:"添加/扣除积分的理由不能为空，请添加理由",
    Message_Id_0039:"请输入1到99999之间的积分数值",
    Message_Id_0040:"采购订单名称长度不符！必须在{min}和{max}之间",
    Message_Id_0041:"预计到货天数必须为正整数",
    Message_Id_0042:"付款期限不能早于当前日期",
    Message_Id_0043:"采购种类必须为正整数",
    Message_Id_0044:"采购数量必须为正整数",
    Message_Id_0045:"请输入有效的数字",
    Message_Id_0046:"以字母开头，长度在8~20之间，只能包含字母、数字和下划线",
    Message_Id_0047:"查询条件变更了，请点击查询按钮重新检索！",
    Message_Id_0050:"请输入的结束值必须大于或者等于开始值的正整数",
    Message_Id_0051:"数值必须大于0的正整数",
    Message_Id_0052:"名称不可为空",
    Message_Id_0053:"分类名称长度最大不能超过90",
    Message_Id_0054:"请输入有效的 中国 国家或地区的身份证件号码",
    Message_Id_0055:"输入非法，只能输入大于1的数字",
    Message_Id_0056:"已经被占用",
    Message_Id_0057:"{0}不能为空，请输入正确的{1}。",
    Message_Id_0058:"请选择完整的地区信息",
    Message_Id_0059:"请选择{0}文件",
    Message_Id_0060:"上传文件类型必须是{0}",
    Message_Id_0061:"请输入有效的邮编",
    Message_Id_0062:"请输入有效的固定电话",
    Message_Id_0063:"请输入有效的金额",
    Message_Id_0064:"{0}不能为空。",
    Message_Id_0065:"两次输入的密码不一致",
    Message_Id_0067:"请输入有效的订单号",
    Message_Id_0068:"员工号不能包含中文或非法符号",
    Message_Id_0069:"数值在{0}和{1}之间",
    Message_Id_0070:"赠品数值必须为正数，切不能为负数",
    Message_Id_0071:"供应商名称不能为空",
    Message_Id_0072:"供应商详细地址不能为空",
    Message_Id_0073:"请输入有效的邮政编码",
    Message_Id_0074:"法人姓名不能为空",
    Message_Id_0075:"联系人姓名不能为空",
    Message_Id_0076:"请输入有效的固定电话号码",
    Message_Id_0077:"请输入有效的传真号码",
    Message_Id_0078:"请输入有效的QQ号码",
    Message_Id_0079:"请输入有效的微信号码",
    Message_Id_0080:"请输入有效的证件编号",
    Message_Id_0081:"供应商区域不能为空",
    Message_Id_0082:"供应商省份不能为空",
    Message_Id_0083:"供应商城市不能为空",
    Message_Id_0084:"供应商县区不能为空",
    Message_Id_0085:"联系人手机号不能为空",
    Message_Id_0086:"采购订单编号不能为空",
    Message_Id_0087:"采购订单编号格式不正确",
    Message_Id_0088:"退货单名称不能为空",
    Message_Id_0089:"退货仓库不能为空",
    Message_Id_0090:"供应商不能为空",
    Message_Id_0091:"是否需要配送不能为空",
    Message_Id_0092:"需要配送时承运商不能空",
    Message_Id_0093:"是否保价不能为空",
    Message_Id_0094:"保价时，声明价值必须大于0",
    Message_Id_0095:"请输入有效的数值，必须大于0且小数点后不超过2位",
    Message_Id_0096:"需要配送时物流支付方式不能空",
    Message_Id_0097:"需要配送时运输存储方式不能空",
    Message_Id_0098:"是否上门自提不能为空",
    Message_Id_0099:"请先添加货品",
    Message_Id_0100:"退货数量不能超过库存-锁仓库存",
    // 信息表示
    getErrorMessage: function (strMessage, strFillValue) {

        // 填充文字没有定义的时候
        if (strFillValue == undefined) {
    
        } else if (strFillValue instanceof Array) {
            for (var i = 0; i < strFillValue.length; i++) {
                strMessage = strMessage.replace("\{" + i.toString() + "\}", strFillValue[i]);
            }
        } else {
            strMessage = strMessage.replace(/\{0\}/, strFillValue);
        }
        return strMessage;
    }
}