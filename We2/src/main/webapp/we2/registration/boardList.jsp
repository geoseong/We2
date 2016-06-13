<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>스프링게시판</title>
<link rel="stylesheet" href="../css/board.css" type="text/css">
</head>
<body>
    
<div id="bo_list">
    <!-- 게시판 카테고리 시작 { -->
    <!-- 게시판 페이지 정보 및 버튼 시작 { -->
    
        <div align="center">
            <span>Total xxx건</span>
            1 페이지
        </div>
 
 
    <!-- } 게시판 페이지 정보 및 버튼 끝 -->
   
    <div>
        <table class="border-style">
        <caption>게시판 목록</caption>
        
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>글쓴이</th>
            <th>날짜</th>
            <th>조회</th>
        </tr>
        </thead>
        
        <tbody>
          <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    매니저님!!
                </a>
            </td>
            <td><span>신입개발자</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>
          <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    매니저님!!
                </a>
            </td>
            <td><span>신입개발자</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>
           <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    매니저님!!
                </a>
            </td>
            <td><span>신입개발자</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>
           <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    매니저님!!
                </a>
            </td>
            <td><span>신입개발자</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>
           <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    매니저님!!
                </a>
            </td>
            <td><span>신입개발자</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>
           <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    매니저님!!
                </a>
            </td>
            <td><span>신입개발자</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>
           <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    매니저님!!
                </a>
            </td>
            <td><span>신입개발자</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>
           <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    매니저님!!
                </a>
            </td>
            <td><span>신입개발자</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>         
         </tbody>
        </table>
    </div>      
</div>
 
<!-- 게시판 검색 시작 { -->
<form action="list.do" name="search" method="get" onsubmit="return seachCheck()">
    <table class="search">
        <tr>
            <td>
                <select name="keyField">
                    <option value="title">제목</option>
                    <option value="writer">이름</option>
                    <option value="content">내용</option>
                    <option value="all">전체</option>
                </select>
            </td>
            <td>
                <input type="text" size="16" name="keyWord">
            </td>
            <td>
                <input type="submit" value="찾기" class="inputb">
            </td>
        </tr>
    </table>
</form>
<!-- 페이징공간-->
<table>
    <tr>
        <td class="align-right"><input type="button" value="글쓰기" class="inputb" onclick="location.href='#'"></td>
    </tr>
</table>    
</body>
</html>
