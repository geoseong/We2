<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�������Խ���</title>
<link rel="stylesheet" href="../css/board.css" type="text/css">
</head>
<body>
    
<div id="bo_list">
    <!-- �Խ��� ī�װ� ���� { -->
    <!-- �Խ��� ������ ���� �� ��ư ���� { -->
    
        <div align="center">
            <span>Total xxx��</span>
            1 ������
        </div>
 
 
    <!-- } �Խ��� ������ ���� �� ��ư �� -->
   
    <div>
        <table class="border-style">
        <caption>�Խ��� ���</caption>
        
        <thead>
        <tr>
            <th>��ȣ</th>
            <th>����</th>
            <th>�۾���</th>
            <th>��¥</th>
            <th>��ȸ</th>
        </tr>
        </thead>
        
        <tbody>
          <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    �Ŵ�����!!
                </a>
            </td>
            <td><span>���԰�����</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>
          <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    �Ŵ�����!!
                </a>
            </td>
            <td><span>���԰�����</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>
           <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    �Ŵ�����!!
                </a>
            </td>
            <td><span>���԰�����</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>
           <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    �Ŵ�����!!
                </a>
            </td>
            <td><span>���԰�����</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>
           <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    �Ŵ�����!!
                </a>
            </td>
            <td><span>���԰�����</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>
           <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    �Ŵ�����!!
                </a>
            </td>
            <td><span>���԰�����</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>
           <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    �Ŵ�����!!
                </a>
            </td>
            <td><span>���԰�����</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>
           <tr>
            <td class="align-center">
            1            
            </td>
            <td>
                <a href="#">
                    �Ŵ�����!!
                </a>
            </td>
            <td><span>���԰�����</span></td>
            <td>04.10</td>
            <td class="align-center">1</td>
          </tr>         
         </tbody>
        </table>
    </div>      
</div>
 
<!-- �Խ��� �˻� ���� { -->
<form action="list.do" name="search" method="get" onsubmit="return seachCheck()">
    <table class="search">
        <tr>
            <td>
                <select name="keyField">
                    <option value="title">����</option>
                    <option value="writer">�̸�</option>
                    <option value="content">����</option>
                    <option value="all">��ü</option>
                </select>
            </td>
            <td>
                <input type="text" size="16" name="keyWord">
            </td>
            <td>
                <input type="submit" value="ã��" class="inputb">
            </td>
        </tr>
    </table>
</form>
<!-- ����¡����-->
<table>
    <tr>
        <td class="align-right"><input type="button" value="�۾���" class="inputb" onclick="location.href='#'"></td>
    </tr>
</table>    
</body>
</html>
