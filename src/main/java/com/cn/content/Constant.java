package com.cn.content;

/**
 * Created by Kris2 on 2016/8/25.
 */
public interface Constant {

    /** 共通定数整数常量--------------开始-------------- */
    /** 静态整数常量 */
    public static final int DIGIT_ZERO = 0;
    public static final int DIGIT_ONE = 1;
    public static final int DIGIT_TWO = 2;
    public static final int DIGIT_THREE = 3;
    public static final int DIGIT_FOUR = 4;
    public static final int DIGIT_FIVE = 5;
    public static final int DIGIT_SIX = 6;
    public static final int DIGIT_SEVEN = 7;
    public static final int DIGIT_EIGHT = 8;
    public static final int DIGIT_NINE = 9;
    public static final int DIGIT_TEN = 10;

    /** 图片格式 "jpeg" */
    public static final String PICTURE_FORMAT_JPEG = "jpeg";

    /** 图片格式 "jpg" */
    public static final String PICTURE_FORMAT_JPG = "jpg";

    /** 判断图片格式用 "image/" */
    public static final String INDEX_OF_IMAGE = "image/";

    /** 判断图片格式用 ";base64 */
    public static final String INDEX_OF_BASE64 = ";base64";

    /** 取得base64为图片的编码 ";base64" */
    public static final String REGEX_BASE64 = ";base64,([^\">]*)";

    /** 拼接路径用左斜线 LEFT_SLASH:"/" */
    public static final String LEFT_SLASH = "/";

    /** 拼接路径时候的点 DOT:"." */
    public static final String DOT = ".";

    /** 一页表示记录件数(少)*/
    public static final int PAGE_SIZE_SHORT = 10;

    /** 一页表示记录件数(多)*/
    public static final int PAGE_SIZE_LONG = 20;

    /** 表示页码索引件数*/
    public static final int SHOW_PAGE_INDEX_COUNT = 10;

    /** 密码随机数上限 */
    public static final int RANDOM_NUM = 100000;
    /** 共通定数整数常量 --------------结束-------------- */

    /** 共通定数字符串常量--------------开始-------------- */
    /** 静态字符串常量 */
    public static final String STRING_0 = "0";
    public static final String STRING_1 = "1";
    public static final String STRING_2 = "2";

    /** 日期格式*/
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String format_yyyyMMdd = "yyyyMMdd";
    public static final String FORMAT_YYMMDD = "yyMMdd";
    public static final String format_yyyyMM = "yyyyMM";
    public static final String format_yyyy = "yyyy";
    public static final String format_yyyycnMMcnddcn = "yyyy年MM月dd日";
    public static final String format_yyyycnMMcn = "yyyy年MM月";
    public static final String format_yyyycn = "yyyy年";

    /** 星期英文名*/
    public static final String WEEK_SUNDAY = "SUNDAY";
    public static final String WEEK_MONDAY = "MONDAY";
    public static final String WEEK_TUESDAY = "TUESDAY";
    public static final String WEEK_WEDNESDAY = "WEDNESDAY";
    public static final String WEEK_THURSDAY = "THURSDAY";
    public static final String WEEK_FRIDAY = "FRIDAY";
    public static final String WEEK_SATURDAY = "SATURDAY";

    /** 字符串("")*/
    public static final String STRING_EMPTY = "";

    /** 字符串(" ")空格*/
    public static final String STRING_SPACE = " ";

    /** 字符串("%")百分号*/
    public static final String STRING_PER_CENT = "%";

    /** 字符串(",")*/
    public static final String STRING_COMMA = ",";

    /** 字符串("全部")*/
    public static final String DROP_DOWN_OPTION_ALL = "全部";

    /** 共通定数字符串常量 --------------结束-------------- */

    /** 顺丰接口  --------------开始-------------- */
    /** WEBSERVICE路径资源文件地址 */
    public static final String WEB_SERVICE_URL_FILE_PATH = "config";
    /** 收货单状态编码 001:处理中 */
    public static final String RECEIVING_ORDER_STATE_CODE_ONE = "001";
    /** 收货单状态编码 002:已完成 */
    public static final String RECEIVING_ORDER_STATE_CODE_TWO = "002";
    /** 发货单状态编码 001:处理中 */
    public static final String DELIVERY_ORDER_STATE_CODE_ONE = "001";
    /** 发货单状态编码 002:已完成 */
    public static final String DELIVERY_ORDER_STATE_CODE_TWO = "002";
    /** 下单状态编码 001:未下单 */
    public static final String SEND_ORDER_STATE_CODE_O = "001";
    /** 下单状态编码 002: 下单中*/
    public static final String SEND_ORDER_STATE_CODE_T = "002";
    /** 下单状态编码 003:已下单 */
    public static final String SEND_ORDER_STATE_CODE_TH = "003";
    /** 下单状态编码 003:下单失败 */
    public static final String SEND_ORDER_STATE_CODE_F = "004";
    /** 商品目录操作：NEW 创建*/
    public static final String PRODUCT_NEW = "NEW";
    /** 商品目录操作：SAVE 修改*/
    public static final String PRODUCT_SAVE = "SAVE";
    /** 送信状态：1 送信成功 */
    public static final String SEND_MESSAGE_STATUS_SUCCESS = "1";
    /** 送信状态：2 送信失败 */
    public static final String SEND_MESSAGE_STATUS_FAIL = "2";
    /** 送信结果信息: 送信成功 */
    public static final String SEND_RESULT_SUCCESS_MESSAGE = "送信成功";

    /** 顺丰接口  --------------结束-------------- */

    /** 各编号编辑用定数 --------------开始-------------- */
    /** 采购单编号前缀*/
    public static final String PUR_ORDER_NO_PRE = "PO";

    /** 供应商编号前缀*/
    public static final String PUR_SUPPLIER_NO_PRE = "S";

    /** 采购退货单编号前缀*/
    public static final String PUR_RETURN_ORDER_NO_PRE = "POR";

    /** 入库单编号前缀*/
    public static final String IN_STORE_ORDER_NO_PRE = "SI";

    /** 出库单编号前缀*/
    public static final String OUT_STORE_ORDER_NO_PRE = "SO";

    /** 调拨单编号前缀*/
    public static final String ALLOCATE_ORDER_NO_PRE = "AO";

    /** 收货单编号前缀*/
    public static final String RECEIVING_ORDER_NO_PRE = "RO";

    /** 盘点单编号前缀*/
    public static final String INVENTORY_CHECK_NO_PRE = "IC";
    /** 盘点单编号的盘点方式标识(1:日常盘点)*/
    public static final String INVENTORY_CHECK_NO_WAY_DAILY = "1";
    /** 盘点单编号的盘点方式标识(2:定期盘点)*/
    public static final String INVENTORY_CHECK_NO_WAY_REGULAR = "2";

    /** 盘点单编号前缀*/
    public static final String SALES_ORDER_NO_PRE = "COM";

    /** 退单编号前缀*/
    public static final String RETURN_ORDER_NO_PRE = "ROM";

    /** 交易流水单编号前缀*/
    public static final String PAY_BILL_SN_PRE = "PB";

    /** 账户流水编号前缀*/
    public static final String PAY_ACCOUNT_BILL_SN_PRE = "PA";
    /** 账户流水单编号变动方式标识（1：充值） */
    public static final String PAY_ACCOUNT_BILL_SN_RECHANGE = "1";
    /** 账户流水单编号变动方式标识（2：订单支付） */
    public static final String PAY_ACCOUNT_BILL_SN_DEFRAY = "2";

    /** 发货单编号前缀*/
    public static final String DELIVERY_ORDER_NO_PRE = "DO";

    /** 退款单编号前缀 */
    public static final String REFUND_ORDER_NO_PRE = "REF";

    /** 采购需求单编号前缀*/
    public static final String PUR_REQUIRE_ORDER_NO = "PRO";

    /** 仓库编号前缀*/
    public static final String STOREHOUSE_NO_PRE = "SH";
    /** 仓库编号的仓库类型(1:冷冻仓)*/
    public static final String STOREHOUSE_NO_TYPE_FREEZING = "1";
    /** 仓库编号的仓库类型(2:普通仓)*/
    public static final String STOREHOUSE_NO_TYPE_ORDINARY = "2";
    /** 仓库编号的仓库归属类型(1:自有)*/
    public static final String STOREHOUSE_NO_OWNERSHIP_OWN = "1";
    /** 仓库编号的仓库归属类型(2:供应商仓库)*/
    public static final String STOREHOUSE_NO_OWNERSHIP_SUPPLIER = "2";
    /** 仓库编号的仓库归属类型(2:物流仓库)*/
    public static final String STOREHOUSE_NO_OWNERSHIP_LOGISTICS = "3";

    /** 各编号编辑用定数 --------------结束-------------- */

    /** 多dataSource --------------开始-------------- */
    /** 主dataSource(默认)*/
    public static final String DATA_SOURCE_MASTER = "masterdataSource";

    /** 从dataSource */
    public static final String DATA_SOURCE_SLAVE = "slavedataSource";
    /** 多dataSource --------------结束-------------- */

    /** 上传文件路径--------------开始-------------- */

    /** 客户端退货上传虚拟文件目录*/
    public static final String CLIENT_UPLOAD_VPATH_RETURN_ORDER = "client/upload/returnOrder/";
    /** 客户端晒单上传虚拟文件目录*/
    public static final String CLIENT_UPLOAD_VPATH_SUN_SINGLE = "client/upload/sunSingle/";
    /** 客户端用户头像上传虚拟文件目录*/
    public static final String CLIENT_UPLOAD_VPATH_CUSTOMER_PORTRAIT = "client/upload/customerPortrait/";

    /** 上传文件路径--------------结束-------------- */

    /** 顺序表定数   -------------开始------------------- */

    /** 顺序表记录（交易流水单编号）*/
    public static final String COLUMN_PAY_BILL_SN_SEQUENCE = "pay_bill_sn_sequence";
    /** 顺序表定数   -------------结束------------------- */

    /** Redis键值格式  --------------开始-------------- */
    /** 分类列表 初期用键值格式 CATEGORY_LIST_INIT_KEY_显示类别_顶级分类ID_成员类型_成员等级*/
    public static final String CATEGORY_LIST_INIT_KEY_FMT = "CATEGORY_LIST_INIT_KEY_%s_%d_%s_%d";
    /** 分类列表 更新用键值格式 CATEGORY_LIST_UPT_KEY_显示类别_顶级分类ID_成员类型_成员等级*/
    public static final String CATEGORY_LIST_UPT_KEY_FMT = "CATEGORY_LIST_UPT_KEY_%s_%d_%s_%d";
    /** Redis键值格式 --------------结束-------------- */


    /** 表字段名定数  --------------开始-------------- */
    /** 编码表字段(表示顺序)*/
    public static final String CODE_MASTER_COLUMN_SORT_ORDER = "sortOrder";

    /** 入库明细信息表字段(入库明细ID)*/
    public static final String IN_STORE_DETAIL_COLUMN_IN_STORE_DETAIL_ID = "inStoreDetailId";

    /** 出库明细信息表字段(入库明细ID)*/
    public static final String OUT_STORE_DETAIL_COLUMN_OUT_STORE_DETAIL_ID = "outStoreDetailId";

    /** 批次货品库存信息表字段(货品ID)*/
    public static final String LOT_PRODUCT_STOCK_COLUMN_PRODUCT_ID = "productId";

    /** 采购明细信息表字段(货品批号)*/
    public static final String PUR_ORDER_DETAIL_COLUMN_LOT_NO = "lotNo";

    /** 购物卡表购物卡编号字段（购物卡号：实体卡）*/
    public static final String COLUMN_PAY_CARD_NO_ENTITY = "pay_card_no_entity";

    /** 购物卡表购物卡编号字段默认开始编号：实体卡 */
    public static final String COLUMN_PAY_CARD_NO_ENTITY_DEFALT_VALUE = "1000386488";

    /** 购物卡表购物卡编号字段（购物卡号：虚拟卡）*/
    public static final String COLUMN_PAY_CARD_NO_VIRTUAL = "pay_card_no_virtual";

    /** 购物卡表购物卡编号字段默认开始编号：虚拟卡 */
    public static final String COLUMN_PAY_CARD_NO_VIRTUAL_DEFALT_VALUE = "2000386488";

    /** 盘点明细信息表字段(盘点明细ID)*/
    public static final String INVENTORY_CHECK_DETAIL_COLUMN_INVENTORY_CHECK_DETAIL_ID = "inventoryCheckDetailId";

    /** 盘点明细信息表字段(货品ID)*/
    public static final String INVENTORY_CHECK_DETAIL_COLUMN_PRODUCT_ID = "productId";

    /** 盘点明细信息表字段(批号)*/
    public static final String INVENTORY_CHECK_DETAIL_COLUMN_LOT_NO = "lotNo";

    /** 仓库信息表字段(仓库ID)*/
    public static final String STOREHOUSE_COLUMN_STOREHOUSE_ID = "storehouseId";

    /** 收货明细信息表字段(收货明细ID)*/
    public static final String RECEIVING_ORDER_DETAIL_COLUMN_DETAIL_ID = "receivingOrderDetailId";

    /** 发货明细信息表字段(发货明细ID)*/
    public static final String DELIVERY_ORDER_DETAIL_COLUMN_DETAIL_ID = "deliveryOrderDetailId";

    /** 表字段名定数  --------------结束-------------- */

    /** 业务定数  --------------开始-------------- */

    /** 逻辑删除标识(0:正常） */
    public static final String DELETE_FLAG_NORMAL_CODE = "0";
    /** 逻辑删除标识(1:冻结） */
    public static final String DELETE_FLAG_INVALID_CODE = "1";
    /** 逻辑删除标识名称(0:正常） */
    public static final String DELETE_FLAG_NORMAL_NAME = "正常";
    /** 逻辑删除标识名称(1:冻结） */
    public static final String DELETE_FLAG_INVALID_NAME = "冻结";

    /** 可删除标识(0:可以删除） */
    public static final String CAN_DELETE_FLAG_CODE = "0";
    /** 可删除标识(1:不可以删除） */
    public static final String CANNOT_DELETE_FLAG_CODE = "1";

    /** 物流导入标识(0:未导入） */
    public static final String LOGISTICS_FLAG_UNIMPORT_CODE = "0";
    /** 物流导入标识(1:已导入） */
    public static final String LOGISTICS_FLAG_IMPORT_CODE = "1";
    /** 物流导入标识(2:已发送） */
    public static final String LOGISTICS_FLAG_SEND_CODE = "2";
    /** 物流导入标识(0:未导入） */
    public static final String LOGISTICS_FLAG_UNIMPORT_NAME = "未导入";
    /** 物流导入标识(1:已导入） */
    public static final String LOGISTICS_FLAG_IMPORT_NAME = "已导入";
    /** 物流导入标识(2:已发送） */
    public static final String LOGISTICS_FLAG_SEND_NAME = "已发送";

    /** 国产/进口标识(0:国产） */
    public static final String PRODUCT_IMPORT_FLAG_DOMESTIC_CODE = "0";
    /** 国产/进口标识(1:进口） */
    public static final String PRODUCT_IMPORT_FLAG_IMPORTED_CODE = "1";
    /** 国产/进口标识名称(0:国产） */
    public static final String PRODUCT_IMPORT_FLAG_DOMESTIC_NAME = "国产";
    /** 国产/进口标识名称(1:进口） */
    public static final String PRODUCT_IMPORT_FLAG_IMPORTED_NAME = "进口";

    /** 编码表表示标识(0:表示)*/
    public static final String CODE_MASTER_SHOW_FLAG_SHOW = "0";
    /** 编码表表示标识(1:不表示)*/
    public static final String CODE_MASTER_SHOW_FLAG_HIDE = "1";

    /** 地区层次，第一层 */
    public static final int REGION_LEVEL_ONE = 1;

    /** 父地区ID */
    public static final long PARENT_REGION_ID = 0;

    /** 默认删除标识*/
    public static final String DEFAULT_DELETE_FlAG = "0";

    /** 积分是否有效(0:无效)*/
    public static final String POINTS_IS_USED_NULLITY = "0";
    /** 积分是否有效(1:有效)*/
    public static final String POINTS_IS_USED_EFFECTIVITY = "1";

    /** 角色是否已经拥有某一个资源的权限 0：未拥有*/
    public static final String IS_EXIST_FLG_NO = "0";
    /** 角色是否已经拥有某一个资源的权限 1：已拥有*/
    public static final String IS_EXIST_FLG_YES = "1";

    /** 资源是否可用 "enable"可用 */
    public static final String RESOURCE_ENABLE = "enable";
    /** 资源是否可用 "disable"不可用 */
    public static final String RESOURCE_DISABLE = "disable";

    /** 资源ID为 0*/
    public static final long RESOURCE_ID_ZERO = 0;

    /** 用户ID为 0*/
    public static final long USER_ID_ZERO = 0;

    /** 超级管理员  ROLE_MANAGER*/
    public static final String ROLE_MANAGER = "ROLE_MANAGER";
    /** 普通用户  ROLE_USER*/
    public static final String ROLE_USER = "ROLE_USER";

    /** 审核状态编码ID 全部-全部 */
    public static final String REVIEW_STATE_CODE_ALL = "全部";
    /** 采购订单列表 controller对应tab页状态 */
    public static final String PUR_ORDER_LIST_STATE = "status";
    /** 采购订单列表 controller对应tab页状态值 【已完成】 */
    public static final String PUR_ORDER_LIST_STATE_FINISHED = "finished";
    /** 采购订单列表 controller对应tab页状态值 【已终止】 */
    public static final String PUR_ORDER_LIST_STATE_STOPED = "stoped";
    /** 采购订单列表 controller对应tab页状态值 【已挂起】 */
    public static final String PUR_ORDER_LIST_STATE_SUSPEND = "suspended";
    /** 采购订单列表 controller对应tab页状态值 【全部】 */
    public static final String PUR_ORDER_LIST_STATE_ALL = "all";

    /** 供应商(仓库)状态 0-正常 */
    public static final String SUPPLIER_DELETE_FLAG_NORMAL = "0";
    /** 供应商(仓库)状态 1-无效 */
    public static final String SUPPLIER_DELETE_FLAG_INVALID = "1";

    /** 客户是否是自己注册, 0: 后台添加 */
    public static final String BACKSTAGE_ADD = "0";
    /** 客户是否是自己注册, 1: 自己注册 */
    public static final String ONESELF_REGISTER = "1";

    /** 客户是否是快捷客户, 0: 否 */
    public static final String SHORTCUT_REGISTER_FLAG_NO = "0";
    /** 客户是否是快捷客户, 1: 是 */
    public static final String SHORTCUT_REGISTER_FLAG_YES = "1";

    /** 客户级别是否自动变更, 0: 否 */
    public static final String RANK_CHANGE_FLG_NO = "0";
    /** 客户级别是否自动变更, 1: 是 */
    public static final String RANK_CHANGE_FLG_YES = "1";

    /** 是否手动更改过级别, 0: 否 */
    public static final String IS_MANUALLY_CHANGED_NO = "0";
    /** 是否手动更改过级别 , 1: 是*/
    public static final String IS_MANUALLY_CHANGED_YES = "1";

    /** 是否舍弃标识, 0: 取回确认 */
    public static final String IS_LOSS_ID_NO = "0";
    /** 是否舍弃标识 , 1: 直接舍弃*/
    public static final String IS_LOSS_ID_YES = "1";

    /** 订单类型 : 0-普通订单*/
    public static final String ORDER_TYPE_ORDINARY = "0";
    /** 订单类型 : 1-预售订单*/
    public static final String ORDER_TYPE_PRESALE = "1";

    /** 客户列表的排序顺序, customerId: 客户ID */
    public static final String ORDER_BY_CUSTOMERID = "customerId";

    /** 客户账户的排序顺序, customerAccountId: 账户ID */
    public static final String ORDER_BY_CUSTOMERACCOUNTID = "customerAccountId";

    /** 用户列表的排序顺序, userId: 用户ID */
    public static final String ORDER_BY_USERID = "userId";

    /** 帮助中心表的排序顺序, helpId: 帮助ID */
    public static final String ORDER_BY_HELP_ID = "helpId";

    /** 帮助分类表的排序顺序, categoryId: 分类ID */
    public static final String ORDER_BY_CATEGORY_ID = "categoryId";

    /** 文章内容表的排序顺序, articleId: 文章ID */
    public static final String ORDER_BY_ARTICLE_ID = "articleId";

    /** 订单号排序顺序, orderNo: 订单号 */
    public static final String ORDER_BY_ORDERNO = "orderNo";

    /** 文章内容中的图片的存放路径 */
    public static final String ARTICLE_CONTENT_IMG_PATH = "articlecontentimg";

    /** 商品详情的存放路径 */
    public static final String GOODS_INFO_PATH = "goodsInfo";

    /** 食谱图片的存放路径 */
    public static final String COOKBOOK_PICTURE = "cookbookpicture";

    /** 食谱图片1 */
    public static final String COOKBOOK_PIC1 = "cookbookpic1";
    /** 食谱图片2 */
    public static final String COOKBOOK_PIC2 = "cookbookpic2";
    /** 食谱图片3 */
    public static final String COOKBOOK_PIC3 = "cookbookpic3";
    /** 食谱图片4 */
    public static final String COOKBOOK_PIC4 = "cookbookpic4";
    /** 食谱图片5 */
    public static final String COOKBOOK_PIC5 = "cookbookpic5";

    /** 设定食谱内容中图片的存放路径 "contentimg"*/
    public static final String CONTENT_IMG = "contentimg";

    /** 厨师各种图片的存放路径 */
    public static final String COOK_IMAGE = "cookimage";
    /** 厨师头像的存放路径 */
    public static final String COOK_PORTRAIT = "cookportrait";
    /** 厨师简介图片的存放路径 */
    public static final String COOK_INTRO = "cookintro";
    /** 厨师头像图片名字 "portrait" */
    public static final String PORTRAIT = "portrait";

    /** 文章内容中的图片属性  */
    public static final String IMG_SRC = "img src";

    /** 文章内容中的图片的base64位的字符取得 "base64" */
    public static final String BASE64 = "base64";

    /** 文章内容中的图片的src中的内容取得 "src" */
    public static final String SRC = "src";

    /** 取得HTML中的img标签中src的值 "src" */
    public static final String REGEX_SRC = "src=\"([^\">]*)";

    /** 静态HTML页面的文件名格式  */
    public static final String FILENAME_FORMAT_STATIC_HTML = "%011d_%011d_%s.html";

    /** 备份静态HTML页面的文件名格式 */
    public static final String FILENAME_FORMAT_STATIC_HTML_BACKUP = "%011d_%011d_%s_%s.html";

    /** 用户操作日志列表的排序顺序, logId: 日志ID */
    public static final String ORDER_BY_LOGID = "logId";

    /** 盲盘标识：明盘*/
    public static final String BLIND_INVENTORY_CHECK_FLAG_NOT = "0";
    /** 盲盘标识：盲盘 */
    public static final String BLIND_INVENTORY_CHECK_FLAG_YES = "1";

    /** 系统用户名称：system */
    public static final String SYSTEM_USER_NAME = "system";

    /** 紧急采购标识：否 */
    public static final String PUR_ORDER_URGENT_FLAG_NOT = "0";
    /** 紧急采购标识：是 */
    public static final String PUR_ORDER_URGENT_FLAG_YES = "1";

    /** 是否需要配送：需要配送 */
    public static final String IS_NEED_DELIVERY_YES = "0";
    /** 是否需要配送：不需配送 */
    public static final String IS_NEED_DELIVERY_NOT = "1";

    /** 承运商——0:供应商 */
    public static final String PUR_ORDER_CARRIER_ID_SUPPLIER = "0";
    /** 承运商——1:其他 */
    public static final String PUR_ORDER_CARRIER_ID_OTHERS = "1";

    /** 承运商选择——0:供应商 */
    public static final String CARRIER_SELECT_SUPPLIER = "0";
    /** 承运商选择——1:承运商 */
    public static final String CARRIER_SELECT_CARRIER = "1";

    /** 库存量比较——1：大于等于 */
    public static final String STOCK_NUM_VALUE_GREATER_EQUAL = "1";
    /** 库存量比较——1：大于等于 */
    public static final String STOCK_NUM_COMPARE_GREATER_EQUAL = ">=";
    /** 库存量比较——2：大于 */
    public static final String STOCK_NUM_VALUE_GREATER = "2";
    /** 库存量比较——2：大于 */
    public static final String STOCK_NUM_COMPARE_GREATER = ">";
    /** 库存量比较——3：小于等于 */
    public static final String STOCK_NUM_VALUE_LESS_EQUAL = "3";
    /** 库存量比较——3：小于等于 */
    public static final String STOCK_NUM_COMPARE_LESS_EQUAL = "<=";
    /** 库存量比较——4：小于 */
    public static final String STOCK_NUM_VALUE_LESS = "4";
    /** 库存量比较——4：小于 */
    public static final String STOCK_NUM_COMPARE_LESS = "<";
    /** 库存量比较——5：等于 */
    public static final String STOCK_NUM_VALUE_EQUAL = "5";
    /** 库存量比较——5：等于 */
    public static final String STOCK_NUM_COMPARE_EQUAL = "=";

    /** 补货需求——1：全部 */
    public static final String REPLENISHMENT_DEMAND_KEY_ALL = "1";
    /** 补货需求——1：全部 */
    public static final String REPLENISHMENT_DEMAND_VALUE_ALL = "全部";
    /** 补货需求——2：需要 */
    public static final String REPLENISHMENT_DEMAND_KEY_NEED = "2";
    /** 补货需求——2：需要 */
    public static final String REPLENISHMENT_DEMAND_VALUE_NEED = "需要";
    /** 补货需求——3：不需要 */
    public static final String REPLENISHMENT_DEMAND_KEY_NONEED = "3";
    /** 补货需求——3：不需要 */
    public static final String REPLENISHMENT_DEMAND_VALUE_NONEED = "不需要";

    /** 警告级别——1：全部 */
    public static final String WARNING_LEVEL_KEY_ALL = "1";
    /** 警告级别——1：全部 */
    public static final String WARNING_LEVEL_VALUE_ALL = "全部";
    /** 警告级别——2：无警告 */
    public static final String WARNING_LEVEL_KEY_NOWARN = "2";
    /** 警告级别——2：无警告 */
    public static final String WARNING_LEVEL_VALUE_NOWARN = "无警告";
    /** 警告级别——3：轻度警告 */
    public static final String WARNING_LEVEL_KEY_LIGHT = "3";
    /** 警告级别——3：轻度警告 */
    public static final String WARNING_LEVEL_VALUE_LIGHT = "轻度警告";
    /** 警告级别——4：重度警告 */
    public static final String WARNING_LEVEL_KEY_SEVERE = "4";
    /** 警告级别——4：重度警告 */
    public static final String WARNING_LEVEL_VALUE_SEVERE = "重度警告";

    /** 必填标识——0：非必填 */
    public static final String PARAMETER_MUST_FLAG_NO = "0";
    /** 必填标识——1：必填 */
    public static final String PARAMETER_MUST_FLAG_YES = "1";

    /** 订单来源(0:管理平台添加） */
    public static final String ORDER_SOURCE_ERP = "0";
    /** 订单来源(1：购物平台） */
    public static final String ORDER_SOURCE_BUY = "1";

    /** 设置警戒/标准库存——设置范围——全部货品 */
    public static final String WARNING_STANDARD_SETTING_ALL = "全部货品";
    /** 设置警戒/标准库存——设置范围——单个货品 */
    public static final String WARNING_STANDARD_SETTING_SINGLE = "单个货品";

    /** 需整单发货标识——0：否 */
    public static final String IS_COMPLETE_DELIVERY_NO = "0";
    /** 需整单发货标识——1：是 */
    public static final String IS_COMPLETE_DELIVERY_YES = "1";

    /** 是否货到付款标识——0：否 */
    public static final String IS_COD_NO = "0";
    /** 是否货到付款标识——1：是 */
    public static final String IS_COD_YES = "1";

    /** 是否保价标识——0：否 */
    public static final String VALUE_INSURED_FLAG_NO = "0";
    /** 是否保价标识——1：是 */
    public static final String VALUE_INSURED_FLAG_YES = "1";

    /** 是否需要签回单标识——0：否 */
    public static final String RETURN_RECEIPT_SERVICE_NO = "0";
    /** 是否需要签回单标识——1：是 */
    public static final String RETURN_RECEIPT_SERVICE_YES = "1";

    /** 是否上门自提标识——0：否 */
    public static final String IS_SELF_PICKUP_FLAG_NO = "0";
    /** 是否上门自提标识——1：是 */
    public static final String IS_SELF_PICKUP_FLAG_YES = "1";

    /** 是否标识名称——否 */
    public static final String IS_FLAG_NAME_NO = "否";
    /** 是否标识名称——是 */
    public static final String IS_FLAG_NAME_YES = "是";

    /** 自有仓库归属公司编码 */
    public static final String OWNERSHIP_COMPANY_NO_SELF = "self";

    /** 业务定数  --------------结束-------------- */

    /** 验证用代码信息定数  --------------开始-------------- */
    /** 日期比较验证类型(greater:大于)*/
    public static final String COMPARE_DATE_TYPE_GREATER = "greater";

    /** 日期比较验证类型(less:小于)*/
    public static final String COMPARE_DATE_TYPE_LESS = "less";

    /*****************     业务处理状态     *************************/
    /** 成功状态：0: 成功*/
    public static final String STATUS_OK = "0";
    /** 失败状态：1: 输入有误*/
    public static final String STATUS_INPUT_ERROR = "1";
    /** 失败状态：2: DB处理错误*/
    public static final String STATUS_DB_ERROR = "2";
    /** 变更密码时，"3":验证密码【DB既存密码】输入错误 */
    public static final String PASSWORD_VALID_ERROR = "3";
    /** 失败状态：4: DB处理错误*/
    public static final String STATUS_DB_SUB_ERROR = "4";

    /** 变更密码时，"修改前的密码输入错误" */
    public static final String PASSWORD_VALID_ERROR_MESSAGE = "原始密码输入错误!";

    /** json用状态值（0：正常）*/
    public static final String JSON_STATUS_OK = "0";
    /** json用状态值（1：输入验证错误）*/
    public static final String JSON_STATUS_INPUT_ERROR = "1";
    /** json用状态值（2：DB处理错误）*/
    public static final String JSON_STATUS_DB_ERROR = "2";
    /** json用状态值（3：DB已经存在）*/
    public static final String JSON_STATUS_DB_EXISTS = "3";
    /** json用状态值（999999：DB存在多条）*/
    public static final String JSON_STATUS_DB_EXISTS_MANY = "999999";

    /** 验证失败信息*/
    public static final String INPUT_ERROR_MESSAGE = "验证失败";
    /** DB处理成功信息*/
    public static final String DB_HANDLE_OK_MESSAGE = "处理成功";
    /** DB处理失败信息*/
    public static final String DB_HANDLE_ERROR_MESSAGE = "处理失败";

    /** 信息是否数据库中存在  2: 存在多条 */
    public static final String DB_EXISTS_MANY = "2";
    /** 信息是否数据库中存在  1: 存在 */
    public static final String DB_EXISTS = "1";
    /** 信息是否数据库中存在   0: 不存在*/
    public static final String DB_NOT_EXISTS = "0";

    /** 盘点单ID生成失败信息*/
    public static final String INVENTORY_CHECK_ID_CREATE_ERR_MSG = "盘点单ID生成失败";

    /** 入库单ID生成失败信息*/
    public static final String IN_STORE_ORDER_ID_CREATE_ERR_MSG = "入库单ID生成失败";

    /** 出库单ID生成失败信息*/
    public static final String OUT_STORE_ORDER_ID_CREATE_ERR_MSG = "出库单ID生成失败";

    /** 盘点货品不存在的错误信息*/
    public static final String INVENTORY_CHECK_PRODUCT_NONE_MSG = "该仓库没有可盘点的货品信息";

    /** 盘点单新建失败错误信息*/
    public static final String INVENTORY_CHECK_ORDER_NEW_ERR_MSG = "盘点单新建失败，请查看错误日志";

    /** 盘点单ID为空错误信息*/
    public static final String INVENTORY_CHECK_ORDER_ID_EMPTY_MSG = "盘点单ID不能为空";

    /** 盘点单ID和版本号为空错误信息*/
    public static final String INVENTORY_CHECK_ORDER_ID_OR_VERSION_NO_EMPTY_MSG = "盘点单ID和版本号不能为空";

    /** 盘点单不存在错误信息*/
    public static final String INVENTORY_CHECK_ORDER_NOT_EXISTS_MSG = "该盘点单可能已被其他用户删除了";

    /** 盘点单已被稽核错误信息*/
    public static final String INVENTORY_CHECK_ORDER_AUDIT_DONE_MSG = "该盘点单已被其他用户稽核了";

    /** 盘点单稽核失败错误信息*/
    public static final String INVENTORY_CHECK_ORDER_AUDIT_ERR_MSG = "盘点单稽核失败，请查看错误日志";

    /** 盘点单删除失败错误信息*/
    public static final String INVENTORY_CHECK_ORDER_DELETE_ERR_MSG = "盘点单删除失败，请查看错误日志";

    /** 盘点单删除成功信息*/
    public static final String INVENTORY_CHECK_ORDER_DELETE_OK_MSG = "盘点单删除成功";

    /** 盘点结果导入错误信息*/
    public static final String INVENTORY_CHECK_RESULT_IMPORT_ERR_MSG = "盘点结果文件导入失败，请查看错误日志";

    /** 盘点结果导入成功信息*/
    public static final String INVENTORY_CHECK_RESULT_IMPORT_OK_MSG = "盘点结果文件导入成功";

    /** 盘点单已被导入错误信息*/
    public static final String INVENTORY_CHECK_ORDER_IMPORT_DONE_MSG = "该盘点单已被其他用户导入了";

    /** 上传文件名为空错误信息*/
    public static final String UPLOAD_FILE_FILENAME_EMPTY_ERR_MSG = "请选择{0}文件";

    /** 上传文件类型错误信息*/
    public static final String UPLOAD_FILE_EXTENSION_ERR_MSG = "上传文件类型必须是{0}";

    /** 上传文件大小为0错误信息*/
    public static final String UPLOAD_FILE_SIZE_ERR_MSG = "上传文件大小不能为0";

    /** 乐观锁排他错误信息*/
    public static final String OPTIMISTIC_LOCK_EXCLUSIVE_ERR_MSG = "该记录可能已被其他用户更改或删除了";

    /** 锁仓库存量不足错误信息*/
    public static final String LOCKED_STORE_NUM_LACK_ERR_MSG = "库存量不足";

    /** 锁仓地区不支持配送错误信息*/
    public static final String LOCKED_STORE_AREA_NOT_SUPPORT_ERR_MSG = "您所在地区不支持配送";

    /** 添加或更改失败错误信息*/
    public static final String POINT_CHECK_UPDATE_ERR_MSG = "该信息可能已被其他用户添加或更改。";

    /** 采购订单添加或更新失败错误信息*/
    public static final String PUR_CHECK_ORER_UPDATE_ERP_MSG = "该采购订单可能已被其他用户更改或删除了";

    /** 供应商冻结失败错误信息*/
    public static final String PUR_CHECK_SUPPLIER_FREEZE_ERP_MSG = "供应商冻结失败，请查看错误日志";

    /** 供应商解冻失败错误信息*/
    public static final String PUR_CHECK_SUPPLIER_UNFREEZE_ERP_MSG = "供应商解冻失败，请查看错误日志";

    /** 供应商删除失败错误信息*/
    public static final String PUR_CHECK_SUPPLIER_DELETE_ERP_MSG = "供应商删除失败，请查看错误日志";

    /** 设置警戒/标准库存成功提示信息*/
    public static final String WARN_STANDARD_SETTING_SUCCEED = "设置警戒/标准库存成功";
    /** 设置警戒/标准库存失败提示信息*/
    public static final String WARN_STANDARD_SETTING_FAILED = "设置警戒/标准库存失败，请查看错误日志";

    /** 清理库存成功信息*/
    public static final String CLEAR_INVENTORY_OK_MSG = "清理库存成功";

    /** 清理库存失败信息*/
    public static final String CLEAR_INVENTORY_ERR_MSG = "清理库存失败，请查看错误日志";

    /** 物流信息导入错误信息*/
    public static final String IMPORT_CHECK_RESULT_IMPORT_ERR_MSG = "物流信息文件导入失败，请查看错误日志";

    /** 物流信息导入成功信息*/
    public static final String IMPORT_CHECK_RESULT_IMPORT_OK_MSG = "物流信息文件导入成功";

    /** 供应商冻结成功信息*/
    public static final String PUR_SUPPLIER_CHECK_FREEZE_OK_MSG = "供应商冻结成功";

    /** 供应商解冻成功信息*/
    public static final String PUR_SUPPLIER_CHECK_UNFREEZE_OK_MSG = "供应商解冻成功";

    /** 供应商删除成功信息*/
    public static final String PUR_SUPPLIER_CHECK_DELETE_OK_MSG = "供应商删除成功";

    /** 物流信息已被导入错误信息*/
    public static final String IMPORT_CHECK_RESULT_IMPORT_DOWN_MSG = "该盘点单已被其他用户导入了";

    /** 采购单ID为空错误信息*/
    public static final String IMPORT_CHECK_ORDER_ID_EMPTY_MSG = "采购单ID不能为空";

    /** 供应商审核失败提示信息*/
    public static final String PUR_SUPPLIER_REVIEW_FAILED_MSG = "供应商审核失败，请查看错误日志";

    /** 仓库ID生成失败信息*/
    public static final String STOREHOUSE_ID_CREATE_ERR_MSG = "仓库ID生成失败";

    /** 仓库编号重复信息*/
    public static final String STOREHOUSE_NO_DOUBLE_ERR_MSG = "该仓库编号已存在，请确认";

    /** 仓库信息新建失败错误信息*/
    public static final String STOREHOUSE_INFO_CREATE_ERR_MSG = "仓库创建失败，请查看错误日志";

    /** 仓库ID和版本号为空错误信息*/
    public static final String STOREHOUSE_ID_OR_VERSION_NO_EMPTY_MSG = "仓库ID和版本号不能为空";

    /** 仓库信息更新失败错误信息*/
    public static final String STOREHOUSE_INFO_UPDATE_ERR_MSG = "仓库更新失败，请查看错误日志";

    /** 仓库不存在错误信息*/
    public static final String STOREHOUSE_INFO_NOT_EXISTS_MSG = "该仓库可能已被其他用户删除了";

    /** 仓库删除失败错误信息*/
    public static final String STOREHOUSE_INFO_DELETE_ERR_MSG = "仓库删除失败，请查看错误日志";

    /** 仓库删除成功信息*/
    public static final String STOREHOUSE_INFO_DELETE_OK_MSG = "仓库删除成功";

    /** 仓库已被使用信息*/
    public static final String STOREHOUSE_INFO_USEED_MSG = "该仓库已被使用，不能删除";

    /** 仓库冻结失败错误信息*/
    public static final String STOREHOUSE_INFO_FROZEN_ERR_MSG = "仓库冻结失败，请查看错误日志";

    /** 仓库冻结成功信息*/
    public static final String STOREHOUSE_INFO_FROZEN_OK_MSG = "仓库冻结成功";

    /** 仓库解冻失败错误信息*/
    public static final String STOREHOUSE_INFO_THAW_ERR_MSG = "仓库解冻失败，请查看错误日志";

    /** 仓库解冻成功信息*/
    public static final String STOREHOUSE_INFO_THAW_OK_MSG = "仓库解冻成功";
    /** 验证用代码信息定数  --------------结束-------------- */

    /** 编码组定数定数  --------------开始-------------- */
    /** 编码组ID(00001：供应商类型)*/
    public static final String CODE_GROUP_ID_SUPPLIER_TYPE = "00001";
    /** 编码ID(00001：供应商类型的001：实物)*/
    public static final String CODE_ID_SUPPLIER_ENTITY_TYPE = "001";
    /** 编码ID(00001：供应商类型的002：虚拟)*/
    public static final String CODE_ID_SUPPLIER_VIRTUAL_TYPE = "002";
    /** 编码ID(00001：供应商类型的003：实物+虚拟)*/
    public static final String CODE_ID_SUPPLIER_ENTITY_VIRTUAL_TYPE = "003";

    /** 编码组ID(00002：供应商结算类型)*/
    public static final String CODE_GROUP_ID_SUPPLIER_BALANCE_TYPE = "00002";
    /** 编码ID(00002：供应商结算类型的001：单结)*/
    public static final String CODE_ID_SUPPLIER_BALANCE_SINGLE_TYPE = "001";
    /** 编码ID(00002：供应商结算类型的002：月结)*/
    public static final String CODE_ID_SUPPLIER_BALANCE_MONTH_TYPE = "002";
    /** 编码ID(00002：供应商结算类型的003：季结)*/
    public static final String CODE_ID_SUPPLIER_BALANCE_SEASON_TYPE = "003";
    /** 编码ID(00002：供应商结算类型的004：年结)*/
    public static final String CODE_ID_SUPPLIER_BALANCE_YEAR_TYPE = "004";

    /** 编码组ID(00003：性别)*/
    public static final String CODE_GROUP_ID_SEX = "00003";

    /** 编码组ID(00004: 证件类型) */
    public static final String ID_CARD_TYPE_GROUP_ID = "00004";
    /** 编码组ID(00004: 证件类型, 001: 身份证) */
    public static final String ID_CARD_TYPE_CODE_ID_CARD = "001";
    /** 编码组ID(00004: 证件类型, 002: 护照) */
    public static final String ID_CARD_TYPE_CODE_ID_PASSPORT = "002";

    /** 编码组ID（00005：审核状态编码）*/
    public static final String CARD_REVIEW_STATE_GROUP_ID = "00005";
    /** 编码组ID（00005：审核状态编码--001：未审核）*/
    public static final String CARD_REVIEW_STATE_UNREVIEWED = "001";
    /** 编码组ID（00005：审核状态编码--002：已审核）*/
    public static final String CARD_REVIEW_STATE_APPROVE = "002";
    /** 编码组ID（00005：审核状态编码--003：已拒绝）*/
    public static final String CARD_REVIEW_STATE_REFUSE = "003";

    /** 编码组ID(00007：物流支付方式)*/
    public static final String CODE_GROUP_ID_SHIPMENT_PAY_WAY = "00007";
    /** 编码组ID(00007：物流支付方式——001：供应商支付)*/
    public static final String CODE_ID_SHIPMENT_PAY_WAY_SUPPLIER = "001";
    /** 编码组ID(00007：物流支付方式——002：我方支付)*/
    public static final String CODE_ID_SHIPMENT_PAY_WAY_OWN = "002";
    /** 编码组ID(00007：物流支付方式——003：承运商月结)*/
    public static final String CODE_ID_SHIPMENT_PAY_WAY_CARRIER = "003";

    /** 编码组ID(00008：运输存储方式)*/
    public static final String CODE_GROUP_ID_TRANS_STO_WAY = "00008";
    /** 编码组ID(00008：运输存储方式——001：冷冻)*/
    public static final String CODE_ID_TRANS_STO_WAY_COLD = "001";
    /** 编码组ID(00008：运输存储方式——002：普通)*/
    public static final String CODE_ID_TRANS_STO_WAY_NOMAL = "002";

    /**编码组ID(00009：采购方式)*/
    public static final String CODE_GROUP_ID_PUR_WAY = "00009";
    /**编码组ID(00009：采购方式——001：现购)*/
    public static final String CODE_TYPE_ID_CASH_PURCHASE = "001";
    /**编码组ID(00009：采购方式——002：赊购)*/
    public static final String CODE_TYPE_ID_CREDIT_PURCHASE = "002";

    /**编码组ID(00010：付款方式)*/
    public static final String CODE_GROUP_ID_PAY_WAY = "00010";
    /**编码组ID(00010：付款方式——001：银行汇款)*/
    public static final String CODE_ID_PAY_WAY_BANK = "001";
    /**编码组ID(00010：付款方式——002：现金支付)*/
    public static final String CODE_ID_PAY_WAY_CASH = "002";

    /**编码组ID(00011：付款计划)*/
    public static final String CODE_GROUP_ID_PAY_PLAN = "00011";
    /**编码组ID(00011：付款计划——001：一次性付款)*/
    public static final String CODE_TYPE_ID_PAY_ONCE = "001";
    /**编码组ID(00011：付款计划——002：多次付款)*/
    public static final String CODE_TYPE_ID_PAY_TIMES = "002";

    /**编码组ID(00012：审核状态)*/
    public static final String CODE_GROUP_ID_REVIEW_STATE = "00012";
    /**编码组ID(00012：审核状态——001：自审未审核)*/
    public static final String CODE_TYPE_ID_REVIEW_NOTSELF = "001";
    /**编码组ID(00012：审核状态——002：自审已审核、財审未审核)*/
    public static final String CODE_TYPE_ID_REVIEW_NOTFINANCE = "002";
    /**编码组ID(00012：审核状态——003：財审已审核、未发送)*/
    public static final String CODE_TYPE_ID_REVIEW_NOTSEND = "003";
    /**编码组ID(00012：审核状态——004：已发送、客审未审核)*/
    public static final String CODE_TYPE_ID_REVIEW_NOTCUSTOMER = "004";
    /**编码组ID(00012：审核状态——005：客审已审核)*/
    public static final String CODE_TYPE_ID_REVIEW_CUSTOMER = "005";
    /**编码组ID(00012：审核状态——006：自审已拒绝)*/
    public static final String CODE_TYPE_ID_REVIEW_SELFREFUSE = "006";
    /**编码组ID(00012：审核状态——007：財审已拒绝)*/
    public static final String CODE_TYPE_ID_REVIEW_FINANCEREFUSE = "007";
    /**编码组ID(00012：审核状态——008：客审已拒绝)*/
    public static final String CODE_TYPE_ID_REVIEW_CUSTOMERREFUSE = "008";

    /**编码组ID(00013：采购订单状态)*/
    public static final String CODE_GROUP_ID_PUR_ORDER_STATE = "00013";
    /**编码组ID(00013：采购订单状态——001：处理中)*/
    public static final String PUR_ORDER_STATE_CODE_PROCESSING = "001";
    /**编码组ID(00013：采购订单状态——002：已完成)*/
    public static final String PUR_ORDER_STATE_CODE_FINISHED = "002";
    /**编码组ID(00013：采购订单状态——003：已终止)*/
    public static final String PUR_ORDER_STATE_CODE_STOPED = "003";
    /**编码组ID(00013：采购订单状态——004：已挂起)*/
    public static final String PUR_ORDER_STATE_CODE_SUSPEND = "004";

    /**编码组ID(00014：收货状态)*/
    public static final String CODE_GROUP_ID_RECEIVING_STATE = "00014";
    /**编码组ID(00014：收货状态——001：未收货)*/
    public static final String CODE_TYPE_ID_NOT_RECEIVING = "001";
    /**编码组ID(00014：收货状态——002：已收货)*/
    public static final String CODE_TYPE_ID_RECEIVED = "002";
    /**编码组ID(00014：收货状态——003：部分收货)*/
    public static final String CODE_TYPE_ID_PART_RECEIVED = "003";

    /**编码组ID(00016：采购订单结算状态)*/
    public static final String CODE_GROUP_ID_IN_BALANCE_STATE = "00016";
    /**编码组ID(00016：采购订单结算状态——001：未结算)*/
    public static final String PUR_ORDER_BALANCE_TYPE_UNBALANCED = "001";
    /**编码组ID(00016：采购订单结算状态——001：已u结算)*/
    public static final String PUR_ORDER_BALANCE_TYPE_BALANCED = "002";
    /**编码组ID(00016：采购订单结算状态——001：部分结算)*/
    public static final String PUR_ORDER_BALANCE_TYPE_PARTBALANCED = "003";

    /**编码组ID(00017：采购需求单状态)*/
    public static final String CODE_GROUP_ID_HANDLE_STATE = "00017";
    /**编码组ID(00017：采购需求单状态——001：处理中)*/
    public static final String CODE_ID_HANDLE_STATE_PROCESS = "001";
    /**编码组ID(00017：采购需求单状态——002：已完成)*/
    public static final String CODE_ID_HANDLE_STATE_FINISH = "002";
    /**编码组ID(00017：采购需求单状态——003：已终止)*/
    public static final String CODE_ID_HANDLE_STATE_SHOP = "003";
    /**编码组ID(00017：采购需求单状态——004：已挂起)*/
    public static final String CODE_ID_HANDLE_STATE_SUSPEND = "004";

    /**编码组ID(00018：退货类型)*/
    public static final String CODE_GROUP_ID_RETURN_TYPE = "00018";
    /**编码组ID(00018：退货类型——001：正常品)*/
    public static final String CODE_ID_RETURN_TYPE_NORMAL = "001";
    /**编码组ID(00018：退货类型——002：残次品)*/
    public static final String CODE_ID_RETURN_TYPE_DEFECTIVE = "002";

    /**编码组ID(00019：发货状态编码组ID)*/
    public static final String CODE_GROUP_ID_DELIVERY_STATE = "00019";
    /**编码组ID(00019：发货状态编码组ID——001：未发货；)*/
    public static final String DELIVERY_STATE_NO_SHIPMENT = "001";
    /**编码组ID(00019：发货状态编码组ID——002：已发货；)*/
    public static final String DELIVERY_STATE_SHIPMENT = "002";
    /**编码组ID(00019：发货状态编码组ID——003：部分发货)*/
    public static final String DELIVERY_STATE_PORTION_SHIPMENT = "003";

    /** 编码组ID(00020：仓库类型)*/
    public static final String CODE_GROUP_ID_STOREHOUSE_TYPE = "00020";
    /** 编码ID(00020：仓库类型，001：冷冻仓)*/
    public static final String STOREHOUSE_TYPE_FREEZING = "001";
    /** 编码ID(00020：仓库类型，002：普通仓)*/
    public static final String STOREHOUSE_TYPE_ORDINARY = "002";

    /** 编码组ID(00021：仓库归属类型)*/
    public static final String CODE_GROUP_ID_STOREHOUSE_OWNERSHIP_TYPE = "00021";
    /** 编码ID(00021：仓库归属类型，001：自有)*/
    public static final String STOREHOUSE_OWNERSHIP_TYPE_OWN = "001";
    /** 编码ID(00021：仓库归属类型，002：供应商仓库)*/
    public static final String STOREHOUSE_OWNERSHIP_TYPE_SUPPLIER = "002";
    /** 编码ID(00021：仓库归属类型，003：物流仓库)*/
    public static final String STOREHOUSE_OWNERSHIP_TYPE_LOGISTICS = "003";

    /** 编码组ID(00022：入库类型)*/
    public static final String CODE_GROUP_ID_IN_STORE_TYPE = "00022";
    /** 编码ID(00022：入库类型的001：采购入库)*/
    public static final String IN_STORE_TYPE_CODE_PUR_IN = "001";
    /** 编码ID(00022：入库类型的002：调配入库)*/
    public static final String IN_STORE_TYPE_CODE_ALLOCATE_IN = "002";
    /** 编码ID(00022：入库类型的003：客户退货入库)*/
    public static final String IN_STORE_TYPE_CODE_CUSTOMER_RETURN_IN = "003";
    /** 编码ID(00022：入库类型的004：盘盈入库)*/
    public static final String IN_STORE_TYPE_CODE_INVERTORY_PROFIT_IN = "004";
    /** 编码ID(00022：入库类型的005：采购补单)*/
    public static final String IN_STORE_TYPE_CODE_PUR_RESUPPLY_ORDER_IN = "005";
    /** 编码ID(00022：入库类型的006：调拨补单)*/
    public static final String IN_STORE_TYPE_CODE_ALLOCATE_RESUPPLY_ORDER_IN = "006";

    /** 编码组ID(00023：出库类型)*/
    public static final String CODE_GROUP_ID_OUT_STORE_TYPE = "00023";
    /** 编码ID(00023：出库类型的001：客户订单)*/
    public static final String OUT_STORE_TYPE_CODE_CUSTOMER_ORDER_OUT = "001";
    /** 编码ID(00023：出库类型的002：调拨出库)*/
    public static final String OUT_STORE_TYPE_CODE_ALLOCATE_OUT = "002";
    /** 编码ID(00023：出库类型的003：采购退货)*/
    public static final String OUT_STORE_TYPE_CODE_PUR_RETURN_OUT = "003";
    /** 编码ID(00023：出库类型的004：损耗出库)*/
    public static final String OUT_STORE_TYPE_CODE_PRODUCT_LOSS_OUT = "004";
    /** 编码ID(00023：出库类型的005：采购补单)*/
    public static final String OUT_STORE_TYPE_CODE_PUR_RESUPPLY_ORDER_OUT = "005";
    /** 编码ID(00023：出库类型的006：调配补单)*/
    public static final String OUT_STORE_TYPE_CODE_ALLOCATE_RESUPPLY_ORDER_OUT = "006";

    /**编码组ID(00024：调拨单状态)*/
    public static final String CODE_GROUP_ID_ALLOCATE_STATE = "00024";
    /**编码组ID(00024：调拨单状态——001：处理中)*/
    public static final String CODE_ID_ALLOCATE_STATE_PROCESS = "001";
    /**编码组ID(00024：调拨单状态——002：已完成)*/
    public static final String CODE_ID_ALLOCATE_STATE_FINISH = "002";
    /**编码组ID(00024：调拨单状态——003：已终止)*/
    public static final String CODE_ID_ALLOCATE_STATE_SHOP = "003";
    /**编码组ID(00024：调拨单状态——004：已挂起)*/
    public static final String CODE_ID_ALLOCATE_STATE_SUSPEND = "004";

    /** 编码组ID(00025：损耗来源)*/
    public static final String CODE_GROUP_ID_LOSS_SOURCE = "00025";
    /** 编码ID(00025：损耗来源的001：盘亏损耗)*/
    public static final String LOSS_SOURCE_CODE_INVENTORY_LOSS = "001";
    /** 编码ID(00025：损耗来源的002：客户退货损耗)*/
    public static final String LOSS_SOURCE_CODE_CUSTOMER_RETURN_LOSS = "002";

    /** 编码组ID(00026：增益来源)*/
    public static final String CODE_GROUP_ID_GAIN_SOURCE = "00026";
    /** 编码ID(00026：增益来源的001：盘盈增益)*/
    public static final String GAIN_SOURCE_CODE_INVENTORY_GAIN = "001";

    /** 编码组ID(00027：参数类型)*/
    public static final String CODE_GROUP_ID_PARAM_TYPE = "00027";
    /** 编码ID(00027：参数类型的001：文本框)*/
    public static final String CODE_GROUP_ID_PARAM_TYPE_TEXT = "001";
    /** 编码ID(00027：参数类型的002：多行文本框)*/
    public static final String CODE_GROUP_ID_PARAM_TYPE_TEXTAREA = "002";
    /** 编码ID(00027：参数类型的003：下拉框)*/
    public static final String CODE_GROUP_ID_PARAM_TYPE_SELECT = "003";
    /** 编码ID(00027：参数类型的004：复选框)*/
    public static final String CODE_GROUP_ID_PARAM_TYPE_CHECKBOX = "004";
    /** 编码ID(00027：参数类型的005：图片)*/
    public static final String CODE_GROUP_ID_PARAM_TYPE_PIC = "005";

    /** 编码组ID(00028：参数能否检索标识)*/
    public static final String CODE_GROUP_ID_PARAM_SELECT_FLAG = "00028";

    /** 编码组ID(00029：货品类型)*/
    public static final String CODE_GROUP_ID_PRODUCT_TYPE = "00029";

    /** 编码组ID(00030：保质期单位)*/
    public static final String CODE_GROUP_ID_EXPIRATION_DATE_UNIT = "00030";

    /** 编码组ID(00031：计量单位)*/
    public static final String CODE_GROUP_ID_MEASURE_UNIT = "00031";
    /** 编码组ID(00031：计量单位,001:天)*/
    public static final String CODE_ID_MEASURE_UNIT_DAY = "001";
    /** 编码组ID(00031：计量单位,001:天)*/
    public static final String CODE_ID_MEASURE_UNIT_WEEK = "002";
    /** 编码组ID(00031：计量单位,001:天)*/
    public static final String CODE_ID_MEASURE_UNIT_MONTH = "003";
    /** 编码组ID(00031：计量单位,001:天)*/
    public static final String CODE_ID_MEASURE_UNIT_SEASON = "004";
    /** 编码组ID(00031：计量单位,001:天)*/
    public static final String CODE_ID_MEASURE_UNIT_YEAR = "005";

    /** 编码组ID(00032：申请上架状态)*/
    public static final String APP_ON_SALE_STATE_GROUP_ID = "00032";
    /** 编码组ID(00032：申请上架状态,001:未申请)*/
    public static final String APP_ON_SALE_STATE_NOT_APPLY = "001";
    /** 编码组ID(00032：申请上架状态,002 :已申请、未审核)*/
    public static final String APP_ON_SALE_STATE_ALREADY_APPLY = "002";
    /** 编码组ID(00032：申请上架状态,003:已审核)*/
    public static final String APP_ON_SALE_STATE_ALREADY_EXAMINE = "003";
    /** 编码组ID(00032：申请上架状态,004:已拒绝)*/
    public static final String APP_ON_SALE_STATE_REFUSED = "004";

    /** 编码组ID(00033：商品销售组成员类型)*/
    public static final String CODE_GOODS_SALE_GROUP_MEMBER_TYPE = "00033";

    /** 客户账户表账户状态编码组ID(00034:账户状态) */
    public static final String ACCOUNT_STATUS_GROUP_ID = "00034";
    /** 客户账户表账户状态编码ID(00034: 账户状态,001:正常) */
    public static final String ACCOUNT_STATUS_CODE_ID_NORMAL = "001";
    /** 客户账户表账户状态编码ID(00034: 账户状态,002:冻结) */
    public static final String ACCOUNT_STATUS_CODE_ID_INVALID = "002";
    /** 客户账户表账户状态编码ID(00034: 账户状态,003:注销) */
    public static final String ACCOUNT_STATUS_CODE_ID_CANCEL = "003";

    /** 卡状态编码组ID（00037）*/
    public static final String CARD_STATUS_GROUP_ID = "00037";
    /** 卡状态编码ID 001：未激活*/
    public static final String CARD_STATUS_UNUSED = "001";
    /** 卡状态编码ID 002：已激活*/
    public static final String CARD_STATUS_OPENED = "002";
    /** 卡状态编码ID 003：已充值*/
    public static final String CARD_STATUS_RECHANGE = "003";
    /** 卡状态编码ID 004：冻结申请 */
    public static final String CARD_STATUS_FREEZE_REVIEW = "004";
    /** 卡状态编码ID 005：已冻结*/
    public static final String CARD_STATUS_FREEZE = "005";
    /** 卡状态编码ID 006：解冻申请 */
    public static final String CARD_STATUS_UNFREEZE_REVIEW = "006";
    /** 卡状态编码ID 007：作废申请 */
    public static final String CARD_STATUS_VOIDED_REVIEW = "007";
    /** 卡状态编码ID 008：已作废*/
    public static final String CARD_STATUS_VOIDED = "008";

    /** 卡类型编码组ID(00038)*/
    public static final String CARD_TYPE_GROUP_ID = "00038";
    /** 卡类型编码ID 001：实体卡*/
    public static final String CARD_TYPE_ENTITY_CARD = "001";
    /** 卡类型编码ID 002：虚拟卡*/
    public static final String CARD_TYPE_VIRTUAL_CARD = "002";

    /** 支付方式激活状态编码组ID（00041）*/
    public static final String PAY_KIND_STATUS_GROUP_ID = "00041";
    /** 支付方式激活状态编码ID 001：启用*/
    public static final String PAY_KIND_STATUS_ENABLE = "001";
    /** 支付方式激活状态编码ID 002：停用*/
    public static final String PAY_KIND_STATUS_DISABLE = "002";

    /** 编码组ID(00043：积分收支类型)*/
    public static final String CODE_GROUP_ID_POINT_BALANCE_TYPE = "00043";
    /** 编码ID(00043：积分收支类型编码(001：收入)*/
    public static final String POINTS_BALANCE_TYPE_CODE_INCOME = "001";
    /** 编码ID(00043：积分收支类型编码(002：支出)*/
    public static final String POINTS_BALANCE_TYPE_CODE_EXPENDITURE = "002";

    /** 编码组ID(00044：获取积分途径)*/
    public static final String CODE_GROUP_ID_GET_MODE = "00044";
    /** 编码ID(00044：获取积分途径编码(001：充值)*/
    public static final String POINTS_MODE_CODE_RECHARGE = "001";
    /** 编码ID(00044：获取积分途径编码(002：购物)*/
    public static final String POINTS_MODE_CODE_SHOPPING = "002";
    /** 编码ID(00044：获取积分途径编码(003：活动)*/
    public static final String POINTS_MODE_CODE_ACTIVITY = "003";
    /** 编码ID(00044：获取积分途径编码(004：人工添加)*/
    public static final String POINTS_MODE_CODE_ARTIFICIAL = "004";
    /** 编码ID(00044：获取积分途径编码(005：其他)*/
    public static final String POINTS_MODE_CODE_ELSE = "005";

    /** 后台用户性质编码组ID  "00046"*/
    public static final String USER_PROPERTY_GROUP_ID = "00046";
    /** 后台用户性质编码ID  001：临时工*/
    public static final String USER_PROPERTY_CODE_ID_TEMP = "001";
    /** 后台用户性质编码ID  002：正式工*/
    public static final String USER_PROPERTY_CODE_ID_FORMAL = "002";

    /** 编码组ID (00047:权限状态) */
    public static final String AUTHORITY_STATUS_GROUP_ID = "00047";
    /** 编码ID (00047:权限状态, 001：不可用)*/
    public static final String AUTHORITY_STATUS_CODE_ID_DISABLE = "001";
    /** 编码ID (00047:权限状态, 002：可用)*/
    public static final String AUTHORITY_STATUS_CODE_ID_ENABLE = "002";

    /** 编码组ID (00048:满意度) */
    public static final String SATISFACTION_GROUP_ID = "00048";
    /** 编码ID (00048:满意度, 001：不满意)*/
    public static final String SATISFACTION_CODE_ID_NOSATISFACTION = "001";
    /** 编码ID (00048:满意度, 002：一般)*/
    public static final String SATISFACTION_CODE_ID_GENERAL = "002";
    /** 编码ID (00048:满意度, 003：满意)*/
    public static final String SATISFACTION_CODE_ID_SATISFACTION = "003";
    /** 编码ID (00048:满意度, 004：非常满意)*/
    public static final String SATISFACTION_CODE_ID_VERYSATISFACTION = "004";

    /** 支付费用标准编码组ID(00049)*/
    public static final String PAY_FEE_TYPE_GROUP_ID = "00049";
    /** 支付费用标准编码ID 001：无费用*/
    public static final String PAY_FEE_TYPE_NO_FEE = "001";
    /** 支付费用标准编码ID 002：固定费用*/
    public static final String PAY_FEE_TYPE_FIXED_FEE = "002";
    /** 支付费用标准编码ID 003：费率收取*/
    public static final String PAY_FEE_TYPE_FLOAT_FEE = "003";

    /** 编码组ID(00057：供应商到货状态)*/
    public static final String CODE_GROUP_ID_SUPPLIER_ARRI_STATE = "00057";
    /** 编码ID(00057：供应商到货状态——001:未到货)*/
    public static final String CODE_ID_SUPPLIER_ARRI_STATE_UNARRI = "001";
    /** 编码ID(00057：供应商到货状态——002:已到货)*/
    public static final String CODE_ID_SUPPLIER_ARRI_STATE_ARRIED = "002";
    /** 编码ID(00057：供应商到货状态——003:部分到货)*/
    public static final String CODE_ID_SUPPLIER_ARRI_STATE_PART = "003";

    /** 编码组ID(00058：盘点方式)*/
    public static final String CODE_GROUP_ID_INVENTORY_CHECK_WAY = "00058";
    /** 编码ID(00058：盘点方式, 001:日常盘点)*/
    public static final String INVENTORY_CHECK_WAY_CODE_DAILY = "001";
    /** 编码ID(00058：盘点方式, 002:定期盘点)*/
    public static final String INVENTORY_CHECK_WAY_CODE_REGULAR = "002";

    /** 编码组ID(00060：盘点状态)*/
    public static final String CODE_GROUP_ID_INVENTORY_CHECK_STATE = "00060";
    /** 编码ID(00060：盘点状态, 001:盘点中)*/
    public static final String INVENTORY_CHECK_STATE_CODE_IN = "001";
    /** 编码ID(00060：盘点状态, 002:盘点完成)*/
    public static final String INVENTORY_CHECK_STATE_CODE_COMPLETE = "002";

    /** 编码组ID(00061：稽核状态)*/
    public static final String CODE_GROUP_ID_AUDIT_STATE = "00061";
    /** 编码ID(00061：稽核状态, 001:未稽核)*/
    public static final String AUDIT_STATE_CODE_NON = "001";
    /** 编码ID(00061：稽核状态, 002:已稽核)*/
    public static final String AUDIT_STATE_CODE_ALREADY = "002";

    /** 编码组ID(00062：货品状态)*/
    public static final String CODE_GROUP_ID_PRODUCT_STATE = "00062";
    /** 编码ID(00062：货品状态, 001:正品)*/
    public static final String PRODUCT_STATE_CODE_NORMAL = "001";
    /** 编码ID(00062：货品状态, 002:次品)*/
    public static final String PRODUCT_STATE_CODE_DEFECTIVE = "002";

    /** 编码组ID(00063：损耗类型)*/
    public static final String CODE_GROUP_ID_LOSS_TYPE = "00063";
    /** 编码ID(00063：损耗类型, 001:正常损耗)*/
    public static final String LOSS_TYPE_CODE_NORMAL = "001";
    /** 编码ID(00063：损耗类型, 002:异常损耗)*/
    public static final String LOSS_TYPE_CODE_ABNORAML = "002";

    /** 编码组ID(00064：承运商服务类型)*/
    public static final String CODE_GROUP_ID_CARRIER_SERVICE_TYPE = "00064";
    /** 编码ID(00064：承运商服务类型, 001:标准快递)*/
    public static final String CARRIER_SERVICE_TYPE_CODE_STANDARD_EXPRESS = "001";
    /** 编码ID(00064：承运商服务类型, 002:大量货品运输)*/
    public static final String CARRIER_SERVICE_TYPE_CODE_LARGE_PRODUCT_TRANSPORT = "002";

    /** 编码组ID(00066：收货单状态)*/
    public static final String CODE_GROUP_ID_RECEIVING_ORDER_STATE = "00066";
    /** 编码ID(00066：收货单状态, 001:处理中)*/
    public static final String RECEIVING_ORDER_STATE_CODE_PROCESSING = "001";
    /** 编码ID(00066：收货单状态, 002:已完成)*/
    public static final String RECEIVING_ORDER_STATE_CODE_FINISH = "002";
    /** 编码ID(00066：收货单状态, 003:已取消)*/
    public static final String RECEIVING_ORDER_STATE_CODE_CANCLE = "003";

    /** 编码组ID(00067：收货单类型)*/
    public static final String CODE_GROUP_ID_RECEIVING_ORDER_TYPE = "00067";
    /** 编码ID(00067：收货单类型, 001:采购收货)*/
    public static final String CODE_ID_RECEIVING_ORDER_TYPE_PUR = "001";
    /** 编码ID(00067：收货单类型, 002:调拨收货)*/
    public static final String CODE_ID_RECEIVING_ORDER_TYPE_ALLOCATE = "002";
    /** 编码ID(00067：收货单类型, 003:订单退货收货)*/
    public static final String CODE_ID_RECEIVING_ORDER_TYPE_RETURN = "003";

    /** 编码组ID(00068：下单状态编码组ID)*/
    public static final String CODE_GROUP_ID_SEND_ORDER_STATE = "00068";
    /** 编码ID 001：未下单； */
    public static final String SEND_ORDER_STATE_ORDER_NO = "001";
    /** 编码ID 002：下单中； */
    public static final String SEND_ORDER_STATE_ORDER_ING = "002";
    /** 编码ID 003：已下单； */
    public static final String SEND_ORDER_STATE_ORDER = "003";
    /** 编码ID 004：下单失败； */
    public static final String SEND_ORDER_STATE_ORDER_ERROR = "004";

    /** 编码组ID(00070：商品类别)*/
    public static final String GOODS_CATEGORY_GROUP_ID = "00070";
    /** 编码ID(00070：商品类别, 001:实物)*/
    public static final String GOODS_CATEGORY_CODE_PHYSICAL = "001";
    /** 编码ID(00070：商品类别, 002:虚物)*/
    public static final String GOODS_CATEGORY_CODE_VIRTUAL = "002";

    /** 编码组ID(00069：商品类型)*/
    public static final String GOODS_TYPE_GROUP_ID = "00069";
    /** 编码ID(00069：商品类型, 001:普通商品)*/
    public static final String GOODS_TYPE_CODE_NORMAL = "001";
    /** 编码ID(00069：商品类型, 002:组合商品)*/
    public static final String GOODS_TYPE_CODE_GENERAL = "002";

    /** 子帐号类别编码组ID "00071" */
    public static final String ACCOUNT_TYPE_GROUP_ID = "00071";
    /** 子帐号类别编码ID, 001: 购物卡账户 */
    public static final String ACCOUNT_TYPE_CODE_ID_SHOP = "001";
    /** 子帐号类别编码ID, 002: 充值卡账户*/
    public static final String ACCOUNT_TYPE_CODE_ID_RECHARGE = "002";

    /** 编码组ID(00072：操作的属性)*/
    public static final String CODE_GROUP_ID_HANDLE_TYPE = "00072";

    /** 编码组ID(00073：是否有差异)*/
    public static final String CODE_GROUP_ID_HAS_DIFFERENT = "00073";
    /** 编码ID(00073：是否有差异, 001:没有差异)*/
    public static final String HAS_DIFFERENT_CODE_NOT_HAS = "001";
    /** 编码ID(00073：是否有差异, 002:有差异)*/
    public static final String HAS_DIFFERENT_CODE_HAS = "002";

    /** 后台用户状态编码组ID  "00074"*/
    public static final String USER_STATUS_GROUP_ID = "00074";
    /** 后台用户状态编码ID  001：冻结*/
    public static final String USER_STATUS_CODE_ID_FREEZE = "001";
    /** 后台用户状态编码ID  002：正常*/
    public static final String USER_STATUS_CODE_ID_NORMAL = "002";

    /** 编码组ID(00075：客户账户状态) */
    public static final String CUSTOMER_ACCOUNT_CODE_GROUP_ID = "00075";
    /** 编码组ID(00075：客户账户状态, 001:冻结) */
    public static final String CUSTOMER_ACCOUNT_CODE_ID_INVALID = "001";
    /** 编码组ID(00075：客户账户状态, 002:正常) */
    public static final String CUSTOMER_ACCOUNT_CODE_ID_NORMAL = "002";

    /** 编码组ID(00077: 客户类别) */
    public static final String CUSTOMER_TYPE_GROUP_ID = "00077";
    /** 编码组ID(00077: 客户类别, 001:普通客户) */
    public static final String CUSTOMER_TYPE_CODE_ID_ORDINARY = "001";
    /** 编码组ID(00077: 客户类别 , 002:大客户) */
    public static final String CUSTOMER_TYPE_CODE_ID_BIG = "002";

    /** 编码组ID(00078：发货单类型) */
    public static final String CODE_GROUP_ID_DELIVERY_ORDER_TYPE = "00078";
    /** 发货单类型 001:订单发货 */
    public static final String DELIVERY_ORDER_TYPE_ORDER = "001";
    /** 发货单类型 002:采购退货发货 */
    public static final String DELIVERY_ORDER_TYPE_PURCHASE_RETURN = "002";
    /** 发货单类型 003:调拨发货 */
    public static final String DELIVERY_ORDER_TYPE_ALLOCATION = "003";

    /** 编码组ID(00079：成长值类型) */
    public static final String GET_MODE_GROUP_ID = "00079";
    /** 编码组ID(00079：成长值类型, 001:登录签到) */
    public static final String GET_MODE_CODE_ID_LOGIN = "001";
    /** 编码组ID(00079：成长值类型, 002:确认收货) */
    public static final String GET_MODE_CODE_ID_AFFIRM = "002";
    /** 编码组ID(00079：成长值类型, 003:评价商品) */
    public static final String GET_MODE_CODE_ID_APPRAISE = "003";
    /** 编码组ID(00079：成长值类型, 004:晒单) */
    public static final String GET_MODE_CODE_ID_BASK = "004";
    /** 编码组ID(00079：成长值类型, 005:充值) */
    public static final String GET_MODE_CODE_ID_RECHARGE = "005";
    /** 编码组ID(00079：成长值类型, 006:扣除) */
    public static final String GET_MODE_CODE_ID_DEDUCT = "006";
    /** 编码组ID(00079：成长值类型, 007:其他) */
    public static final String GET_MODE_CODE_ID_ELSE = "007";

    /** 编码组ID(00080：模板分类) */
    public static final String TEMPLATE_CATEGORY_GROUP_ID = "00080";
    /** 编码组ID(00080：模板分类, 001:短信) */
    public static final String TEMPLATE_CATEGORY_CODE_ID_SMS = "001";
    /** 编码组ID(00080：模板分类, 002:邮件) */
    public static final String TEMPLATE_CATEGORY_CODE_ID_EMAIL = "002";

    /** 公告发布状态编码组ID(00081：公告发布状态) */
    public static final String ANNOUNCEMENT_STATUS_GROUP_ID = "00081";
    /** 公告发布状态编码ID(00081：公告发布状态, 001:已发布) */
    public static final String ANNOUNCEMENT_STATUS_CODE_ID_YES = "001";
    /** 公告发布状态编码ID(00081：公告发布状态, 002:未发布) */
    public static final String ANNOUNCEMENT_STATUS_CODE_ID_NO = "002";

    /** 订单状态编码组ID（00082）*/
    public static final String ORDER_STATUS_GROUP_ID = "00082";
    /** 订单状态编码ID  001：已提交*/
    public static final String ORDER_STATUS_SUBMITTED = "001";
    /** 订单状态编码ID  002：已完成*/
    public static final String ORDER_STATUS_COMPLETED = "002";
    /** 订单状态编码ID  003：已取消*/
    public static final String ORDER_STATUS_CANCELED = "003";

    /** 订单物流状态编码组ID（00083）*/
    public static final String SHIPPING_STATUS_GROUP_ID = "00083";
    /** 订单物流状态编码ID  001：未发货*/
    public static final String SHIPPING_STATUS_UNFILLED = "001";
    /** 订单物流状态编码ID  002：已发货*/
    public static final String SHIPPING_STATUS_DELIVERED = "002";
    /** 订单物流状态编码ID  003：签收*/
    public static final String SHIPPING_STATUS_SIGNFOR = "003";
    /** 订单物流状态编码ID  004：拒收*/
    public static final String SHIPPING_STATUS_REJECTION = "004";

    /** 支付状态编码组ID（00084）*/
    public static final String ORDER_PAY_STATUS_GROUP_ID = "00084";
    /** 支付状态编码ID 001：未付款*/
    public static final String ORDER_PAY_STATUS_ARREARAGE = "001";
    /** 支付状态编码ID 002：已付款*/
    public static final String ORDER_PAY_STATUS_PAID = "002";
    /** 支付状态编码ID 003：付款失败*/
    public static final String ORDER_PAY_STATUS_FAILED = "003";
    /** 支付状态编码ID 004：未退款*/
    public static final String ORDER_PAY_STATUS_NO_REFUND = "004";
    /** 支付状态编码ID 005：已退款*/
    public static final String ORDER_PAY_STATUS_REFUND = "005";

    /** 关联商品类型编码组ID（00085）*/
    public static final String LINK_GOODS_GROUP_ID = "00085";
    /** 支付状态编码ID 001：购物车*/
    public static final String LINK_GOODS_SHOPPING_CART = "001";
    /** 支付状态编码ID 002：商品详情页*/
    public static final String LINK_GOODS_DETAIL_PAGE = "002";
    /** 支付状态编码ID 003：支付完成推荐*/
    public static final String LINK_GOODS_PAY_COMPLETE = "003";

    /** 审核状态编码组ID（00086）*/
    public static final String AUDIT_STATUS_GROUP_ID = "00086";
    /** 审核状态 001：申请 */
    public static final String AUDIT_STATUS_APPLY = "001";
    /** 审核状态 002：取消 */
    public static final String AUDIT_STATUS_CANCEL = "002";
    /** 审核状态 003：审核通过 */
    public static final String AUDIT_STATUS_APPROVE = "003";
    /** 审核状态 004：审核不通过 */
    public static final String AUDIT_STATUS_UNAPPROVE = "004";
    /** 编辑审核状态001：通过*/
    public static final String EDIT_AUDITOR_STATUS_APPROVE = "001";

    /** 编码组ID(00087：积分类型) */
    public static final String POINT_TYPE_CODE_GROUP_ID = "00087";
    /** 编码组ID(00087：积分类型, 001:消费) */
    public static final String POINT_TYPE_CODE_ID_EXPENSE = "001";
    /** 编码组ID(00087：积分类型, 002:评价) */
    public static final String POINT_TYPE_CODE_ID_APPRAISE = "002";
    /** 编码组ID(00087：积分类型, 003:晒单) */
    public static final String POINT_TYPE_CODE_ID_BASK = "003";

    /** 食谱是否启用编码组ID(00088：食谱是否启用) */
    public static final String IS_START_USING_GROUP_ID = "00088";
    /** 食谱是否启用编码ID(00088：食谱是否启用, 001:未启用) */
    public static final String IS_START_USING_CODE_ID_YES = "001";
    /** 食谱是否启用编码ID(00088：食谱是否启用, 002:已启用) */
    public static final String IS_START_USING_CODE_ID_NO = "002";

    /** 退货状态编码组ID(00092) */
    public static final String RETURN_GOODS_STATUS_GROUP_ID = "00092";
    /** 退货状态编码ID(00092：退货状态, 001:退货中) */
    public static final String RETURN_GOODS_STATUS_CODE_ID_RETOF = "001";
    /** 退货状态编码ID(00092：退货状态, 002:已退货) */
    public static final String RETURN_GOODS_STATUS_CODE_ID_HAVERET = "002";

    /** 采购单销售状态编码组ID(00093) */
    public static final String CODE_GROUP_ID_PUR_SALE_STATE = "00093";
    /** 采购单销售状态编码ID(001：销售中)*/
    public static final String PUR_SALE_STATE_CODE_IN = "001";
    /** 采购单销售状态编码ID(002：销售完成)*/
    public static final String PUR_SALE_STATE_CODE_COMPLETE = "002";

    /** 商品照片类型编码组ID(00095) */
    public static final String GALLERY_TYPE_GROUP_ID = "00095";
    /** 商品照片类型编码ID(001：轮播)*/
    public static final String GALLERY_TYPE_CODE_ID_CAROUSEL = "001";
    /** 商品照片类型编码ID(002：首页)*/
    public static final String GALLERY_TYPE_CODE_ID_HOME_PAGE = "002";
    /** 商品照片类型编码ID(003：分类页)*/
    public static final String GALLERY_TYPE_CODE_ID_CATEGORY_PAGE = "003";

    /** 编码组ID(00097: 显示类别) */
    public static final String DISPLAY_CLASS_GROUP_ID = "00097";
    /** 编码组ID(00097: 显示类别, 001:全部) */
    public static final String DISPLAY_CLASS_ALL = "001";
    /** 编码组ID(00097: 显示类别, 002:非冻品) */
    public static final String DISPLAY_CLASS_NOT_FROZEN = "002";

    /** 编码组ID（00035：账务变动方向） */
    public static final String CODE_GROUP_ID_SEQ_FLAG = "00035";
    /** 编码组ID（00035：账务变动方向， 001：充值） */
    public static final String CODE_ID_SEQ_FLAG_RECHANGE = "001";
    /** 编码组ID（00035：账务变动方向， 002：支出） */
    public static final String CODE_ID_SEQ_FLAG_DEFRAY = "002";

    /** 编码组ID(00029：货品类型)*/
    public static final String PRODUCT_CATEGORY_GROUP_ID = "00029";
    /** 编码ID(00029：货品类型, 001:实物)*/
    public static final String PRODUCT_CATEGORY_CODE_PHYSICAL = "001";
    /** 编码ID(00029：货品类型, 002:虚物)*/
    public static final String PRODUCT_CATEGORY_CODE_VIRTUAL = "002";

    /** 编码组定数  --------------结束-------------- */

    /** 顺丰：入库单（采购订单）接口  --------------开始-------------- */
    /** 下单状态编码 001:未下单 */
    public static final String SEND_ORDER_STATE_CODE = "001";
    /** 收货单状态编码 001:处理中 */
    public static final String RECEIVING_ORDER_STATE_CODE = "001";
    /** 顺丰接口：收货单接口  --------------结束-------------- */

    /** 顺序名称 定数 --------------开始-------------- */

    /** 顺序表记录(采购订单ID顺序) */
    public static final String COLUMN_PUR_ORDER_ID_SEQUENCE = "pur_order_id_sequence";

    /**顺序表记录(销售订单ID顺序)*/
    public static final String COLUMN_SALES_SUB_ORDER_ID_SEQUENCE = "sales_sub_order_id_sequence";

    /**顺序表记录(销售子订单ID顺序)*/
    public static final String COLUMN_SALES_ORDER_ID_SEQUENCE = "sales_order_id_sequence";

    /**顺序表记录(退货单ID顺序)*/
    public static final String COLUMN_RETURN_ORDER_ID = "return_order_id_sequence";

    /** 顺序表记录(供应商ID顺序) */
    public static final String COLUMN_PUR_SUPPLIER_ID = "supplier_id_sequence";

    /**顺序表记录(采购退货单ID顺序)*/
    public static final String COLUMN_PUR_RETURN_ORDER_ID = "pur_return_order_id_sequence";

    /**顺序表记录(退货单明细ID顺序)*/
    public static final String COLUMN_RETURN_ORDER_DETAIL_ID = "return_order_detail_id_sequence";

    /** 仓库ID顺序*/
    public static final String SEQUENCE_NAME_STOREHOUSE_ID_SEQUENCE = "storehouse_id_sequence";

    /** 入库单ID顺序*/
    public static final String SEQUENCE_NAME_IN_STORE_ORDER_ID_SEQUENCE = "in_store_order_id_sequence";

    /** 出库单ID顺序*/
    public static final String SEQUENCE_NAME_OUT_STORE_ORDER_ID_SEQUENCE = "out_store_order_id_sequence";

    /** 调拨单ID顺序*/
    public static final String SEQUENCE_NAME_ALLOCATE_ORDER_ID_SEQUENCE = "allocate_order_id_sequence";

    /** 盘点单ID顺序*/
    public static final String SEQUENCE_NAME_INVENTORY_CHECK_ID_SEQUENCE = "inventory_check_id_sequence";

    /** 货品ID顺序*/
    public static final String SEQUENCE_NAME_PRODUCT_ID_SEQUENCE = "product_id_sequence";

    /** 商品ID顺序*/
    public static final String SEQUENCE_NAME_GOODS_ID_SEQUENCE = "goods_id_sequence";

    /** 货品组ID顺序*/
    public static final String SEQUENCE_NAME_PRODUCT_GROUP_ID_SEQUENCE = "product_group_id_sequence";

    /** 发货单ID顺序*/
    public static final String DELIVERY_ORDER_ID_SEQUENCE = "delivery_order_id_sequence";

    /** 收货单ID顺序*/
    public static final String SEQUENCE_NAME_RECEIVING_ORDER_ID_SEQUENCE = "receiving_order_id_sequence";

    /** 客户账户ID顺序*/
    public static final String ACCOUNT_ID_SEQUENCE = "account_id_sequence";

    /** 退款单ID顺序 */
    public static final String REFUND_ORDER_ID_SEQUENCE = "pay_return_bill_sequence";

    /** 活动页ID顺序*/
    public static final String ASEQUENCE_NAME_ACTIVEPAGE_ID_SEQUENCE = "activepage_id_sequence";

    /** 采购需求单ID顺序 */
    public static final String COLUMN_PUR_REQUIRE_ORDER_ID_SEQUENCE = "pur_require_order_id_sequence";

    /** 顺序名称 定数 --------------结束-------------- */

    /** 上传文件路径--------------开始-------------- */

    /** 商品上传虚拟文件目录*/
    public static final String UPLOAD_FILE_VIRTUAL_PATH_GOODS = "goods/upload/";
    /** 商品详情上传虚拟文件目录*/
    public static final String UPLOAD_FILE_VIRTUAL_PATH_GOODS_DETAIL = "goods/upload/goodsDetail/";
    /** 商品备份虚拟文件目录*/
    public static final String BACKUP_FILE_VIRTUAL_PATH_GOODS = "goods/upload/backup/";

    /** 活动页编辑器内容上传虚拟文件目录*/
    public static final String UPLOAD_FILE_VIRTUAL_PATH_ACTIVEPAGE = "activepage/upload/";

    /** 活动页信息上传虚拟文件目录*/
    public static final String UPLOAD_FILE_VIRTUAL_PATH_ACTIVEPAGE_INFO = "activepage/";

    /** 上传文件路径--------------结束-------------- */

    /** 默认好评乐观锁 */
    public static final String DEFAULT_EVALUATIONS_LOCK = "default_evaluations_lock";
}
