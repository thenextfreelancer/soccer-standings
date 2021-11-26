Ext.define('Fiddle.view.Viewport', {
    extend: 'Ext.container.Viewport',
    requires : ['Fiddle.view.UserForm','Fiddle.view.Toggle'],
    layout : {
        align : 'stretch',
        type : 'vbox'
    },
    offlineMode: 0,
    initComponent : function() {
    	var me = this;
    	me.offlineMode = 0;
        Ext.apply(this, {
            items : [{
                extend : 'Ext.container.Container',
                border : false,
                flex : 1,
                items : [
                	{
                	    xtype: 'togglebutton',
                	    fieldLabel: 'Offline mode',
                        value: 0,
                        labelWidth: 130,
                        listeners: {
                            changecomplete: function (slider, newValue, thumb, eOpts) {
                            	var msg = 'Offline mode disabled.';
                            	if(newValue)
                        		{
                            		msg = 'Offline mode enabled.';
                        		}
                            	me.offlineMode = newValue;
                                Ext.Msg.alert('Info', msg);
                            }
                        }
                	},
                    {
                        xtype: 'userform',
                        width: 500,
                        offlineMode: me.offlineMode
                    }
                ]
               
            }]
        });
        this.callParent(arguments);
    }
});