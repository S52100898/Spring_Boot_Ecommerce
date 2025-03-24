<!-- TOC -->
* [Cấu trúc code.](#cấu-trúc-code)
  * [Cấu trúc thư mục src](#cấu-trúc-thư-mục-src)
<!-- TOC -->



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