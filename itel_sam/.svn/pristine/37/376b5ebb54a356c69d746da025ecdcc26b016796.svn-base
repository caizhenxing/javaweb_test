function UpgradePanel(o) {
	var iOSonSubmit = function() {
		Ext.Ajax.request({
			url : Ext.ctx + '/samUpgradeController/pubVersion/pubVersionByIOS',
			method : 'POST',
			defaultHeaders : {
				'Accept' : 'application/json'
			},
			success : Ext.ux.AjaxUtil.successHandler.createSequence(
					function(r) {
						versionstore.reload();
						iOSfp.hide();
					}, this),
			failure : Ext.ux.AjaxUtil.failureHandler,
			params : function() {
				var params = {};
				iOSfp.items.each(function(item, i) {
					if(item.name=='required'){
						params[item.name] = item.getValue().inputValue;
					}else{
						params[item.name] = item.getValue();
					}
						}, this);
				return params;
			}.createDelegate(this)()
		});
	};
	
	var deleteSubmit = function() {
		Ext.Ajax.request({
			url : Ext.ctx + '/samNoticController/deleteNotics',
			method : 'POST',
			defaultHeaders : {
				'Accept' : 'application/json'
			},
			success : Ext.ux.AjaxUtil.successHandler.createSequence(
					function(r) {
						noticstore.reload();
						window.hide();
					}, this),
			failure : Ext.ux.AjaxUtil.failureHandler,
			params : function() {
				var params = {};
				var ids = Ext.getCmp('noticGridId').getSelectionModel().getSelections();
					alert(ids);
				return params;
			}.createDelegate(this)()
		});
	};
	var Record = Ext.data.Record.create( [ {
		name : 'upgradeId',
		type : 'string'
	}, {
		name : 'name',
		type : 'string'
	}, {
		name : 'url',
		type : 'string'
	}, {
		name : 'platform',
		type : 'string'
	}, {
		name : 'decription',
		type : 'string'
	}, {
		name : 'required',
		type : 'string'
	}, {
		name : 'pubtime',
		type : 'string'
	}, {
		name : 'version',
		type : 'string'
	} ]);

	var connection = new Ext.data.Connection( {
		url : Ext.ctx + '/samUpgradeController/getVersionAll',
		method : 'GET',
		defaultHeaders : {
			'Accept' : 'application/json'
		},
		timeout : 10000
	});
	connection.on('requestexception', Ext.ux.AjaxUtil.failureHandler, this);

	var versionstore = new Ext.data.JsonStore( {
		root : 'results',
		totalProperty : 'totalCount',
// remoteSort : true,
		fields : Record,
		sortInfo : { field : 'pubtime', direction : 'DESC' },
						 
		proxy : new Ext.data.HttpProxy(connection)
	});
	versionstore.load();

	var fp = new Ext.FormPanel(
			{
				id:'uploadForm',
				fileUpload : true,
				monitorValid : true,
				headerCfg:{
					'Accept' : 'application/json'
				},
				width : 600,
				frame : true,
				labelWidth : 90,
				defaults : {
					xtype:'textfield',
					anchor : '95%',
					msgTarget : 'side',
					
				},
				items : [ {
					fieldLabel : 'Name',
					name:'name',
					allowBlank : false 

				}, /*
					 * { xtype: 'radiogroup', name:'platform', fieldLabel:
					 * 'PlatForm', items: [ {boxLabel: 'Android', name:
					 * 'platform', inputValue:'Android'}, {boxLabel: 'IOS',
					 * name: 'platform', inputValue:'IOS'} ], listeners:{
					 * 'change':function(e,checked){ var platForm =
					 * checked.inputValue; if(platForm=='Android'){
					 * Ext.getCmp('androidapk').setDisabled(false);
					 * Ext.getCmp('iosUrlInput').setDisabled(true);
					 * Ext.getCmp('iosUrlInput').setValue(''); }else{
					 * Ext.getCmp('androidapk').setDisabled(true);
					 * Ext.getCmp('iosUrlInput').setDisabled(false); } } } },
					 */ {
					hidden:true,
					name:'platform',
					value:'Android'
				},{
		            xtype: 'radiogroup',
		            name:'required',
		            fieldLabel: 'Required',
		            items: [
		                {boxLabel: 'NO', name: 'required', inputValue:'N',checked:true},
		                {boxLabel: 'YES', name: 'required', inputValue:'Y'}
		            ]
		        },{
					xtype : 'fileuploadfield',
					id:'androidapk',
					allowBlank : false ,
					emptyText : '请选择apk文件',
					fieldLabel : 'APK(Android)',
					name : 'file',
					buttonText : '浏览'/*
										 * , buttonCfg: { iconCls: 'upload-icon' }
										 */
				},/*
					 * { fieldLabel : 'IOS URL', name:'iosurl', id:'iosUrlInput' },
					 */{
					fieldLabel : 'Version',
					name:'version',
					allowBlank : false ,
				} ,{
					xtype:'textarea',
					name:'decription',
					fieldLabel : 'Decription'
				}  ],

				buttons : [
						{
							text : '保存',
							formBind : true,
							handler : function() {
							/*
							 * var platForm =
							 * fp.getForm().findField('platform').getValue();
							 * if(platForm=='Android'){ var fileName =
							 * fp.getForm().findField('file') .getValue(); var
							 * objtype = fileName.substring(
							 * fileName.lastIndexOf(".")) .toLowerCase(); if
							 * (objtype != ".apk") { Ext.Msg.alert('错误',
							 * "您导入的文件格式不对，请导入正确的apk文件!"); return; } }
							 */
							var fileName = fp.getForm().findField('file')
							.getValue();
							var objtype = fileName.substring(
									fileName.lastIndexOf("."))
									.toLowerCase();
							if (objtype != ".apk") {
								Ext.Msg.alert('错误',
										"您导入的文件格式不对，请导入正确的apk文件!");
								return;
							}
								if (fp.getForm().isValid()) {
								
									fp.getForm().submit(
											{
												headers : {
													'Accept' : 'application/json'
												},
												url : '/itel/samUpgradeController/pubVersion',
												waitMsg : '正在上传...',
												success : function(fp,o) {
													versionstore.reload();
													window.hide();
												},
												failure : function(fp,o) {
													versionstore.reload();
													window.hide();
												}
											});
								};
						}}, {
							text : '重置',
							handler : function() {
								fp.getForm().reset();
							}
						} ]
			});

	var window = new Ext.Window({
		title : 'Android版本发布',
		closeAction:'hide',
		items:[fp]
		
	});
	
	
	
	var iOSfp = new Ext.FormPanel({
				width : 600,
				frame : true,
				labelWidth : 90,
				monitorValid : true,
				defaults : {
					xtype:'textfield',
					anchor : '95%',
					msgTarget : 'side',
					
				},
				items : [ {
					fieldLabel : 'Name',
					name:'name',
					allowBlank : false 
				}, {
					hidden:true,
					name:'platform',
					value:'IOS'
				},{
		            xtype: 'radiogroup',
		            name:'required',
		            allowBlank : false,
		            fieldLabel: 'Required',
		            items: [
		                {boxLabel: 'NO', name: 'required', inputValue:'N',checked:true},
		                {boxLabel: 'YES', name: 'required', inputValue:'Y'}
		            ]
		        }, {
					fieldLabel : 'IOS URL',
					name:'iosurl',
					id:'iosUrlInput',
					allowBlank : false 
				},{
					fieldLabel : 'Version',
					name:'version'
				} ,{
					xtype:'textarea',
					name:'decription',
					allowBlank : false, 
					fieldLabel : 'Decription'
				}  ],

				buttons : [
						{
							text : '保存',
							formBind : true,
							handler : function() { 
								iOSonSubmit();
						}}, {
							text : '重置',
							handler : function() {
								iOSfp.getForm().reset();
							}
						} ]
			});

	var ioswindow = new Ext.Window({
		title : 'IOS版本发布',
		closeAction:'hide',
		items:[iOSfp]
		
	});
	 
	var editor = new Ext.ux.grid.RowEditor({
        saveText: 'Update'
        
    });
	
	editor.on({ 
	// scope: editor.saveText,
	 afteredit: function(roweditor,changes,record, rowIndex){
	 Ext.Ajax.request({ 
	     url   : Ext.ctx + '/samUpgradeController/updateSamUpgrade',
	     method: 'POST',
	     defaultHeaders : {
				'Accept' : 'application/json'
		 },
	     params: {
		 	upgradeId:record.get('upgradeId'),
		 	url:record.get('url'),
		 	decription:record.get('decription'),
		 	required:record.get('required'),
		 	version:record.get('version')},
	     success: function() { 
		 		versionstore.reload();
	     },failure: function() { 
 
	     } 
	 })}});
	
	var sm = new Ext.grid.CheckboxSelectionModel();// 设置多选
	var grid = new Ext.grid.GridPanel( {
		id:'noticGridId',
		store : versionstore,
		plugins: [editor],
		tbar : [ new Ext.Button( {
			text : 'Android版本发布',
			listeners : {
				'click' : function() {
					window.show();
				}
			}
		}), '-', new Ext.Button( {
			text : 'IOS版本发布',
			listeners:{
				'click':function(){
					ioswindow.show();
				}
			}
		}) ],
// sm:sm,
		columns : [new Ext.grid.RowNumberer(),
		           /* sm, */{
			id : 'title',
			header : '版本名称',
			width : 160,
			sortable : true,
			dataIndex : 'name'
		}, {
			header : '下载地址',
			width : 75,
			sortable : true,
			dataIndex : 'url',
			editor: {
                xtype: 'textfield',
                allowBlank: false
            }
		}, {
			header : '设备平台',
			width : 75,
			sortable : true,
			dataIndex : 'platform'
		}, {
			header : '描述',
			width : 75,
			sortable : true,
			dataIndex : 'decription',
			editor: {
                xtype: 'textfield',
                allowBlank: false
            }
		}, {
			header : '是否硬发布',
			width : 75,
			sortable : true,
			dataIndex : 'required',
			editor: {
                xtype: 'textfield',
                allowBlank: false
            }
		}, {
			header : '发布时间',
			width : 85,
			sortable : true,
			dataIndex : 'pubtime'
		}, {
			header : '版本号',
			width : 85,
			sortable : true,
			dataIndex : 'version',
			editor: {
                xtype: 'textfield',
                allowBlank: false
            }
		} ],
		viewConfig : {
			forceFit : true
		},
		stripeRows : true,
		autoExpandColumn : 'company',
		height : 650,
		stateful : true,
		stateId : 'grid'
	});
	
	
	
	

	return grid;

}
