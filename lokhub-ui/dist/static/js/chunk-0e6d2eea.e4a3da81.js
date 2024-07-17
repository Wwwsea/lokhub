(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0e6d2eea"],{"31ed":function(t,e,a){"use strict";a.d(e,"d",(function(){return i})),a.d(e,"b",(function(){return n})),a.d(e,"c",(function(){return s})),a.d(e,"a",(function(){return o}));var r=a("b775");function i(){return Object(r["a"])({url:"/project/statistics",method:"get"})}function n(){return Object(r["a"])({url:"/project/doing",method:"get"})}function s(){return Object(r["a"])({url:"/project/select",method:"get"})}function o(t){return Object(r["a"])({url:"/project/queryMyTaskList",method:"post",data:t})}},"713c":function(t,e,a){},9406:function(t,e,a){"use strict";a.r(e);a("9911");var r=function(){var t=this,e=t._self._c;return e("div",{staticClass:"app-container"},[e("el-card",{staticClass:"data-wrapper",attrs:{header:"数据总览",shadow:"never"}},t._l(t.panelList,(function(a,r){return e("div",{key:r,staticClass:"panel"},[e("div",{staticClass:"panel-icon-wrapper",class:a.class},[e("svg-icon",{attrs:{"icon-class":a.icon,"class-name":"panel-icon"}})],1),e("div",{staticClass:"panel-description"},[e("div",{staticClass:"panel-text"},[t._v(t._s(a.title))]),e("count-to",{staticClass:"panel-num",attrs:{"start-val":0,"end-val":a.number,duration:1e3}})],1)])})),0),e("el-row",{attrs:{gutter:20}},[e("el-col",{attrs:{span:16}},[e("el-card",{staticClass:"project-wrapper",attrs:{shadow:"never"}},[e("template",{slot:"header"},[e("span",[t._v("进行中的项目")]),e("el-button",{attrs:{type:"text"},on:{click:function(e){return t.link("lokhub-project/my-project")}}},[t._v("全部项目")])],1),t._l(t.projectList,(function(a,r){return e("div",{key:r,staticClass:"panel",on:{click:function(e){return t.clickProject(a.projectId)}}},[e("div",{staticClass:"content"},[e("el-image",{staticStyle:{width:"50px",height:"50px"},attrs:{src:a.cover,fit:"cover"}},[e("div",{staticStyle:{display:"flex","justify-content":"center","align-items":"center",height:"100%"},attrs:{slot:"error"},slot:"error"},[e("i",{staticClass:"el-icon-picture-outline",staticStyle:{"font-size":"40px"}})])]),e("div",{staticClass:"text"},[e("p",[t._v("项目名:"+t._s(a.projectName))]),e("p",[t._v("负责人:"+t._s(a.nickName))])])],1),e("div",{staticClass:"progress"},[e("el-progress",{attrs:{"text-inside":!0,"stroke-width":16,percentage:a.process}})],1)])}))],2)],1),e("el-col",{attrs:{span:8}},[e("el-card",{staticClass:"task-wrapper",attrs:{shadow:"never"}},[e("template",{slot:"header"},[e("span",[t._v("我的任务")]),e("el-select",{attrs:{placeholder:"请选择项目",size:"mini",filterable:""},on:{change:t.changeProjectId},model:{value:t.projectId,callback:function(e){t.projectId=e},expression:"projectId"}},t._l(t.projectOptions,(function(t,a){return e("el-option",{key:a,attrs:{label:t.projectName,value:t.projectId}})})),1)],1),e("el-radio-group",{on:{input:t.changeTaskRadio},model:{value:t.taskRadio,callback:function(e){t.taskRadio=e},expression:"taskRadio"}},[e("el-radio-button",{attrs:{label:1}},[t._v("我执行的")]),e("el-radio-button",{attrs:{label:2}},[t._v("我参与的")]),e("el-radio-button",{attrs:{label:3}},[t._v("我创建的")])],1),e("el-table",{attrs:{data:t.tableData,"highlight-current-row":"","row-style":{cursor:"pointer"},"show-header":!1},on:{"row-click":t.handleRowClick}},[e("el-table-column",{attrs:{label:"任务名",prop:"taskName",align:"center","show-overflow-tooltip":""}}),e("el-table-column",{attrs:{label:"所属阶段",prop:"stageName",align:"center","show-overflow-tooltip":""}}),e("el-table-column",{attrs:{label:"任务状态",prop:"statusName",align:"center","show-overflow-tooltip":""}}),e("el-table-column",{attrs:{label:"时间",prop:"createdTime",align:"center","show-overflow-tooltip":""}})],1),e("el-pagination",{attrs:{layout:"prev, pager, next",total:t.total,"page-size":5,"current-page":t.currentPage},on:{"current-change":t.handleCurrentChange}})],2)],1)],1),e("el-row",{staticClass:"chart-wrapper",attrs:{gutter:20}},[e("el-col",{attrs:{span:16}},[e("el-card",{attrs:{header:"项目进度排行",shadow:"never"}},[e("div",{attrs:{id:"projectProgressChart"}})])],1),e("el-col",{attrs:{span:8}},[e("el-card",{attrs:{header:"任务状态",shadow:"never"}},[e("div",{attrs:{id:"taskStatusChart"}})])],1)],1)],1)},i=[],n=a("2909"),s=(a("14d9"),a("d3b7"),a("a9e3"),a("99af"),a("ec1b")),o=a.n(s),l=a("313e"),c=a.n(l),u=a("31ed"),d={name:"Index",components:{CountTo:o.a},data:function(){return{panelList:[{title:"项目总数",number:0,icon:"project",class:"icon-1"},{title:"任务总数",number:0,icon:"task",class:"icon-2"},{title:"今日任务数",number:0,icon:"task2",class:"icon-3"},{title:"逾期任务数",number:0,icon:"overdue-task",class:"icon-4"}],projectList:[],taskRadio:1,projectId:void 0,projectOptions:[],tableData:[],total:0,currentPage:1,projectProgressChart:null,projectProgressData:{x:[],y:[]},taskStatusChart:null,taskStatusData:[]}},methods:{link:function(t){this.$router.push(t)},clickProject:function(t){this.$router.push({path:"/lokhub-project/my-project/info",query:{projectId:t}})},changeTaskRadio:function(t){this.currentPage=1,this.getTableData()},changeProjectId:function(){this.currentPage=1,this.getTableData()},handleRowClick:function(t,e){this.$router.push({path:"/lokhub-project/my-task/info",query:{taskId:t.taskId}})},handleCurrentChange:function(t){this.currentPage=t,this.getTableData()},getTableData:function(){var t=this;this.$modal.loading("加载中..."),Object(u["a"])({pageNum:this.currentPage,pageSize:5,projectId:this.projectId,type:this.taskRadio}).then((function(e){t.total=e.data.total,t.tableData=e.data.list})).catch((function(){t.tableData=[]})).finally((function(){t.$modal.closeLoading()}))},initProjectProgressChart:function(){var t=document.getElementById("projectProgressChart");this.projectProgressChart=c.a.init(t);var e={color:["#409EFF"],tooltip:{trigger:"axis",formatter:function(t){var e=t[0];return"进度："+e.value+"%"}},grid:{left:"3%",right:"3%",top:"12%",bottom:"6%",containLabel:!0},dataZoom:[{type:"inside",start:0,end:100},{start:0,end:100}],xAxis:{type:"category",data:this.projectProgressData.x},yAxis:{type:"value"},series:[{data:this.projectProgressData.y,type:"bar"}]};this.projectProgressChart.setOption(e)},initTaskStatusChart:function(){var t=document.getElementById("taskStatusChart");this.taskStatusChart=c.a.init(t);var e={color:["#00DDFF","#37A2FF","#FF0087","#FFBF00","#909399"],tooltip:{trigger:"item"},label:{alignTo:"edge",formatter:"{name|{b}}\n{time|{c}}",minMargin:5,edgeDistance:10,lineHeight:15,rich:{time:{fontSize:10,color:"#999"}}},legend:{top:"bottom"},series:[{data:this.taskStatusData,type:"pie",radius:["30%","50%"]}]};this.taskStatusChart.setOption(e)},resizeChart:function(){this.projectProgressChart.resize(),this.taskStatusChart.resize()},disposeChart:function(){this.projectProgressChart.dispose(),this.taskStatusChart.dispose()}},mounted:function(){var t=this;Object(u["d"])().then((function(e){t.panelList[0].number=Number(e.data.projectNum),t.panelList[1].number=Number(e.data.taskNum),t.panelList[2].number=Number(e.data.todayTaskNum),t.panelList[3].number=Number(e.data.overdueTaskNum);for(var a=0;a<e.data.projectRankVOList.length;a++){var r=e.data.projectRankVOList[a];t.projectProgressData.x.push(r.projectName),t.projectProgressData.y.push(r.process)}for(var i=0;i<e.data.taskStatisticsVOList.length;i++){var n=e.data.taskStatisticsVOList[i];t.taskStatusData.push({name:n.statusName,value:n.taskNum})}t.initProjectProgressChart(),t.initTaskStatusChart()})),Object(u["b"])().then((function(e){for(var a=0;a<e.data.length;a++)e.data[a].cover="/prod-api"+e.data[a].cover,console.log("Image URL:",e.data[a].cover);t.projectList=e.data})),Object(u["c"])().then((function(e){t.projectOptions=[{projectName:"全部项目",projectId:void 0}].concat(Object(n["a"])(e.data))})),this.getTableData(),window.addEventListener("resize",this.resizeChart)},beforeDestroy:function(){window.removeEventListener("resize",this.resizeChart),this.disposeChart()}},p=d,h=(a("a49e"),a("2877")),m=Object(h["a"])(p,r,i,!1,null,"ec345520",null);e["default"]=m.exports},a49e:function(t,e,a){"use strict";a("713c")},ec1b:function(t,e,a){!function(e,a){t.exports=a()}(0,(function(){return function(t){function e(r){if(a[r])return a[r].exports;var i=a[r]={i:r,l:!1,exports:{}};return t[r].call(i.exports,i,i.exports,e),i.l=!0,i.exports}var a={};return e.m=t,e.c=a,e.i=function(t){return t},e.d=function(t,a,r){e.o(t,a)||Object.defineProperty(t,a,{configurable:!1,enumerable:!0,get:r})},e.n=function(t){var a=t&&t.__esModule?function(){return t.default}:function(){return t};return e.d(a,"a",a),a},e.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},e.p="/dist/",e(e.s=2)}([function(t,e,a){var r=a(4)(a(1),a(5),null,null);t.exports=r.exports},function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var r=a(3);e.default={props:{startVal:{type:Number,required:!1,default:0},endVal:{type:Number,required:!1,default:2017},duration:{type:Number,required:!1,default:3e3},autoplay:{type:Boolean,required:!1,default:!0},decimals:{type:Number,required:!1,default:0,validator:function(t){return t>=0}},decimal:{type:String,required:!1,default:"."},separator:{type:String,required:!1,default:","},prefix:{type:String,required:!1,default:""},suffix:{type:String,required:!1,default:""},useEasing:{type:Boolean,required:!1,default:!0},easingFn:{type:Function,default:function(t,e,a,r){return a*(1-Math.pow(2,-10*t/r))*1024/1023+e}}},data:function(){return{localStartVal:this.startVal,displayValue:this.formatNumber(this.startVal),printVal:null,paused:!1,localDuration:this.duration,startTime:null,timestamp:null,remaining:null,rAF:null}},computed:{countDown:function(){return this.startVal>this.endVal}},watch:{startVal:function(){this.autoplay&&this.start()},endVal:function(){this.autoplay&&this.start()}},mounted:function(){this.autoplay&&this.start(),this.$emit("mountedCallback")},methods:{start:function(){this.localStartVal=this.startVal,this.startTime=null,this.localDuration=this.duration,this.paused=!1,this.rAF=(0,r.requestAnimationFrame)(this.count)},pauseResume:function(){this.paused?(this.resume(),this.paused=!1):(this.pause(),this.paused=!0)},pause:function(){(0,r.cancelAnimationFrame)(this.rAF)},resume:function(){this.startTime=null,this.localDuration=+this.remaining,this.localStartVal=+this.printVal,(0,r.requestAnimationFrame)(this.count)},reset:function(){this.startTime=null,(0,r.cancelAnimationFrame)(this.rAF),this.displayValue=this.formatNumber(this.startVal)},count:function(t){this.startTime||(this.startTime=t),this.timestamp=t;var e=t-this.startTime;this.remaining=this.localDuration-e,this.useEasing?this.countDown?this.printVal=this.localStartVal-this.easingFn(e,0,this.localStartVal-this.endVal,this.localDuration):this.printVal=this.easingFn(e,this.localStartVal,this.endVal-this.localStartVal,this.localDuration):this.countDown?this.printVal=this.localStartVal-(this.localStartVal-this.endVal)*(e/this.localDuration):this.printVal=this.localStartVal+(this.localStartVal-this.startVal)*(e/this.localDuration),this.countDown?this.printVal=this.printVal<this.endVal?this.endVal:this.printVal:this.printVal=this.printVal>this.endVal?this.endVal:this.printVal,this.displayValue=this.formatNumber(this.printVal),e<this.localDuration?this.rAF=(0,r.requestAnimationFrame)(this.count):this.$emit("callback")},isNumber:function(t){return!isNaN(parseFloat(t))},formatNumber:function(t){t=t.toFixed(this.decimals),t+="";var e=t.split("."),a=e[0],r=e.length>1?this.decimal+e[1]:"",i=/(\d+)(\d{3})/;if(this.separator&&!this.isNumber(this.separator))for(;i.test(a);)a=a.replace(i,"$1"+this.separator+"$2");return this.prefix+a+r+this.suffix}},destroyed:function(){(0,r.cancelAnimationFrame)(this.rAF)}}},function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var r=a(0),i=function(t){return t&&t.__esModule?t:{default:t}}(r);e.default=i.default,"undefined"!=typeof window&&window.Vue&&window.Vue.component("count-to",i.default)},function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var r=0,i="webkit moz ms o".split(" "),n=void 0,s=void 0;if("undefined"==typeof window)e.requestAnimationFrame=n=function(){},e.cancelAnimationFrame=s=function(){};else{e.requestAnimationFrame=n=window.requestAnimationFrame,e.cancelAnimationFrame=s=window.cancelAnimationFrame;for(var o=void 0,l=0;l<i.length&&(!n||!s);l++)o=i[l],e.requestAnimationFrame=n=n||window[o+"RequestAnimationFrame"],e.cancelAnimationFrame=s=s||window[o+"CancelAnimationFrame"]||window[o+"CancelRequestAnimationFrame"];n&&s||(e.requestAnimationFrame=n=function(t){var e=(new Date).getTime(),a=Math.max(0,16-(e-r)),i=window.setTimeout((function(){t(e+a)}),a);return r=e+a,i},e.cancelAnimationFrame=s=function(t){window.clearTimeout(t)})}e.requestAnimationFrame=n,e.cancelAnimationFrame=s},function(t,e){t.exports=function(t,e,a,r){var i,n=t=t||{},s=typeof t.default;"object"!==s&&"function"!==s||(i=t,n=t.default);var o="function"==typeof n?n.options:n;if(e&&(o.render=e.render,o.staticRenderFns=e.staticRenderFns),a&&(o._scopeId=a),r){var l=Object.create(o.computed||null);Object.keys(r).forEach((function(t){var e=r[t];l[t]=function(){return e}})),o.computed=l}return{esModule:i,exports:n,options:o}}},function(t,e){t.exports={render:function(){var t=this,e=t.$createElement;return(t._self._c||e)("span",[t._v("\n  "+t._s(t.displayValue)+"\n")])},staticRenderFns:[]}}])}))}}]);
