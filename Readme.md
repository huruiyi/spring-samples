[![Badge](https://img.shields.io/badge/link-996.icu-%23FF4D5B.svg)](https://996.icu/#/en_US)
[![LICENSE](https://img.shields.io/badge/license-Anti%20996-blue.svg)](https://github.com/996icu/996.ICU/blob/master/LICENSE)
[![Slack](https://img.shields.io/badge/slack-996icu-green.svg)](https://join.slack.com/t/996icu/shared_invite/enQtNTg4MjA3MzA1MzgxLWQyYzM5M2IyZmIyMTVjMzU5NTE5MGI5Y2Y2YjgwMmJiMWMxMWMzNGU3NDJmOTdhNmRlYjJlNjk5ZWZhNWIwZGM)
[![HitCount](http://hits.dwyl.io/996icu/996.ICU.svg)](http://hits.dwyl.io/996icu/996.ICU)


 [HttpAsyncClient Examples](http://hc.apache.org/httpcomponents-asyncclient-dev/examples.html)  [httpcomponents](http://svn.apache.org/repos/asf/httpcomponents/)
 `BasicAsyncRequestProducer，HttpAsyncRequestConsumer`
***
# `修改字符集编码`
 
### 显示编码: `show variables like 'ch%'`
 
| Variable_name | value |
|------|------|
|character_set_client	|utf8
|character_set_connection	|utf8
|character_set_database	|utf8
|character_set_filesystem	|utf8
|character_set_results	|utf8
|character_set_server	|utf8
|character_set_system	|utf8
|character_sets_dir	|C:\Program Files\MySQL\MySQLServer5.7\share\charsets\
|check_proxy_users	|OFF

### 修改编码:`set character_set_server=utf8`
***
 #TreeSet特点
 TreeSet是用来排序的, 可以指定一个顺序, 对象存入之后会按照指定的顺序排列
 使用方式
 ##a.自然顺序(Comparable)
 TreeSet类的add()方法中会把存入的对象提升为Comparable类型
 调用对象的compareTo()方法和集合中的对象比较
 根据compareTo()方法返回的结果进行存储
 ##b.比较器顺序(Comparator)
 创建TreeSet的时候可以制定 一个Comparator
 如果传入了Comparator的子类对象, 那么TreeSet就会按照比较器中的顺序排序
 add()方法内部会自动调用Comparator接口中compare()方法排序
 调用的对象是compare方法的第一个参数,集合中的对象是compare方法的第二个参数
 ##c.两种方式的区别
 TreeSet构造函数什么都不传, 默认按照类中Comparable的顺序(没有就报错ClassCastException)
 TreeSet如果传入Comparator, 就优先按照Comparator
 
 # [characterEncoding编码](https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-reference-charsets.html)
    MySQL Character Set Name	
        For 8.0.12 and earlier: utf8    
        For 8.0.13 and later: utf8mb4
    Java-Style Character Encoding Name
        UTF-8

