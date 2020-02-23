<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>评论管理 /所有回复</title>

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
    <header class="header dark-bg">
            <div class="toggle-nav">
                <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"></div>
            </div>

            <!--logo start-->
            <a href="index.html" class="logo">LAZYHOME <span class="lite">Admin</span></a>
            <!--logo end-->

            <div class="nav search-row" id="top_menu">
                <!--  search form start -->
                <ul class="nav top-menu">                    
                    <li>
                        <form class="navbar-form">
                            <input class="form-control" placeholder="Search" type="text">
                        </form>
                    </li>                    
                </ul>
                <!--  search form end -->                
            </div>

            <div class="top-nav notification-row">                
                <!-- notificatoin dropdown start-->
                <ul class="nav pull-right top-menu">
                    <!-- user login dropdown start-->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
                                <img alt="" src="img/avatar1_small.jpg">
                            </span>
                            <span class="username">Jenifer Smith</span>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu extended logout">
                            <li>
                                <a href="login.html"><i class="icon_key_alt"></i> Log Out</a>
                            </li>
                        </ul>
                    </li>
                    <!-- user login dropdown end -->
                </ul>
                <!-- notificatoin dropdown end-->
            </div>
      </header> 
      <!--header end-->

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
            <table class="table table-striped">
                <tr>
                    <td class="col-md-2">id</td>
                    <td class="col-md-10">20111111</td>
                </tr>
                <tr>
                    <td class="col-md-2"><a href="user.html">评论人</a></td>
                    <td class="col-md-10">大人</td>
                </tr>
                <tr>
                    <td class="col-md-2"><a href="user.html">被评论人</a></td>
                    <td class="col-md-10">小
                    人</td>
                </tr>
                <tr>
                    <td class="col-md-2">评论时间</td>
                    <td class="col-md-10">2017-11-17</td>
                </tr>
                <tr>
                    <td class="col-md-2">评论内容</td>
                    <td class="col-md-10">很帅的小姐姐</td>
                </tr>
            </table>

              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
  </section>
  <!-- container section end -->
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
