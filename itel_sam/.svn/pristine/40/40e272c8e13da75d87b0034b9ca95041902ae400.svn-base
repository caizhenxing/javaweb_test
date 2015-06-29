Ext.define('Wlan', {
    extend: 'Ext.data.Model',

    config: {
        fields: [{
    		name : 'wid',
    		type : 'string'
    	}, {
    		name : 'city',
    		type : 'string'
    	}, {
    		name : 'cellid',
    		type : 'string'
    	}, {
    		name : 'cellname',
    		type : 'string'
    	}, {
    		name : 'bsc',
    		type : 'string'
    	}, {
    		name : 'vender',
    		type : 'string'
    	}, {
    		name : 'sdcch00',
    		type : 'string'
    	}, {
    		name : 'sdcch01',
    		type : 'string'
    	}, {
    		name : 'sdcch02',
    		type : 'string'
    	}, {
    		name : 'sdcch03',
    		type : 'string'
    	}, {
    		name : 'sdcch04',
    		type : 'string'
    	}, {
    		name : 'sdcch05',
    		type : 'string'
    	}, {
    		name : 'sdcch06',
    		type : 'string'
    	}, {
    		name : 'sdcch07',
    		type : 'string'
    	}, {
    		name : 'sdcch08',
    		type : 'string'
    	}, {
    		name : 'sdcch09',
    		type : 'string'
    	}, {
    		name : 'sdcch10',
    		type : 'string'
    	}, {
    		name : 'sdcch11',
    		type : 'string'
    	}, {
    		name : 'sdcch12',
    		type : 'string'
    	}, {
    		name : 'sdcch13',
    		type : 'string'
    	}, {
    		name : 'sdcch14',
    		type : 'string'
    	}, {
    		name : 'sdcch15',
    		type : 'string'
    	}, {
    		name : 'sdcch16',
    		type : 'string'
    	}, {
    		name : 'sdcch17',
    		type : 'string'
    	}, {
    		name : 'sdcch18',
    		type : 'string'
    	}, {
    		name : 'sdcch19',
    		type : 'string'
    	}, {
    		name : 'time',
    		type : 'string'
    	}, {
    		name : 'type',
    		type : 'string'
    	}], 
		proxy: {
	        type: 'rest',
	        method: 'GET',
	        url : Ext.cts + 'ars/nature/worstCellInfo',
	        reader: {
	            type: 'json',
	            rootProperty: 'data'
	        }
	    }
    }
});

Ext.Ajax.setDefaultHeaders({
    'Accept': 'application/json'
});

// Define our simple application
Ext.application({
	
    glossOnIcon: false,

    /**
     * The launch method of our application gets called when the application is good to launch.
     * In here, we are going to build the structure of our application and add it into the Viewport.
     */
    launch: function() {
        // Get all the items for our form.
        var items = this.getFormItems(), form, tabPanel;

        form = Ext.create('Ext.form.Panel', {
            items: items	
        });

        // If we are on a phone, we just want to add the form into the viewport as is.
        // This will make it stretch to the size of the Viewport.
        if (Ext.os.deviceType == 'Phone') {
        	tabPanel = Ext.Viewport.add(form);
        } else {
            // Add it to the Viewport and show it.
            tabPanel = Ext.Viewport.add(form);
            tabPanel.show();
        }
        
        Wlan.load(Ext.param.id, {
         	scope: this,
         	success: function (record, operation) {
         		form.setRecord(record);
         	}
        });
        
        this.form = form;
    },
    
    /**
     * This method returns an array of all items we should add into the form panel we create above in our launch function.
     * We have created this function to simply make things cleaner and easier to read and understand. You could just put these items
     * inline up above in the form `config`.
     * @return {Array} items
     */
    getFormItems: function() {
        return [
            {
                xtype : 'toolbar',
                docked: 'top',
                title: '最差小区'
            }, {
                xtype: 'fieldset',
                instructions: '最差小区信息',
                defaults: {
                    labelAlign: 'left',
                    labelWidth: '60%',
                    inputCls: 'form-input'
                },
                items: [{
                    xtype: 'textfield',
                    name: 'time',
                    label: '统计时间:',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'type',
                    label: '最差小区分类:',
                    readOnly: true
                }, {
                    xtype: 'textfield',
                    name: 'sdcch00',
                    label: 'SDCCH可用总数:',
                    readOnly: true
                }, {
                    xtype: 'textfield',
                    name: 'sdcch01',
                    label: 'SDCCH试呼总次数:',
                    readOnly: true
                }, {
                    xtype: 'textfield',
                    name: 'sdcch02',
                    label: 'SDCCH占用次数:',
                    readOnly: true
                }, {
                    xtype: 'textfield',
                    name: 'sdcch03',
                    label: 'SDCCH溢出总次数:',
                    readOnly: true
                }, {
                    xtype: 'textfield',
                    name: 'sdcch04',
                    label: 'SDCCH总话务量:',
                    readOnly: true
                }, {
                    xtype: 'textfield',
                    name: 'sdcch05',
                    label: 'SDCCH拥塞率:',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'sdcch06',
                    label: 'SDCCH分配成功率:',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'sdcch07',
                    label: 'SDCCH每信道话务量:',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'sdcch08',
                    label: '话音信道可用总数:',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'sdcch09',
                    label: '话音信道试呼总次数(不含切换):',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'sdcch10',
                    label: '话音信道占用总次数(不含切换):',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'sdcch11',
                    label: '话音信道占用次数(含切换):',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'sdcch12',
                    label: '话音信道溢出总次数(不含切换):',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'sdcch13',
                    label: '话音信道掉话总次数:',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'sdcch14',
                    label: '话音信道总话务量:',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'sdcch15',
                    label: 'TCH拥塞率:',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'sdcch16',
                    label: 'TCH分配成功率:',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'sdcch17',
                    label: 'TCH每信道话务量:',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'sdcch18',
                    label: 'TCH掉话率:',
                    readOnly: true
                }, {
                	xtype: 'textfield',
                    name: 'sdcch19',
                    label: '无线接入性:',
                    readOnly: true
                }]
            }
        ];
    }
});

