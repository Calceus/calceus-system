$(function(){$.widget("primeui.puidatatable",{options:{columns:null,datasource:null,paginator:null,selectionMode:null,rowSelect:null,rowUnselect:null,caption:null,sortField:null,sortOrder:null,keepSelectionInLazyMode:false,scrollable:false,scrollHeight:null,scrollWidth:null,responsive:false},_create:function(){this.id=this.element.attr("id");
if(!this.id){this.id=this.element.uniqueId().attr("id")
}this.element.addClass("pui-datatable ui-widget");
if(this.options.responsive){this.element.addClass("pui-datatable-reflow")
}if(this.options.scrollable){this._createScrollableDatatable()
}else{this._createRegularDatatable()
}if(this.options.datasource){if($.isArray(this.options.datasource)){this._onDataInit(this.options.datasource)
}else{if($.type(this.options.datasource)==="function"){if(this.options.lazy){this.options.datasource.call(this,this._onDataInit,{first:0,sortField:this.options.sortField,sortOrder:this.options.sortOrder})
}else{this.options.datasource.call(this,this._onDataInit)
}}}}},_createRegularDatatable:function(){this.tableWrapper=$('<div class="pui-datatable-tablewrapper" />').appendTo(this.element);
this.table=$("<table><thead></thead><tbody></tbody></table>").appendTo(this.tableWrapper);
this.thead=this.table.children("thead");
this.tbody=this.table.children("tbody").addClass("pui-datatable-data")
},_createScrollableDatatable:function(){this.element.append('<div class="ui-widget-header pui-datatable-scrollable-header"><div class="pui-datatable-scrollable-header-box"><table><thead></thead></table></div></div>').append('<div class="pui-datatable-scrollable-body"><table><tbody></tbody></table></div></div>');
this.thead=this.element.find("> .pui-datatable-scrollable-header > .pui-datatable-scrollable-header-box > table > thead");
this.tbody=this.element.find("> .pui-datatable-scrollable-body > table > tbody")
},_initialize:function(){var b=this;
if(this.options.columns){var a=$("<tr></tr>").appendTo(b.thead);
$.each(this.options.columns,function(d,c){var e=$('<th class="ui-state-default"><span class="pui-column-title"></span></th>').data("field",c.field).uniqueId().appendTo(a);
if(c.headerClass){e.addClass(c.headerClass)
}if(c.headerStyle){e.attr("style",c.headerStyle)
}if(c.headerText){e.children(".pui-column-title").text(c.headerText)
}else{if(c.headerContent){e.children(".pui-column-title").append(c.headerContent.call(this,c))
}}if(c.sortable){e.addClass("pui-sortable-column").data("order",0).append('<span class="pui-sortable-column-icon fa fa-fw fa-sort"></span>')
}})
}if(this.options.caption){this.element.prepend('<div class="pui-datatable-caption ui-widget-header">'+this.options.caption+"</div>")
}if(this.options.paginator){this.options.paginator.paginate=function(c,d){b.paginate()
};
this.options.paginator.totalRecords=this.options.lazy?this.options.paginator.totalRecords:this.data.length;
this.paginator=$("<div></div>").insertAfter(this.tableWrapper).puipaginator(this.options.paginator)
}if(this._isSortingEnabled()){this._initSorting()
}if(this.options.selectionMode){this._initSelection()
}if(this.options.sortField&&this.options.sortOrder){this._indicateInitialSortColumn();
this.sort(this.options.sortField,this.options.sortOrder)
}else{this._renderData()
}if(this.options.scrollable){this._initScrolling()
}},_indicateInitialSortColumn:function(){this.sortableColumns=this.thead.find("> tr > th.pui-sortable-column");
var a=this;
$.each(this.sortableColumns,function(b,c){var e=$(c),d=e.data();
if(a.options.sortField===d.field){var f=e.children(".pui-sortable-column-icon");
e.data("order",a.options.sortOrder).removeClass("ui-state-hover").addClass("ui-state-active");
if(a.options.sortOrder===-1){f.removeClass("fa-sort fa-sort-asc").addClass("fa-sort-desc")
}else{if(a.options.sortOrder===1){f.removeClass("fa-sort fa-sort-desc").addClass("fa-sort-asc")
}}}})
},_onDataInit:function(a){this.data=a;
if(!this.data){this.data=[]
}this._initialize()
},_onDataUpdate:function(a){this.data=a;
if(!this.data){this.data=[]
}this.reset();
this._renderData()
},_onLazyLoad:function(a){this.data=a;
if(!this.data){this.data=[]
}this._renderData()
},reset:function(){if(this.options.selectionMode){this.selection=[]
}if(this.paginator){this.paginator.puipaginator("setState",{page:0,totalRecords:this.data.length})
}this.thead.children("th.pui-sortable-column").data("order",0).filter(".ui-state-active").removeClass("ui-state-active").children("span.pui-sortable-column-icon").removeClass("fa-sort-asc fa-sort-desc").addClass("fa-sort")
},_initSorting:function(){var b=this,a=this.thead.find("> tr > th.pui-sortable-column");
a.on("mouseover.puidatatable",function(){var c=$(this);
if(!c.hasClass("ui-state-active")){c.addClass("ui-state-hover")
}}).on("mouseout.puidatatable",function(){var c=$(this);
if(!c.hasClass("ui-state-active")){c.removeClass("ui-state-hover")
}}).on("click.puidatatable",function(){var f=$(this),d=f.data("field"),c=f.data("order"),e=(c===0)?1:(c*-1),g=f.children(".pui-sortable-column-icon");
f.siblings().filter(".ui-state-active").data("order",0).removeClass("ui-state-active").children("span.pui-sortable-column-icon").removeClass("fa-sort-asc fa-sort-desc").addClass("fa-sort");
b.options.sortField=d;
b.options.sortOrder=e;
b.sort(d,e);
f.data("order",e).removeClass("ui-state-hover").addClass("ui-state-active");
if(e===-1){g.removeClass("fa-sort fa-sort-asc").addClass("fa-sort-desc")
}else{if(e===1){g.removeClass("fa-sort fa-sort-desc").addClass("fa-sort-asc")
}}})
},paginate:function(){if(this.options.lazy){if(this.options.selectionMode&&!this.options.keepSelectionInLazyMode){this.selection=[]
}this.options.datasource.call(this,this._onLazyLoad,this._createStateMeta())
}else{this._renderData()
}},sort:function(b,a){if(this.options.selectionMode){this.selection=[]
}if(this.options.lazy){this.options.datasource.call(this,this._onLazyLoad,this._createStateMeta())
}else{this.data.sort(function(d,g){var f=d[b],e=g[b],c=(f<e)?-1:(f>e)?1:0;
return(a*c)
});
if(this.options.selectionMode){this.selection=[]
}if(this.paginator){this.paginator.puipaginator("option","page",0)
}this._renderData()
}},sortByField:function(d,c){var f=d.name.toLowerCase();
var e=c.name.toLowerCase();
return((f<e)?-1:((f>e)?1:0))
},_renderData:function(){if(this.data){this.tbody.html("");
var l=this._getFirst(),e=this.options.lazy?0:l,n=this._getRows();
for(var d=e;
d<(e+n);
d++){var b=this.data[d];
if(b){var m=$('<tr class="ui-widget-content" />').appendTo(this.tbody),g=(d%2===0)?"pui-datatable-even":"pui-datatable-odd",h=d;
m.addClass(g);
if(this.options.lazy){h+=l
}if(this.options.selectionMode&&PUI.inArray(this.selection,h)){m.addClass("ui-state-highlight")
}for(var c=0;
c<this.options.columns.length;
c++){var a=$("<td />").appendTo(m),k=this.options.columns[c];
if(k.bodyClass){a.addClass(k.bodyClass)
}if(k.bodyStyle){a.attr("style",k.bodyStyle)
}if(k.content){var f=k.content.call(this,b);
if($.type(f)==="string"){a.html(f)
}else{a.append(f)
}}else{a.text(b[k.field])
}if(this.options.responsive&&k.headerText){a.prepend('<span class="pui-column-title">'+k.headerText+"</span>")
}}}}}},_getFirst:function(){if(this.paginator){var b=this.paginator.puipaginator("option","page"),a=this.paginator.puipaginator("option","rows");
return(b*a)
}else{return 0
}},_getRows:function(){return this.paginator?this.paginator.puipaginator("option","rows"):this.data.length
},_isSortingEnabled:function(){var b=this.options.columns;
if(b){for(var a=0;
a<b.length;
a++){if(b[a].sortable){return true
}}}return false
},_initSelection:function(){var a=this;
this.selection=[];
this.rowSelector="#"+this.id+" tbody.pui-datatable-data > tr.ui-widget-content:not(.ui-datatable-empty-message)";
if(this._isMultipleSelection()){this.originRowIndex=0;
this.cursorIndex=null
}$(document).off("mouseover.puidatatable mouseout.puidatatable click.puidatatable",this.rowSelector).on("mouseover.datatable",this.rowSelector,null,function(){var b=$(this);
if(!b.hasClass("ui-state-highlight")){b.addClass("ui-state-hover")
}}).on("mouseout.datatable",this.rowSelector,null,function(){var b=$(this);
if(!b.hasClass("ui-state-highlight")){b.removeClass("ui-state-hover")
}}).on("click.datatable",this.rowSelector,null,function(b){a._onRowClick(b,this)
})
},_onRowClick:function(f,e){if(!$(f.target).is(":input,:button,a")){var h=$(e),d=h.hasClass("ui-state-highlight"),g=f.metaKey||f.ctrlKey,b=f.shiftKey;
if(d&&g){this.unselectRow(h)
}else{if(this._isSingleSelection()||(this._isMultipleSelection()&&!g&&!b)){if(this._isMultipleSelection()){var c=this.getSelection();
for(var a=0;
a<c.length;
a++){this._trigger("rowUnselect",null,c[a])
}}this.unselectAllRows()
}this.selectRow(h,false,f)
}PUI.clearSelection()
}},_isSingleSelection:function(){return this.options.selectionMode==="single"
},_isMultipleSelection:function(){return this.options.selectionMode==="multiple"
},unselectAllRows:function(){this.tbody.children("tr.ui-state-highlight").removeClass("ui-state-highlight").attr("aria-selected",false);
this.selection=[]
},unselectRow:function(b,a){var c=this._getRowIndex(b);
b.removeClass("ui-state-highlight").attr("aria-selected",false);
this._removeSelection(c);
if(!a){this._trigger("rowUnselect",null,this.data[c])
}},selectRow:function(d,a,b){var e=this._getRowIndex(d),c=this.data[e];
d.removeClass("ui-state-hover").addClass("ui-state-highlight").attr("aria-selected",true);
this._addSelection(e);
if(!a){if(this.options.lazy){c=this.data[e-this._getFirst()]
}this._trigger("rowSelect",b,c)
}},getSelection:function(){var c=this.options.lazy?this._getFirst():0,b=[];
for(var a=0;
a<this.selection.length;
a++){if(this.data.length>this.selection[a]-c&&this.selection[a]-c>0){b.push(this.data[this.selection[a]-c])
}}return b
},_removeSelection:function(a){this.selection=$.grep(this.selection,function(b){return b!==a
})
},_addSelection:function(a){if(!this._isSelected(a)){this.selection.push(a)
}},_isSelected:function(a){return PUI.inArray(this.selection,a)
},_getRowIndex:function(b){var a=b.index();
return this.options.paginator?this._getFirst()+a:a
},_createStateMeta:function(){var a={first:this._getFirst(),rows:this._getRows(),sortField:this.options.sortField,sortOrder:this.options.sortOrder};
return a
},_updateDatasource:function(a){this.options.datasource=a;
if($.isArray(this.options.datasource)){this._onDataUpdate(this.options.datasource)
}else{if($.type(this.options.datasource)==="function"){if(this.options.lazy){this.options.datasource.call(this,this._onDataUpdate,{first:0,sortField:this.options.sortField,sortorder:this.options.sortOrder})
}else{this.options.datasource.call(this,this._onDataUpdate)
}}}},_setOption:function(a,b){if(a==="datasource"){this._updateDatasource(b)
}else{$.Widget.prototype._setOption.apply(this,arguments)
}},_initScrolling:function(){this.scrollHeader=this.element.children(".pui-datatable-scrollable-header");
this.scrollBody=this.element.children(".pui-datatable-scrollable-body");
this.scrollHeaderBox=this.scrollHeader.children(".pui-datatable-scrollable-header-box");
this.headerTable=this.scrollHeaderBox.children("table");
this.bodyTable=this.scrollBody.children("table");
this.percentageScrollHeight=this.options.scrollHeight&&(this.options.scrollHeight.indexOf("%")!==-1);
this.percentageScrollWidth=this.options.scrollWidth&&(this.options.scrollWidth.indexOf("%")!==-1);
var c=this,b=this.getScrollbarWidth()+"px";
if(this.options.scrollHeight){if(this.percentageScrollHeight){this.adjustScrollHeight()
}else{this.scrollBody.css("max-height",this.options.scrollHeight+"px")
}if(this.hasVerticalOverflow()){this.scrollHeaderBox.css("margin-right",b)
}}this.fixColumnWidths();
if(this.options.scrollWidth){if(this.percentageScrollWidth){this.adjustScrollWidth()
}else{this.setScrollWidth(parseInt(this.cfg.scrollWidth))
}}this.cloneHead();
this.scrollBody.on("scroll.dataTable",function(){var d=c.scrollBody.scrollLeft();
c.scrollHeaderBox.css("margin-left",-d)
});
this.scrollHeader.on("scroll.dataTable",function(){c.scrollHeader.scrollLeft(0)
});
var a="resize."+this.id;
$(window).off(a).on(a,function(){if(c.element.is(":visible")){if(c.percentageScrollHeight){c.adjustScrollHeight()
}if(c.percentageScrollWidth){c.adjustScrollWidth()
}}})
},cloneHead:function(){this.theadClone=this.thead.clone();
this.theadClone.find("th").each(function(){var b=$(this);
b.attr("id",b.attr("id")+"_clone");
$(this).children().not(".pui-column-title").remove()
});
this.theadClone.removeAttr("id").addClass("pui-datatable-scrollable-theadclone").height(0).prependTo(this.bodyTable);
if(this.options.scrollWidth){var a=this.theadClone.find("> tr > th.pui-sortable-column");
a.each(function(){$(this).data("original",$(this).attr("id").split("_clone")[0])
});
a.on("blur.dataTable",function(){$(PrimeFaces.escapeClientId($(this).data("original"))).removeClass("ui-state-focus")
}).on("focus.dataTable",function(){$(PrimeFaces.escapeClientId($(this).data("original"))).addClass("ui-state-focus")
}).on("keydown.dataTable",function(d){var b=d.which,c=$.ui.keyCode;
if((b===c.ENTER||b===c.NUMPAD_ENTER)&&$(d.target).is(":not(:input)")){$(PrimeFaces.escapeClientId($(this).data("original"))).trigger("click.dataTable",(d.metaKey||d.ctrlKey));
d.preventDefault()
}})
}},adjustScrollHeight:function(){var d=this.element.parent().innerHeight()*(parseInt(this.cfg.scrollHeight)/100),f=this.element.children(".pui-datatable-header").outerHeight(true),b=this.element.children(".pui-datatable-footer").outerHeight(true),c=(this.scrollHeader.outerHeight(true)+this.scrollFooter.outerHeight(true)),e=this.paginator?this.paginator.getContainerHeight(true):0,a=(d-(c+e+f+b));
this.scrollBody.css("max-height",a+"px")
},adjustScrollWidth:function(){var a=parseInt((this.element.parent().innerWidth()*(parseInt(this.options.scrollWidth)/100)));
this.setScrollWidth(a)
},setOuterWidth:function(a,b){var c=a.outerWidth()-a.width();
a.width(b-c)
},setScrollWidth:function(a){var b=this;
this.element.children(".ui-widget-header").each(function(){b.setOuterWidth($(this),a)
});
this.scrollHeader.width(a);
this.scrollBody.css("margin-right",0).width(a)
},alignScrollBody:function(){var a=this.hasVerticalOverflow()?this.getScrollbarWidth()+"px":"0px";
this.scrollHeaderBox.css("margin-right",a)
},getScrollbarWidth:function(){if(!this.scrollbarWidth){this.scrollbarWidth=PUI.browser.webkit?"15":PUI.calculateScrollbarWidth()
}return this.scrollbarWidth
},hasVerticalOverflow:function(){return(this.options.scrollHeight&&this.bodyTable.outerHeight()>this.scrollBody.outerHeight())
},restoreScrollState:function(){var a=this.scrollStateHolder.val(),b=a.split(",");
this.scrollBody.scrollLeft(b[0]);
this.scrollBody.scrollTop(b[1])
},saveScrollState:function(){var a=this.scrollBody.scrollLeft()+","+this.scrollBody.scrollTop();
this.scrollStateHolder.val(a)
},clearScrollState:function(){this.scrollStateHolder.val("0,0")
},fixColumnWidths:function(){if(!this.columnWidthsFixed){if(this.options.scrollable){this.scrollHeaderBox.find("> table > thead > tr > th").each(function(){var b=$(this),a=b.width();
b.width(a)
})
}else{this.options.find("> .pui-datatable-tablewrapper > table > thead > tr > th").each(function(){var a=$(this);
a.width(a.width())
})
}this.columnWidthsFixed=true
}}})
});