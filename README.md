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
