SQLite

SQLite是一个嵌入式、开源的SQL数据库引擎(1),它遵守ACID约束(2)，能够嵌入到很多应用程序中。SQLite提供了非常出色的工具集(3)，
能够处理多种类型的数据。与托管在服务器上基于进程的关系型数据库相比，它的约束更少，更容易使用。
近日，SQLite 3.8.7 alpha版本发布，现已提供[下载](http://www.sqlite.org/download.html)，该版本包含数百项的优化措施，使得整个SQLite 数据库在速度上要比16个月前
发布的3.7.17版本快50%以上。这次性能的提升不是来源于查询计划的改进上（以前的版本中已经实现查询计划的相关优化），
而是得益于底层的硬盘的数据读写和B树(4)的搜索的改进。在上一版本已经达到了10%的性能提升基础上，该版本进行了数百项的优化，
每项优化能达到大约0.05%性能提高。目前，针对优化措施的测试已经全部通过，且测试分支覆盖率达到了100%。
另外SQLite也希望用户能帮助其对该版本进行测试验证，并给予建议。更加详细的介绍请查看[发行说明](http://permalink.gmane.org/gmane.comp.db.sqlite.general/90549)。

SQLite的官方网站是这样介绍SQLite的：SQLite是一个软件库和嵌入式SQL数据库引擎，用于实现[自包含](http://www.sqlite.org/selfcontained.html)、[非服务式](http://www.sqlite.org/serverless.html)、[零配置](http://www.sqlite.org/zeroconf.html)、[事务型](http://www.sqlite.org/transactional.html)的SQL数据库引擎。(5)
与其它大多数SQL数据库不同，它没有独立的服务进程。SQLite支持的数据类型包括NULL、INTEGER、REAL、TEXT、BLOB。(6)
它的设计目的是用于嵌入式应用的开发，现已被广泛应用被用在无数的桌面电脑应用中和消费电子设备中，如移动电话、掌上电脑和MP3播放器等。
它已经是世界上[布署得最广泛](http://www.sqlite.org/mostdeployed.html)的SQL数据库引擎，SQLite的源码就放在[公有领域](http://www.sqlite.org/copyright.html)中。
SQLite的开发和维护得到了Bloomberg、Adobe、Mozilla、Bentley、Oracle等著名公司的赞助。

在这里，请读者注意，当应用程序使用SQLite时，SQLite并非作为一个独立进程通过某种通信协议（例如Socket）与应用程序通信，(7)
而是作为应用程序的一部分，应用程序通过调用SQLite的接口直接访问数据文件。欲了解SQLite数据类型相关的更多内容，请参阅[官方文档](http://www.sqlite.org/datatype3.html)，
更多SQLite相关信息请登陆其[官网](http://www.sqlite.org/)查看。

本文来源：http://www.infoq.com/cn/news/2014/10/sqlite-3.8.7-release 

问题：

1- 什么是数据库引擎？

2- 什么是ACID约束？

3- 工具集含哪些？

4- B树：数据库专用数据结构？

5- 官方解释定义

6- 支持数据类型列表

7- SQLite非独立进程