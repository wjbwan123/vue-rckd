/**
 * 公用的js
 * Created by hanyi on 2017/4/4 0004.
 */
var common = {
    /**
     * 获得项目根路径
     * @returns {string}
     */
    getRootPath: function () {
        //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
        var curWwwPath = window.document.location.href;
        //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
        var pathName = window.document.location.pathname;
        var pos = curWwwPath.indexOf(pathName);
        //获取主机地址，如： http://localhost:8083
        var localhostPath = curWwwPath.substring(0, pos);
        //获取带"/"的项目名，如：/uimcardprj
        var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
        if (projectName != null && projectName != '') {
            return (localhostPath + projectName);
        }
        return localhostPath;
    },

    /**
     * 重写post请求
     * @param parame 参数
     * @param callback 回调函数
     */
    post: function (_this, url, parame, callback) {
        _this.$http.post(url, parame, {
            emulateJSON: true
        }).then(function (res) {
            callback(res.body);
        });
    },

    /**
     * 重写get请求
     * @param callback 回调函数
     */
    get: function (_this, url, callback) {
        _this.$http.get(url).then(function (res) {
            callback(res.body);
        });
    },

    /**
     * 根据父Id获得地区集合
     * @param parentId 父id
     * @param callback 回调函数
     */
    getAreaListByParentId: function (_this, parentId, callback) {
        var url = "/dictionary/area/list/" + parentId;
        _this.$http.get(url).then(function (res) {
            callback(res.body.areaList);
        });
    }
};


