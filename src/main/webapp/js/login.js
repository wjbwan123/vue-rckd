new Vue({
    el: '#app',
    data: {
        showLeft: false,
        user: {
            account: '',
            password: ''
        }
    },
    //引入模板
    components: {
        'app-header': components.header
    },
    methods: {
        login: function () {
            if (this.user.account === '' || this.user.password === '') {
                this.$toast('账号或密码不能为空');
            }
            var _this = this;
            var url = '/u/login';
            common.post(_this, url, _this.user, function (data) {
                if (data.code === 0) {
                    location.reload();
                } else {
                    _this.$toast(data.msg);
                }
            });
        }
    }
});