# DongdongMall
东东商城项目

## API 文档

启动 Nacos、商品服务和网关后，打开 [Swagger UI](http://localhost:10010/swagger-ui.html) 查看并调试商品服务接口。网关转发的商品服务 OpenAPI JSON 地址为 `http://localhost:10010/shop-goods-service/v3/api-docs`。

只启动商品服务时，可直接访问 OpenAPI JSON：`http://localhost:8081/v3/api-docs`。Swagger 页面由网关提供；页面中的商品接口仍通过网关的 `/brand/**` 路径调试。
