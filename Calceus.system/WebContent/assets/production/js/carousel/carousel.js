$(function(){$.widget("primeui.puicarousel",{options:{datasource:null,numVisible:3,firstVisible:0,headerText:null,effectDuration:500,circular:false,breakpoint:560,itemContent:null,responsive:true,autoplayInterval:0,easing:"easeInOutCirc",pageLinks:3,styleClass:null},_create:function(){this.id=this.element.attr("id");
if(!this.id){this.id=this.element.uniqueId().attr("id")
}this.element.wrap('<div class="pui-carousel ui-widget ui-widget-content ui-corner-all"><div class="pui-carousel-viewport"></div></div>');
this.container=this.element.parent().parent();
this.element.addClass("pui-carousel-items");
this.container.prepend('<div class="pui-carousel-header ui-widget-header"><div class="pui-carousel-header-title"></div></div>');
this.viewport=this.element.parent();
this.header=this.container.children(".pui-carousel-header");
this.header.append('<span class="pui-carousel-button pui-carousel-next-button fa fa-arrow-circle-right"></span><span class="pui-carousel-button pui-carousel-prev-button fa fa-arrow-circle-left"></span>');
if(this.options.headerText){this.header.children(".pui-carousel-header-title").html(this.options.headerText)
}if(this.options.styleClass){this.container.addClass(this.options.styleClass)
}if(this.options.datasource){this._loadData()
}else{this._render()
}},_loadData:function(){if($.isArray(this.options.datasource)){this._render(this.options.datasource)
}else{if($.type(this.options.datasource)==="function"){this.options.datasource.call(this,this._render)
}}},_updateDatasource:function(a){this.options.datasource=a;
this.element.children().remove();
this.header.children(".pui-carousel-page-links").remove();
this.header.children("select").remove();
this._loadData()
},_render:function(b){this.data=b;
if(this.data){for(var a=0;
a<b.length;
a++){var c=this.options.itemContent.call(this,b[a]);
if($.type(c)==="string"){this.element.append("<li>"+c+"</li>")
}else{this.element.append($("<li></li>").wrapInner(c))
}}}this.items=this.element.children("li");
this.items.addClass("pui-carousel-item ui-widget-content ui-corner-all");
this.itemsCount=this.items.length;
this.columns=this.options.numVisible;
this.first=this.options.firstVisible;
this.page=parseInt(this.first/this.columns);
this.totalPages=Math.ceil(this.itemsCount/this.options.numVisible);
this._renderPageLinks();
this.prevNav=this.header.children(".pui-carousel-prev-button");
this.nextNav=this.header.children(".pui-carousel-next-button");
this.pageLinks=this.header.find("> .pui-carousel-page-links > .pui-carousel-page-link");
this.dropdown=this.header.children(".pui-carousel-dropdown");
this.mobileDropdown=this.header.children(".pui-carousel-mobiledropdown");
this._bindEvents();
if(this.options.responsive){this.refreshDimensions()
}else{this.calculateItemWidths();
this.container.width(this.container.width());
this.updateNavigators()
}},_renderPageLinks:function(){if(this.totalPages<=this.options.pageLinks){this.pageLinksContainer=$('<div class="pui-carousel-page-links"></div>');
for(var b=0;
b<this.totalPages;
b++){this.pageLinksContainer.append('<a href="#" class="pui-carousel-page-link fa fa-circle-o"></a>')
}this.header.append(this.pageLinksContainer)
}else{this.dropdown=$('<select class="pui-carousel-dropdown ui-widget ui-state-default ui-corner-left"></select>');
for(var b=0;
b<this.totalPages;
b++){var a=(b+1);
this.dropdown.append('<option value="'+a+'">'+a+"</option>")
}this.header.append(this.dropdown)
}if(this.options.responsive){this.mobileDropdown=$('<select class="pui-carousel-mobiledropdown ui-widget ui-state-default ui-corner-left"></select>');
for(var b=0;
b<this.itemsCount;
b++){var a=(b+1);
this.mobileDropdown.append('<option value="'+a+'">'+a+"</option>")
}this.header.append(this.mobileDropdown)
}},calculateItemWidths:function(){var b=this.items.eq(0);
if(b.length){var a=b.outerWidth(true)-b.width();
this.items.width((this.viewport.innerWidth()-a*this.columns)/this.columns)
}},refreshDimensions:function(){var a=$(window);
if(a.width()<=this.options.breakpoint){this.columns=1;
this.calculateItemWidths(this.columns);
this.totalPages=this.itemsCount;
this.mobileDropdown.show();
this.pageLinks.hide()
}else{this.columns=this.options.numVisible;
this.calculateItemWidths();
this.totalPages=Math.ceil(this.itemsCount/this.options.numVisible);
this.mobileDropdown.hide();
this.pageLinks.show()
}this.page=parseInt(this.first/this.columns);
this.updateNavigators();
this.element.css("left",(-1*(this.viewport.innerWidth()*this.page)))
},_bindEvents:function(){var b=this;
if(this.eventsBound){return
}this.prevNav.on("click.puicarousel",function(){if(b.page!==0){b.setPage(b.page-1)
}else{if(b.options.circular){b.setPage(b.totalPages-1)
}}});
this.nextNav.on("click.puicarousel",function(){var c=(b.page===(b.totalPages-1));
if(!c){b.setPage(b.page+1)
}else{if(b.options.circular){b.setPage(0)
}}});
this.element.swipe({swipe:function(c,d){if(d==="left"){if(b.page===(b.totalPages-1)){if(b.options.circular){b.setPage(0)
}}else{b.setPage(b.page+1)
}}else{if(d==="right"){if(b.page===0){if(b.options.circular){b.setPage(b.totalPages-1)
}}else{b.setPage(b.page-1)
}}}}});
if(this.pageLinks.length){this.pageLinks.on("click",function(c){b.setPage($(this).index());
c.preventDefault()
})
}this.header.children("select").on("change",function(){b.setPage(parseInt($(this).val())-1)
});
if(this.options.autoplayInterval){this.options.circular=true;
this.startAutoplay()
}if(this.options.responsive){var a="resize."+this.id;
$(window).off(a).on(a,function(){b.refreshDimensions()
})
}this.eventsBound=true
},updateNavigators:function(){if(!this.options.circular){if(this.page===0){this.prevNav.addClass("ui-state-disabled");
this.nextNav.removeClass("ui-state-disabled")
}else{if(this.page===(this.totalPages-1)){this.prevNav.removeClass("ui-state-disabled");
this.nextNav.addClass("ui-state-disabled")
}else{this.prevNav.removeClass("ui-state-disabled");
this.nextNav.removeClass("ui-state-disabled")
}}}if(this.pageLinks.length){this.pageLinks.filter(".fa-dot-circle-o").removeClass("fa-dot-circle-o");
this.pageLinks.eq(this.page).addClass("fa-dot-circle-o")
}if(this.dropdown.length){this.dropdown.val(this.page+1)
}if(this.mobileDropdown.length){this.mobileDropdown.val(this.page+1)
}},setPage:function(b){if(b!==this.page&&!this.element.is(":animated")){var a=this;
this.element.animate({left:-1*(this.viewport.innerWidth()*b),easing:this.options.easing},{duration:this.options.effectDuration,easing:this.options.easing,complete:function(){a.page=b;
a.first=a.page*a.columns;
a.updateNavigators();
a._trigger("pageChange",null,{page:b})
}})
}},startAutoplay:function(){var a=this;
this.interval=setInterval(function(){if(a.page===(a.totalPages-1)){a.setPage(0)
}else{a.setPage(a.page+1)
}},this.options.autoplayInterval)
},stopAutoplay:function(){clearInterval(this.interval)
},_setOption:function(a,b){if(a==="datasource"){this._updateDatasource(b)
}else{$.Widget.prototype._setOption.apply(this,arguments)
}},_destroy:function(){}})
});