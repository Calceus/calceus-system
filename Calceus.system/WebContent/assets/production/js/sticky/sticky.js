$(function(){$.widget("primeui.puisticky",{_create:function(){this.initialState={top:this.element.offset().top,height:this.element.height()};
this.id=this.element.attr("id");
if(!this.id){this.id=this.element.uniqueId().attr("id")
}this._bindEvents()
},_bindEvents:function(){var d=this,c=$(window),b="scroll."+this.id,a="resize."+this.id;
c.off(b).on(b,function(){if(c.scrollTop()>d.initialState.top){d._fix()
}else{d._restore()
}}).off(a).on(a,function(){if(d.fixed){d.element.width(d.ghost.outerWidth()-(d.element.outerWidth()-d.element.width()))
}})
},_fix:function(){if(!this.fixed){this.element.css({position:"fixed",top:0,"z-index":10000}).addClass("pui-shadow pui-sticky");
this.ghost=$('<div class="pui-sticky-ghost"></div>').height(this.initialState.height).insertBefore(this.element);
this.element.width(this.ghost.outerWidth()-(this.element.outerWidth()-this.element.width()));
this.fixed=true
}},_restore:function(){if(this.fixed){this.element.css({position:"static",top:"auto",width:"auto"}).removeClass("pui-shadow pui-sticky");
this.ghost.remove();
this.fixed=false
}}})
});