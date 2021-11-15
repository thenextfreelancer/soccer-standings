Ext.define('Fiddle.view.UserForm', {
    extend : 'Ext.form.Panel',
    alias : 'widget.userform',
    requires:['Fiddle.model.Country','Fiddle.model.League','Fiddle.model.Team'],
    bodyPadding: 5,
    frame: true,
    width: 350,
    layout: 'anchor',
    defaults: {
        anchor: '100%'
    },
    countryId: null,
    leagueId: null,
    teamId: null,
    initComponent : function() {
        var me = this;
        
        var countryStore = Ext.create('Ext.data.Store',{
        	model:'Fiddle.model.League',
        	pageSize: 0,
        	autoLoad: true,
            proxy: {
                type: 'ajax',
                url: '/league',
                reader: {
                    type: 'json',
                    rootProperty: 'list'
                }
            }
        });
        
        var leagueStore = Ext.create('Ext.data.Store',{
        	model:'Fiddle.model.League',
        	pageSize: 0,
            proxy: {
                type: 'ajax',
                url: '/league',
                reader: {
                    type: 'json',
                    rootProperty: 'list'
                }
            }
        });
        
        var teamStore = Ext.create('Ext.data.Store',{
        	model:'Fiddle.model.Team',
        	pageSize: 0,
            proxy: {
                type: 'ajax',
                url: '/team',
                reader: {
                    type: 'json',
                    rootProperty: 'list'
                }
            }
        });
        
        Ext.apply(this,{
            items: [{
                xtype: 'combo',
                fieldLabel: 'Country ID & Name:',
                name: 'country',
                queryMode: 'local',
                displayField: 'displayCountry',
                valueField: 'countryId',
                store: countryStore,
                emptyText:'Select country',
                listeners:{
                    change: function(combo, value) {
                        if(value)
                    	{
                        	me.countryId = value;
                            me.down('#league').reset();
                            me.down('#team').reset();
                            me.down('#positionLabel').setValue('');
                        	leagueStore.load({
                                params: {
                                	country_id: value
                                }
                            });
                    	}
                    }
                }
            },{
                xtype: 'combo',
                fieldLabel: 'League ID & Name',
                name: 'league',
                itemId: 'league',
                queryMode: 'local',
                displayField: 'displayLeague',
                valueField: 'id',
                store: leagueStore,
                emptyText:'Select league',
                listeners:{
                    change: function(combo, value) {
                        if(value)
                    	{
                        	me.leagueId = value;
                            me.down('#team').reset();
                            me.down('#positionLabel').setValue('');
                        	teamStore.load({
                                params: {
                                	league_id: value
                                }
                            });
                    	}
                        
                    }
                }
            },{
                xtype: 'combo',
                fieldLabel: 'Team ID & Name',
                name: 'team',
                itemId: 'team',
                queryMode: 'local',
                displayField: 'display',
                valueField: 'id',
                store: teamStore,
                emptyText:'Select team',
                listeners:{
                    change: function(combo, value) {
                        if(value && me.leagueId)
                    	{
                            me.teamId = value;
                        	Ext.Ajax.request({
                                url : '/team/standings',
                                method : 'GET',
                                params: {
                                	league_id: me.leagueId,
                                	team_id: value
                                },
                                success : function(response, opts) {
                                	var resp = Ext.decode(response.responseText);
                                	me.down('#positionLabel').setValue(resp.list[0].leaguePosition);
                                },
                                failure : function(response, opts) {
                                  alert('error');
                                }
                            });
                    	}
                    }
                }
            },{
                xtype: 'textfield',
                fieldLabel: 'Overall league Position',
                itemId: 'positionLabel',
                readOnly: true
            }]
        });
        this.callParent(arguments);
    }
});