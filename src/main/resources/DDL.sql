CREATE TABLE `storage_bucket_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `tenant_id` varchar(50) NOT NULL DEFAULT '0' COMMENT '前期存储biz_type：app业务类型；私有云租户ID概念',
  `storage_day` int(11) NOT NULL DEFAULT '0' COMMENT '文件存储天数，1~无穷大，-1：永久bucket',
  `file_type` varchar(32) NOT NULL DEFAULT '' COMMENT '文件类型，PIC-图片，MEDIA-录像，AUDIO-音频',
  `storage_account_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '云存储账户表主键id',
  `ext_info` varchar(1024) NOT NULL DEFAULT '' COMMENT '扩展信息',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标记，0-有效，1-已删除',
  `gmt_create` bigint(13) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_tenant_id_storage_day` (`tenant_id`,`storage_day`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='云存储bucket规则表 ##';
