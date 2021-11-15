Ext.application({
    name : 'Fiddle',
    namespaces: ['Fiddle'],
    views:['Fiddle.view.Viewport'],
    autoCreateViewport: true,
    launch : function() {
        Ext.Msg.alert('Fiddle', 'Welcome to Sencha Fiddle!');
        this.callParent()
    }
});