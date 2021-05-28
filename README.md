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

|类型|作用域|作用|可达对象|参数配置位置|
|--|--|--|
|ServletConfig|一个 ```Servlet``` 一个 ```ServletConfig```|传递发布配置给 ```Servlet``` |获取 ```ServletContext```|在 ```web.xml``` 中配置|
|ServletContext|一个 ```web appp``` 一个 ```ServletContext```|获取 ```web appp``` 相关参数|应用相关信息,容器信息|在 ```web.xml``` 中配置|

