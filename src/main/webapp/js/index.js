new Vue({
    el: '#app',
    data: {
        showLeft: false,
        tree: [],
        visible: false,
        provinceList: [],
        cityList: [],
        townList: [],
        slots: [
            {
                flex: 1,
                values: [],
                className: 'slot1',
                textAlign: 'center'
            }, {
                divider: true,
                content: '-',
                className: 'slot2'
            }, {
                flex: 1,
                values: [],
                className: 'slot1',
                textAlign: 'center'
            }, {
                divider: true,
                content: '-',
                className: 'slot2'
            }, {
                flex: 1,
                values: [],
                className: 'slot1',
                textAlign: 'left'
            }
        ]
    },
    //引入模板
    components: {
        'app-header': components.header,
        'app-footer': components.footer,
        'app-footer1': components.footer1
    },
    methods: {
        getTreeList: function () {
            var _this = this;
            common.get(_this, '/region/getTreeList', function (data) {
                if (data.code === 0) {
                    //_this.slots[0].values = provinceList;
                } else {
                    _this.$toast(data.msg);
                }
            });
        },
        onValuesChange: function (picker, values) {
            picker.setSlotValue(1, values[0].fullName);
        }
    },
    created: function () {
        this.getTreeList();
    }
});