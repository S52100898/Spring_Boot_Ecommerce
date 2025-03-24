<!-- TOC -->
* [Giới thiệu về ứng dụng.](#giới-thiệu-về-ứng-dụng)
* [Cấu trúc code.](#cấu-trúc-code)
  * [Cấu trúc thư mục src](#cấu-trúc-thư-mục-src)
  * [Giải thích cấu trúc trên](#giải-thích-cấu-trúc-trên)
* [Các bước để chạy chương trình ở máy tính (sử dụng docker)](#các-bước-để-chạy-chương-trình-ở-máy-tính-sử-dụng-docker)
* [Command trên Postman](#command-trên-postman)
  * [Login](#login)
  * [Register](#register)
  * [Get user](#get-user)
    * [khi không đăng nhập](#khi-không-đăng-nhập)
    * [khi đăng nhập nhưng không phải là admin](#khi-đăng-nhập-nhưng-không-phải-là-admin)
      * [đăng nhập](#đăng-nhập)
      * [get user](#get-user-1)
    * [khi đăng nhập là admin](#khi-đăng-nhập-là-admin)
      * [đăng nhập](#đăng-nhập-1)
      * [get user](#get-user-2)
  * [Update user](#update-user)
    * [khi chưa đăng nhập](#khi-chưa-đăng-nhập)
    * [khi đăng nhập nhưng không phải admin](#khi-đăng-nhập-nhưng-không-phải-admin)
    * [khi là admin](#khi-là-admin)
  * [Delete user](#delete-user)
    * [khi chưa đăng nhập](#khi-chưa-đăng-nhập-1)
    * [khi đăng nhập nhưng không phải admin](#khi-đăng-nhập-nhưng-không-phải-admin-1)
    * [khi là admin](#khi-là-admin-1)
<!-- TOC -->

# Giới thiệu về ứng dụng.
- Ứng dụng này được tạo lập và thực thi bởi công nghệ spring boot framework
- Đây là một ứng dụng mô phỏng quản lý về bán hàng, giúp cho người dùng có thể đặt hàng, thanh toán, quản lý danh sách các sản phẩm và thêm vào giỏ hàng
- Ứng dụng này sử dụng spring MVC để tạo lập, và spring security 6 để quản lý việc bảo mật

# Cấu trúc code.
src: chứa thư mục main (mã nguồn java, resources) và test (viết các unit test).
 
- main: định nghĩa các mã nguồn để tạo lập 1 ứng dụng
- test: dùng để viết các unit test cho ứng dụng

pom.xml: chứa các cấu hình liên quan đến ứng dụng: các dependency, version, các repository, các plugin.

readme.md: giải thích cách vận hành ứng dụng, việc thực thi, kết quả test
## Cấu trúc thư mục src
~~~
src/
|-- main/
|    |-- java/
|    |    `-- com.example.Midterm/
|    |        |-- Models/
|    |        |-- Repositories/
|    |        |-- Services/
|    |        |    |-- Originals/
|    |        |    `-- Implements/
|    |        |-- DTOs/
|    |        |-- JwtUtils/
|    |        `-- Security/
|    `-- resources/
|       |-- static/
|       |   |-- css/
|       |   `-- js/
|       |-- template/
|       `-- application.properties
`-- test/
    `-- java/
        `-- com.example.Midterm/
~~~
## Giải thích cấu trúc trên
- Models: chứa các lớp java định nghĩa các entity được lưu trong cơ sở dữ liệu, chịu trách nhiệm lưu trữ dữ liệu của hệ thống
- Repositories, Services: đảm bảo điều hướng đúng luồng hoạt động của Spring Boot theo nguyên tắc Loose Coupling
- DTOs: chịu trách nhiệm nhận dữ liệu khi người dùng Request từ các form
- Security: chịu trách nhiệm cho việc bảo mật, ngăn chặn các truy cập không được phép
- JwtUtils: định nghĩa các lớp về Jwt, chịu trách nhiệm cho cơ chế bảo mật Jwt, đảm bảo hệ thống hoạt động an toàn

# Các bước để chạy chương trình ở máy tính (sử dụng docker)
- Khởi động docker desktop
- Trong thư mục gốc có thư mục docker chứa file docker-compose.yml, run file này để tiến hành tạo môi trường
- Sau khi docker đã hoạt động thì chạy file MidtermApplication trong thư mục Java để khởi động hệ thống

# Command trên Postman

## Login
~~~
curl --location 'http://localhost:8080/api/users/login' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E' \
--data-raw '{
    "username": "admin",
    "password": "123456"
}'
~~~
![alt](./captures/login.png)

## Register
~~~
curl --location 'http://localhost:8080/api/users/register' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E' \
--data-raw '{
    "username": "khangle",
    "password": "123456",
    "email": "khangle@gmail.com"
}'
~~~
![alt](./captures/register.png)

## Get user
### khi không đăng nhập
~~~
curl --location 'http://localhost:8080/api/users' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E'
~~~
![alt](./captures/getAllUserUnAuthorized.png)
~~~
curl --location 'http://localhost:8080/api/users' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E'
~~~
![alt](./captures/getOneUserUnAuthorized.png)
### khi đăng nhập nhưng không phải là admin
#### đăng nhập
~~~
curl --location 'http://localhost:8080/api/users/login' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E' \
--data '{
    "username": "consumer",
    "password": "123456"
}'
~~~
![alt](./captures/loginWithNotAdmin.png)
#### get user
~~~
curl --location 'http://localhost:8080/api/users' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjb25zdW1lciIsImlhdCI6MTcwMTM2NDQwMCwiZXhwIjoxNzAxNDAwNDAwfQ.SSuQrmHfL6B-4a617gZTI4d1tRp2Wf8Hs08SExkBhes' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E'
~~~
![alt](./captures/getAllUserNotAdmin.png)
~~~
curl --location 'http://localhost:8080/api/users/login' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E' \
--data '{
    "username": "admin",
    "password": "123456"
}'
~~~
![alt](./captures/getOneUserNotAdmin.png)
### khi đăng nhập là admin
#### đăng nhập
~~~
curl --location 'http://localhost:8080/api/users/login' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E' \
--data '{
    "username": "admin",
    "password": "123456"
}'
~~~
![alt](./captures/loginWithAdmin.png)
#### get user
~~~
curl --location 'http://localhost:8080/api/users' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMTM2NDY2MywiZXhwIjoxNzAxNDAwNjYzfQ.bZ8L6zIOoE--6a9EtSnnqzgPnykwQkj1otKSampsK4Y' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E'
~~~
![alt](./captures/getAllUserByAdmin.png)
~~~
curl --location 'http://localhost:8080/api/users/1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMTM2NDY2MywiZXhwIjoxNzAxNDAwNjYzfQ.bZ8L6zIOoE--6a9EtSnnqzgPnykwQkj1otKSampsK4Y' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E'
~~~
![alt](./captures/getOneUserByAdmin.png)

## Update user
### khi chưa đăng nhập
~~~
curl --location --request PUT 'http://localhost:8080/api/users/4' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E'
~~~
![alt](./captures/updateUserUnAuthorized.png)
### khi đăng nhập nhưng không phải admin
~~~
curl --location --request PUT 'http://localhost:8080/api/users/3' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFuZ2xlIiwiaWF0IjoxNzAxMzY2MDk3LCJleHAiOjE3MDE0MDIwOTd9.Wg5BCa28VBay7iWlKH7xFQVUMgCzQzrNrhUVZaBKEkc' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E' \
--data-raw '{
    "accountType": "admin",
    "email": "user1421@email.com",
    "username": "banhang1"
}'
~~~
![alt](./captures/updateUserNotAdmin.png)
### khi là admin
~~~
curl --location --request PUT 'http://localhost:8080/api/users/3' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMTM2MTU0OSwiZXhwIjoxNzAxMzk3NTQ5fQ.XHaAdABjRShXQ4SQXAqLNUadarPkqqmuZN00rM_Alf8' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E' \
--data-raw '{
    "accountType": "admin",
    "email": "user1421@email.com"
}'
~~~
![alt](./captures/updateUserByAdmin.png)

## Delete user
### khi chưa đăng nhập
~~~
curl --location --request DELETE 'http://localhost:8080/api/users/4' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E'
~~~
![alt](./captures/deleteUserUnAuthorized.png)
### khi đăng nhập nhưng không phải admin
~~~
curl --location --request DELETE 'http://localhost:8080/api/users/3' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJraGFuZ2xlIiwiaWF0IjoxNzAxMzY2MDk3LCJleHAiOjE3MDE0MDIwOTd9.Wg5BCa28VBay7iWlKH7xFQVUMgCzQzrNrhUVZaBKEkc' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E'
~~~
![alt](./captures/deleteUserNotAdmin.png)
### khi là admin
~~~
curl --location --request DELETE 'http://localhost:8080/api/users/4' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcwMTM2MTU0OSwiZXhwIjoxNzAxMzk3NTQ5fQ.XHaAdABjRShXQ4SQXAqLNUadarPkqqmuZN00rM_Alf8' \
--header 'Cookie: JSESSIONID=41ABACA8E50E41B6F7E23978ABA8D09E'
~~~
![alt](./captures/deleteUserByAdmin.png)