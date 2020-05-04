CREATE TABLE `alias` (
  `cluster_id` int(11) NOT NULL COMMENT 'Cluster.Id',
  `document_id` int(11) NOT NULL COMMENT 'Document.Id',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `name` varchar(100) DEFAULT NULL COMMENT 'Name',
  `data_status` int(11) DEFAULT '0' COMMENT 'DataStatus',
  `create_time` datetime DEFAULT NULL COMMENT 'CreateTime',
  `last_update_time` datetime DEFAULT NULL COMMENT 'LastUpdateTime',
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8mb4 COMMENT='Alias';

CREATE TABLE `cluster` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `name` varchar(100) DEFAULT NULL COMMENT 'Name',
  `remark` varchar(100) DEFAULT NULL COMMENT 'Remark',
  `data_status` int(11) DEFAULT '0' COMMENT 'DataStatus',
  `create_time` datetime DEFAULT NULL COMMENT 'CreateTime',
  `last_update_time` datetime DEFAULT NULL COMMENT 'LastUpdateTime',
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8mb4 COMMENT='Cluster';

CREATE TABLE `document` (
  `cluster_id` int(11) NOT NULL COMMENT 'Cluster.Id',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `name` varchar(100) DEFAULT NULL COMMENT 'Name',
  `remark` varchar(100) DEFAULT NULL COMMENT 'Remark',
  `number_of_shards` int(11) DEFAULT '0' COMMENT 'NumberOfShards',
  `number_of_replicas` int(11) DEFAULT '0' COMMENT 'NumberOfReplicas',
  `mapping_total_fields_limit` int(11) DEFAULT '0' COMMENT 'MappingTotalFieldsLimit',
  `dynamic` tinyint(1) DEFAULT '0' COMMENT 'Dynamic',
  `data_status` int(11) DEFAULT '0' COMMENT 'DataStatus',
  `create_time` datetime DEFAULT NULL COMMENT 'CreateTime',
  `last_update_time` datetime DEFAULT NULL COMMENT 'LastUpdateTime',
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8mb4 COMMENT='Document';

CREATE TABLE `field` (
  `cluster_id` int(11) NOT NULL COMMENT 'Cluster.Id',
  `document_id` int(11) NOT NULL COMMENT 'Document.Id',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `name` varchar(100) DEFAULT NULL COMMENT 'Name',
  `field_type` varchar(100) DEFAULT NULL COMMENT 'FieldType',
  `remark` varchar(100) DEFAULT NULL COMMENT 'Remark',
  `null_value` varchar(100) DEFAULT NULL COMMENT 'NullValue',
  `copy_to` varchar(100) DEFAULT NULL COMMENT 'CopyTo',
  `data_status` int(11) DEFAULT '0' COMMENT 'DataStatus',
  `create_time` datetime DEFAULT NULL COMMENT 'CreateTime',
  `last_update_time` datetime DEFAULT NULL COMMENT 'LastUpdateTime',
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8mb4 COMMENT='Field';

