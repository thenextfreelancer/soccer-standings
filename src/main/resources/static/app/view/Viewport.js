Ext.define('Fiddle.view.Viewport', {
    extend: 'Ext.container.Viewport',
    requires : ['Fiddle.view.UserForm'],
    layout : {
        align : 'stretch',
        type : 'vbox'
    },
    initComponent : function() {
        Ext.apply(this, {
            items : [{
                extend : 'Ext.container.Container',
                border : false,
                flex : 1,
                items : [
                    {
                        xtype: 'userform',
                        width: 500
                    }
                ]
               
            }]
        });
        this.callParent(arguments);
    }
});