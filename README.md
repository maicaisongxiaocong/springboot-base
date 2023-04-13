#集成springboot常见功能 mybatis plus + swagger2 + jwt + shiro + redis +  Log4j + 日常错误抛出  + 统一返回结果封装

## 搭建过程见下链接：

https://blog.csdn.net/chenpeiyanbing/article/details/130141070?spm=1001.2014.3001.5502

## 适应你自己的项目需要修改的地方

1: plication.yml中mysql和redis改成你自己
![image](https://user-images.githubusercontent.com/113015852/231783188-ec51f0a2-d6b0-444a-9bf2-35e40a9d0bbb.png)

2: plication.yml中swagger文档改成你自己的项目说明
![image](https://user-images.githubusercontent.com/113015852/231783520-36422af0-10ca-4480-9618-ee04ea26131c.png)

3: logback-spring.xml 中默认日志的位置
![image](https://user-images.githubusercontent.com/113015852/231783940-bbcc625a-694e-4025-8fc5-103fd2a105e7.png)

4：UserController.java中将用户信息改为从你自己的数据库里查找
![image](https://user-images.githubusercontent.com/113015852/231786982-a9bb2a2e-19d4-4dcd-8652-fc2cd2518e40.png)

 另外的想到了再加上吧，目前就想到这些。
 data：2023/4/13
