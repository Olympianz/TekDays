/***
 * Excerpted from "Grails: A Quickstart Guide",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/dkgrails for more book information.
***/
/*
Copyright (c) 2007, Caridy Patino. All rights reserved.
Portions Copyright (c) 2007, Yahoo!, Inc. All rights reserved.
Code licensed under the BSD License:
http://www.bubbling-library.com/eng/licence
version: 1.5.0
*/
(function(){var $B=YAHOO.Bubbling,$E=YAHOO.util.Event,$L=YAHOO.lang,$D=YAHOO.util.Dom;YAHOO.plugin.Lighter=function(){var obj={},_areas={},_listClass='yui-cms-selector',_itemClass='yui-cms-item',_selector='selected',_defConf={persistent:false,onReset:null,onSelect:null};function reset(area,conf){var resetItem=function(ref){$D.removeClass(ref,_selector);};var items=$D.getElementsByClassName(_itemClass,'*',area);if(items.length>0){$D.batch(items,resetItem,obj,true);}if($L.isFunction(conf.onReset)){conf.onReset.apply(conf,[area]);}}$B.on('rollover',function(layer,args){var area,item,onWayOut,conf={},id;item=$B.getOwnerByClassName(args[1].target,_itemClass);if(item&&(area=$B.getOwnerByClassName(item,_listClass))&&!$D.hasClass(item,_selector)){for(id in _areas){if(_areas.hasOwnProperty(id)&&$D.hasClass(area,id)){conf=_areas[id];}}if(!$D.hasClass(area,_selector)){$D.addClass(area,_selector);onWayOut=function(e){if(!$B.virtualTarget(e,area)){reset(area,conf);}};if(!conf.persistent){$E.removeListener(area,'mouseout',onWayOut);$E.addListener(area,'mouseout',onWayOut,obj,true);}}reset(area,conf);$D.addClass(item,_selector);if($L.isFunction(conf.onSelect)){conf.onSelect.apply(conf,[item,area]);}}});obj.add=function(className,conf){if($L.isString(className)&&(className!=='')){obj.remove(className);_areas[className]=conf||_defConf;}};obj.remove=function(className){if($L.isString(className)&&(className!=='')&&(_areas[className])){_areas[className]=null;}_areas[className]=null;};return obj;}();})();
YAHOO.register("lighter",YAHOO.plugin.Lighter,{version:"1.5.0",build:"208"});