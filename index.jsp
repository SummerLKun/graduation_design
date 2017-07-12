<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->
<meta charset="utf-8">
<title>首页</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<!-- js调用部分begin -->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.yomi.js"></script>
<script src="js/jquery.flexslider-min.js"></script>
<script src="js/totop.js" type="text/javascript"></script>
<script>
$(function(){
	$('.flexslider').flexslider({
		directionNav: true,
		pauseOnAction: false
	});
});
//
</script>
<!-- js调用部分end -->
</head>

<body>
<div class="header">
	<div class="topbar">
        <span class="item">
        <%if(session.getAttribute("username")!=null){
        	%>
        	<a href="member.jsp"><%=session.getAttribute("username") %></a><span><a href="login.jsp">退出</a></span>
        <%} else{%>
        <a href="login.jsp">登录</a></span><span class="item"><a href="login.jsp">注册</a></span>
        <%} %>
        &nbsp;<span class="hr-line">|</span>
        <span class="orange"><a href="#">积分签到</a></span>
    </div>
    <div class="headbox">
    	<div class="logo"><img src="image/logo.png" /></div>
        <div class="searchbox">
        	<div class="tips-num gray">今日更新&nbsp;<span class="green">158</span>&nbsp;款</div>
            <form id="submitform">
                <input id="searchText" type="text" class="text gray" value=' 鲜美大富士'  onFocus="if (this.value==this.defaultValue) this.value='';" onblur="if (this.value=='') this.value=this.defaultValue;"/>
                <input id="searchSubmit" type="text" value=""/>
        	</form>
            
            <div class="tipswrap">
            	<div class="tipsbox">
                	<a href="#" />
                    	<img src="image/tips-icon1.jpg" /></br>
                        <span class="gray">看过</span>
                    </a>
                </div>
                <span class="gray">|</span>
            	<div class="tipsbox">
                	<a href="#" />
                    	<img src="image/tips-icon2.jpg" /></br>
                        <span class="gray">收藏</span>
                    </a>
                </div>
            </div><!--tipswrap end--><div class="clear"></div>
        </div><!--searchbox end-->

    </div><!--headbox end-->
    <div class="nav">
    	<ul class="cate">
        	<li class="font16"><a href="index.html">首页</a></li>
        	<li class="font16"><a href="#">今日推荐</a></li>
        	<li class="font16"><a href="#">鲜果汇</a></li>
        	<li class="font16"><a href="applyfree.html">免费申请</a></li>
            <div class="clear"></div> 
        </ul>

    </div>
</div>

<!--图片滚动效果-->
<div class="flexslider">
	<ul class="slides">
		<li style="background:url(image/banner/img1.jpg) 50% 0 no-repeat;"><a href="#">div+css</a></li>
		<li style="background:url(image/banner/img2.jpg) 50% 0 no-repeat;"><a href="#">div-css</a></li>
		<li style="background:url(image/banner/img3.jpg) 50% 0 no-repeat;"><a href="#">div css</a></li>
		<li style="background:url(image/banner/img4.jpg) 50% 0 no-repeat;"><a href="#">css div</a></li>
	</ul>
</div>
<!--回到顶部-->
<div class="bottom_tools">
	<div class="qr_tool">二维码</div>
	<a id="feedback" href="#" title="意见反馈">意见反馈</a>
	<a id="scrollUp" href="#" title="飞回顶部"></a>
	<img class="qr_img" src="image/qr_img.png">
</div>

<!--container start-->
<div class="container bgstyle">
    <div class="clear"></div>
    <!--colum tuijian start-->
    <div class="column">
    	<div class="colbox">
        	<div class="coltitle" style="width:780px;"><h1><a href="#">今日爆款推荐</a></h1>&nbsp;&nbsp;<span class="tipword gray">精品秒杀，限量稀缺</span></div>
            <div class="timer"><span class="gray tipword" style="float:left;">距本场结束仅剩</span><div class="yomibox" data="2017-6-25 00:00:09"></div></div>
        </div>
        <div class="clear"></div>
        
        <div class="goods">
        	<div class="goodsname"><a href="#">果园直供&nbsp;口感极佳 烟台大富士</a></div>
        	<div class="goodspic"><a href="#"><img src='image/images/1.jpg' /></a></div>
            <div class="goodsprice">
            	<a href="#">
                	<span class="orange font16num">￥</span><span class="orange font32">7.0</span>&nbsp;<span>原价:￥58</span>
                </a>
                <input type="button" value="去购买" />
            </div>
            <div class="goodsdetail">宏辉果蔬  苹果 烟台红富士 12个 单果约75mm 总重约2.1kg 新鲜水果</div>
        </div>
        <div class="goods">
        	<div class="goodsname"><a href="#">果园直供&nbsp;口感极佳 烟台大富士</a></div>
        	<div class="goodspic"><a href="#"><img src="image/images/1.jpg" /></a></div>
            <div class="goodsprice">
            	<a href="#">
                	<span class="orange font16">￥</span><span class="orange font32">7.0</span>&nbsp;<span>原价:￥58</span>
                </a>
                <input type="button" value="去购买"/>
            </div>
            <div class="goodsdetail">宏辉果蔬  苹果 烟台红富士 12个 单果约75mm 总重约2.1kg 新鲜水果</div>
        </div>
        <div class="goods" style="margin-right:0;">
        	<div class="goodsname"><a href="#">果园直供&nbsp;口感极佳 烟台大富士</a></div>
        	<div class="goodspic"><a href="#"><img src="image/images/1.jpg" /></a></div>
            <div class="goodsprice">
            	<a href="#">
                	<span class="orange font16">￥</span><span class="orange font32">7.0</span>&nbsp;<span>原价:￥58</span>
                </a>
                <input type="button" value="去购买">
            </div>
            <div class="goodsdetail">宏辉果蔬  苹果 烟台红富士 12个 单果约75mm 总重约2.1kg 新鲜水果</div>
        </div>
    </div><!--colum tuijian end-->
    <div class="clear"></div>
    <div class="column">
    	<div class="colbox">
        	<div class="coltitle"><h1><a href="#">水果分类</a></h1>&nbsp;&nbsp;<span class="tipword gray"></span></div>
            <div class="colmore"><a href="#">更多</a></div>
        </div>
        <div class="hotags">
            <div class="tagpic"><a href="#"><img src="image/images/hotagspics_coat.jpg"></a></div>
            <div class="tagpicname"><a href="#">仁果类</a></div>
            <div class="tagtext">
                <a href="#">苹果</a><span>|</span><a href="#">梨</a><span>|</span>
                <a href="#">山楂</a><span>|</span><a href="#">木瓜</a>
            </div>
        </div>
        <div class="hotags">
            <div class="tagpic"><a href="#"><img src="image/images/hotagspics_shoes.jpg"></a></div>
            <div class="tagpicname"><a href="#">核果类</a></div>
            <div class="tagtext">
                <a href="#">桃子</a><span>|</span><a href="#">杏子</a><span>|</span>
                <a href="#">李子</a><span>|</span><a href="#">樱桃</a>
            </div>
        </div>
        <div class="hotags" style="margin-right:0;">
            <div class="tagpic"><a href="#"><img src="image/images/hotagspics_bag.jpg"></a></div>
            <div class="tagpicname"><a href="#">坚果类</a></div>
            <div class="tagtext">
                <a href="#">栗子</a><span>|</span><a href="#">榛子</a><span>|</span>
                <a href="#">核桃</a><span>|</span><a href="#">开心果</a>
            </div>
        </div>
        <div class="hotags">
            <div class="tagpic"><a href="#"><img src="image/images/hotagspics_food.jpg"></a></div>
            <div class="tagpicname"><a href="#">浆果类</a></div>
            <div class="tagtext">
                <a href="#">葡萄</a><span>|</span><a href="#">草莓</a><span>|</span>
                <a href="#">猕猴桃</a><span>|</span><a href="#">石榴</a>
            </div>
        </div>
        <div class="hotags">
            <div class="tagpic"><a href="#"><img src="image/images/hotagspics_houseware.jpg"></a></div>
            <div class="tagpicname"><a href="#">柑橘类</a></div>
            <div class="tagtext">
                <a href="#">柑</a><span>|</span><a href="#">柠檬</a><span>|</span>
                <a href="#">橘</a><span>|</span><a href="#">柚</a>
            </div>
        </div>
        <div class="hotags" style="margin-right:0;">
            <div class="tagpic"><a href="#"><img src="image/images/hotagspics_toiletry.jpg"></a></div>
            <div class="tagpicname"><a href="#">热带水果</a></div>
            <div class="tagtext">
                <a href="#">香蕉</a><span>|</span><a href="#">杨桃</a><span>|</span>
                <a href="#">菠萝</a><span>|</span><a href="#">椰子</a>
            </div>
        </div>      
    </div>
    <div class="clear"></div><!--column hotags end -->
    <!--column dress start-->
    <div class="column">
    	<div class="colbox">
        	<div class="coltitle">
            	<h1><a href="#">精选水果</a></h1>&nbsp;&nbsp;
                <div class="coltag">
                	<a href="#" class="lab">柠檬</a><a href="#" class="lab">柑橘</a>
                    <a href="#" class="lab">草莓</a><a href="#" class="lab">樱桃</a>
                </div>
            </div>
            <div class="sorbar">
                <a href="#" class="lab1">默认</a><a href="#" class="lab2">折扣↑</a><a href="#" class="lab2">价格↑</a><a href="#" class="lab3">人群</a>
            </div>   
        </div>
        <div class="colwrap" >
            <div id="itemList"></div>
            <div id="findItemsByNameList"></div>
            <div id="findItemsByClassList"></div>
        </div>
    </div><!--column dress end-->
    <div class="clear"></div>

    </br></br > </br></br ></br></br >
</div><!--container end-->
<div class="footer">
	<div class="footbox">
    	<div class="about">
        	<div class="font16 abtitle">关于我们</div>
            <ul class="gray">
                <li>鲜果到家简介</li>
                <li>联系我们</li>
                <li>加入我们</li>
            </ul>
        </div>
    	<div class="cooper"> 
        	<div class="font16 abtitle">关于我们</div>
            <ul class="gray">
                <li>鲜果到家简介</li>
                <li>联系我们</li>
                <li>加入我们</li>
            </ul>    
        </div>
    	<div class="weixin">
        	<div class="wxlogo"><img src="image/logo.png"></div>
            <div class="wxpic"></div>
        </div>
    	<div class="cooper" style="border-right:1px dotted #CCC;">
        	<div class="font16 abtitle">商务合作</div>
            <ul class="gray">
                <li>鲜果到家简介</li>
                <li>联系我们</li>
                <li>加入我们</li>
            </ul>
        </div>
    	<div class="about" style="border:none;">
        	<div class="font16 abtitle">帮助中心</div>
            <ul class="gray">
                <li>鲜果到家简介</li>
                <li>加入我们</li>
                <li>联系我们</li>

            </ul>
        </div>
    </div><!--footbox end-->
	<div class="copyright gray">Copyright © 2017 Xian Guo Dao Jia Limited All Rights Reserved.</div>
</div><!--footer end--> 
<script tpye="text/javascript">
$(document).ready(function(){
	/* <!--导航点击出现下划线--> --start*/
	$("ul.cate li").mouseover(function(){
		$("ul.cate li").removeClass('unline');
		$(this).addClass('unline');
		
		$('ul .cate li a').click(function(){
			$("ul.cate li a").css('color','#000');
			$(this).css('color','#ff3a27');
			});
			
		}),function(){		
			$("ul.cate li").removeClass('unline');
			$("ul.cate li.lihome").addClass('unline');
			}
	/* <!--导航点击出现下划线--> --end*/
	//鼠标经过图片 下方出现半透明提示文字--start
	$(".pictext").hide();
	$(".picbox").hover(function() {
		$(".pictext", this).stop(true).slideToggle(500);
	});
	//鼠标经过图片 下方出现半透明提示文字--end
	//主页面加载商品信息--start
	$.ajax({
		type: "GET",
		async: false,
		url: "../springmvc_mybatis/items/getItemList.action",
		dataType: 'json',
		data: {},
		success: function (data) {
			if(data.msg=="SUCCESS"){
                $("#findItemsByNameList").hide();
                $("#itemList").get(0).innerHTML = '';
                $("#findItemsByClassList").hide();
                $("#itemList").show();
			}
			if(data.list.length>0){
				var id="";
				$.each(data.list,function(k,v){
					id="itemList_"+k;
                    $("#itemList").append("<div class='dress' id='"+id+"'><div class='dresspic picbox' ><a href='itemsDetail.jsp?itemsId="+v.id+"'><img src='"+v.pic+"'></a><div class='pictext'><div class='text'><a href=''>"+v.detail+"</a></div><div class='grayer'>原价：￥50</div></div></div></div>");
                    $("#"+id).append("<div class='dressprice'><div class='sl'><a href='' class='orange'><h3>￥</h3><h1>"+v.price+"</h1></a></div><div class='sr'><a href='' class='orange'>1.7折</a>&nbsp;<span>|</span>&nbsp;<a href=''>❤698</a>&nbsp;<span>|</span>&nbsp;<a href=''>分享</a></div><div class='clear'></div></div>");
                    $("#"+id).append("<div class='dressdetail'><span class='sl'><a href=''>"+v.username+"旗舰店</a></span><span class='sr'><em class='orange'>4795</em>人已开抢</span></div>");
                });
			}
		}
	});
	//主页面加载商品信息--end
});

	//鼠标经过图片 出现图片放大效果
	$(function() {
		var x = 10;
		var y = 20;
		$("a.tooltip")
				.mouseover(
						function(e) {
							this.myTitle = this.title;
							this.title = "";
							var imgTitle = this.myTitle ? "<br/>"
									+ this.myTitle : "";
							var tooltip = "<div id='tooltip'><img src='"+ this.href +"' alt='产品预览图'/>"
									+ imgTitle + "<\/div>"; //创建 div 元素
							$("body").append(tooltip); //把它追加到文档中						 
							$("#tooltip").css({
								"top" : (e.pageY + y) + "px",
								"left" : (e.pageX + x) + "px"
							}).show("fast"); //设置x坐标和y坐标，并且显示
						}).mouseout(function() {
					this.title = this.myTitle;
					$("#tooltip").remove(); //移除 
				}).mousemove(function(e) {
					$("#tooltip").css({
						"top" : (e.pageY + y) + "px",
						"left" : (e.pageX + x) + "px"
					});
				});
	});
    $("#searchSubmit").click(function(){
        var searchText = $("#searchText").val();
        $.ajax({
                type: "POST",
                async: false,
                url: "../springmvc_mybatis/items/findItemsByName.action",
                dataType: 'json',
                data: {itemname: searchText},
                success: function (data) {
                    if(data.msg=="SUCCESS"){
                        $("#findItemsByNameList").get(0).innerHTML = '';
                        $("#findItemsByNameList").show();
                        $("#itemList").hide();
                        $("#findItemsByClassList").hide();
                        if(data.list.length>0){
                            var id="";
                            /*这段代码需要注意，还有页面上的隐藏*/
				            $.each(data.list,function(k,v){
					           id="itemSearchList_"+k;
                                $("#findItemsByNameList").append("<div class='dress' id='"+id+"'><div class='dresspic picbox' ><a href='itemsDetail.jsp?itemsId="+v.id+"'><img src='"+v.pic+"'></a><div class='pictext'><div class='text'><a href=''>"+v.detail+"</a></div><div class='grayer'>原价：￥50</div></div></div></div>");
                                $("#"+id).append("<div class='dressprice'><div class='sl'><a href='' class='orange'><h3>￥</h3><h1>"+v.price+"</h1></a></div><div class='sr'><a href='' class='orange'>1.7折</a>&nbsp;<span>|</span>&nbsp;<a href=''>❤698</a>&nbsp;<span>|</span>&nbsp;<a href=''>分享</a></div><div class='clear'></div></div>");
                                $("#"+id).append("<div class='dressdetail'><span class='sl'><a href=''>"+v.username+"旗舰店</a></span><span class='sr'><em class='orange'>4795</em>人已开抢</span></div>");
                            });
                        }
                    }
                 }
        });
    });
</script>
</body>
</html>
