window.__define("camunda-cockpit-bootstrap",["./scripts/camunda-cockpit-ui"],function(){"use strict";var p=window.CamundaCockpitUi;requirejs.config({baseUrl:"../../../lib"});var i=window;p.exposePackages(i),window.define=window.__define,window.require=window.__require,requirejs(["globalize"],function(n){n(requirejs,["angular","camunda-commons-ui","camunda-bpm-sdk-js","jquery","angular-data-depend","moment","events"],i);var e=window.PLUGIN_PACKAGES||[],u=window.PLUGIN_DEPENDENCIES||[];e.forEach(function(n){var e=document.createElement("link");e.setAttribute("rel","stylesheet"),e.setAttribute("href",n.location+"/plugin.css"),document.head.appendChild(e)}),requirejs.config({packages:e,baseUrl:"../",paths:{ngDefine:"../../lib/ngDefine"}});var o=["jquery","angular","ngDefine","moment"].concat(u.map(function(n){return n.requirePackageName}));requirejs(o,function(o,n){if(void 0!==window.camCockpitConf&&(window.camCockpitConf.customScripts||window.camCockpitConf.bpmnJs)){var i=window.camCockpitConf.customScripts||{},t={};["baseUrl","paths","bundles","shim","map","config","packages","waitSeconds","context","callback","enforceDefine","xhtml","urlArgs","scriptType"].forEach(function(n){i[n]&&(t[n]=i[n])}),t.paths=t.paths||{},i.deps=i.deps||[],i.ngDeps=i.ngDeps||[];var c=(window.camCockpitConf.bpmnJs||{}).additionalModules;c&&n.forEach(c,function(n,e){t.paths[e]=c[e],i.deps.push(e)});var e=(window.camCockpitConf.bpmnJs||{}).moddleExtensions;if(e){var a={};n.forEach(e,function(n,e){a[e]=o.getJSON("../"+n+".json",function(n){return n})}),window.bpmnJsModdleExtensions={};var r=Object.keys(a).map(function(n){return a[n]});o.when(r).then(function(){n.forEach(a,function(n,e){n.done(function(n){window.bpmnJsModdleExtensions[e]=n}).fail(function(n){404===n.status?console.error('bpmn-js moddle extension "'+e+'" could not be loaded.'):console.error('unhandled error with bpmn-js moddle extension "'+e+'"')})}),s()})}else s()}else n.module("cam.cockpit.custom",[]),require([],function(){d(u)});function s(){requirejs.config(t),requirejs(i.deps||[],function(){n.module("cam.cockpit.custom",i.ngDeps),d(u)})}function d(n){window.define=void 0,window.require=void 0,p(n)}})})}),requirejs(["camunda-cockpit-bootstrap"],function(){});