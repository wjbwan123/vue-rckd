new Vue({
    el: '#app',
    data: {
        showLeft: false
    },
    //引入模板
    components: {
        'app-header': components.header,
        'app-footer': components.footer
    },
    methods: {
    }
});