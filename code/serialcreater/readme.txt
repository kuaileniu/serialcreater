nohup java -jar xxx.jar &

//TODO 考虑当redis未持久化前重启的情况

//TODO 初始化 表id到redis

//TODO 将老数据转换到新库表任务处理

//TODO 定时器，将t_org_product 已经完成的前10条数据迁移到对应的历史表中


1.去除 org  product中重复的类别代码和 号段

2. 自定义针对枚举的注解，用于OrgEnum和ProductEnum，区别专有属性和通用属性

3. log日志输出位置

