create table user
(
    id               bigint auto_increment comment 'id'
        primary key,
    realName         varchar(256)                           null comment '用户名（实名）',
    electricityId    varchar(256)                           null comment '用电户号',
    phoneNumber      varchar(20)                            null comment '手机号',
    userAccount      varchar(256)                           not null comment '账号',
    userPassword     varchar(512)                           not null comment '密码',
    userAvatar       varchar(1024)                          null comment '用户头像',
    address          varchar(512)                           null comment '地址',
    residentOrComp   varchar(50)                            null comment '居民/企事业',
    isAdmin          tinyint      default 0                 not null comment '是否管理员：0-否，1-是',
    isValid          tinyint      default 1                 not null comment '账户是否有效：0-无效，1-有效',
    idCard           varchar(20)                            null comment '身份证',
    electricityUsage decimal(10, 2)                         null comment '当月用电量',
    unionId          varchar(256)                           null comment '微信开放平台id',
    mpOpenId         varchar(256)                           null comment '公众号openId',
    userRole         varchar(256) default 'user'            not null comment '用户角色：user/admin/ban',
    isDelete         tinyint      default 0                 not null comment '是否删除',
    createTime       datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime       datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '用户' engine = InnoDB
                   collate = utf8mb4_unicode_ci;

create index idx_unionId
    on user (unionId);


