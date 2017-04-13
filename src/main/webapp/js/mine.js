new Vue({
    el: '#app',
    data: {
        showLeft: true,
        items: [
            {name: '个人信息', url: '/u/person.html'},
            {name: '聘方信息', url: '/u/company.html'}
        ]
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
        },
        //页面跳转
        jumpHandle: function (url) {
            location.href = url;
        }
    }
});