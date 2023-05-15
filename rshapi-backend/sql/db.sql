-- 接口信息
create table if not exists rshapi.`interface_info`
(
`id` bigint not null auto_increment comment '主键' primary key,
`name` varchar(256) not null comment '接口名',
`url` varchar(512) not null comment '接口地址',
`method` varchar(256) not null comment '请求类型',
`description` varchar(256) null comment '接口描述',
`requestParams` text null comment '请求参数',
`requestHeader` text null comment '请求头',
`responseHeader` text null comment '响应头',
`userId` bigint not null comment '创建人',
`status` int default 0 not null comment '接口状态（0-关闭，1-开启）',
`createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
`updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
`isDeleted` int default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '接口信息';
-- 用户接口关系
create table if not exists rshapi.`user_interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `userId` bigint not null comment '调用人id',
    `interfaceInfoId` bigint not null comment '接口id',
    `totalNum` int default 0 not null comment '总调用次数',
    `leftNum` int default 0 not null comment '剩余调用次数',
    `status` int default 0 not null comment '状态（0-正常，1-禁用）',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDeleted` int default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '用户接口关系';

insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('谢哲瀚', 'www.amee-koepp.io', '金金鑫', '曹烨伟', '徐思', '尹鑫磊', 377761269, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('陆鸿涛', 'www.bryce-kilback.name', '袁子默', '陆峻熙', '谢烨华', '尹鸿煊', 91883045, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('于明辉', 'www.eldridge-skiles.net', '叶俊驰', '陈思远', '余擎苍', '魏梓晨', 159401722, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('薛烨伟', 'www.paul-walter.org', '何思淼', '龙博涛', '丁伟诚', '田志强', 4972993942, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('丁天翊', 'www.estela-wuckert.net', '孔嘉熙', '姚熠彤', '马潇然', '范鹤轩', 8936, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('毛烨华', 'www.albertha-goldner.name', '曹笑愚', '杜博涛', '陆潇然', '雷哲瀚', 69075, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('黄建辉', 'www.bobby-abbott.info', '夏炎彬', '戴鹏飞', '范晟睿', '覃明轩', 865203280, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('程炎彬', 'www.addie-pfannerstill.net', '雷志强', '徐明', '冯瑞霖', '韦文', 12391, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('雷楷瑞', 'www.foster-flatley.info', '邱昊天', '程晓博', '曾君浩', '胡潇然', 870, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('洪烨华', 'www.yan-ruecker.name', '沈智渊', '夏思源', '陆昊然', '覃俊驰', 668009249, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('何子骞', 'www.tracie-predovic.info', '谢耀杰', '龙航', '姜伟诚', '金峻熙', 1185, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('陶智辉', 'www.arnold-hahn.biz', '龙鹏涛', '何立果', '熊立诚', '毛子轩', 642972, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('彭金鑫', 'www.ambrose-denesik.com', '廖绍齐', '傅博涛', '程熠彤', '谭熠彤', 92562996, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('刘志泽', 'www.brendon-oreilly.net', '彭伟泽', '刘浩宇', '李君浩', '谢志泽', 5, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('杜晋鹏', 'www.elbert-dickinson.io', '任子涵', '彭果', '李越彬', '孟晓啸', 6842761002, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('丁浩', 'www.siobhan-considine.org', '贾煜城', '杨鑫磊', '袁果', '雷晟睿', 9192, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('钟烨伟', 'www.theresia-miller.io', '龙擎苍', '贺思聪', '董炎彬', '任天宇', 4932931, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('段旭尧', 'www.armando-tremblay.info', '韩文昊', '马君浩', '邱聪健', '郭鹏涛', 37392, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('邹正豪', 'www.myrtice-nader.org', '白泽洋', '卢耀杰', '董昊然', '杨乐驹', 2, 0);
insert into rshapi.`interface_info` (`name`, `url`, `method`, `description`, `requestHeader`, `responseHeader`, `userid`, `status`) values ('余俊驰', 'www.isreal-bergstrom.co', '韩琪', '周鸿煊', '洪立果', '于靖琪', 670, 0);