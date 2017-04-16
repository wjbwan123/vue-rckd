/*
 组件JS（存放组件）
 http://mint-ui.github.io/#!/zh-cn（mint ui）
 */
var components = {
    //头部模块
    header: {
        props: ['title', 'showLeft'],
        template: '<div style="margin-bottom: 20%;"><mt-header fixed :title="title">' +
        '<mt-button icon="back" slot="left" v-if="showLeft" @click.native="goBack">返回</mt-button>' +
        '</mt-header></div>',
        methods: {
            goBack: function () {
                location.href = history.go(-1);
            }
        }
    },
    //底部的tabbar
    footer: {
        props: ['id'],
        template: '<mt-tabbar v-model="selected">' +
        '<mt-tab-item id="tab1"><img slot="icon" src="../assets/100x100.png">首页</mt-tab-item>' +
        '<mt-tab-item id="tab2"><img slot="icon" src="../assets/100x100.png">消息</mt-tab-item>' +
        '<mt-tab-item id="tab3"><img slot="icon" src="../assets/100x100.png">我的</mt-tab-item>' +
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
                        url = "/";
                        break;
                    case 'tab2':
                        url = "/u/message.html";
                        break;
                    case 'tab3':
                        url = "/u/mine.html";
                        break;
                }
                location.href = url;
            }
        },
        created: function () {
            this.selected = this.id;
        }
    },
    //底部的tabbar1
    footer1: {
        props: ['index'],
        template: '<footer class="page-footer fixed-footer"><ul>' +
        '<li v-for="item in tabItems" :class="item.className">' +
        '<a :href="item.url"><img :src="item.imgSrc"/><p>{{item.name}}</p></a>' +
        '</li></ul></footer>',
        data: function () {
            return {
                tabItems: [
                    {
                        url: '/', name: '首页', className: '',
                        imgSrc: common.getRootPath() + '/images/footer001.png',
                    },
                    {
                        url: '/index.html', name: '分类', className: '',
                        imgSrc: common.getRootPath() + '/images/footer002.png'
                    },
                    {
                        url: '/index.html', name: '购物车', className: '',
                        imgSrc: common.getRootPath() + '/images/footer003.png'
                    },
                    {
                        url: '/u/mine.html', name: '个人中心', className: '',
                        imgSrc: common.getRootPath() + '/images/footer004.png'
                    }
                ]
            }
        },
        created: function () {
            var item = this.tabItems[this.index];
            var src = item.imgSrc;
            src = src.replace(/footer00/, 'footer0');
            item.imgSrc = src;
            item.className = 'active';
        }
    },
    //登陆模块
    login: {
        props: ['visible'],
        template: '<div style="z-index: 9999">' +
        '<mt-field label="手机号码" placeholder="输入手机号码"></mt-field>' +
        '<mt-field label="账号密码" placeholder="输入密码" type="password"></mt-field>' +
        '</div>'
    }

}