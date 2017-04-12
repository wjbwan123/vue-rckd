new Vue({
    el: '#app',
    data: {
        showLeft: true
    },
    //引入模板
    components: {
        'app-header': components.header,
        'app-footer': components.footer
    },
    methods: {
        logout: function () {
            var _this = this;
            common.post(_this, '/u/logout', {}, function (data) {
                if (data.code === 0) {
                    location.href = '/';
                } else {
                    _this.$toast(data.msg);
                }
            })
        }
    }
});