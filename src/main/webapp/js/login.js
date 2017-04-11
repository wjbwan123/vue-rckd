new Vue({
    el: '#app',
    data: {
        showLeft: false,
        user: {
            account: '1',
            password: '1'
        }
    },
    //引入模板
    components: {
        'app-header': components.header
    },
    methods: {}
});