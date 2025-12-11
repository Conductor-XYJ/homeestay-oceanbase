/*
 Navicat Premium Data Transfer

 Source Server         : mysql-ustb
 Source Server Type    : MySQL
 Source Server Version : 80003
 Source Host           : localhost:3306
 Source Schema         : homeestay_ustb

 Target Server Type    : MySQL
 Target Server Version : 80003
 File Encoding         : 65001

 Date: 11/12/2025 13:37:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_chat_message
-- ----------------------------
DROP TABLE IF EXISTS `t_chat_message`;
CREATE TABLE `t_chat_message`  (
  `message_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sender_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `receiver_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `message_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `timestamp` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  `message_read` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_chat_message
-- ----------------------------
INSERT INTO `t_chat_message` VALUES ('1844583057597243394', '10001', '10002', '你好房东', '2024-10-11 11:37:26', 1);
INSERT INTO `t_chat_message` VALUES ('1844583107073253377', '10001', '10002', '你好房东啊', '2024-10-11 11:37:38', 1);
INSERT INTO `t_chat_message` VALUES ('M1002', '10002', '10001', '消息回复测试', '2024-10-12 15:30:49', 1);

-- ----------------------------
-- Table structure for t_facility
-- ----------------------------
DROP TABLE IF EXISTS `t_facility`;
CREATE TABLE `t_facility`  (
  `facility_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `facility_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`facility_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_facility
-- ----------------------------
INSERT INTO `t_facility` VALUES ('1', '近公交站');
INSERT INTO `t_facility` VALUES ('2', '近地铁站');
INSERT INTO `t_facility` VALUES ('3', '近机场');
INSERT INTO `t_facility` VALUES ('4', '可以做饭');
INSERT INTO `t_facility` VALUES ('5', '免费停车');
INSERT INTO `t_facility` VALUES ('6', '收费停车');
INSERT INTO `t_facility` VALUES ('7', '提供早餐');
INSERT INTO `t_facility` VALUES ('8', '提供三餐');
INSERT INTO `t_facility` VALUES ('9', '免费接送');

-- ----------------------------
-- Table structure for t_favorite
-- ----------------------------
DROP TABLE IF EXISTS `t_favorite`;
CREATE TABLE `t_favorite`  (
  `favorite_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `property_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`favorite_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_favorite
-- ----------------------------
INSERT INTO `t_favorite` VALUES ('S1001', '10002', 'P001');
INSERT INTO `t_favorite` VALUES ('S1002', '10002', 'P002');

-- ----------------------------
-- Table structure for t_image
-- ----------------------------
DROP TABLE IF EXISTS `t_image`;
CREATE TABLE `t_image`  (
  `image_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_image
-- ----------------------------
INSERT INTO `t_image` VALUES ('1868215751364636673', 'http://example.com/image11.jpg');
INSERT INTO `t_image` VALUES ('1868215751435939842', 'http://example.com/image12.jpg');
INSERT INTO `t_image` VALUES ('1868215751435939843', 'http://example.com/image13.jpg');
INSERT INTO `t_image` VALUES ('I001', 'http://example.com/image1.jpg');
INSERT INTO `t_image` VALUES ('I002', 'http://example.com/image2.jpg');
INSERT INTO `t_image` VALUES ('I003', 'http://example.com/image3.jpg');
INSERT INTO `t_image` VALUES ('I004', 'http://example.com/image4.jpg');
INSERT INTO `t_image` VALUES ('I005', 'http://example.com/image5.jpg');
INSERT INTO `t_image` VALUES ('I006', 'http://example.com/image6.jpg');
INSERT INTO `t_image` VALUES ('I007', 'http://example.com/image7.jpg');
INSERT INTO `t_image` VALUES ('I008', 'http://example.com/image8.jpg');
INSERT INTO `t_image` VALUES ('I009', 'http://example.com/image9.jpg');
INSERT INTO `t_image` VALUES ('I010', 'http://example.com/image10.jpg');

-- ----------------------------
-- Table structure for t_orders
-- ----------------------------
DROP TABLE IF EXISTS `t_orders`;
CREATE TABLE `t_orders`  (
  `order_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `property_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `check_in_date` date NOT NULL,
  `check_out_date` date NOT NULL,
  `num_guests` int(11) NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `contact_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `order_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_orders
-- ----------------------------
INSERT INTO `t_orders` VALUES ('1857308405397024770', 'P001', 299.99, '2024-12-01', '2024-12-07', 2, '13800000000', '张三', '10002', '已支付');
INSERT INTO `t_orders` VALUES ('1872937182820360193', 'P002', 600.00, '2024-12-28', '2024-12-29', 3, '19870371576', '肖逸嘉', '10003', '已支付');

-- ----------------------------
-- Table structure for t_property
-- ----------------------------
DROP TABLE IF EXISTS `t_property`;
CREATE TABLE `t_property`  (
  `property_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `deposit` decimal(10, 2) NULL DEFAULT NULL,
  `rent` decimal(10, 2) NULL DEFAULT NULL,
  `region_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `rental_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `capacity` int(11) NULL DEFAULT NULL,
  `bedrooms` int(11) NULL DEFAULT NULL,
  `beds` int(11) NULL DEFAULT NULL,
  `bathrooms` int(11) NULL DEFAULT NULL,
  `area` decimal(10, 2) NULL DEFAULT NULL,
  `longitude` double(50, 6) NULL DEFAULT NULL COMMENT '经度',
  `latitude` double(50, 6) NULL DEFAULT NULL COMMENT '维度',
  PRIMARY KEY (`property_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_property
-- ----------------------------
INSERT INTO `t_property` VALUES ('1868215750987149313', '测试的公寓', '珠海某地', 10000.00, 20000.00, 'R001', '月租', '靠近海边，非常适合度假', '10002', 4, 2, 2, 1, 80.00, 113.576726, 22.271722);
INSERT INTO `t_property` VALUES ('P001', '现代豪华公寓', '珠海市香洲区凤凰路', 1000.00, 3500.00, 'R001', '月租', '全新装修，交通便利，设施齐全', '10002', 4, 2, 3, 1, 90.00, 113.576726, 22.271722);
INSERT INTO `t_property` VALUES ('P002', '热门海景房', '海南市三亚湾', 2000.00, 5000.00, 'R003', '日租', '面朝大海，春暖花开', '10002', 2, 1, 1, 1, 60.00, 109.517750, 18.252847);
INSERT INTO `t_property` VALUES ('P003', '舒适家庭住宅', '成都市锦江区东大街', 1500.00, 4000.00, 'R004', '月租', '家具齐全，适合家庭入住', '10002', 6, 3, 4, 2, 120.00, 104.091037, 30.656371);
INSERT INTO `t_property` VALUES ('P004', '小资风情公寓', '吉隆坡市中心', 1000.00, 3000.00, 'R002', '月租', '靠近商场，购物方便，设计时尚', '10002', 2, 1, 1, 1, 50.00, 101.711643, 3.152592);
INSERT INTO `t_property` VALUES ('P005', '温馨度假别墅', '济州岛南部', 5000.00, 10000.00, 'R005', '日租', '独栋别墅，带私家花园', '10002', 8, 4, 5, 3, 200.00, 126.531188, 33.499621);
INSERT INTO `t_property` VALUES ('P006', '高端商务公寓', '珠海市横琴新区', 2000.00, 7000.00, 'R001', '月租', '适合高端商务人士，拎包入住', '10002', 3, 2, 2, 2, 85.00, 113.551262, 22.110814);
INSERT INTO `t_property` VALUES ('P007', '山景度假房', '海南五指山', 2500.00, 5500.00, 'R003', '日租', '靠近自然风景区，空气清新', '10002', 4, 2, 3, 1, 100.00, 109.515441, 18.775146);
INSERT INTO `t_property` VALUES ('P008', '舒适单间公寓', '成都市武侯区', 800.00, 2500.00, 'R004', '月租', '交通便利，适合单身居住', '10002', 1, 1, 1, 1, 40.00, 104.043487, 30.650863);
INSERT INTO `t_property` VALUES ('P009', '豪华海滩别墅', '三亚市海棠湾', 4000.00, 8000.00, 'R003', '日租', '靠近海滩，风景优美，带游泳池', '10002', 10, 5, 6, 4, 300.00, 109.745726, 18.392512);
INSERT INTO `t_property` VALUES ('P010', '市中心便利公寓', '吉隆坡武吉免登', 1200.00, 3200.00, 'R002', '月租', '位于市中心，交通非常便利', '10002', 2, 1, 1, 1, 55.00, 101.708186, 3.145774);

-- ----------------------------
-- Table structure for t_property_facility
-- ----------------------------
DROP TABLE IF EXISTS `t_property_facility`;
CREATE TABLE `t_property_facility`  (
  `property_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `facility_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_property_facility
-- ----------------------------
INSERT INTO `t_property_facility` VALUES ('P001', '1');
INSERT INTO `t_property_facility` VALUES ('P001', '2');
INSERT INTO `t_property_facility` VALUES ('P001', '3');
INSERT INTO `t_property_facility` VALUES ('P002', '4');
INSERT INTO `t_property_facility` VALUES ('P002', '5');
INSERT INTO `t_property_facility` VALUES ('P002', '6');
INSERT INTO `t_property_facility` VALUES ('P003', '7');
INSERT INTO `t_property_facility` VALUES ('P003', '8');
INSERT INTO `t_property_facility` VALUES ('P003', '9');
INSERT INTO `t_property_facility` VALUES ('P004', '1');
INSERT INTO `t_property_facility` VALUES ('P004', '4');
INSERT INTO `t_property_facility` VALUES ('P004', '5');
INSERT INTO `t_property_facility` VALUES ('P005', '2');
INSERT INTO `t_property_facility` VALUES ('P005', '3');
INSERT INTO `t_property_facility` VALUES ('P005', '8');
INSERT INTO `t_property_facility` VALUES ('P006', '6');
INSERT INTO `t_property_facility` VALUES ('P006', '7');
INSERT INTO `t_property_facility` VALUES ('P006', '9');
INSERT INTO `t_property_facility` VALUES ('P007', '1');
INSERT INTO `t_property_facility` VALUES ('P007', '2');
INSERT INTO `t_property_facility` VALUES ('P007', '4');
INSERT INTO `t_property_facility` VALUES ('P008', '5');
INSERT INTO `t_property_facility` VALUES ('P008', '8');
INSERT INTO `t_property_facility` VALUES ('P008', '3');
INSERT INTO `t_property_facility` VALUES ('P009', '7');
INSERT INTO `t_property_facility` VALUES ('P009', '6');
INSERT INTO `t_property_facility` VALUES ('P009', '2');
INSERT INTO `t_property_facility` VALUES ('P010', '1');
INSERT INTO `t_property_facility` VALUES ('P010', '5');
INSERT INTO `t_property_facility` VALUES ('P010', '4');
INSERT INTO `t_property_facility` VALUES ('1868215750987149313', '1');
INSERT INTO `t_property_facility` VALUES ('1868215750987149313', '2');
INSERT INTO `t_property_facility` VALUES ('1868215750987149313', '5');

-- ----------------------------
-- Table structure for t_property_image
-- ----------------------------
DROP TABLE IF EXISTS `t_property_image`;
CREATE TABLE `t_property_image`  (
  `property_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `image_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_property_image
-- ----------------------------
INSERT INTO `t_property_image` VALUES ('P001', 'I001');
INSERT INTO `t_property_image` VALUES ('P001', 'I002');
INSERT INTO `t_property_image` VALUES ('P001', 'I003');
INSERT INTO `t_property_image` VALUES ('P002', 'I004');
INSERT INTO `t_property_image` VALUES ('P002', 'I005');
INSERT INTO `t_property_image` VALUES ('P002', 'I006');
INSERT INTO `t_property_image` VALUES ('P003', 'I007');
INSERT INTO `t_property_image` VALUES ('P003', 'I008');
INSERT INTO `t_property_image` VALUES ('P003', 'I009');
INSERT INTO `t_property_image` VALUES ('P004', 'I010');
INSERT INTO `t_property_image` VALUES ('P004', 'I001');
INSERT INTO `t_property_image` VALUES ('P004', 'I002');
INSERT INTO `t_property_image` VALUES ('P005', 'I003');
INSERT INTO `t_property_image` VALUES ('P005', 'I004');
INSERT INTO `t_property_image` VALUES ('P005', 'I005');
INSERT INTO `t_property_image` VALUES ('P006', 'I006');
INSERT INTO `t_property_image` VALUES ('P006', 'I007');
INSERT INTO `t_property_image` VALUES ('P006', 'I008');
INSERT INTO `t_property_image` VALUES ('P007', 'I009');
INSERT INTO `t_property_image` VALUES ('P007', 'I010');
INSERT INTO `t_property_image` VALUES ('P007', 'I001');
INSERT INTO `t_property_image` VALUES ('P008', 'I002');
INSERT INTO `t_property_image` VALUES ('P008', 'I003');
INSERT INTO `t_property_image` VALUES ('P008', 'I004');
INSERT INTO `t_property_image` VALUES ('P009', 'I005');
INSERT INTO `t_property_image` VALUES ('P009', 'I006');
INSERT INTO `t_property_image` VALUES ('P009', 'I007');
INSERT INTO `t_property_image` VALUES ('P010', 'I008');
INSERT INTO `t_property_image` VALUES ('P010', 'I009');
INSERT INTO `t_property_image` VALUES ('P010', 'I010');
INSERT INTO `t_property_image` VALUES ('1868215750987149313', '1868215751364636673');
INSERT INTO `t_property_image` VALUES ('1868215750987149313', '1868215751435939842');
INSERT INTO `t_property_image` VALUES ('1868215750987149313', '1868215751435939843');

-- ----------------------------
-- Table structure for t_region
-- ----------------------------
DROP TABLE IF EXISTS `t_region`;
CREATE TABLE `t_region`  (
  `region_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `region_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`region_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_region
-- ----------------------------
INSERT INTO `t_region` VALUES ('R001', '珠海');
INSERT INTO `t_region` VALUES ('R002', '吉隆坡');
INSERT INTO `t_region` VALUES ('R003', '海南');
INSERT INTO `t_region` VALUES ('R004', '成都');
INSERT INTO `t_region` VALUES ('R005', '济州岛');

-- ----------------------------
-- Table structure for t_review
-- ----------------------------
DROP TABLE IF EXISTS `t_review`;
CREATE TABLE `t_review`  (
  `review_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `property_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `rating` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`review_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_review
-- ----------------------------
INSERT INTO `t_review` VALUES ('R001', '10003', 'P001', '非常不错的体验，环境很好！', 5);
INSERT INTO `t_review` VALUES ('R002', '10003', 'P001', '房间干净整洁，服务态度很好。', 4);
INSERT INTO `t_review` VALUES ('R003', '10003', 'P001', '性价比高，值得推荐。', 5);
INSERT INTO `t_review` VALUES ('R004', '10003', 'P001', '交通便利，住得很舒适。', 4);
INSERT INTO `t_review` VALUES ('R005', '10003', 'P001', '整体不错，但希望可以改善设施。', 3);
INSERT INTO `t_review` VALUES ('R006', '10003', 'P002', '位置很好，适合短途旅行。', 4);
INSERT INTO `t_review` VALUES ('R007', '10003', 'P002', '单间小巧，干净整洁。', 5);
INSERT INTO `t_review` VALUES ('R008', '10003', 'P002', '性价比很高，值得入住。', 4);
INSERT INTO `t_review` VALUES ('R009', '10003', 'P002', '房东很热情，体验不错。', 5);
INSERT INTO `t_review` VALUES ('R010', '10003', 'P002', '可以做饭，方便。', 4);
INSERT INTO `t_review` VALUES ('R011', '10003', 'P003', '绝佳的海景，真的很美！', 5);
INSERT INTO `t_review` VALUES ('R012', '10003', 'P003', '适合家庭度假，空间很大。', 5);
INSERT INTO `t_review` VALUES ('R013', '10003', 'P003', '非常满意，位置很棒。', 5);
INSERT INTO `t_review` VALUES ('R014', '10003', 'P003', '设施齐全，非常方便。', 4);
INSERT INTO `t_review` VALUES ('R015', '10003', 'P003', '值得再次入住。', 5);
INSERT INTO `t_review` VALUES ('R016', '10003', 'P004', '时尚的装修，住得很舒服。', 4);
INSERT INTO `t_review` VALUES ('R017', '10003', 'P004', '环境不错，但希望可以更安静。', 3);
INSERT INTO `t_review` VALUES ('R018', '10003', 'P004', '整体体验很不错，值得推荐。', 4);
INSERT INTO `t_review` VALUES ('R019', '10003', 'P004', '出门就能找到吃的，非常方便。', 5);
INSERT INTO `t_review` VALUES ('R020', '10003', 'P004', '价格合适，性价比高。', 4);
INSERT INTO `t_review` VALUES ('R021', '10003', 'P005', '安静舒适，适合度假。', 5);
INSERT INTO `t_review` VALUES ('R022', '10003', 'P005', '位置偏远，但环境很好。', 4);
INSERT INTO `t_review` VALUES ('R023', '10003', 'P005', '房东热情好客，体验不错。', 5);
INSERT INTO `t_review` VALUES ('R024', '10003', 'P005', '整体满意，值得再次入住。', 5);
INSERT INTO `t_review` VALUES ('R025', '10003', 'P005', '设施还可以再升级。', 3);
INSERT INTO `t_review` VALUES ('R026', '10003', 'P006', '近海，风景美丽！', 5);
INSERT INTO `t_review` VALUES ('R027', '10003', 'P006', '适合全家出行，空间大。', 4);
INSERT INTO `t_review` VALUES ('R028', '10003', 'P006', '设施齐全，服务周到。', 5);
INSERT INTO `t_review` VALUES ('R029', '10003', 'P006', '海边度假，真是太好了。', 5);
INSERT INTO `t_review` VALUES ('R030', '10003', 'P006', '有一些小问题，但总体不错。', 4);
INSERT INTO `t_review` VALUES ('R031', '10003', 'P007', '交通便利，性价比高。', 4);
INSERT INTO `t_review` VALUES ('R032', '10003', 'P007', '小而美，适合短租。', 5);
INSERT INTO `t_review` VALUES ('R033', '10003', 'P007', '整体还不错，环境很好。', 4);
INSERT INTO `t_review` VALUES ('R034', '10003', 'P007', '房间温馨，住得很舒适。', 5);
INSERT INTO `t_review` VALUES ('R035', '10003', 'P007', '希望可以再改进一些设施。', 3);
INSERT INTO `t_review` VALUES ('R036', '10003', 'P008', '早餐很丰富，满意！', 5);
INSERT INTO `t_review` VALUES ('R037', '10003', 'P008', '环境优雅，住得很开心。', 5);
INSERT INTO `t_review` VALUES ('R038', '10003', 'P008', '可以做饭，方便很多。', 4);
INSERT INTO `t_review` VALUES ('R039', '10003', 'P008', '整体非常好，推荐！', 5);
INSERT INTO `t_review` VALUES ('R040', '10003', 'P008', '周围有很多好吃的地方。', 4);
INSERT INTO `t_review` VALUES ('R041', '10003', 'P009', '健身房不错，整体满意。', 4);
INSERT INTO `t_review` VALUES ('R042', '10003', 'P009', '现代化设施，住得舒服。', 5);
INSERT INTO `t_review` VALUES ('R043', '10003', 'P009', '性价比高，值得入住。', 4);
INSERT INTO `t_review` VALUES ('R044', '10003', 'P009', '整体体验不错，房东热情。', 5);
INSERT INTO `t_review` VALUES ('R045', '10003', 'P009', '房间有点小，但很整洁。', 3);
INSERT INTO `t_review` VALUES ('R046', '10003', 'P010', '乡村环境，适合放松。', 5);
INSERT INTO `t_review` VALUES ('R047', '10003', 'P010', '房东很好，服务到位。', 4);
INSERT INTO `t_review` VALUES ('R048', '10003', 'P010', '安静，适合休闲度假。', 5);
INSERT INTO `t_review` VALUES ('R049', '10003', 'P010', '房间干净，体验不错。', 4);
INSERT INTO `t_review` VALUES ('R050', '10003', 'P010', '希望可以再增加一些设施。', 3);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_gender` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_card_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_hobby` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_occupation` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('10002', '李四', '999999', '女', '18210041380', '110111199910104568', '足球', '北京海淀', '大老板');
INSERT INTO `t_user` VALUES ('10003', '王二', '000000', '男', '12345678912', '110111199909091234', '排球', '北京朝阳', '拆迁户');
INSERT INTO `t_user` VALUES ('10004', '麻子', '111111', '男', '15912344567', '110111199808084568', '足球', '北京大兴', '拆迁户');

SET FOREIGN_KEY_CHECKS = 1;
