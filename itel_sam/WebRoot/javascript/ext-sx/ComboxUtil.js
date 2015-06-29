Ext.ns('Ext.ux.form');

// 基站搜索Combox
Ext.ux.form.StationComboBox = function(config) {
	Ext.apply(this, config);
	
	Ext.ux.form.StationComboBox.superclass.constructor.call(this, config);
};

Ext.extend(Ext.ux.form.StationComboBox, Ext.form.ComboBox, {
	url: 'user/grid',
	emptyText:'请输入处理员名称...',
	displayField:'personName',
	valueField:'personName',
	typeAhead: false,
	minChars: 1,
	anchor: '90%',
	pageSize:10,
	hideTrigger:true,
    tpl: new Ext.XTemplate(
    	'<tpl for="."><div class="search-item">',
        '<h3>{personName} ({groupName} {departmentName}})</h3>',
        '</div></tpl>'
    ),
	itemSelector: 'div.search-item',
	queryFields: ['personName'],
	mappingFields: ['personId', 'personName','departmentName','groupName'],
	
	initComponent:function() {
		// 调用父类的构造函数（必须）
		Ext.ux.form.StationComboBox.superclass.initComponent.apply(this, arguments);
		
		this.store = new Ext.data.JsonStore({
			root:'results',
			totalProperty: 'totalCount',
			fields:this.mappingFields,
			baseParams: {fields: Ext.encode(this.queryFields)},
			proxy:new Ext.data.HttpProxy({
				url: this.url,
				method: 'GET',
				defaultHeaders : {
					'Accept' : 'application/json'
				}
			})
		});
	}
	
});
		
Ext.reg('stationcombobox', Ext.ux.form.StationComboBox);

// 合同搜索Combox
Ext.ux.form.ContractComboBox = function(config) {
	Ext.apply(this, config);
	
	Ext.ux.form.ContractComboBox.superclass.constructor.call(this, config);
};

Ext.extend(Ext.ux.form.ContractComboBox, Ext.form.ComboBox, {
	emptyText:'请输入合同编号/归档号/合同名称/物业单位/物业地址...',
	displayField:'contractName',
	valueField:'contractName',
	typeAhead: false,
	minChars: 2,
	anchor: '90%',
	pageSize:10,
	hideTrigger:true,
    tpl: new Ext.XTemplate(
    	'<tpl for="."><div class="search-item">',
	    	'<h3>{contractNo}&emsp;{contractPigeonholeNo}<br/>{contractName}</h3>',
	        '{propertyName}{supplyElectricity}&emsp;{propertyAddress}',
        '</div></tpl>'
    ),
	itemSelector: 'div.search-item',
	queryFields: ['contractNo', 'contractPigeonholeNo', 'contractName', 'propertyName', 'propertyAddress'],
	mappingFields: [
	    'machineRoomId', 'machineRoomName',
		'contractId', 'contractNo', 'contractPigeonholeNo',
		'contractName', 'contractStartDate',
		'propertyName', 'propertyAddress',
		'bankName', 'ownerAccountName',
		'ownerAccountNo', 'sectionId', 'sectionCode',
		'startTenancyDate', 'endTenancyDate',
		'tenancyCost', 'payDate', 'pay'
	],
	
	initComponent:function() {
		// 调用父类的构造函数（必须）
		Ext.ux.form.ContractComboBox.superclass.initComponent.apply(this, arguments);
		
		this.store = new Ext.data.JsonStore({
			root:'results',
			totalProperty: 'totalCount',
			fields:this.mappingFields,
			baseParams: {fields: Ext.encode(this.queryFields)},
			proxy:new Ext.data.HttpProxy({
				url:this.url,
				method: 'GET'			
			})
		});
	}
	
});
		
Ext.reg('contractcombobox', Ext.ux.form.ContractComboBox);


Ext.ux.form.BaseTypeComboBox = function(config) {
	Ext.apply(this, config);
	
	Ext.ux.form.BaseTypeComboBox.superclass.constructor.call(this, config);
};

Ext.extend(Ext.ux.form.BaseTypeComboBox, Ext.form.ComboBox, {
	typeCode: '',
	emptyText:'请选择...',
	displayField:'baseTypeName',
	valueField:'baseTypeName',
	triggerAction:'all',
	typeAhead: true,
	editable:false,
	lazyRender:true,
	forceSelection:true,
	allowBlank : false,
	width:140,
	
	initComponent : function() {
		// 调用父类的构造函数（必须）
		Ext.ux.form.BaseTypeComboBox.superclass.initComponent.apply(this, arguments);
		
		this.store = new Ext.data.JsonStore({
			root:'results',
			fields:['baseTypeId', 'baseTypeName'],
			proxy:new Ext.data.HttpProxy({
				url:'baseType.json?baseTypeCode=' + this.typeCode,
				method: 'GET'
			})
		});
	}
	
});
		
Ext.reg('basetypecombobox', Ext.ux.form.BaseTypeComboBox);


Ext.ux.form.SectionComboBox = function(config) {
	Ext.apply(this, config);
	
	Ext.ux.form.SectionComboBox.superclass.constructor.call(this, config);
};

Ext.extend(Ext.ux.form.SectionComboBox, Ext.form.ComboBox, {
	emptyText:'请选择...',
 	displayField:'sectionCode',
 	valueField:'sectionCode',
 	triggerAction:'all',
 	typeAhead: true,
 	editable:false,
 	lazyRender:true,
 	allowBlank: false,
 	forceSelection:true,
 	width:140,
 	itemSelector: 'div.search-item',
 	tpl: new Ext.XTemplate(
    	'<tpl for="."><div class="search-item">',
	    	'<h3>{sectionCode}({userName})</h3>',
        '</div></tpl>'
    ),
	
	initComponent : function() {
		// 调用父类的构造函数（必须）
		Ext.ux.form.SectionComboBox.superclass.initComponent.apply(this, arguments);
		
		this.store = new Ext.data.JsonStore({
			root:'results',
	 		fields:['sectionId', 'sectionCode', 'userName'],
	 		proxy:new Ext.data.HttpProxy({
				url:'section.json?combox=all',
				method: 'GET'
	 		})
		});
	}
	
});
		
Ext.reg('sectioncombobox', Ext.ux.form.SectionComboBox);


Ext.ux.form.AmmeterComboBox = function(config) {
	Ext.apply(this, config);
	
	Ext.ux.form.AmmeterComboBox.superclass.constructor.call(this, config);
};

Ext.extend(Ext.ux.form.AmmeterComboBox, Ext.form.ComboBox, {
	url: 'ammeterElectric.json?combox=all',
	emptyText:'请输入机房名称/电表编号...',
	displayField:'ammeterNo',
	valueField:'ammeterNo',
	typeAhead: false,
	minChars: 2,
	anchor: '90%',
	pageSize:10,
	hideTrigger:true,
    tpl: new Ext.XTemplate(
    	'<tpl for="."><div class="search-item">',
        '<h3>{machineRoomName} {ammeterNo}</h3>{machineRoomAddress}',
        '</div></tpl>'
    ),
	itemSelector: 'div.search-item',
	queryFields: ['machineRoomName', 'ammeterNo'],
	mappingFields: ['ammeterId', 'ammeterNo', 'machineRoomId', 'machineRoomName', 'machineRoomAddress'],
	
	initComponent:function() {
		// 调用父类的构造函数（必须）
		Ext.ux.form.AmmeterComboBox.superclass.initComponent.apply(this, arguments);
		
		this.store = new Ext.data.JsonStore({
			root:'results',
			totalProperty: 'totalCount',
			fields:this.mappingFields,
			baseParams: {fields: Ext.encode(this.queryFields)},
			proxy:new Ext.data.HttpProxy({
				url: this.url,
				method: 'GET'					
			})
		});
	}
	
});
		
Ext.reg('ammetercombobox', Ext.ux.form.AmmeterComboBox);


Ext.ux.form.RegionComboBox = function(config) {
	Ext.apply(this, config);
	
	Ext.ux.form.RegionComboBox.superclass.constructor.call(this, config);
};

Ext.extend(Ext.ux.form.RegionComboBox, Ext.form.ComboBox, {
	typeCode: '',
	emptyText:'请选择...',
	displayField:'regionName',
	valueField:'regionName',
	triggerAction:'all',
	typeAhead: true,
	editable:false,
	lazyRender:true,
	forceSelection:true,
	allowBlank : false,
	width:140,
	
	initComponent : function() {
		// 调用父类的构造函数（必须）
		Ext.ux.form.RegionComboBox.superclass.initComponent.apply(this, arguments);
		
		this.store = new Ext.data.JsonStore({
			root:'results',
			fields:['regionId', 'regionName'],
			proxy:new Ext.data.HttpProxy({
				url:'region.json?combox=all',
				method: 'GET'
			})
		});
	}
	
});
		
Ext.reg('regioncombobox', Ext.ux.form.RegionComboBox);