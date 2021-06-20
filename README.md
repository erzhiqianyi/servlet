# servlet
Learning Servlet

## 为什么需要在 ```web.xml``` 配置 ```servlet``` 和 ```servlet-mapping```
```servlet``` 规范

## Servlet 如何在容器中运行
### 为什么需要容器
- 创建servlet
- 处理请求
- 管理servlet生命周期

### Web容器是什么
运行 ```servlet``` 的 ```java``` 应用


### 容器能做什么
- 通信支持
专注于业务逻辑

- 生命周期管理
管理 ```servlet``` 生命周期

- 多线程支持
自动创建线程处理请求

- 声明式的权限处理

### 容器如何处理请求
1. 监听端口
2. 发现请求,创建 ```HttpServletResponse``` 和 ```HttpServletRequest```
3. 根据 ```url``` 查找对应的 ```servlet```,为```servlet```创建或分配线程 , 将```HttpServletResponse``` 和 ```HttpServletRequest``` 传递给线程
4. 容器调用 ``service()``` 方法来处理请求,如 ```doGet()```,```doPost()```,```doPut()```,```doDelete()``` 等。
5. ```servlet``` 进行业务处理

### 常用 ```web``` 容器
#### tomcat

## Servlet 技术模型

### 1. 定义 HTTP Methods 并匹配到相应 ```HttpServlet Method```
- 定义```HTTP Method``` 及相应协议
- 定义```HTTP Method``` 触发机制 
- 将请求匹配到相应 ```HttpServlet Methhod```

### 2. 使用 ```HttpServletRequest``` 接口接收请求信息 
- 接收 ```Http``` 请求参数
- 接收请求头信息
- 接收请求cookies等

### 3. 使用 ```HttpServletResponse``` 接口设置返回信息
- 设置响应码
- 设置响应类型
- 设置响应内容
- 重定向请求
- 设置响应coookies等

### 定义管理 ```Servlet``` 生命周期
- 加载 ```Servelet``` 类
- 实例化 ```Servlet```
- 调用 ```init()```` 初始化servlet 
```Servlet``` 创建后, 加载自定义数据
- 调用 ```service()``` 执行响应请求
根据 ```HTTP Method```,分发到响应方法进行处理
doGet(),处理 ```GET```请求
doPost(),处理 ```POST```请求
doPut(),处理 ```PUT```请求
doDelete(),处理 ```DELETE```请求
- 调用 ```destroy()``` 进行销毁

## 普通类如何成为 ```Servlet``` 
容器初始化 ```Servlet``` 时，会传 ```ServletConfig``` 给 ```Servlet```, 使普通类成为 ```Servlet```.

### ```ServletConfig``` 和 ```ServletContext``` 的区别

| 类型           | 作用域                                        | 作用                            | 可达对象                  | 参数配置位置            |
| -------------- | --------------------------------------------- | ------------------------------- | ------------------------- | ----------------------- |
| ServletConfig  | 一个 ```Servlet``` 一个 ```ServletConfig```   | 传递发布配置给 ```Servlet``` \| | 获取 ```ServletContext``` | 在 ```web.xml``` 中配置 |
| ServletContext | 一个 ```web appp``` 一个 ```ServletContext``` | 获取 ```web appp``` 相关参数    | 应用相关信息,容器信息     | 在 ```web.xml``` 中配置 |


##  ```Servlet``` 输出类型类型
### characters 
使用 ```PrintWrite``` 输出文本

```java
PrintWriter writer = reponse.getWriter();
writer.println(" Some text and HTML")
``` 
### bytes
使用 ```OutputStream``` 输出字节流
```java
ServletOutputStream out = resp.getOutputStream();
out.write(byteArray);
```

## 设置响应头
用 ```setHeader()```  或 ```addHeader``` 设置响应头

- setHeader  
覆盖原来的值

- addHeader 
可以添加多个值

## 重定向路径配置区别
使用 ```sendRedirect()```,进行重定向.
流写入之后，不能再重定向

有没有 ```/``` 的区别
- 没有 ```/``` 
根路径当前web项目根路径

- 有 ```/``` 
根路径为当前容器根路径

## ```dislpatch```和 ```redirect``` 区别
- ```dislpatch```
服务端处理,客户端 ```URL``` 不变

- ```redirect``` 
客户端处理,客户端 ```URL``` 会变化


 
## ```Web``` 容器模型
### 1. 处理 ```Servlet``` 和 ```ServletContext```   初始化参数
将 ```web.xml``` 中的发布参数写入到对应的  ```Servlet``` 配置中

### 2. 处理 ```Serlvet``` 作用域参数
处理不同作用域参数,包括 ```request```、 ```session```、 ```context``` 参数。

### 3. 描述 ```Web``` 容器请求处理模型
处理 ```Filter``` ,```Filter Chain``` ,```Request``` 和  ```Response```  包装器, ```Web(Serlet 或JSP)``` 资源

### 4.  处理```Web``` 容器生命周期事件
处理   ```request``` , ```sessions``` 和 ```Web``` 应用的生命周期事件，创建配置相应监听器

### 5. 描述请求处理机制
将请求和 ```Servet``` 绑定，查找 ```Servlet``` 对应的资源,配置请求到目标资源的请求参数


## Servlet 配置初始化参数
只有 ```Servlet``` 初始化完成后才能获取相应参数.
容器初始化```Servlet``` 时，加载相应参数，只加载一次。

- 配置初始化参数
在 ```web.xml``` 中使用 ```<init-param>``` 配置参数 
```xml
    <servlet>
        <servlet-name>ServletName</servlet-name>
        <servlet-class>ServletClass</servlet-class>
        <init-param>
            <param-name>ParamName</param-name>
            <param-value>ParamValue</param-value>
        </init-param>
    </servlet>
```
- 读取初始化参数
在 ```servlet``` 中获取相应参数,
```getServletConfig()``` 获取  ```ServletConfig```,通过 ```ServletConfig``` 获取相应参数 ```getInitParameter()``` 。

## 配置上下文初始化参数 
在 ```web.xml```中配置，整个 ```web app ```都可以使用。

- 配置初始化参数
使用 ```<context-param>``` 配置参数
```xml
    <context-param>
        <param-name>ContextParamName</param-name>
        <param-value>ContextParamValue</param-value>
    </context-param>
```

- 读取初始化参数
获取到 ```ServletContext``` ,再通过 ```ServletContext```  获取相应参数
```java
getServletContext().getInitParameter(ContextParamName);
```

## 监听器的作用
监听状态变化，发生指定事件时，产生行为。

### 8大监听器
- ServletContextAttributeListener  
  监听 ``WebContext``` 的属性状态变化,包括添加,删除和替换.
  
- HttpSessionListener 
  监听 ```Session````状态变化
  
- ServletRequestListener 
  监听请求状态变化,包括请求初始化和销毁
  
- ServletRequestAttributeListener
  监听请求属性状态变化,包括添加,删除和替换
  
- HttpSessionBindingListener
  监听```session```中数据绑定事件i

- HttpSessionAttributeListener
  监听 ```session``` 属性状态变化,包括添加,删除和替换
  
- ServletContextListener 
  监听```ServletContext``` 状态变化,包括初始化和销毁
 
- HttpSessionActivationListener  
  监听```session```在jvm状态中的变化

### 三大作用域
- Context
  应用内都可以使用,非线程安全
- Request
  只有特定 ```ServletRequest``` 才能访问
- Session
  只有特定 ```HttpSession``` 才能访问
  
## Session 如何工作
1. 请求到达容器,容器处理完后,返回一个独一无二的 ```session id``` 给客户端
2. 客户端请求时,带上 ```session id``` 
3. 容器根据 ```session id```查找对应数据