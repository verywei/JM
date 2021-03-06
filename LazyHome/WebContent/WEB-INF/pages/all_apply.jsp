<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>用户管理 /所有用户</title>

    <!-- Bootstrap CSS -->    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="css/elegant-icons-style.css" rel="stylesheet" />
    <link href="css/font-awesome.min.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
      <script src="js/lte-ie7.js"></script>
    <![endif]-->
  </head>

  <body>
  <!-- container section start -->
  <section id="container" class="">
      <!--header start-->
     <jsp:include page="header.jsp" flush="true"/><!--动态包含--> 

      <!--sidebar start-->
      <aside>
           <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu">                
                  <li class="active">
                      <a class="" href="index.html">
                          <i class="icon_house_alt"></i>
                          <span>主页</span>
                      </a>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon_document_alt"></i>
                          <span>用户管理</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="all_user.html">所有用户</a></li>
                          <li><a class="" href="lazy.html">懒人</a></li>                  
                          <li><a class="" href="bee.html">小蜜蜂</a></li>
                      </ul>
                  </li> 
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon_document_alt"></i>
                          <span>订单管理</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="all_order.html">全部订单</a></li>
                          <li><a class="" href="non_finished_order.html">未完成订单</a></li>                  
                          <li><a class="" href="finished_order.html">已完成订单</a></li>
                      </ul>
                  </li> 

                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon_document_alt"></i>
                          <span>小蜜蜂申请审核</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="all_apply.html">全部申请</a></li>
                          <li><a class="" href="passed_apply.html">已通过申请</a></li>
                          <li><a class="" href="non_passed_apply.html">被丑拒的申请</a></li>
                          <li><a class="" href="apply_ing.html">审核ing</a></li>                            
                      </ul>
                  </li> 

                   <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon_document_alt"></i>
                          <span>评论管理</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="all_comment.html">所有评论</a></li>
                          <li><a class="" href="all_reply.html">所有回复</a></li>
                      </ul>
                  </li> 
                </ul>
              </div>
               <!-- sidebar menu end-->
      </aside>
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
      <div class="row">
        <div class="col-lg-12">
          <h3 class="page-header"><i class="fa fa-table"></i>小蜜蜂申请审核</h3>
          <ol class="breadcrumb">
            <li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
            <li><i class="fa fa-table"></i>小蜜蜂申请审核</li>
            <li><i class="fa fa-th-list"></i>所有申请</li>
          </ol>
        </div>
      </div>
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                              所有申请
                          </header>
                          <table class="table table-striped table-advance table-hover">
                           <tbody>
                              <tr>
                                 <th><i class="icon_profile"></i>id</th>
                                 <th><i class="icon_profile"></i>申请人用户名</th>
                                 <th><i class="icon_calendar"></i>申请时间</th>
                                 <th><i class="icon_mail_alt"></i>申请人邮箱</th>
                                 <th><i class="icon_mobile"></i>申请人手机号</th>
                                 <th><i class="icon_cogs"></i>状态</th>
                              </tr>
                              <tr>
                                 <td><a href="user.html">201513138054</a></td>
                                 <td><a href="user.html">lr</a></td>
                                 <td>2017-11-14</td>
                                 <td>8023@qq.com</td>
                                 <td>13260523446</td>   
                                 <td>
                                  <div class="btn-group">
                                     <!--  <a class="btn btn-primary" href="#"><i class="icon_plus_alt2"></i></a> -->
                                      <a class="btn btn-info" href="#">审核中</a>
                                      
                                  </div>
                                  </td>
                              </tr>
                              <tr>
                                 <td><a href="user.html">201513138059</a></td>
                                 <td><a href="user.html">jm</a></td>
                                 <td>2017-11-12</td>
                                 <td>2633475631@qq.com</td>
                                 <td>13260523458</td>   
                                 <td>
                                  <div class="btn-group">
                                     <!--  <a class="btn btn-primary" href="#"><i class="icon_plus_alt2"></i></a> -->
                                     
                                      <a class="btn btn-warning" href="#">被丑拒</a>
                                  </td>
                              </tr>
                              <tr>
                                 <td><a href="user.html">201513138054</a></td>
                                 <td><a href="user.html">hyj</a></td>
                                 <td>2017-11-13</td>
                                 <td>23333@qq.com</td>
                                 <td>13260523484</td>   
                                 <td>
                                  <div class="btn-group">
                                     <!--  <a class="btn btn-primary" href="#"><i class="icon_plus_alt2"></i></a> -->
                                      <a class="btn btn-success" href="#">已通过</a>
                                     
                                  </div>
                                  </td>
                              </tr>                          
                           </tbody>
                         </table>
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
  </section>
  <!-- container section end -->
    <div>
      <ul class="pagination pagination-sm pull-right">
          <li><a href="#">«</a></li>
          <li><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">3</a></li>
          <li><a href="#">4</a></li>
          <li><a href="#">5</a></li>
          <li><a href="#">»</a></li>
      </ul>
    </div>
    <!-- javascripts -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- nicescroll -->
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <!--custome script for all page-->
    <script src="js/scripts.js"></script>


  </body>
</html>
