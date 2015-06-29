// 判断Tabpanel中id为panelId的面板是否已经存在
var judge = function(tabPanel, panelId) {
	var panel = null;
	Ext.each(tabPanel.items.items, function(item, i) {
		if (item.id == panelId) {
			panel = item;
			return panel;
		}
	});
	return panel;
};

Ext.onReady(function() {
			var northTitle = new Ext.BoxComponent({
				region : 'north',
				height : 64,
				autoEl : {
					id : 'header',
					tag : 'div',
					html : '艾泰尔智能生活馆'
				}
			});
			Ext.TaskMgr.start({
				run : function() {
					// writeTime();
				},
				interval : 1000
			});
			var southTitle = new Ext.Panel(
					{
						region : 'south',
						title : '<table><tr align="left"><td align="right"><font height: 55px; padding: 10px 0 0 55px;>&nbsp欢迎您,&nbsp'
								+ "&nbsp[&nbsp<font color='#0000FF'>"
								+ "</font>,&nbsp<a href='./logout' style='text-decoration:none'>注销</a>&nbsp]</font></td><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><td id='currentTime'><td></tr></table>",
						height : 10
					});
			var tab = new Ext.TabPanel({
				id : 'content-panel',
				activeItem : 0,
				border : true,
				region : 'center',
				resizeTabs : true,
				enableTabScroll : true,
				margins : '2 5 5 0',
				plugins : new Ext.ux.TabCloseMenu(),
				items : []
			});
			var root = new Ext.tree.TreeNode({
				text : "导航菜单",
				expanded : true,
				border : false,
				frame : true
			});

			var firstMenu = [ {
				moduleId : 'M1',
				moduleName : '系统管理',
			}, {
				moduleId : 'M1-0',
				moduleName : '消息管理'
			}, {
				moduleId : 'M1-1',
				moduleName : '版本发布'
			}, {
				moduleId : 'M1-2',
				moduleName : 'Android帮助中心'
			},{
				moduleId : 'M1-3',
				moduleName : 'IOS帮助中心'
			},{
				moduleId : 'M1-4',
				moduleName : '设备管理'
			}  ,{
				moduleId : 'M2',
				moduleName : '配置中心',
			},{
				moduleId : 'M2-0',
				moduleName : '配置中心M2-0'
			}, {
				moduleId : 'M2-1',
				moduleName : '配置中心M2-1'
			}, {
				moduleId : 'M2-2',
				moduleName : '配置中心M2-2'
			} ];

			Ext.each(firstMenu, function(item, i) {
				if (item.moduleId.length <= 2) {
					temp = new Ext.tree.TreeNode({
						id : item.moduleId,
						text : item.moduleName,
						expanded : true
					});
					root.appendChild(temp);
				} else {
					c = new Ext.tree.TreeNode({
						id : item.moduleId,
						text : item.moduleName,
						listeners : {
							'click' : function(node, event) {
								event.stopEvent();
								var panel = judge(tab, node.id);
								if (panel != null) {
									panel.show();
								} else {
									n = tab.add({
										id : node.id,
										layout : 'border',
										title : node.text,
										split : true,
										closable : true,
										items : NewPanel(node.id)
									});
									tab.setActiveTab(n);
								}
							}
						}
					});
					temp.appendChild(c);
				}
			});

			var tree = new Ext.tree.TreePanel({
				root : root,
				region : 'center',
				border : false,
				width : 210,
				autoScroll : true,
				animate : true,
				containerScroll : true,
				tbar : [ {
					text : '全部展开',
					handler : function() {
						tree.expandAll();
					}
				}, '-', {
					text : '全部关闭',
					handler : function() {
						tree.collapseAll();
					}
				} ]
			});
			var accordion = new Ext.Panel({
				region : 'west',
				title : '导航菜单',
				margins : '1 0 1 1',
				split : true,
				width : 210,
				normal : false,
				collapsible : true,
				items : tree
			});

			var centerPanel = new Ext.Panel({
				region : 'center',
				title : 'centerPanel',
				margins : '1 0 1 1',
				split : true,
				normal : false,
				html : 'CenterPanel',
				collapsible : true
			});
			new Ext.Viewport({
				layout : 'border',
				items : [ northTitle, accordion, tab, southTitle ]
			});

		});