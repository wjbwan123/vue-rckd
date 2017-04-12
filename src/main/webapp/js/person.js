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
        //页面跳转
        jumpUrlHandle: function () {
            
        }
    }
});