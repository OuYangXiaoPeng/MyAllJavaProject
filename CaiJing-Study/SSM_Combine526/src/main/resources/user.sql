DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                           `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                           `birthday` date NULL DEFAULT NULL,
                           `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'root', 'admin', '1998-10-10', '江西南昌');
INSERT INTO `t_user` VALUES (2, 'admin', '123', '1997-08-21', '福建福州');
INSERT INTO `t_user` VALUES (3, 'zhangsan', 'admin', '2000-09-09', '福建莆田');
INSERT INTO `t_user` VALUES (4, 'lisi', 'admin', '1996-12-10', '江西宜春');