/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : qy102

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 20/12/2019 11:27:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cms_app_version
-- ----------------------------
DROP TABLE IF EXISTS `cms_app_version`;
CREATE TABLE `cms_app_version`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` int(11) NULL DEFAULT 0 COMMENT '类型：0->餐饮',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '版本名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '版本描述',
  `wx_template_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '小程序模板ID',
  `price` decimal(10, 0) NOT NULL,
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '说明',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '封面链接',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'sass提供的版本' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_app_version
-- ----------------------------
INSERT INTO `cms_app_version` VALUES (6, 0, '入门版', '入门版，只有基础的点餐服务', 'dededa', 0, '功能列表描述在这里！', NULL, '2019-10-21 15:51:29', '2019-10-21 15:51:29');

-- ----------------------------
-- Table structure for cms_home_servcie_item
-- ----------------------------
DROP TABLE IF EXISTS `cms_home_servcie_item`;
CREATE TABLE `cms_home_servcie_item`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `description` char(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `icon` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '图标的名字，后续屏幕适配名字后面加X数字来拉去不同的图片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cms_member_report
-- ----------------------------
DROP TABLE IF EXISTS `cms_member_report`;
CREATE TABLE `cms_member_report`  (
  `id` bigint(20) NULL DEFAULT NULL,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `report_type` int(1) NULL DEFAULT NULL COMMENT '举报类型：0->商品评价；1->话题内容；2->用户评论',
  `report_member_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '举报人',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `report_object` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `report_status` int(1) NULL DEFAULT NULL COMMENT '举报状态：0->未处理；1->已处理',
  `handle_status` int(1) NULL DEFAULT NULL COMMENT '处理结果：0->无效；1->有效；2->恶意',
  `note` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户举报表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oms_cart_item
-- ----------------------------
DROP TABLE IF EXISTS `oms_cart_item`;
CREATE TABLE `oms_cart_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `product_sku_id` bigint(20) NULL DEFAULT NULL,
  `member_id` bigint(20) NULL DEFAULT NULL,
  `shop_id` bigint(20) NULL DEFAULT NULL COMMENT '店铺ID',
  `quantity` int(11) NULL DEFAULT NULL COMMENT '购买数量',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '添加到购物车的价格',
  `sp1` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '销售属性1',
  `sp2` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '销售属性2',
  `sp3` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '销售属性3',
  `product_pic` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品主图',
  `product_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `product_sub_title` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品副标题（卖点）',
  `product_sku_code` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品sku条码',
  `member_nickname` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员昵称',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `delete_status` int(1) NULL DEFAULT 0 COMMENT '是否删除',
  `product_category_id` bigint(20) NULL DEFAULT NULL COMMENT '商品分类',
  `product_brand` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品品牌',
  `product_sn` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品序列号',
  `product_attr` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品销售属性:[{\"key\":\"颜色\",\"value\":\"颜色\"},{\"key\":\"容量\",\"value\":\"4G\"}]',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oms_order
-- ----------------------------
DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `member_id` bigint(20) NOT NULL,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `group_promotion_id` bigint(20) NULL DEFAULT NULL COMMENT '拼团活动ID',
  `coupon_id` bigint(20) NULL DEFAULT NULL COMMENT '促销活动ID',
  `order_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `member_username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户帐号',
  `total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总金额',
  `pay_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '应付金额（实际支付金额）',
  `freight_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '运费金额',
  `promotion_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '促销优化金额（促销价、满减、阶梯价）',
  `integration_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '积分抵扣金额',
  `coupon_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠券抵扣金额',
  `discount_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '管理员后台调整订单使用的折扣金额',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付方式：0->未支付；1->支付宝；2->微信',
  `source_type` int(1) NULL DEFAULT NULL COMMENT '订单来源：0->PC订单；1->app订单',
  `status` int(1) NULL DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
  `order_type` int(1) NULL DEFAULT NULL COMMENT '订单类型：0->正常订单；1->秒杀订单',
  `delivery_company` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流公司(配送方式)',
  `delivery_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物流单号',
  `auto_confirm_day` int(11) NULL DEFAULT NULL COMMENT '自动确认时间（天）',
  `integration` int(11) NULL DEFAULT NULL COMMENT '可以获得的积分',
  `growth` int(11) NULL DEFAULT NULL COMMENT '可以活动的成长值',
  `promotion_info` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动信息',
  `bill_type` int(1) NULL DEFAULT NULL COMMENT '发票类型：0->不开发票；1->电子发票；2->纸质发票',
  `bill_header` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票抬头',
  `bill_content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票内容',
  `bill_receiver_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收票人电话',
  `bill_receiver_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收票人邮箱',
  `receiver_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人姓名',
  `receiver_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人电话',
  `receiver_post_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人邮编',
  `receiver_province` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份/直辖市',
  `receiver_city` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市',
  `receiver_region` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区',
  `receiver_detail_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单备注',
  `confirm_status` int(1) NULL DEFAULT NULL COMMENT '确认收货状态：0->未确认；1->已确认 ;2 -> 退款中',
  `delete_status` int(1) NOT NULL DEFAULT 0 COMMENT '删除状态：0->未删除；1->已删除',
  `use_integration` int(11) NULL DEFAULT NULL COMMENT '下单时使用的积分',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `delivery_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `receive_time` datetime(0) NULL DEFAULT NULL COMMENT '确认收货时间',
  `comment_time` datetime(0) NULL DEFAULT NULL COMMENT '评价时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oms_order_item
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_item`;
CREATE TABLE `oms_order_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单id',
  `order_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `product_id` bigint(20) NULL DEFAULT NULL,
  `product_pic` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_brand` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌',
  `product_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品序列号',
  `product_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '销售价格',
  `product_quantity` int(11) NULL DEFAULT NULL COMMENT '购买数量',
  `product_sku_id` bigint(20) NULL DEFAULT NULL COMMENT '商品sku编号',
  `product_sku_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品sku条码',
  `product_category_id` bigint(20) NULL DEFAULT NULL COMMENT '商品分类id',
  `sp1` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品的销售属性',
  `sp2` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sp3` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `promotion_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品促销名称',
  `promotion_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品促销分解金额',
  `coupon_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠券优惠分解金额',
  `integration_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '积分优惠分解金额',
  `real_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '该商品经过优惠后的分解金额',
  `gift_integration` int(11) NULL DEFAULT 0,
  `gift_growth` int(11) NULL DEFAULT 0,
  `product_attr` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品销售属性:[{\"key\":\"颜色\",\"value\":\"颜色\"},{\"key\":\"容量\",\"value\":\"4G\"}]',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单中所包含的商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oms_order_operate_history
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_operate_history`;
CREATE TABLE `oms_order_operate_history`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单id',
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `operate_man` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人：0:用户；1:系统；2:后台管理员',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `order_status` int(1) NULL DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单操作历史记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oms_order_return_apply
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_return_apply`;
CREATE TABLE `oms_order_return_apply`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NOT NULL COMMENT '店铺ID',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `company_address_id` bigint(20) NULL DEFAULT NULL COMMENT '收货地址表id',
  `product_id` bigint(20) NULL DEFAULT NULL COMMENT '退货商品id',
  `order_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  `member_username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员用户名',
  `return_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '退款金额',
  `return_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货人姓名',
  `return_phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货人电话',
  `status` int(1) NULL DEFAULT NULL COMMENT '申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝',
  `handle_time` datetime(0) NULL DEFAULT NULL COMMENT '处理时间',
  `product_pic` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `product_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `product_brand` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品品牌',
  `product_attr` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品销售属性：颜色：红色；尺码：xl;',
  `product_count` int(11) NULL DEFAULT NULL COMMENT '退货数量',
  `product_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品单价',
  `product_real_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品实际支付单价',
  `reason` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原因',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `proof_pics` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '凭证图片，以逗号隔开',
  `handle_note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理备注',
  `handle_man` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理人员',
  `receive_man` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `receive_time` datetime(0) NULL DEFAULT NULL COMMENT '收货时间',
  `receive_note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单退货申请' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oms_order_return_reason
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_return_reason`;
CREATE TABLE `oms_order_return_reason`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL COMMENT '店铺ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退货类型',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `status` int(1) NOT NULL COMMENT '状态：0->不启用；1->启用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '退货原因表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oms_order_setting
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_setting`;
CREATE TABLE `oms_order_setting`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NOT NULL COMMENT '店铺ID',
  `normal_order_overtime` int(11) NULL DEFAULT NULL COMMENT '正常订单超时时间(分)',
  `confirm_overtime` int(11) NULL DEFAULT NULL COMMENT '发货后自动确认收货时间（天）',
  `finish_overtime` int(11) NULL DEFAULT NULL COMMENT '自动完成交易时间，不能申请售后（天）',
  `comment_overtime` int(11) NULL DEFAULT NULL COMMENT '订单完成后自动好评时间（天）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单设置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_album
-- ----------------------------
DROP TABLE IF EXISTS `pms_album`;
CREATE TABLE `pms_album`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cover_pic` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic_count` int(11) NULL DEFAULT NULL,
  `sort` int(11) NULL DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '相册表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_album_pic
-- ----------------------------
DROP TABLE IF EXISTS `pms_album_pic`;
CREATE TABLE `pms_album_pic`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `album_id` bigint(20) NULL DEFAULT NULL,
  `pic` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '画册图片表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_brand
-- ----------------------------
DROP TABLE IF EXISTS `pms_brand`;
CREATE TABLE `pms_brand`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `first_letter` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '首字母',
  `sort` int(11) NULL DEFAULT NULL,
  `factory_status` int(1) NULL DEFAULT NULL COMMENT '是否为品牌制造商：0->不是；1->是',
  `show_status` int(1) NULL DEFAULT NULL,
  `product_count` int(11) NULL DEFAULT NULL COMMENT '产品数量',
  `product_comment_count` int(11) NULL DEFAULT NULL COMMENT '产品评论数量',
  `logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌logo',
  `big_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专区大图',
  `brand_story` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '品牌故事',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '品牌表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_comment
-- ----------------------------
DROP TABLE IF EXISTS `pms_comment`;
CREATE TABLE `pms_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NOT NULL,
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单ID',
  `product_id` bigint(20) NULL DEFAULT NULL COMMENT '订单为单一商品时，该字段有值',
  `member_nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `star` int(3) NULL DEFAULT NULL COMMENT '评价星数：0->5',
  `member_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价的ip',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `show_status` int(1) NULL DEFAULT NULL,
  `product_attribute` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '购买时的商品属性',
  `collect_couont` int(11) NULL DEFAULT NULL,
  `read_count` int(11) NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `pics` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传图片地址，以逗号隔开',
  `member_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论用户头像',
  `replay_count` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品评价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_comment_replay
-- ----------------------------
DROP TABLE IF EXISTS `pms_comment_replay`;
CREATE TABLE `pms_comment_replay`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(20) NULL DEFAULT NULL,
  `member_nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `type` int(1) NULL DEFAULT NULL COMMENT '评论人员类型；0->会员；1->管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品评价回复表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_member_price
-- ----------------------------
DROP TABLE IF EXISTS `pms_member_price`;
CREATE TABLE `pms_member_price`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL COMMENT '产品id',
  `member_level_id` bigint(20) NULL DEFAULT NULL,
  `member_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '会员价格',
  `member_level_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品会员价格表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_product
-- ----------------------------
DROP TABLE IF EXISTS `pms_product`;
CREATE TABLE `pms_product`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NOT NULL COMMENT '店铺ID',
  `brand_id` bigint(20) NULL DEFAULT NULL COMMENT '品牌ID',
  `product_category_id` bigint(20) NULL DEFAULT NULL COMMENT '产品类别ID',
  `product_attribute_category_id` bigint(20) NULL DEFAULT NULL COMMENT '产品属性类别ID',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '货号',
  `delete_status` int(1) NULL DEFAULT NULL COMMENT '删除状态：0->未删除；1->已删除',
  `publish_status` int(1) NULL DEFAULT NULL COMMENT '上架状态：0->下架；1->上架',
  `new_status` int(1) NULL DEFAULT NULL COMMENT '新品状态:0->不是新品；1->新品',
  `recommand_status` int(1) NULL DEFAULT NULL COMMENT '推荐状态；0->不推荐；1->推荐',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `sale` int(11) NULL DEFAULT NULL COMMENT '销量',
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `promotion_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '促销价格',
  `gift_point` int(11) NULL DEFAULT 0 COMMENT '赠送的积分',
  `sub_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '副标题',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品描述',
  `original_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '市场价',
  `stock` int(11) NULL DEFAULT NULL COMMENT '库存',
  `low_stock` int(11) NULL DEFAULT NULL COMMENT '库存预警值',
  `unit` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `weight` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品重量，默认为克',
  `service_ids` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `album_id` bigint(255) NULL DEFAULT NULL COMMENT '画册id',
  `detail_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `detail_html` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '产品详情网页内容',
  `detail_mobile_html` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '移动端网页详情',
  `promotion_start_time` datetime(0) NULL DEFAULT NULL COMMENT '促销开始时间',
  `promotion_end_time` datetime(0) NULL DEFAULT NULL COMMENT '促销结束时间',
  `promotion_per_limit` int(11) NULL DEFAULT NULL COMMENT '活动限购数量',
  `promotion_type` int(1) NULL DEFAULT NULL COMMENT '促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购',
  `brand_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `product_category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品分类名称',
  `currency` tinyint(4) NULL DEFAULT 0 COMMENT '币种，0-> 人民币;  1-> 积分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_product_attribute
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute`;
CREATE TABLE `pms_product_attribute`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NOT NULL,
  `product_attribute_category_id` bigint(20) NULL DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `select_type` int(1) NULL DEFAULT NULL COMMENT '属性选择类型：0->唯一；1->单选；2->多选',
  `input_type` int(1) NULL DEFAULT NULL COMMENT '属性录入方式：0->手工录入；1->从列表中选取',
  `input_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '可选值列表，以逗号隔开',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序字段：最高的可以单独上传图片',
  `filter_type` int(1) NULL DEFAULT NULL COMMENT '分类筛选样式：1->普通；1->颜色',
  `search_type` int(1) NULL DEFAULT NULL COMMENT '检索类型；0->不需要进行检索；1->关键字检索；2->范围检索',
  `related_status` int(1) NULL DEFAULT NULL COMMENT '相同属性产品是否关联；0->不关联；1->关联',
  `hand_add_status` int(1) NULL DEFAULT NULL COMMENT '是否支持手动新增；0->不支持；1->支持',
  `type` int(1) NULL DEFAULT NULL COMMENT '属性的类型；0->规格；1->参数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品属性参数表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_product_attribute_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute_category`;
CREATE TABLE `pms_product_attribute_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attribute_count` int(11) NULL DEFAULT 0 COMMENT '属性数量',
  `param_count` int(11) NULL DEFAULT 0 COMMENT '参数数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品属性分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_product_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute_value`;
CREATE TABLE `pms_product_attribute_value`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `product_attribute_id` bigint(20) NULL DEFAULT NULL,
  `value` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '存储产品参数信息的表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_product_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_category`;
CREATE TABLE `pms_product_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '上机分类的编号：0表示一级分类',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` int(1) NULL DEFAULT NULL COMMENT '分类级别：0->1级；1->2级',
  `show_status` int(1) NULL DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  `sort` int(11) NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pms_product_category
-- ----------------------------
INSERT INTO `pms_product_category` VALUES (4, 3, 0, '主食', 0, 1, NULL, 'http://www.huifangyuan.net/zhushi.jpg', '米饭,糕点,小笼包', '各种面食、糕点、米饭等');
INSERT INTO `pms_product_category` VALUES (5, 3, 4, '面食', 1, 1, NULL, 'http://www.huifangyuan.net/zhushi.jpg', '葱油饼，馒头', '各种面食');
INSERT INTO `pms_product_category` VALUES (6, 3, 0, '海鲜系列', 0, 1, NULL, 'http://www.huifangyuan.net/zhushi.jpg', '小龙虾,螃蟹', '各种海鲜');
INSERT INTO `pms_product_category` VALUES (7, 3, 5, '烩面', 2, 1, NULL, 'http://www.huifangyuan.net/zhushi.jpg', '滋补', '各种烩面');

-- ----------------------------
-- Table structure for pms_product_category_attribute_relation
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_category_attribute_relation`;
CREATE TABLE `pms_product_category_attribute_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `product_category_id` bigint(20) NULL DEFAULT NULL,
  `product_attribute_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_product_full_reduction
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_full_reduction`;
CREATE TABLE `pms_product_full_reduction`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `full_price` decimal(10, 2) NULL DEFAULT NULL,
  `reduce_price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品满减表(只针对同商品)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_product_ladder
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_ladder`;
CREATE TABLE `pms_product_ladder`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `count` int(11) NULL DEFAULT NULL COMMENT '满足的商品数量',
  `discount` decimal(10, 2) NULL DEFAULT NULL COMMENT '折扣',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '折后价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品阶梯价格表(只针对同商品)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pms_sku_stock
-- ----------------------------
DROP TABLE IF EXISTS `pms_sku_stock`;
CREATE TABLE `pms_sku_stock`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `sku_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'sku编码',
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `stock` int(11) NULL DEFAULT 0 COMMENT '库存',
  `low_stock` int(11) NULL DEFAULT NULL COMMENT '预警库存',
  `sp1` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '销售属性1',
  `sp2` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sp3` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '展示图片',
  `sale` int(11) NULL DEFAULT NULL COMMENT '销量',
  `promotion_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单品促销价格',
  `lock_stock` int(11) NULL DEFAULT 0 COMMENT '锁定库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'sku的库存' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_advertise
-- ----------------------------
DROP TABLE IF EXISTS `sms_advertise`;
CREATE TABLE `sms_advertise`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position_id` bigint(1) NULL DEFAULT NULL COMMENT '轮播位置',
  `pic` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '上下线状态：0->下线；1->上线',
  `click_count` int(11) NULL DEFAULT NULL COMMENT '点击数',
  `order_count` int(11) NULL DEFAULT NULL COMMENT '下单数',
  `url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接地址',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `sort` int(11) NULL DEFAULT 0 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '广告位' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sms_advertise
-- ----------------------------
INSERT INTO `sms_advertise` VALUES (1, 2, '吊顶图片广告一', 1, 'http://www.wahaha.com', '2019-11-01 00:00:00', '2019-12-01 00:00:00', NULL, 0, 0, NULL, '测试1', NULL);

-- ----------------------------
-- Table structure for sms_advertise_position
-- ----------------------------
DROP TABLE IF EXISTS `sms_advertise_position`;
CREATE TABLE `sms_advertise_position`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `type` int(11) NULL DEFAULT 0 COMMENT '业务类型，餐饮小程序0',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '广告位置名称',
  `descrition` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '广告位置名称',
  `max_count` int(11) NULL DEFAULT 1 COMMENT '该位置最多几个广告',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '广告位位置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sms_advertise_position
-- ----------------------------
INSERT INTO `sms_advertise_position` VALUES (1, 0, '小程序吊顶广告', '小程序吊顶轮播广告，最多3个广告', 3);
INSERT INTO `sms_advertise_position` VALUES (2, 0, '小程序首页底部广告', '小程序首页底部轮播广告，最多3个广告', 3);

-- ----------------------------
-- Table structure for sms_coupon
-- ----------------------------
DROP TABLE IF EXISTS `sms_coupon`;
CREATE TABLE `sms_coupon`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `type` int(1) NULL DEFAULT NULL COMMENT '优惠卷类型；0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `platform` int(1) NULL DEFAULT NULL COMMENT '使用平台：0->全部；1->移动；2->PC',
  `count` int(11) NULL DEFAULT NULL COMMENT '数量',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '金额',
  `per_limit` int(11) NULL DEFAULT NULL COMMENT '每人限领张数',
  `min_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '使用门槛；0表示无门槛',
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `use_type` int(1) NULL DEFAULT NULL COMMENT '使用类型：0->全场通用；1->指定分类；2->指定商品',
  `note` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `publish_count` int(11) NULL DEFAULT NULL COMMENT '发行数量',
  `use_count` int(11) NULL DEFAULT NULL COMMENT '已使用数量',
  `receive_count` int(11) NULL DEFAULT NULL COMMENT '领取数量',
  `enable_time` datetime(0) NULL DEFAULT NULL COMMENT '可以领取的日期',
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '优惠码',
  `member_level` int(1) NULL DEFAULT NULL COMMENT '可领取的会员类型：0->无限时',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠卷表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_coupon_history
-- ----------------------------
DROP TABLE IF EXISTS `sms_coupon_history`;
CREATE TABLE `sms_coupon_history`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `coupon_id` bigint(20) NULL DEFAULT NULL,
  `member_id` bigint(20) NULL DEFAULT NULL,
  `coupon_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `member_nickname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '领取人昵称',
  `get_type` int(1) NULL DEFAULT NULL COMMENT '获取类型：0->后台赠送；1->主动获取',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `use_status` int(1) NULL DEFAULT NULL COMMENT '使用状态：0->未使用；1->已使用；2->已过期',
  `use_time` datetime(0) NULL DEFAULT NULL COMMENT '使用时间',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `order_sn` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号码',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_member_id`(`member_id`) USING BTREE,
  INDEX `idx_coupon_id`(`coupon_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券使用、领取历史表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_coupon_product_category_relation
-- ----------------------------
DROP TABLE IF EXISTS `sms_coupon_product_category_relation`;
CREATE TABLE `sms_coupon_product_category_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `coupon_id` bigint(20) NULL DEFAULT NULL,
  `product_category_id` bigint(20) NULL DEFAULT NULL,
  `product_category_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品分类名称',
  `parent_category_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父分类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券和产品分类关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_coupon_product_relation
-- ----------------------------
DROP TABLE IF EXISTS `sms_coupon_product_relation`;
CREATE TABLE `sms_coupon_product_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `coupon_id` bigint(20) NULL DEFAULT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `product_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `product_sn` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品编码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优惠券和产品的关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_group_promotion
-- ----------------------------
DROP TABLE IF EXISTS `sms_group_promotion`;
CREATE TABLE `sms_group_promotion`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `images` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '团购活动的图片',
  `start_date` date NULL DEFAULT NULL COMMENT '开始日期',
  `end_date` date NULL DEFAULT NULL COMMENT '结束日期',
  `status` int(1) NULL DEFAULT NULL COMMENT '上下线状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `type` tinyint(4) NULL DEFAULT 1 COMMENT 'n人团',
  `auto_delay` int(11) NULL DEFAULT 0 COMMENT '未成团，自动延期n天',
  `price` decimal(10, 0) NULL DEFAULT NULL COMMENT '团购价格',
  `original_price` decimal(10, 0) NULL DEFAULT NULL COMMENT '原价',
  `auto_open` tinyint(4) NULL DEFAULT 0 COMMENT '1是自动成团，拼团时间到，不管人数是否到，自动开团',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '团购活动' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_group_promotion_product_relation
-- ----------------------------
DROP TABLE IF EXISTS `sms_group_promotion_product_relation`;
CREATE TABLE `sms_group_promotion_product_relation`  (
  `id` int(11) NOT NULL,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `group_promotion_id` int(11) NOT NULL COMMENT '团购活动id',
  `product_id` int(11) NOT NULL COMMENT '商品ID',
  `count` int(11) NOT NULL DEFAULT 1 COMMENT '产品数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sms_home_recommend_product
-- ----------------------------
DROP TABLE IF EXISTS `sms_home_recommend_product`;
CREATE TABLE `sms_home_recommend_product`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL COMMENT '店铺ID',
  `product_id` bigint(20) NULL DEFAULT NULL COMMENT '产品ID',
  `product_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称',
  `recommend_status` int(1) NULL DEFAULT NULL COMMENT '推荐状态，1推荐，0不再推荐',
  `sort` int(1) NULL DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '人气推荐商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-default', 'Y', 'admin', '2018-03-16 11:33:00', 'admin', '2019-11-19 20:19:18', '默认 skin-default、蓝色 skin-blue、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '初始化密码 123456');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` int(11) NULL DEFAULT 0 COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 110 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (100, 0, '0', 'AAA软件教育', 0, 'Seven', '15888888888', '396691973@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2019-11-19 20:20:12');
INSERT INTO `sys_dept` VALUES (101, 100, '0,100', '深圳总公司', 1, '豆豆', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (102, 100, '0,100', '长沙分公司', 2, '豆豆', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (103, 101, '0,100,101', '研发部门', 1, '豆豆', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (104, 101, '0,100,101', '市场部门', 2, '豆豆', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (105, 101, '0,100,101', '测试部门', 3, '豆豆', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (106, 101, '0,100,101', '财务部门', 4, '豆豆', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (107, 101, '0,100,101', '运维部门', 5, '豆豆', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (108, 102, '0,100,102', '市场部门', 1, '豆豆', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');
INSERT INTO `sys_dept` VALUES (109, 102, '0,100,102', '财务部门', 2, '豆豆', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00');

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别男');
INSERT INTO `sys_dict_data` VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别女');
INSERT INTO `sys_dict_data` VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '性别未知');
INSERT INTO `sys_dict_data` VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '显示菜单');
INSERT INTO `sys_dict_data` VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES (10, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认是');
INSERT INTO `sys_dict_data` VALUES (11, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统默认否');
INSERT INTO `sys_dict_data` VALUES (12, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知');
INSERT INTO `sys_dict_data` VALUES (13, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '公告');
INSERT INTO `sys_dict_data` VALUES (14, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES (15, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '关闭状态');
INSERT INTO `sys_dict_data` VALUES (16, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '新增操作');
INSERT INTO `sys_dict_data` VALUES (17, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '修改操作');
INSERT INTO `sys_dict_data` VALUES (18, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '删除操作');
INSERT INTO `sys_dict_data` VALUES (19, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '授权操作');
INSERT INTO `sys_dict_data` VALUES (20, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导出操作');
INSERT INTO `sys_dict_data` VALUES (21, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '导入操作');
INSERT INTO `sys_dict_data` VALUES (22, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '强退操作');
INSERT INTO `sys_dict_data` VALUES (23, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '生成操作');
INSERT INTO `sys_dict_data` VALUES (24, 8, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '清空操作');
INSERT INTO `sys_dict_data` VALUES (25, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '正常状态');
INSERT INTO `sys_dict_data` VALUES (26, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '停用状态');
INSERT INTO `sys_dict_data` VALUES (29, 1, '郑州市', '450001', 'sys_henan_province', '', 'default', 'Y', '0', 'admin', '2019-11-19 20:15:25', 'admin', '2019-11-19 20:28:40', '郑州市信息');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  `identify` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典标识',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '用户性别列表', NULL);
INSERT INTO `sys_dict_type` VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单状态列表', NULL);
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统开关列表', NULL);
INSERT INTO `sys_dict_type` VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '任务状态列表', NULL);
INSERT INTO `sys_dict_type` VALUES (5, '系统是否', 'sys_yes_no', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统是否列表', NULL);
INSERT INTO `sys_dict_type` VALUES (6, '通知类型', 'sys_notice_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知类型列表', NULL);
INSERT INTO `sys_dict_type` VALUES (7, '通知状态', 'sys_notice_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '通知状态列表', NULL);
INSERT INTO `sys_dict_type` VALUES (8, '操作类型', 'sys_oper_type', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作类型列表', NULL);
INSERT INTO `sys_dict_type` VALUES (9, '系统状态', 'sys_common_status', '0', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录状态列表', NULL);
INSERT INTO `sys_dict_type` VALUES (13, '河南省', 'sys_henan_province', '0', 'admin', '2019-11-19 20:14:50', 'admin', '2019-11-19 21:00:30', '河南省地址', 'province');
INSERT INTO `sys_dict_type` VALUES (14, '北京市', 'sys_beijing_city', '0', 'admin', '2019-11-19 20:49:05', '', NULL, '北京市信息', 'province');
INSERT INTO `sys_dict_type` VALUES (15, '上海市', 'sys_shanghai_city', '0', 'admin', '2019-11-19 20:51:57', '', NULL, '上海市信息', 'province');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`  (
  `job_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '任务组名',
  `method_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '任务方法',
  `method_params` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '方法参数',
  `cron_expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务调度表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES (1, 'ryTask', '系统默认（无参）', 'ryNoParams', '', '0/10 * * * * ?', '3', '1', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_job` VALUES (2, 'ryTask', '系统默认（有参）', 'ryParams', 'ry', '0/20 * * * * ?', '3', '1', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log`  (
  `job_log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务组名',
  `method_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务方法',
  `method_params` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法参数',
  `job_message` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志信息',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '异常信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '定时任务调度日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor`  (
  `info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '提示消息',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统访问记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '请求地址',
  `menu_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公告内容',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `oper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '方法名称',
  `operator_type` int(1) NULL DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `status` int(1) NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`  (
  `post_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '岗位信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `dept_id` int(11) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '盐加密',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime(0) NULL DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_online
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_online`;
CREATE TABLE `sys_user_online`  (
  `sessionId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户会话id',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录账号',
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `ipaddr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
  `start_timestamp` datetime(0) NULL DEFAULT NULL COMMENT 'session创建时间',
  `last_access_time` datetime(0) NULL DEFAULT NULL COMMENT 'session最后访问时间',
  `expire_time` int(5) NULL DEFAULT 0 COMMENT '超时时间，单位为分钟',
  PRIMARY KEY (`sessionId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '在线用户记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post`  (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `post_id` int(11) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`, `post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户与岗位关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_agent_informaion
-- ----------------------------
DROP TABLE IF EXISTS `ums_agent_informaion`;
CREATE TABLE `ums_agent_informaion`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `business_license` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `contract_id` bigint(20) NULL DEFAULT NULL COMMENT '合同ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_contract
-- ----------------------------
DROP TABLE IF EXISTS `ums_contract`;
CREATE TABLE `ums_contract`  (
  `id` bigint(20) NOT NULL,
  `owner_id` bigint(20) NOT NULL COMMENT '签订者ID',
  `type` int(11) NULL DEFAULT NULL COMMENT '合同类型',
  `template_id` bigint(20) NOT NULL COMMENT '合同模版ID',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'json格式，具体格式跟合同模块对应',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_contract_template
-- ----------------------------
DROP TABLE IF EXISTS `ums_contract_template`;
CREATE TABLE `ums_contract_template`  (
  `id` bigint(20) NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '模版内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_integration_change_history
-- ----------------------------
DROP TABLE IF EXISTS `ums_integration_change_history`;
CREATE TABLE `ums_integration_change_history`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) NULL DEFAULT NULL COMMENT '会员ID',
  `shop_id` bigint(20) NULL DEFAULT NULL COMMENT '店铺ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建记录时间',
  `change_type` int(1) NULL DEFAULT NULL COMMENT '积分变化类型 1. 外卖下单获取积分，2.食堂下单获取积分，3. 管理员修改 ，4. 积分兑换消耗积分',
  `change_count` int(11) NULL DEFAULT NULL COMMENT '积分改变数量',
  `operate_man` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人员',
  `operate_note` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作备注',
  `source_type` int(1) NULL DEFAULT NULL COMMENT '积分来源：0->购物奖励；1->管理员修改；2->购物消费',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '积分变化历史记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_integration_grant_setting
-- ----------------------------
DROP TABLE IF EXISTS `ums_integration_grant_setting`;
CREATE TABLE `ums_integration_grant_setting`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `deduction_per_amount` int(11) NULL DEFAULT NULL COMMENT '每一元需要抵扣的积分数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '积分发放设置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_member
-- ----------------------------
DROP TABLE IF EXISTS `ums_member`;
CREATE TABLE `ums_member`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `member_level_id` bigint(20) NULL DEFAULT NULL,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nickname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `phone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `status` int(1) NULL DEFAULT NULL COMMENT '帐号启用状态:0->禁用；1->启用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `icon` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `gender` int(1) NULL DEFAULT NULL COMMENT '性别：0->未知；1->男；2->女',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所做城市',
  `job` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `personalized_signature` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `source_type` int(1) NULL DEFAULT NULL COMMENT '用户来源',
  `integration` int(11) NULL DEFAULT NULL COMMENT '积分',
  `growth` int(11) NULL DEFAULT NULL COMMENT '成长值',
  `luckey_count` int(11) NULL DEFAULT NULL COMMENT '剩余抽奖次数',
  `history_integration` int(11) NULL DEFAULT NULL COMMENT '历史积分数量',
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `open_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信返回的open_id',
  `session_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信返回的session_key',
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录验证token',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_username`(`username`) USING BTREE,
  UNIQUE INDEX `idx_phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_member
-- ----------------------------
INSERT INTO `ums_member` VALUES (1, NULL, NULL, 'zhangsan', '123456', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for ums_member_level
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_level`;
CREATE TABLE `ums_member_level`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `growth_point` int(11) NULL DEFAULT NULL,
  `default_status` int(1) NULL DEFAULT NULL COMMENT '是否为默认等级：0->不是；1->是',
  `free_freight_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '免运费标准',
  `comment_growth_point` int(11) NULL DEFAULT NULL COMMENT '每次评价获取的成长值',
  `priviledge_free_freight` int(1) NULL DEFAULT NULL COMMENT '是否有免邮特权',
  `priviledge_sign_in` int(1) NULL DEFAULT NULL COMMENT '是否有签到特权',
  `priviledge_comment` int(1) NULL DEFAULT NULL COMMENT '是否有评论获奖励特权',
  `priviledge_promotion` int(1) NULL DEFAULT NULL COMMENT '是否有专享活动特权',
  `priviledge_member_price` int(1) NULL DEFAULT NULL COMMENT '是否有会员价格特权',
  `priviledge_birthday` int(1) NULL DEFAULT NULL COMMENT '是否有生日特权',
  `note` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员等级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_member_login_log
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_login_log`;
CREATE TABLE `ums_member_login_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `member_id` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_type` int(1) NULL DEFAULT NULL COMMENT '登录类型：0->PC；1->android;2->ios;3->小程序',
  `province` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员登录记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_member_receive_address
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_receive_address`;
CREATE TABLE `ums_member_receive_address`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人名称',
  `phone_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `default_status` int(1) NULL DEFAULT NULL COMMENT '是否为默认',
  `post_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮政编码',
  `province` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省份/直辖市',
  `city` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市',
  `region` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区',
  `detail_address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址(街道)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员收货地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_member_receive_address
-- ----------------------------
INSERT INTO `ums_member_receive_address` VALUES (1, 1, '张三', '15999999999', 0, '450001', '河南省', '郑州市', '金水区', '杨金路牛顿国际');
INSERT INTO `ums_member_receive_address` VALUES (2, 1, '张三', '15777777777', 1, '450002', '河南省', '郑州市', '高新区', '瑞达路36号');
INSERT INTO `ums_member_receive_address` VALUES (3, 1, '李四', '15666666666', 1, '450003', '河南省', '郑州市', '郑东新区', '文苑北路');

-- ----------------------------
-- Table structure for ums_member_rule_setting
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_rule_setting`;
CREATE TABLE `ums_member_rule_setting`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `continue_sign_day` int(11) NULL DEFAULT NULL COMMENT '连续签到天数',
  `continue_sign_point` int(11) NULL DEFAULT NULL COMMENT '连续签到赠送数量',
  `consume_per_point` decimal(10, 2) NULL DEFAULT NULL COMMENT '每消费多少元获取1个点',
  `low_order_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '最低获取点数的订单金额',
  `max_point_per_order` int(11) NULL DEFAULT NULL COMMENT '每笔订单最高获取点数',
  `type` int(1) NULL DEFAULT NULL COMMENT '类型：0->积分规则；1->成长值规则',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员积分成长规则表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_member_statistics_info
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_statistics_info`;
CREATE TABLE `ums_member_statistics_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `member_id` bigint(20) NULL DEFAULT NULL,
  `consume_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '累计消费金额',
  `order_count` int(11) NULL DEFAULT NULL COMMENT '订单数量',
  `coupon_count` int(11) NULL DEFAULT NULL COMMENT '优惠券数量',
  `comment_count` int(11) NULL DEFAULT NULL COMMENT '评价数',
  `return_order_count` int(11) NULL DEFAULT NULL COMMENT '退货数量',
  `login_count` int(11) NULL DEFAULT NULL COMMENT '登录次数',
  `attend_count` int(11) NULL DEFAULT NULL COMMENT '关注数量',
  `fans_count` int(11) NULL DEFAULT NULL COMMENT '粉丝数量',
  `collect_product_count` int(11) NULL DEFAULT NULL,
  `collect_subject_count` int(11) NULL DEFAULT NULL,
  `collect_topic_count` int(11) NULL DEFAULT NULL,
  `collect_comment_count` int(11) NULL DEFAULT NULL,
  `invite_friend_count` int(11) NULL DEFAULT NULL,
  `recent_order_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次下订单时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员统计信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_member_task
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_task`;
CREATE TABLE `ums_member_task`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `growth` int(11) NULL DEFAULT NULL COMMENT '赠送成长值',
  `intergration` int(11) NULL DEFAULT NULL COMMENT '赠送积分',
  `type` int(1) NULL DEFAULT NULL COMMENT '任务类型：0->新手任务；1->日常任务',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员任务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_message
-- ----------------------------
DROP TABLE IF EXISTS `ums_message`;
CREATE TABLE `ums_message`  (
  `id` bigint(20) NULL DEFAULT NULL,
  `shop_id` int(11) NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL COMMENT '消息类型',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息标题',
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '摘要',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `send_to` bigint(20) NULL DEFAULT NULL COMMENT '该字段不为null 时为接受消息的用户ID',
  `channel` int(11) NULL DEFAULT NULL COMMENT '1. 小程序消息 2. 后天管理系统消息'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_shop_facility
-- ----------------------------
DROP TABLE IF EXISTS `ums_shop_facility`;
CREATE TABLE `ums_shop_facility`  (
  `id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `shop_id` bigint(20) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '店铺的基础设置，例如：Wi-Fi，纸巾，停车位，包厢等' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_shop_facility
-- ----------------------------
INSERT INTO `ums_shop_facility` VALUES (1, 1, '测试标题', '测试描述', NULL);

-- ----------------------------
-- Table structure for ums_shop_information
-- ----------------------------
DROP TABLE IF EXISTS `ums_shop_information`;
CREATE TABLE `ums_shop_information`  (
  `id` bigint(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `owner_id` bigint(11) NOT NULL COMMENT '店铺所有者ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '店铺名称',
  `province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省',
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '市',
  `borough` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '区',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `lng` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `lat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `closed` tinyint(4) NULL DEFAULT NULL COMMENT '是否打烊（手动打烊标示）和营业时间一起使用',
  `open_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字符串，如：1-5|10:00-14:00，1-5|17:00-22:00，6-7|9:00-24:00  周和时间用“|”分割，周几到周几用“-”分割，多个设置用“，”分割',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商家电话',
  `images` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商家实景照片URL，json格式 {realimsg:[\'http://xxx\',\'http://xxx\']}',
  `status` tinyint(4) NULL DEFAULT 1 COMMENT '0：冻结状态，1：正常，2：违规关闭，3：店铺到期关闭',
  `auth_start_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '授权开始时间',
  `auth_long` int(11) NULL DEFAULT 0 COMMENT '授权时长，单位是月',
  `template_id` int(11) NULL DEFAULT NULL COMMENT '授权版本的ID',
  `business_license` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '营业执照图片链接',
  `food_license` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '食品安全许可证图片链接',
  `sanitation_license` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '卫生许可证图片链接',
  `assess` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '量化考核图片链接',
  `contract_id` bigint(20) NULL DEFAULT NULL COMMENT '合同ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '店铺的基本信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ums_shop_information
-- ----------------------------
INSERT INTO `ums_shop_information` VALUES (1, 2, '兰寨大碗菜', '河南省', '郑州市', '中原区', '云杉路64号', NULL, NULL, 0, '10:00-14:00,17:00-22:00', NULL, NULL, 1, NULL, 12, 6, 'http://www.huifangyuan.net/bl/111.gif', 'http://www.huifangyuan.net/fl/111.gif', NULL, 'http://www.huifangyuan.net/as/111.gif', NULL);
INSERT INTO `ums_shop_information` VALUES (2, 2, '兰寨大碗菜', '河南省', '郑州市', '中原区', '云杉路64号', NULL, NULL, 0, '10:00-14:00,17:00-22:00', NULL, NULL, 1, '2019-10-22 14:47:33', 12, 6, 'http://www.huifangyuan.net/bl/111.gif', 'http://www.huifangyuan.net/fl/111.gif', NULL, 'http://www.huifangyuan.net/as/111.gif', NULL);
INSERT INTO `ums_shop_information` VALUES (3, 2, 'wahaha', '河南省', '郑州市', '中原区', '云杉路64号', NULL, NULL, 0, '10:00-14:00,17:00-22:00', NULL, NULL, 1, '2019-10-22 15:37:40', 12, 6, 'http://www.huifangyuan.net/bl/111.gif', 'http://www.huifangyuan.net/fl/111.gif', NULL, 'http://www.huifangyuan.net/as/111.gif', NULL);

-- ----------------------------
-- Table structure for ums_shop_questionnaire
-- ----------------------------
DROP TABLE IF EXISTS `ums_shop_questionnaire`;
CREATE TABLE `ums_shop_questionnaire`  (
  `id` bigint(20) NULL DEFAULT NULL,
  `shop_id` bigint(20) NULL DEFAULT NULL COMMENT '店铺ID',
  `question` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '问卷问题',
  `type` int(11) NULL DEFAULT NULL COMMENT '业务点：1. 用户反馈的问卷',
  `sort` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问卷问题' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ums_shop_questionnaire_answer
-- ----------------------------
DROP TABLE IF EXISTS `ums_shop_questionnaire_answer`;
CREATE TABLE `ums_shop_questionnaire_answer`  (
  `id` bigint(20) NULL DEFAULT NULL,
  `question_id` bigint(20) NULL DEFAULT NULL COMMENT '问卷ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '问卷的回答',
  `member_id` bigint(20) NULL DEFAULT NULL COMMENT '会员ID',
  `shop_id` bigint(20) NULL DEFAULT NULL COMMENT '店铺ID',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `star` tinyint(4) NULL DEFAULT NULL COMMENT '0-5星'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '问卷的回答' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
