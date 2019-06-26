# oauth2
Spring Security Oauth2 实践

## Oauth基本介绍
Oauth的两种角色：客户端（以A网站为例）和资源所有者（以B网站为例）

参考[RFC 6796](https://tools.ietf.org/html/rfc6749)

Oauth的核心是向第三方应用颁发令牌，发放令牌有四种方式：

> 1. 授权码（authorization-code）
> 2. 隐藏式（implicit）
> 3. 密码式（password）
> 4. 客户端凭证（client credentials）

### 授权码方式

第三方应用先申请一个授权码，然后再用该码获取令牌。

（1）A网站提供一个链接，用户点击后跳转到B网站，授权用户数据给A网站使用。

```html
https://b.com/oauth/authorize?
    response_type=code&
    client_id=CLIENT_ID&
    redirect_uri=CALLBACK_URL&
    scope=read
```

`response_type`代表要求返回授权码  
`client_id`让B网站知道是谁在请求  
`redirect-uri`是B接受或拒绝请求后的跳转网址  
`scope`参数表示要求的授权范围  

（2）用户跳转后，B网站会要求用户登录，然后询问是否统一给A网站授权，用户表示同意，这时候B网站就会跳回`redirect_uri`参数指定的网址，跳转时，会传回一个授权码，就像这样：

```html
https://a.com/callback?code=AUTHORIZATION_CODE
```

在上面的URL中，code里的参数就是授权码。

（3）A网站拿到授权码之后，就可以在后端（也必须在后端）向B网站请求令牌。

```html
https://b.com/oauth/token?
    client_id=CLIENT_ID&
    client_secret=CLIENT_SECRET&
    grant_type=authorization_code&
    code=AUTHORIZATION_CODE&
    redirect_uri=CALLBACK_URL
```

`client_id`用来让B确认A的身份  
`client_secret`用来让B确认A的身份  
`grant_type`表示采用的授权方式是授权码  
`code`上一步拿到的授权码  
`redirect_uri`令牌颁发后的回调地址  

（4）B网站收到请求后，向指定的redirect_uri发送一段JSON数据：

```json
{
  "access_token":"ACCESS_TOKEN",
  "token_type":"bearer",
  "expires_in":2592000,
  "refresh_token":"REFRESH_TOKEN",
  "scope":"read",
  "uid":100101,
  "info":{...}
}
```

`access_token`就是令牌

### 隐藏式

纯前端应用直接请求令牌，不安全。

### 密码式

高度信任某应用情况下直接给出用户名密码，风险更大。

### 客户端凭证

没有前端的情况下，在命令行下请求令牌，一般面向的是第三方应用，而不是用户，可能多个应用共享一个令牌。

## 令牌使用

A网站拿到令牌后，就可以向B网站的API请求数据了。

每个发到API的请求，都必须带上令牌（在请求头的Authorization字段中填上Bearer ACCESS_TOKEN）。

## 令牌刷新

B网站颁发令牌的时候，一次性颁发两个令牌，一个用于获取数据，另一个用来获取新的令牌，令牌到期前，用户使用refresh_token发一个请求，更新令牌。

```html
https://b.com/oauth/token?
    grant_type=refresh_token&
    client_id=CLIENT_ID&
    client_secret=CLIENT_SECRET&
    refresh_token=REFRESH_TOKEN
```

`grant_type`参数为refresh_token表示要求更新令牌  
`client_id`参数和client_secret用于确认身份  
`refresh_token`是用来获取新的令牌的令牌  
