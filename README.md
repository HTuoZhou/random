#### 目录结构说明

##### random

- **random-bootstrap：**

  启动模块，负责项目启动

- **random-common：**

  通用模块，提供通用的配置和工具

- **random-persistence：**

  持久层模块，负责数据库和缓存接入

- **random-business：**

  服务层模块，负责相关api层的相关业务实现

- **random-webapi：**

  自身系统api模块，提供给自身系统（web、移动端等）进行使用

- **random-api：**

  内部其它系统api模块，通过openFeign的方式提供给内部其它系统进行使用

- **random-openapi：**

  外部系统api模块，提供给外部系统（其它公司）进行使用