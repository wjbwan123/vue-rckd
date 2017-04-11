/*
 组件JS（存放组件）
 http://mint-ui.github.io/#!/zh-cn（mint ui）
 */
var components = {
    //头部模块
    header: {
        props: ['title', 'showLeft'],
        template: '<mt-header fixed :title="title">' +
        '<mt-button icon="back" slot="left" v-if="showLeft">返回</mt-button>' +
        '<mt-button icon="more" slot="right"></mt-button>' +
        '</mt-header>'
    },
    //底部的tabbar
    footer: {
        props: ['id'],
        template: '<mt-tabbar v-model="selected">' +
        '<mt-tab-item id="tab1">首页</mt-tab-item>' +
        '<mt-tab-item id="tab2">tab2</mt-tab-item>' +
        '<mt-tab-item id="tab3">tab3</mt-tab-item>' +
        '<mt-tab-item id="tab4">我的</mt-tab-item>' +
        '</mt-tabbar>',
        data: function () {
            return {
                selected: null
            }
        },
        watch: {
            selected: {
                handler: function (newVal, oldVal) {
                    if (oldVal !== null) {
                        this.returnUrl(newVal);
                    }
                },
                // 深度观察
                deep: true
            }
        },
        methods: {
            //根据不同的tabId跳转不同的页面
            returnUrl: function (tabId) {
                var url = '';
                switch (tabId) {
                    case 'tab1':
                        url = "/vue-rckd/index.html";
                        break;
                    case 'tab2':
                        alert("哈哈tab2");
                        break;
                    case 'tab3':
                        alert("哈哈tab3");
                        break;
                    case 'tab4':
                        url = "/vue-rckd/pages/self.html";
                        break;
                }
                location.href = url;
            }
        },
        created: function () {
            this.selected = this.id;
        }
    },
    //登陆模块
    login: {
        props: ['visible'],
        template: '<div style="z-index: 9999" v-show="visible">' +
        '<mt-field label="手机号码" placeholder="输入手机号码"></mt-field>' +
        '<mt-field label="账号密码" placeholder="输入密码" type="password"></mt-field>' +
        '</div>'
    }

}