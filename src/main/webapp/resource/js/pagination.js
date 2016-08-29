/*!
 * DESCRIBE: 基于Page JSON对像的翻页控件
 * Copyright 2016-2016 .
 * AUTHOR 苏振江
 * VERSION 1.0 2016/05/25
 */

/**
 * 基于Page JSON对像的翻页控件
 * @type {{url: string, formdata: JSON, callback: Pagination.callback, fnShow: Pagination.fnShow, fnGotopage: Pagination.fnGotopage}}
 */
var Pagination = {

    // 翻页请求URL
    url:'',
    // 提交的表单JSON数据
    formdata:{},
    /**
     * 回调方法
     */
    callback: function () {
        
    },


    /**
     * 翻页控件显示
     * @param pagedata JSON对像
     * @param paginationObj 翻页控件
     * @param url 翻页请求URL
     * @param formdata 提交的表单JSON数据
     * @param callback 翻页处理成功的回调方法
     */
    fnShow: function (pagedata, paginationObj, url, formdata, callback) {
        paginationObj.empty();

        // 回调方法
        this.callback = callback;
        // 翻页请求URL
        this.url = url;
        // 提交的表单JSON数据
        this.formdata = formdata;

        // 总页数
        var totalPages = pagedata.totalPages;
        // 当前页数
        var pagenum = pagedata.number;
        // 表示页码索引件数
        var showPageCnt = 10;

        // 当前页码大于总页码的时候
        if (pagenum > totalPages) {
            pagenum = totalPages;
        }

        // 中间页码
        var midPage = showPageCnt / 2;
        // 余数
        var midMod = showPageCnt % 2;
        // 余数不是0的时候
        if (midMod != 0) {
            midPage++;
        }

        // 前置页码件数
        var beforePageCount = midPage - 1;

        // 后置页码件数
        var afterPageCount = showPageCnt - midPage;

        // 开始页码
        var beginPage = 1;

        // 结束页码
        var endPage = 1;

        // 当前页码小于等于中间页码的时候
        if (pagenum <= midPage) {

            // 总页码 < 表示页码索引件数的时候
            if (totalPages <= showPageCnt) {

                // 结束页码
                endPage = totalPages;
            } else {

                // 结束页码
                endPage = showPageCnt;
            }
        } else {

            // 后置实际页数
            var afterRealPage = totalPages - pagenum;

            // 后置实际页数 >= 后置页码件数
            if (afterRealPage >= afterPageCount) {

                // 开始页码
                beginPage = pagenum - beforePageCount;

                // 结束页码
                endPage = pagenum + afterPageCount;
            } else {

                // 结束页码
                endPage = totalPages;

                // 开始页码
                beginPage = pagenum - beforePageCount - (afterPageCount - afterRealPage);

                // 开始页码小于1的时候
                if (beginPage < 1) {
                    beginPage = 1;
                }
            }
        }

        var begin = beginPage;
        var end = endPage;

        var paginationBar = ''
            + '<nav>'
            + '<ul class="pagination">'
            + '<li>'
            + '<a href="javascript:void(0)" aria-label="首页" onclick="Pagination.fnGotopage(0)">'
            + '<span aria-hidden="true">&laquo;</span>'
            + '</a>'
            + '</li>'

        var pageNumItem = '';
        for (var i = begin; i <= end; i++) {
            if (i == (pagenum + 1)) {
                pageNumItem = pageNumItem
                    + '<li class="active">'
                    + '<a href="javascript:void(0)">'
                    +  i
                    + '<span class="sr-only">(current)</span></a>'
                    + '</li>';
            } else {
                pageNumItem = pageNumItem
                    + '<li>'
                    + '<a href="javascript:void(0)" onclick="Pagination.fnGotopage('+ (i-1) + ')">'
                    +  i
                    + '</a>'
                    + '</li>';
            }

        }

        paginationBar = paginationBar + pageNumItem
            + '<li>'
            + '<a href="javascript:void(0)" aria-label="末页" onclick="Pagination.fnGotopage('+ (totalPages - 1) + ')">'
            + '<span aria-hidden="true">&raquo;</span>'
            + '</a>'
            + '</li>'
            + '</ul>'
            + '</nav>';

        paginationObj.append(paginationBar);
    },

    /**
     * 翻页方法
     * @param obj 翻页按钮
     * @param num 页码
     * @param callback 翻页处理成功的回调方法
     */
    fnGotopage: function (num) {
        var url = this.url + "?pageNumber=" + num;
        fnAjax(url, this.formdata, this.callback);
    }
}