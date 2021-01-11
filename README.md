# cloud2020

一个微服务架构项目，目前整合了Eureka、Zookeeper、Consul等注册中心，Ribbon、OpenFeign负载均衡调用，Hystrix熔断器、Gateway 网关、SpringCloud Config 分布式配置中心、SpringCloud Bus 消息总线..

写该项目做的笔记：[SpringCloud 01 - 基础理论](https://blog.csdn.net/weixin_44210965/article/details/105800536)


# 一、Maven简介
### 1.Maven是什么
 - Maven是基于项目对象模型(POM project object model)，可以通过一小段描述信息（配置）来管理项目的构建，报告和文档的软件项目管理工具
 - 通过pom.xml文件的配置获取jar包，而不用手动去添加jar包
 - 合理叙述项目间的依赖关系


### 2.Maven下载安装
- [Maven下载地址](http://maven.apache.org/download.cgi)
- 安装：直接解压就可以，放在指定目录。后期写项目时选中这个文件夹。
- Maven环境变量配置（配置的目的：在任何地方都能够运行mvn命令）：
		配置两个：一个Home，一个home/bin
		![在这里插入图片描述](https://img-blog.csdnimg.cn/20190412194954716.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
	![在这里插入图片描述](https://img-blog.csdnimg.cn/20190412195149774.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
配置好后打开命令输入mvn -v查看结果，出来maven的版本号即是配置好了。
# 二、Maven使用
### 1.Maven规定了一套默认的项目格式
- src/main/java：存放项目的.java文件
- src/main/resources：存放项目资源文件，如spring、struts2配置文件，db.properties
- src/main/webapp：存放jsp，css，image等文件
- src/test/java：存放所有测试.java文件，如JUnit测试类
- src/test/resources：测试资源文件
- pom.xml：主要要写的maven配置文件
- target：项目由maven自动输出位置


### 2.创建第一个maven项目（idea中）
（首先确定已安装了maven插件）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190412195932554.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413094404797.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190412200529607.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190412205935767.png)
项目创建好后再设置中设置maven路径：
![在这创建好香楠木里插入图片描述](https://img-blog.csdnimg.cn/2019041220064483.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
添加maven依赖jar包：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190412201127625.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70 )
之前写项目要自己导包，有了maven之后就不用导包了，需要什么包在pom.xml中配置，如上图。配置信息在哪找：[Maven Repositiory](https://mvnrepository.com/tags/maven)，在maven数据仓库中搜索
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190412201811679.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190412201906797.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190412202010502.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190412202126597.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
### 3. maven仓库
- Maven所有的Jar包都是放到maven仓库当中
- 在项目当中是对仓库jar包的引用
- Maven仓库
	本地仓库：本地存放jar的目录
	私服：私人搭建的服务器,一般在企业内部局域网使用
	中央仓库：Maven内置了一个远程仓库的地址,它就是中央仓库
- Maven找jar包的过程
	Maven查找引入jar包时, 会先到本地仓库当中查找,没有找到现到私服中找,也没有就去到远程中央仓库查找，找到后会下载到本地仓库,下次就不用到远程仓库了。最终都会把jar包下载到本地仓库。Maven工程最终引用的都是本地的jar包

- 本地仓库目录地址
	默认本地仓库（c盘用户下.m2的文件夹中）：
	![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413002527228.png)
		
	修改本地仓库：
		*a)把maven安装目录config中setting.xml复制一份到.m2文件夹下
		![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413002806235.png)
		b)打开setting.xml修改本地仓库地址*
		![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413002948151.png)
- 配置阿里云镜像：
（在刚刚的settings.xml当中配置）

```
<mirror>
      <id>alimaven</id>
      <mirrorOf>central</mirrorOf>
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
</mirror>
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413003720425.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
			
- jar包的坐标：组织、项目、版本		


### 4. maven常用命令
- validate：确保当前配置和 POM 的内容是有效的
- clean：删除target目录下及其目录下的所有内
- mvn compile：将java文件编译成二进制放到target目录当中
- test：运行测试用例
- package：打包工程
- install：把 maven 打成的包发布到本地仓库当中

**后一个命令执行时, 前面命令都会执行**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413004352662.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
### 5.Maven的作用范围
- compile
	默认值 他表示被依赖项目需要参与当前项目的编译，还有后续的测试，运行周期也参与其中，是一个比较强的依赖。打包的时候通常需要包含进去
- test
	依赖项目仅仅参与测试相关的工作，包括测试代码的编译和执行，不会被打包，例如：junit
- runtime
	表示被依赖项目无需参与项目的编译，不过后期的测试和运行周期需要其参与。与compile相比，跳过了编译而已。例如JDBC驱动，适用运行和测试阶段
- provided
	打包的时候可以不用包进去，别的设施会提供。事实上该依赖理论上可以参与编译，测试，运行等周期。相当于compile，但是打包阶段做了exclude操作
-  system
	从参与度来说，和provided相同，不过被依赖项不会从maven仓库下载，而是从本地文件系统拿。需要添加systemPath的属性来定义路径





# 三、Maven-SSM整合三层架构
### 1. 创建web工程
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413094058796.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413094502542.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019041309462827.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
- 注意事项
	generating project in batch mode 很慢,是因为maven获取archetype-catalog.xml导致用浏览器打开http://repo1.maven.org/maven2/archetype-catalog.xml很慢
- 解决方法： 在用maven创建项目时在properties中添加 archetypeCatalog=internal,让maven读取本地配置即可

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413094920951.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
 -     archetypeCatalog=internal
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413095006103.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
自动导入jar包
![项目进去以后选择自动导入](https://img-blog.csdnimg.cn/20190413095129580.png)
- 检查一下路径是否正确
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413110129748.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)

-  新建文件夹，并标记文件夹
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413100936103.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413100704823.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)

### 2.安装tomcat插件
（pom.xml中）

```xml
 	<plugins>
	      <plugin>
	        <groupId>org.apache.tomcat.maven</groupId>
	        <artifactId>tomcat7-maven-plugin</artifactId>
	        <version>2.2</version>
	        <configuration>
	          <port>8081</port>
	          <path>/</path>
	        </configuration>  
	      </plugin>
	 </plugins>

```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413095940926.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
（tomcat插件不支持热部署，需要自己rebuild：Ctrl+F9）

### 3. 添加代码生成器
- 添加代码生成器插件pom依赖
```xml
  	<plugins>
          <plugin>
              <groupId>org.mybatis.generator</groupId>
              <artifactId>mybatis-generator-maven-plugin</artifactId>
              <version>1.3.2</version>
              <configuration>
                  <verbose>true</verbose>
                  <overwrite>false</overwrite>
              </configuration>
              <dependencies>
                  <dependency>
                      <groupId>mysql</groupId>
                      <artifactId>mysql-connector-java</artifactId>
                      <version>5.1.21</version>
                  </dependency>
              </dependencies>
          </plugin>
	 </plugins>

```
添加之后会有插件生成
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019041311275484.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)
- 添加代码生成器配置文件(可以直接复制这个文件到项目中的resources中，也可自己新建，附录为源代码)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413100244786.png)


### 4. SSM框架集成
- 添加依赖（我这里添加了几个要用的）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413111855769.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDIxMDk2NQ==,size_16,color_FFFFFF,t_70)

```xml
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>

    <!--定义版本号   ${org.springframework.version}-->
    <org.springframework.version>5.0.7.RELEASE</org.springframework.version>
    <org.mybatis.version>3.4.6</org.mybatis.version>

  </properties>

  <dependencies>

    <!--单元测试-->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
    <!--lombok-->
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.16.6</version>
    </dependency>
    <!-- servlet-api -->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
      <scope>provided</scope>
    </dependency>
    <!--mysql驱动-->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.1.21</version>
    </dependency>
    <!-- druid -->
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>1.0.14</version>
    </dependency>
    <!-- common-lang -->
    <dependency>
      <groupId>commons-lang</groupId>
      <artifactId>commons-lang</artifactId>
      <version>2.6</version>
    </dependency>
    <!--spring-test-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>${org.springframework.version}</version>
      <scope>test</scope>
    </dependency>
    <!--spring-core-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>${org.springframework.version}</version>
    </dependency>
    <!--spring-context-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>${org.springframework.version}</version>
    </dependency>
    <!--spring-context-support-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context-support</artifactId>
      <version>${org.springframework.version}</version>
    </dependency>
    <!--spring-expression-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-expression</artifactId>
      <version>${org.springframework.version}</version>
    </dependency>
    <!--spring-jdbc-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>${org.springframework.version}</version>
    </dependency>
    <!--spring-tx-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-tx</artifactId>
      <version>${org.springframework.version}</version>
    </dependency>
    <!--spring-web-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>${org.springframework.version}</version>
    </dependency>
    <!--spring-aop-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>${org.springframework.version}</version>
    </dependency>
    <!--spring-webmvc-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>${org.springframework.version}</version>
    </dependency>

    <!-- aspectj -->
    <dependency>
      <groupId>org.aspectj</groupId>
      <artifactId>aspectjrt</artifactId>
      <version>1.7.4</version>
    </dependency>
    <!--aspectj weaver-->
    <dependency>
      <groupId>org.aspectj</groupId>
      <artifactId>aspectjweaver</artifactId>
      <version>1.7.4</version>
    </dependency>

    <!-- cglib -->
    <dependency>
      <groupId>cglib</groupId>
      <artifactId>cglib</artifactId>
      <version>3.1</version>
    </dependency>

    <!-- mybatis -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>${org.mybatis.version}</version>
    </dependency>
    <!--mybatis-spring-->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>1.3.0</version>
    </dependency>

    <!-- jackson-core -->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.9.4</version>
    </dependency>
    <!--jackson-databind-->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.9.4</version>
    </dependency>
    <!--jackson-annotations-->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
      <version>2.9.4</version>
    </dependency>

    <!--slf4j-api-->
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>1.7.6</version>
    </dependency>
    <!--slf4j-log4j12-->
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-log4j12</artifactId>
      <version>1.7.6</version>
    </dependency>
    <!--log4j-->
    <dependency>
      <groupId>log4j</groupId>
      <artifactId>log4j</artifactId>
      <version>1.2.17</version>
    </dependency>
    <!--commons-fileupload-->
    <dependency>
      <groupId>commons-fileupload</groupId>
      <artifactId>commons-fileupload</artifactId>
      <version>1.3.1</version>
    </dependency>
    <!-- jstl -->
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
    <!-- standard -->
    <dependency>
      <groupId>taglibs</groupId>
      <artifactId>standard</artifactId>
      <version>1.1.2</version>
    </dependency>
    <!--pagehelper-->
    <dependency>
      <groupId>com.github.pagehelper</groupId>
      <artifactId>pagehelper</artifactId>
      <version>4.1.4</version>
    </dependency>
  </dependencies>


```


- 添加配置文件（见附录）
（maven的web工程中，所有的xml文件都必须放在main.resources中）
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413102820482.png)
- 在webapp中新建views的文件夹
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413133427468.png)
- 配置web.xml

```xml

  <!--配置前端控制器-->

  <servlet>

    <servlet-name>SpringMVC</servlet-name>

    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>

    <init-param>

      <param-name>contextConfigLocation</param-name>

      <!--加载的主配置文件-->

      <param-value>classpath:applicationContext.xml</param-value>

    </init-param>

    <!-- 项目启动就加载框架 -->

    <load-on-startup>1</load-on-startup>

  </servlet>

  <servlet-mapping>

    <servlet-name>SpringMVC</servlet-name>

    <url-pattern>/</url-pattern>

  </servlet-mapping>

  <!-- 编码过滤器 -->

  <filter>

    <filter-name>CharacterEncoding</filter-name>

    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>

    <init-param>

      <param-name>encoding</param-name>

      <param-value>utf-8</param-value>

    </init-param>

  </filter>

  <filter-mapping>

    <filter-name>CharacterEncoding</filter-name>

    <url-pattern>/*</url-pattern>

  </filter-mapping>
```
- 第一次运行 
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413134714615.png)
（如果没出来可能是配置文件出错了哦!）
-----------
太累了，后期更新~



## 附录
 1. db.properties（连接数据库的配置文件）

```properties
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8
jdbc.username=root
jdbc.password=1234
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190413132958801.png)
 		
2. applicationContext.xml（spring框架配置文件）

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
    http://www.springframework.org/schema/aop
    http://www.springframework.org/schema/aop/spring-aop.xsd
     http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd
">
    <!--注解扫描-->
    <context:component-scan base-package="com.lyd"/>
    <!--导入mybatis-->
    <import resource="classpath:application-mybatis.xml"/>

    <!--导入springMVC-->
    <import resource="classpath:application-mvc.xml"/>


</beans>
```

3. application-mvc.xml（SpringMVC配置文件）

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
	http://www.springframework.org/schema/beans/spring-beans.xsd
	http://www.springframework.org/schema/context
	http://www.springframework.org/schema/context/spring-context.xsd
	http://www.springframework.org/schema/mvc
    http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd
	">

    <mvc:annotation-driven />
    <!--静态资源处理 -->
    <mvc:default-servlet-handler/>
    <!--视图解析器 -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/views/"/>
        <property name="suffix" value=".jsp" />
    </bean>

</beans>
```

4. application-mybatis.xml（Mybatis框架配置文件）

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
    http://www.springframework.org/schema/aop
    http://www.springframework.org/schema/aop/spring-aop.xsd
     http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd
">

    <!--spring-Mybatis整合-->
    <!--加载数据库属性文件-->
    <context:property-placeholder location="classpath:db.properties"/>
    <!--连接池-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}" />
        <!--属性文件当中的名称不能和name名称一样-->
        <property name="url" value="${jdbc.url}" />
        <property name="username" value="${jdbc.username}" />
        <property name="password" value="${jdbc.password}" />
    </bean>
    <!-- 配置事务管理器 -->
    <bean id="transactionManager"
          class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <!-- 数据源 -->
        <property name="dataSource" ref="dataSource" />
    </bean>
    <!-- 开启注解事务 -->
    <tx:annotation-driven transaction-manager="transactionManager"/>

    <!-- Mybatis的工厂 -->
    <bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <!-- 核心配置文件的位置 -->
        <property name="configLocation" value="classpath:sqlMapConfig.xml"/>
        <!--配置mapper映射文件的路径-->
        <!--<property name="mapperLocations" value="classpath:com.lyd.mapper/*Mapper.xml"/>-->
    </bean>

    <!-- 配置Mapper接口扫描 -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!-- 配置Mapper扫描包 -->
        <property name="basePackage" value="com.lyd.mapper" />
    </bean>

</beans>
```

6. sqlMapConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>
    <typeAliases>
        <!-- 批量别名定义，扫描整个包下的类，别名为类名（大小写不敏感） -->
        <package name="com.lyd.domain" />
    </typeAliases>
    <plugins>
        <plugin interceptor="com.github.pagehelper.PageHelper"></plugin>
    </plugins>
</configuration>
```

 7. generatorConfig.xml（代码生成器配置文件）

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
		PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
		"http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<!-- 配置生成器 -->
<generatorConfiguration>

	<context id="mysql" defaultModelType="hierarchical"
			 targetRuntime="MyBatis3Simple">

		<!-- 自动识别数据库关键字，
		默认false，如果设置为true，
		根据SqlReservedWords中定义的关键字列表；
		一般保留默认值，
		遇到数据库关键字（Java关键字），
		使用columnOverride覆盖 -->
		<property name="autoDelimitKeywords" value="false" />
		<!-- 生成的Java文件的编码 -->
		<property name="javaFileEncoding" value="UTF-8" />
		<!-- 格式化java代码 -->
		<property name="javaFormatter"
				  value="org.mybatis.generator.api.dom.DefaultJavaFormatter" />
		<!-- 格式化XML代码 -->
		<property name="xmlFormatter"
				  value="org.mybatis.generator.api.dom.DefaultXmlFormatter" />

		<!-- beginningDelimiter和endingDelimiter：指明数据库的用于标记数据库对象名的符号，
		比如ORACLE就是双引号，MYSQL默认是`反引号； -->
		<property name="beginningDelimiter" value="`" />
		<property name="endingDelimiter" value="`" />

		<!--阻止生成日期和注释-->
		<commentGenerator>
			<property name="suppressDate" value="true" />
			<property name="suppressAllComments" value="true" />
		</commentGenerator>

		<!-- 数据库连接信息 -->
		<jdbcConnection driverClass="com.mysql.jdbc.Driver"
						connectionURL="jdbc:mysql:///mybatis" userId="root" password="1234">
		</jdbcConnection>

		<!-- java类型处理器 用于处理数据库中的类型到Java中的类型，
			 默认使用JavaTypeResolverDefaultImpl；
			 注意一点，默认会先尝试使用Integer，Long，Short等来对应DECIMAL和
			NUMERIC数据类型； -->
		<javaTypeResolver
				type="org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl">
			<!-- true：使用BigDecimal对应DECIMAL和 NUMERIC数据类型 f
				 alse：默认, scale>0;length>18：使用BigDecimal;
				scale=0;length[10,18]：使用Long； scale=0;length[5,9]：
				使用Integer； scale=0;length<5：使用Short； -->
			<property name="forceBigDecimals" value="false" />
		</javaTypeResolver>


		<!--
		配置domain生成策略
        targetProject:把自动生成的domian放在哪个工程里面
        targetPackage:哪个包下
		-->
		<javaModelGenerator targetPackage="com.lyd.domain"
							targetProject="src/main/java">
			<!-- for MyBatis3/MyBatis3Simple
			自动为每一个生成的类创建一个构造方法，
			构造方法包含了所有的field；而不是使用setter； -->
			<property name="constructorBased" value="false" />

			<!-- for MyBatis3 / MyBatis3Simple
			是否创建一个不可变的类，如果为true，
			那么MBG会创建一个没有setter方法的类，
			取而代之的是类似constructorBased的类 -->
			<property name="immutable" value="false" />

			<!-- 设置是否在getter方法中，
			对String类型字段调用trim()方法 -->
			<property name="trimStrings" value="true" />
		</javaModelGenerator>

		<!--
            配置mapper.xml的生成策略
            targetPackage:把自动生成的mapper放在哪个工程里面
            targetProject:哪个包下
        -->
		<sqlMapGenerator targetPackage="com.lyd.mapper"
						 targetProject="src/main/java">
			<!-- 在targetPackage的基础上，
			根据数据库的schema再生成一层package，
			最终生成的类放在这个package下，默认为false -->
			<property name="enableSubPackages" value="true" />
		</sqlMapGenerator>

		<!--
           mapper接口生成策略
        -->
		<javaClientGenerator targetPackage="com.lyd.mapper"
							 type="XMLMAPPER" targetProject="src/main/java">
			<property name="enableSubPackages" value="true" />
		</javaClientGenerator>

		<table tableName="teacher"></table>

	</context>
</generatorConfiguration>
```

 8. web.xml

```xml
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
                      http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
         version="3.0"
         metadata-complete="false">
  <absolute-ordering/>
  <display-name>web</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>

  <!--配置前端控制器-->
  <servlet>
    <servlet-name>SpringMVC</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <!--加载的主配置文件-->
      <param-value>classpath:applicationContext.xml</param-value>
    </init-param>
    <!-- 项目启动就加载框架 -->
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>SpringMVC</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
  <!-- 编码过滤器 -->
  <filter>
    <filter-name>CharacterEncoding</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>utf-8</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>CharacterEncoding</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>

</web-app>

```

