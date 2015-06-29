function onBackKeyWorstCell() {
	var form = Ext.getCmp('worstCellForm');
	form.hide();
};

function onBackKeySdcch() {
	var form = Ext.getCmp('sdcchForm');
	form.hide();
};

function onBackKeyTch() {
	var form = Ext.getCmp('tchForm');
	form.hide();
};

function onBackKeyCellHo() {
	var form = Ext.getCmp('cellHoForm');
	form.hide();
};

function onBackKeyPdch() {
	var form = Ext.getCmp('pdchForm');
	form.hide();
};

function onBackKeyCellWarn() {
	var form = Ext.getCmp('cellWarnForm');
	form.hide();
};

Ext.define('BaseSite', {
    extend: 'Ext.data.Model',

    config: {
        fields: [{
			name : 'omc',
			type : 'string'
		}, {
			name : 'msc',
			type : 'string'
		}, {
			name : 'bsc',
			type : 'string'
		}, {
			name : 'site',
			type : 'string'
		}, {
			name : 'lac',
			type : 'string'
		}, {
			name : 'ci',
			type : 'string'
		}, {
			name : 'baseSiteName',
			type : 'string'
		}, {
			name : 'type',
			type : 'string'
		}, {
			name : 'standardName',
			type : 'string'
		}, {
			name : 'vip',
			type : 'string'
		}, {
			name : 'areas',
			type : 'string'
		}, {
			name : 'aegis',
			type : 'string'
		}, {
			name : 'userName',
			type : 'string'
		}, {
			name : 'phone',
			type : 'string'
		}], 
		proxy: {
	        type: 'rest',
	        url : Ext.cts + 'ars/baseSite',
	        reader: {
	            type: 'json',
	            rootProperty: 'baseSite'
	        }
	    }
    }
});

var worstCellStore = Ext.create('Ext.data.Store', {
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
		type : 'string',
		convert: function(value, record) {
			var date = Ext.Date.parse(value, "Y-m-d H:i:s", true);
            return Ext.Date.format(date, "H:i");
        }
	}, {
		name : 'type',
		type : 'string'
	}],
	sorters: {
        property : 'time',
        direction: 'DESC'
    },
    proxy: {
    	type: 'rest',
	        reader: {
	            type: 'json',
	            rootProperty: 'data'
	        }
    }
});

var worstCellTpl = [
	'<div><span style="font-weight:bold;">时间粒度: {time}</span><br/>',
	'<div style="margin-top:5px;font-size:15px;color:#888888;">SDCCH拥塞率: {sdcch05}, SDCCH分配成功率: {sdcch06},',
	'话音信道掉话总次数: {sdcch13}, TCH拥塞率: {sdcch15}, TCH分配成功率: {sdcch16}, TCH掉话率: {sdcch18}<div></div>'
];

var ccchStore = Ext.create('Ext.data.Store', {
    fields: [{
		name : 'ccchid',
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
		name : 'bschb00',
		type : 'int'
	}, {
		name : 'bschb01',
		type : 'int'
	}, {
		name : 'bschb02',
		type : 'int'
	}, {
		name : 'bschb03',
		type : 'int'
	}, {
		name : 'time',
		type : 'string',
		convert: function(value, record) {
			var date = Ext.Date.parse(value, "Y-m-d H:i:s", true);
            return Ext.Date.format(date, "H:i");
        }
	}],
	sorters: {
        property : 'time',
        direction: 'DESC'
    },
    proxy: {
    	type: 'rest',
	        reader: {
	            type: 'json',
	            rootProperty: 'data'
	        }
    }
});

var ccchTpl = [
	'<div><span style="font-weight:bold;">时间粒度: {time}</span><br/>',
	'<div style="margin-top:5px;font-size:15px;color:#888888;">随机接入尝试次数: {bschb00}, 立即指配成功次数: {bschb01},',
	'立即指配拒绝次数: {bschb02}, PCH寻呼尝试次数: {bschb03}<div></div>'
];

var sdcchStore = Ext.create('Ext.data.Store', {
    fields: [{
		name : 'ccchid',
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
		name : 'bschc00',
		type : 'string'
	}, {
		name : 'bschc01',
		type : 'string'
	}, {
		name : 'bschc02',
		type : 'string'
	}, {
		name : 'bschc03',
		type : 'string'
	}, {
		name : 'bschc04',
		type : 'string'
	}, {
		name : 'bschc05',
		type : 'string'
	}, {
		name : 'bschc06',
		type : 'string'
	}, {
		name : 'bschc07',
		type : 'string'
	}, {
		name : 'bschc08',
		type : 'string'
	}, {
		name : 'time',
		type : 'string',
		convert: function(value, record) {
			var date = Ext.Date.parse(value, "Y-m-d H:i:s", true);
            return Ext.Date.format(date, "H:i");
        }
	}],
	sorters: {
        property : 'time',
        direction: 'DESC'
    },
    proxy: {
    	type: 'rest',
	        reader: {
	            type: 'json',
	            rootProperty: 'data'
	        }
    }
});

var sdcchTpl = [
 	'<div><span style="font-weight:bold;">时间粒度: {time}</span><br/>',
	'<div style="margin-top:5px;font-size:15px;color:#888888;">SDCCH话务量: {bschc02}, SDCCH试呼次数: {bschc03},',
	'SDCCH占用次数: {bschc04}, SDCCH掉话次数: {bschc06}<div></div>'
];

var tchStore = Ext.create('Ext.data.Store', {
    fields: [{
		name : 'tid',
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
		name : 'bsche00',
		type : 'string'
	}, {
		name : 'bsche01',
		type : 'string'
	}, {
		name : 'bsche02',
		type : 'string'
	}, {
		name : 'bsche03',
		type : 'string'
	}, {
		name : 'bsche04',
		type : 'string'
	}, {
		name : 'bsche05',
		type : 'string'
	}, {
		name : 'bsche06',
		type : 'string'
	}, {
		name : 'bsche07',
		type : 'string'
	}, {
		name : 'bsche08',
		type : 'string'
	}, {
		name : 'bsche09',
		type : 'string'
	}, {
		name : 'bsche10',
		type : 'string'
	}, {
		name : 'bsche11',
		type : 'string'
	}, {
		name : 'bsche12',
		type : 'string'
	}, {
		name : 'bsche13',
		type : 'string'
	}, {
		name : 'bsche14',
		type : 'string'
	}, {
		name : 'bsche15',
		type : 'string'
	}, {
		name : 'bsche16',
		type : 'string'
	}, {
		name : 'bsche17',
		type : 'string'
	}, {
		name : 'time',
		type : 'string',
		convert: function(value, record) {
			var date = Ext.Date.parse(value, "Y-m-d H:i:s", true);
            return Ext.Date.format(date, "H:i");
        }
	}],
	sorters: {
        property : 'time',
        direction: 'DESC'
    },
    proxy: {
    	type: 'rest',
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});

var tchTpl = [
	'<div><span style="font-weight:bold;">时间粒度: {time}</span><br/>',
	'<div style="margin-top:5px;font-size:15px;color:#888888;">话音信道总话务量: {bsche00}, 半速率话音信道话务量: {bsche01},',
	'话音信道掉话次数: {bsche02}, 半速率话音信道话务量: {bsche03}<div></div>'
];

// 小区切换
var cellHoStore = Ext.create('Ext.data.Store', {
    fields: [{
		name : 'vid',
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
		name : 'bschf00',
		type : 'string'
	}, {
		name : 'bschf01',
		type : 'string'
	}, {
		name : 'bschf02',
		type : 'string'
	}, {
		name : 'bschf03',
		type : 'string'
	}, {
		name : 'bschf04',
		type : 'string'
	}, {
		name : 'bschf05',
		type : 'string'
	}, {
		name : 'bschf06',
		type : 'string'
	}, {
		name : 'bschf07',
		type : 'string'
	}, {
		name : 'time',
		type : 'string',
		convert: function(value, record) {
			var date = Ext.Date.parse(value, "Y-m-d H:i:s", true);
            return Ext.Date.format(date, "H:i");
        }
	}],
	sorters: {
        property : 'time',
        direction: 'DESC'
    },
    proxy: {
    	type: 'rest',
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});

var cellHoTpl = [
	'<div><span style="font-weight:bold;">时间粒度: {time}</span><br/>',
	'<div style="margin-top:5px;font-size:15px;color:#888888;">小区切出试呼次数: {bschf04}, 小区切出成功次数: {bschf05},',
	'小区切入试呼次数: {bschf06}, 小区切入成功次数: {bschf07}<div></div>'
];

// 干扰频带
var bandStore = Ext.create('Ext.data.Store', {
    fields: [{
		name : 'vid',
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
		name : 'bschi00',
		type : 'string'
	}, {
		name : 'bschi01',
		type : 'string'
	}, {
		name : 'bschi02',
		type : 'string'
	}, {
		name : 'bschi03',
		type : 'string'
	}, {
		name : 'bschi04',
		type : 'string'
	}, {
		name : 'time',
		type : 'string',
		convert: function(value, record) {
			var date = Ext.Date.parse(value, "Y-m-d H:i:s", true);
            return Ext.Date.format(date, "H:i");
        }
	}],
	sorters: {
        property : 'time',
        direction: 'DESC'
    },
    proxy: {
    	type: 'rest',
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});

var bandTpl = [
   	'<div><span style="font-weight:bold;">时间粒度: {time}</span><br/>',
	'<div style="margin-top:5px;font-size:15px;color:#888888;">干扰频带1: {bschi00}, 干扰频带2: {bschi01},',
	'干扰频带3: {bschi02}, 干扰频带4: {bschi03}, 干扰频带5: {bschi04}<div></div>'
];

var pdchStore = Ext.create('Ext.data.Store', {
    fields: [{
		name : 'vid',
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
		name : 'bschk00',
		type : 'string'
	}, {
		name : 'bschk01',
		type : 'string'
	}, {
		name : 'bschk02',
		type : 'string'
	}, {
		name : 'bschk03',
		type : 'string'
	}, {
		name : 'bschk04',
		type : 'string'
	}, {
		name : 'bschk05',
		type : 'string'
	}, {
		name : 'bschk07',
		type : 'string'
	}, {
		name : 'time',
		type : 'string',
		convert: function(value, record) {
			var date = Ext.Date.parse(value, "Y-m-d H:i:s", true);
            return Ext.Date.format(date, "H:i");
        }
	}],
	sorters: {
        property : 'time',
        direction: 'DESC'
    },
    proxy: {
    	type: 'rest',
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});

var pdchTpl = [
  	'<div><span style="font-weight:bold;">时间粒度: {time}</span><br/>',
	'<div style="margin-top:5px;font-size:15px;color:#888888;">PDCH平均可用数: {bschk00}, 占用的PDCH的平均数目: {bschk01},',
	'PDCH分配失败次数: {bschk04}, TCH争夺PDCH次数: {bschk05}, EGPRS-PDCH占用的数量: {bschk07}<div></div>'
];

var cellWarnStore = Ext.create('Ext.data.Store', {
    fields: [{
		name : 'bid',
		type : 'string'
	}, {
		name : 'ne',
		type : 'string'
	}, {
		name : 'level',
		type : 'string'
	}, {
		name : 'programmewarning',
		type : 'string'
	}, {
		name : 'warningtype',
		type : 'string'
	}, {
		name : 'neobject',
		type : 'string'
	}, {
		name : 'warningtitle',
		type : 'string'
	}, {
		name : 'warningtime',
		type : 'string'
	}, {
		name : 'mark',
		type : 'string'
	}, {
		name : 'affirmtime',
		type : 'string'
	}, {
		name : 'affirminfo',
		type : 'string'
	}, {
		name : 'listmark',
		type : 'string'
	}, {
		name : 'cellid',
		type : 'string'
	}, {
		name : 'city',
		type : 'string'
	}, {
		name : 'area',
		type : 'string'
	}, {
		name : 'swaphandle',
		type : 'string'
	}, {
		name : 'listNo',
		type : 'string'
	}, {
		name : 'warningobjecttype',
		type : 'string'
	}, {
		name : 'type',
		type : 'string'
	}],
	sorters: {
        property : 'warningtime',
        direction: 'DESC'
    },
    proxy: {
    	type: 'rest',
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});

var cellWarnTpl = [
  	'<div><span style="font-weight:bold;">告警时间: {warningtime}</span><br/>',
	'<div style="margin-top:5px;font-size:15px;color:#888888;">告警标题: {warningtitle}, 告警类型: {warningtype},',
	'告警级别: {level}, 网元对象: {neobject}<div></div>'
];

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
    	Ext.Date.monthNames = [
            '一月', '二月', '三月', '四月', '五月', '六月', 
            '七月', '八月', '九月', '十月', '十一月', '十二月'
        ];
    	
    	Ext.searchDate = '2012-11-26';//Ext.Date.format(new Date(), 'Y-m-d');
    	
        // Get all the items for our form.
        var items = this.getFormItems(), form,
        	worstCellItems = this.getWorstCellFormItems(), worstCellForm,
        	sdcchItems = this.getSdcchFormItems(), sdcchForm,
        	tchItems = this.getTchFormItems(), tchForm,
        	cellHoItems = this.getCellHoFormItems(), cellHoForm,
        	pdchItems = this.getPdchFormItems(), pdchForm,
        	cellWarnItems = this.getCellWarnFormItems(), cellWarnForm,
        	worstCellList, ccchList, sdcchList, tchList, cellHoList, bandList, cellWarnList,
            config, tabPanel;

        form = Ext.create('Ext.form.Panel', {
    		title: '小区信息',
            items: items	
        });
        
        worstCellForm = this.getDetailForm({
        	id: 'worstCellForm',
        	items: worstCellItems,
        	onBackKey: onBackKeyWorstCell
        });
        
        sdcchForm = this.getDetailForm({
        	id: 'sdcchForm',
        	items: sdcchItems,
        	onBackKey: onBackKeySdcch
        });
        
        tchForm = this.getDetailForm({
        	id: 'tchForm',
        	items: tchItems,
        	onBackKey: onBackKeyTch
        });
        
        cellHoForm = this.getDetailForm({
        	id: 'cellHoForm',
        	items: cellHoItems,
        	onBackKey: onBackKeyCellHo
        });
        
        pdchForm = this.getDetailForm({
        	id: 'pdchForm',
        	items: pdchItems,
        	onBackKey: onBackKeyPdch
        });
        
        cellWarnForm = this.getDetailForm({
        	id: 'cellWarnForm',
        	items: cellWarnItems,
        	onBackKey: onBackKeyCellWarn
        });
        
        worstCellList = this.getList({
        	title: '最差小区',
        	tpl: worstCellTpl,
        	store: worstCellStore,
        	url: Ext.cts + 'ars/nature/worstCell/' + Ext.param.id,
        	itemtap: function(list, index, item, record, event, options) {
        		if (!this.worstCellForm) {
		    		this.worstCellForm = Ext.Viewport.add(worstCellForm);
		    	}
        		this.worstCellForm.setRecord(record);
		    	this.worstCellForm.show();
		    	Ext.getCmp('worstCellFormFieldSet').setInstructions(record.data['cellname']);
        	}
        });
        
        ccchList = this.getList({
        	title: 'CCCH指标',
        	tpl: ccchTpl,
        	store: ccchStore,
        	url: Ext.cts + 'ars/nature/ccch/' + Ext.param.id
        });
        
        sdcchList = this.getList({
        	title: 'SDCCH指标',
        	tpl: sdcchTpl,
        	store: sdcchStore,
        	url: Ext.cts + 'ars/nature/sdcch/' + Ext.param.id,
        	itemtap: function(list, index, item, record, event, options) {
        		if (!this.sdcchForm) {
		    		this.sdcchForm = Ext.Viewport.add(sdcchForm);
		    	}
        		this.sdcchForm.setRecord(record);
		    	this.sdcchForm.show();
		    	Ext.getCmp('sdcchFormFieldSet').setInstructions(record.data['cellname']);
        	}
        });
        
        tchList = this.getList({
        	title: 'TCH指标',
        	tpl: tchTpl,
        	store: tchStore,
        	url: Ext.cts + 'ars/nature/tch/' + Ext.param.id,
        	itemtap: function(list, index, item, record, event, options) {
        		if (!this.tchForm) {
		    		this.tchForm = Ext.Viewport.add(tchForm);
		    	}
        		this.tchForm.setRecord(record);
		    	this.tchForm.show();
		    	Ext.getCmp('tchFormFieldSet').setInstructions(record.data['cellname']);
        	}
        });
        
        cellHoList = this.getList({
        	title: '小区切换指标',
        	tpl: cellHoTpl,
        	store: cellHoStore,
        	url: Ext.cts + 'ars/nature/cellHo/' + Ext.param.id,
        	itemtap: function(list, index, item, record, event, options) {
        		if (!this.cellHoForm) {
		    		this.cellHoForm = Ext.Viewport.add(cellHoForm);
		    	}
        		this.cellHoForm.setRecord(record);
		    	this.cellHoForm.show();
		    	Ext.getCmp('cellHoFormFieldSet').setInstructions(record.data['cellname']);
        	}
        });
        
        pdchList = this.getList({
        	title: 'PDCH指标',
        	tpl: pdchTpl,
        	store: pdchStore,
        	url: Ext.cts + 'ars/nature/pdch/' + Ext.param.id,
        	itemtap: function(list, index, item, record, event, options) {
        		if (!this.pdchForm) {
		    		this.pdchForm = Ext.Viewport.add(pdchForm);
		    	}
        		this.pdchForm.setRecord(record);
		    	this.pdchForm.show();
		    	Ext.getCmp('pdchFormFieldSet').setInstructions(record.data['cellname']);
        	}
        });
        
        bandList = this.getList({
        	title: '干扰频带',
        	tpl: bandTpl,
        	store: bandStore,
        	url: Ext.cts + 'ars/nature/frequencyBand/' + Ext.param.id
        });
        
        cellWarnList = this.getList({
        	title: '小区告警',
        	tpl: cellWarnTpl,
        	store: cellWarnStore,
        	url: Ext.cts + 'ars/nature/cellWarn/' + Ext.param.id,
        	itemtap: function(list, index, item, record, event, options) {
        		if (!this.cellWarnForm) {
		    		this.cellWarnForm = Ext.Viewport.add(cellWarnForm);
		    	}
        		this.cellWarnForm.setRecord(record);
		    	this.cellWarnForm.show();
        	}
        });
        
        // Create the configuration of our form.
        // We give it the `formpanel` xtype and give it the items we got above.
        config = {
            xtype: 'tabpanel',
            tabBar: {
            	docked: 'top',
            	scrollable: {
            	    direction: 'horizontal',
            	    directionLock: true
            	}
            },
        	ui: 'light',
        	defaults: {
        		scrollable: true
        	},
        	items: [
        		form, worstCellList, cellWarnList,
        		ccchList, sdcchList, tchList,
        		cellHoList, bandList, pdchList 
        	]
        };

        // If we are on a phone, we just want to add the form into the viewport as is.
        // This will make it stretch to the size of the Viewport.
        if (Ext.os.deviceType == 'Phone') {
        	tabPanel = Ext.Viewport.add(config);
        } else {
            // Add it to the Viewport and show it.
            tabPanel = Ext.Viewport.add(config);
            tabPanel.show();
        }
        
        BaseSite.load(Ext.param.id, {
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
        return [{
            xtype: 'fieldset',
            instructions: '基站的基本维护信息',
            defaults: {
                labelAlign: 'left',
                labelWidth: '40%',
                inputCls: 'form-input'
            },
            items: [{
                xtype: 'textfield',
                name: 'omc',
                label: 'OMC:',
                readOnly: true,
                autoCapitalize: false
            }, {
                xtype: 'textfield',
                name: 'msc',
                label: 'MSC:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bsc',
                label: 'BSC:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'site',
                label: 'SITE:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'lac',
                label: 'LAC:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'ci',
                label: 'CI:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'baseSiteName',
                label: '基站名称:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'type',
                label: '基站类型:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'standardName',
                label: '公司名称:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'vip',
                label: 'VIP:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'areas',
                label: '所属地区:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'aegis',
                label: '监理公司:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'userName',
                label: '联系人:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'phone',
                label: '联系方式:',
                readOnly: true
            }]
        }];
    },
    
    getWorstCellFormItems: function() {
    	return [{
            docked: 'top',
            xtype: 'toolbar',
            title: '最差小区',
            items:[{ xtype: 'spacer' }, {
                text: '取消',
                scope: this,
                handler: function() {
                	Ext.getCmp('worstCellForm').hide();
                }
            }]
        }, {
        	id: 'worstCellFormFieldSet',
            xtype: 'fieldset',
            instructions: '',
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
        }];
    },
    
    getSdcchFormItems: function() {
    	return [{
            docked: 'top',
            xtype: 'toolbar',
            title: 'SDCCH详细指标',
            items:[{ xtype: 'spacer' }, {
                text: '取消',
                scope: this,
                handler: function() {
                	Ext.getCmp('sdcchForm').hide();
                }
            }]
        }, {
        	id: 'sdcchFormFieldSet',
            xtype: 'fieldset',
            instructions: '',
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
                name: 'bschc00',
                label: '静态SDCCH可用数:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschc01',
                label: '动态SDCCH可用数:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschc02',
                label: 'SDCCH话务量:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschc03',
                label: 'SDCCH试呼次数:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschc04',
                label: 'SDCCH占用次数:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschc05',
                label: 'SDCCH分配失败次数:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bschc06',
                label: 'SDCCH掉话次数:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bschc07',
                label: 'SDCCH溢出次数:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bschc08',
                label: 'sdcch定义信道数:',
                readOnly: true
            }]
        }];
    },
    
    getTchFormItems: function() {
    	return [{
            docked: 'top',
            xtype: 'toolbar',
            title: 'TCH详细指标',
            items:[{ xtype: 'spacer' }, {
                text: '取消',
                scope: this,
                handler: function() {
                	Ext.getCmp('tchForm').hide();
                }
            }]
        }, {
        	id: 'tchFormFieldSet',
            xtype: 'fieldset',
            instructions: '',
            defaults: {
                labelAlign: 'left',
                labelWidth: '75%',
                inputCls: 'form-input'
            },
            items: [{
                xtype: 'textfield',
                name: 'time',
                label: '统计时间:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bsche00',
                label: '话音信道总话务量:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bsche01',
                label: '半速率话音信道话务量:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bsche02',
                label: '话音信道掉话次数:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bsche03',
                label: '全速率话音信道可用数:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bsche04',
                label: '半速率话音信道可用数:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bsche05',
                label: '最大话音信道占用数量:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bsche06',
                label: '话音信道切换试呼次数:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bsche07',
                label: '话音信道切换占用次数:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bsche08',
                label: '话音信道试呼次数（不含切换）:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bsche09',
                label: '话音信道溢出次数（不含切换）:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bsche10',
                label: '话音信道分配失败次数(不含切换):',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bsche11',
                label: '话音信道占用次数(不含切换):',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bsche12',
                label: '话音信道试呼次数(含切换):',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bsche13',
                label: '话音信道溢出次数(含切换):',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bsche14',
                label: '话音信道分配失败次数(含切换):',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bsche15',
                label: '话音信道占用次数(含切换):',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bsche16',
                label: 'TCH定义信道数:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bsche17',
                label: 'TCH可用信道数:',
                readOnly: true
            }]
        }];
    },
    
    getCellHoFormItems: function() {
    	return [{
            docked: 'top',
            xtype: 'toolbar',
            title: '小区切换详细指标',
            items:[{ xtype: 'spacer' }, {
                text: '取消',
                scope: this,
                handler: function() {
                	Ext.getCmp('cellHoForm').hide();
                }
            }]
        }, {
        	id: 'cellHoFormFieldSet',
            xtype: 'fieldset',
            instructions: '',
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
                name: 'bschf00',
                label: '双频切换试呼总次数:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschf01',
                label: '双频切换成功总次数:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschf02',
                label: '切换请求总次数:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschf03',
                label: '切换成功总次数:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschf04',
                label: '小区切出试呼次数:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschf05',
                label: '小区切出成功次数:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bschf06',
                label: '小区切入试呼次数:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bschf07',
                label: '小区切入成功次数:',
                readOnly: true
            }]
        }];
    },

    getPdchFormItems: function() {
    	return [{
            docked: 'top',
            xtype: 'toolbar',
            title: 'PDCH详细指标',
            items:[{ xtype: 'spacer' }, {
                text: '取消',
                scope: this,
                handler: function() {
                	Ext.getCmp('pdchForm').hide();
                }
            }]
        }, {
        	id: 'pdchFormFieldSet',
            xtype: 'fieldset',
            instructions: '',
            defaults: {
                labelAlign: 'left',
                labelWidth: '70%',
                inputCls: 'form-input'
            },
            items: [{
                xtype: 'textfield',
                name: 'time',
                label: '统计时间:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschk00',
                label: 'PDCH平均可用数:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschk01',
                label: '占用的PDCH的平均数目:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschk02',
                label: '占用的PDCH的最大数目:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschk03',
                label: 'PDCH分配请求次数:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschk04',
                label: 'PDCH分配失败次数:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'bschk05',
                label: 'TCH争夺PDCH次数:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'bschk07',
                label: 'EGPRS-PDCH占用的数量:',
                readOnly: true
            }]
        }];
    },
    
    getCellWarnFormItems: function() {
    	return [{
            docked: 'top',
            xtype: 'toolbar',
            title: '小区告警详情',
            items:[{ xtype: 'spacer' }, {
                text: '取消',
                scope: this,
                handler: function() {
                	Ext.getCmp('cellWarnForm').hide();
                }
            }]
        }, {
        	id: 'cellWarnFormFieldSet',
            xtype: 'fieldset',
            instructions: '',
            defaults: {
                labelAlign: 'left',
                labelWidth: '70%',
                inputCls: 'form-input'
            },
            items: [{
                xtype: 'textfield',
                name: 'warningtime',
                label: '告警时间:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'ne',
                label: '网元:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'level',
                label: '告警级别:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'programmewarning',
                label: '工程告警:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'warningtype',
                label: '告警类型:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'neobject',
                label: '网元对象:',
                readOnly: true
            }, {
                xtype: 'textfield',
                name: 'warningtitle',
                label: '告警标题:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'affirmtime',
                label: '确认时间:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'affirminfo',
                label: '确认信息:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'listmark',
                label: '派单标志:',
                readOnly: true
            }, {
            	xtype: 'textfield',
                name: 'warningobjecttype',
                label: '告警对象类型:',
                readOnly: true
            }]
        }];
    },
    
    getList: function(config) {
    	var loadData = function() {
			config.store.getProxy().setUrl(config.url + '/' + Ext.searchDate + ' 00:00:00/' + Ext.searchDate + ' 23:00:00');
			config.store.load();
    	};
    	
    	var list = Ext.create('Ext.List', {
            title: config.title,
            emptyText: '<div class="x-list-item"><div class="x-list-item-label" style="text-align:center">找不到相关数据</div></div>',
            itemTpl: config.tpl,
            store: config.store,
            items: [{
        		xtype: 'fieldset',
        		style: 'margin-bottom: 0px;',
        		items: [{
        			xtype: 'datepickerfield',
                    name : 'searchDate',
                    label: '查询日期',
                    value: new Date(),
                    dateFormat: 'Y-m-d',
                    picker: {
                    	 doneButton: '确定',
                         cancelButton: '取消',
                         slotOrder: ['year', 'month', 'day']
                    },
                    listeners: {
                    	initialize: function(datePicker) {
                    		datePicker.setValue(Ext.Date.parse(Ext.searchDate, datePicker.getDateFormat()));
                    	},
                    	change: function(datePicker, date) {
                    		var date  = Ext.util.Format.date(datePicker.getValue(), datePicker.getDateFormat());
                    		if(date != Ext.searchDate) {
                    			config.lastSearchDate = Ext.searchDate = date;
                    			loadData();
                    		}
                    	}
                    }
        		}]
        	}], 
        	listeners: {
             	show: function(list) {
             		if(config.lastSearchDate != Ext.searchDate) {
             			config.lastSearchDate = Ext.searchDate;
             			var datePicker = list.query('datepickerfield[name=searchDate]')[0];
             			datePicker.setValue(Ext.Date.parse(Ext.searchDate, 'Y-m-d'));
             			loadData();
             		}
             	}
        	}
        });
    	
    	if(config.itemtap) {
    		list.addListener('itemtap', config.itemtap, list);
    	}
    	
        return list;
    },
    
    getDetailForm: function(config) {
    	return Ext.create('Ext.form.Panel', {
    		id: config.id,
        	modal: true,
            hideOnMaskTap: true,
            width: '100%',
            height: '100%',
            centered: true,
            items: config.items,
            scrollable: true,
            listeners: {
            	show: function(panel) {
            		document.removeEventListener("backbutton", onBackKeyDown, false);
            		document.addEventListener("backbutton", config.onBackKey, false);
            	},
            	hide: function(panel) {
            		document.removeEventListener("backbutton", config.onBackKey, false);
            		document.addEventListener("backbutton", onBackKeyDown, false);
            	}
            }
        });
    }
    
});

