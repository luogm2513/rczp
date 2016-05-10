<#--
包含页面
	可以包含当前目录、方案、甚至其他站点的页面。
eg：
[@p.Include page="mypage.html"/]
-->
<#macro Include page params={}>
<#include "/include/${page}"/>
</#macro>

<#macro PublicResource css=[] js=[]>
	<link rel="shortcut icon" href="${imgRoot}/favicon.png">
	<!-- Bootstrap core CSS -->
    <link href="${cssRoot}/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${cssRoot}/parox-base.css" rel="stylesheet">   
    <!--input check style-->
    <link href="${cssRoot}/plugin.input.check.polaris/polaris.css" rel="stylesheet">
  <#list css as s>
	<#if s?starts_with('/')>	
		<link href="${cssRoot+s}" rel="stylesheet">
	<#else>
		<link href="${s}" rel="stylesheet">
	</#if>    
  </#list>
    <!--[if lt IE 9]>
    	<script src="${jsRoot}/core/ie8-responsive-file-warning.js"></script>
    <![endif]-->    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->    

    <script type="text/javascript" src="${jsRoot}/jquery/jquery-1.10.2.js" charset="utf-8"></script>
  	<script type="text/javascript" src="${jsRoot}/bootstrap/bootstrap.js" charset="utf-8"></script>
  	<script type="text/javascript" src="${jsRoot}/core/base.js"></script>
  	<script type="text/javascript" src="${jsRoot}/system/global.js"></script>
  	<script type="text/javascript" src="${jsRoot}/comet/comet4j.js"></script>
  <#list js as s>
	<#if s?starts_with('/')>	
		<script type="text/javascript" src="${jsRoot+s}"></script>
	<#else>
		<script type="text/javascript" src="${s}"></script>
	</#if>    
  </#list>  	
    <script type="text/javascript" src="${jsRoot}/core/parox-core-0.1.js"></script>
    <script type="text/javascript" src="${jsRoot}/core/ajax.js"></script>
	<script type="text/javascript" src="${jsRoot}/system/message.js"></script>
	<script type="text/javascript" src="${jsRoot}/system/parox-bm.js"></script>	
</#macro>

<#--
系统分页样式调用标签
style：系统样式编号。
-->
<#macro SysPage style cssClass="" cssStyle="" ajaxFunc="ajaxPage">
<#if pagination??>
	<#local lp=pagination/>
<#elseif n_pagination??>
	<#local lp=n_pagination/>
<#else>
	<#return/>
</#if>
<#include "style_pager/style${style}.ftl"/>
</#macro>