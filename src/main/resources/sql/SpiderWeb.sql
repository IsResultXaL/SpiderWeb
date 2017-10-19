-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE SpiderWeb;
-- 使用数据库
USE SpiderWeb;

-- 创建世纪佳缘用户表
CREATE TABLE UserByJiaYuan(
    `user_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `realUid` BIGINT NOT NULL COMMENT '世纪佳缘Uid',
    `nickname` VARCHAR(100) NOT NULL COMMENT '昵称',
    `sex` VARCHAR(10) COMMENT '性别',
    `age` INT(3) COMMENT '年龄',
    `marriage` VARCHAR(10) COMMENT '婚否',
    `height` VARCHAR(10) COMMENT '身高',
    `education` VARCHAR(100) COMMENT '教育',
    `localhost` VARCHAR(100) COMMENT '居住地',
    `province` VARCHAR(100) COMMENT '省份',
    `image` VARCHAR(500) COMMENT '头像Url',
    `randTag` VARCHAR(500) COMMENT '标签1',
    `randListTag` VARCHAR(500) COMMENT '标签2',
    `shortnote` VARCHAR(500) COMMENT '介绍',
    `matchCondition` VARCHAR(500) COMMENT '择偶条件',
    `helloUrl` VARCHAR(200) COMMENT '打招呼Url',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间',
    PRIMARY KEY (`user_id`),
	  KEY `userbyjiayuan_create_time` (`create_time`),
	  KEY `userbyjiayuan_sex` (`sex`),
	  KEY `userbyjiayuan_age` (`age`),
	  KEY `userbyjiayuan_height` (`height`),
	  KEY `userbyjiayuan_localhost` (`localhost`),
	  KEY `userbyjiayuan_province` (`province`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='世纪佳缘用户表'

ALTER TABLE userbyjiayuan ADD INDEX userbyjiayuan_province_sex (province,sex)

UPDATE userbyjiayuan SET province="澳门" WHERE localhost = "澳门";
UPDATE userbyjiayuan SET province="香港" WHERE localhost = "香港";
UPDATE userbyjiayuan SET province="台湾" WHERE localhost = "台湾";
UPDATE userbyjiayuan SET province="海南" WHERE localhost in ("海口","三亚","儋州","三沙","五指山","琼海","文昌","万宁","东方");
UPDATE userbyjiayuan SET province="宁夏" WHERE localhost in ("银川","石嘴山","吴忠","固原","中卫");
UPDATE userbyjiayuan SET province="四川" WHERE localhost in ("成都","自贡","攀枝花","泸州","德阳","绵阳","广元","遂宁","内江","乐山","南充","眉山","宜宾","广安","达州","雅安","巴中","资阳");
UPDATE userbyjiayuan SET province="西藏" WHERE localhost in ("拉萨","日喀则","昌都","林芝","山南");
UPDATE userbyjiayuan SET province="青海" WHERE localhost in ("西宁","海东");
UPDATE userbyjiayuan SET province="广东" WHERE localhost in ("广州","深圳","清远","韶关","河源","梅州","潮州","肇庆","云浮","佛山","东莞","惠州","汕尾","揭阳","汕头","湛江","茂名","阳江","江门","中山","珠海");
UPDATE userbyjiayuan SET province="贵州" WHERE localhost in ("贵阳","六盘水","遵义","安顺","铜仁","毕节");
UPDATE userbyjiayuan SET province="福建" WHERE localhost in ("福州","厦门","莆田","三明","泉州","漳州","南平","龙岩","宁德");
UPDATE userbyjiayuan SET province="吉林" WHERE localhost in ("长春","吉林","四平","辽源","通化","白山","松原","白城");
UPDATE userbyjiayuan SET province="陕西" WHERE localhost in ("咸阳","西安","延安","榆林","渭南","商洛","安康","汉中","宝鸡","铜川","杨凌");
UPDATE userbyjiayuan SET province="内蒙古" WHERE localhost in ("呼和浩特","包头","乌海","赤峰","通辽","鄂尔多斯","呼伦贝尔","巴彦淖尔","乌兰察布");
UPDATE userbyjiayuan SET province="山西" WHERE localhost in ("太原","大同","阳泉","长治","晋城","朔州","晋中","运城","忻州","临汾","吕梁");
UPDATE userbyjiayuan SET province="甘肃" WHERE localhost in ("酒泉","嘉峪关","张掖","金昌","武威","白银","兰州","定西","陇南","天水","平凉","庆阳");
UPDATE userbyjiayuan SET province="广西" WHERE localhost in ("百色","河池","柳州","桂林","贺州","崇左","南宁","来宾","贵港","梧州","防城港","钦州","北海","玉林");
UPDATE userbyjiayuan SET province="湖北" WHERE localhost in ("武汉","黄石","十堰","宜昌","襄阳","鄂州","荆门","孝感","荆州","黄冈","咸宁","随州","仙桃","潜江","天门");
UPDATE userbyjiayuan SET province="江西" WHERE localhost in ("南昌","抚州","赣州","吉安","景德镇","九江","萍乡","上饶","新余","宜春","鹰潭");
UPDATE userbyjiayuan SET province="浙江" WHERE localhost in ("杭州","宁波","温州","嘉兴","湖州","绍兴","金华","衢州","舟山","台州","丽水");
UPDATE userbyjiayuan SET province="江苏" WHERE localhost in ("苏州","徐州","南京","南通","盐城","无锡","淮安","宿迁","泰州","常州","扬州","连云港","镇江");
UPDATE userbyjiayuan SET province="新疆" WHERE localhost in ("乌鲁木齐","克拉玛依","吐鲁番","哈密");
UPDATE userbyjiayuan SET province="山东" WHERE localhost in ("济南","青岛","滨州","德州","东营","菏泽","济宁","莱芜","聊城","临沂","日照","泰安","潍坊","威海","烟台","枣庄","淄博");
UPDATE userbyjiayuan SET province="安徽" WHERE localhost in ("合肥","芜湖","蚌埠","淮南","马鞍山","淮北","铜陵","安庆","黄山","滁州","阜阳","宿州","六安","亳州","池州","宣城");
UPDATE userbyjiayuan SET province="湖南" WHERE localhost in ("长沙","株洲","湘潭","衡阳","邵阳","岳阳","常德","张家界","益阳","郴州","永州","怀化","娄底");
UPDATE userbyjiayuan SET province="黑龙江" WHERE localhost in ("哈尔滨","齐齐哈尔","鸡西","鹤岗","双鸭山","大庆","伊春","佳木斯","七台河","牡丹江","黑河","绥化");
UPDATE userbyjiayuan SET province="辽宁" WHERE localhost in ("沈阳","大连","营口","鞍山","抚顺","锦州","本溪","丹东","阜新","辽阳","铁岭","朝阳","盘锦","葫芦岛");
UPDATE userbyjiayuan SET province="云南" WHERE localhost in ("昆明","曲靖","玉溪","保山","昭通","丽江","普洱","临沧");
UPDATE userbyjiayuan SET province="河南" WHERE localhost in ("郑州","安阳","鹤壁","焦作","开封","漯河","洛阳","南阳","平顶山","濮阳","三门峡","商丘","新乡","信阳","许昌","周口","驻马店","济源");
UPDATE userbyjiayuan SET province="河北" WHERE localhost in ("石家庄","唐山","秦皇岛","邯郸","邢台","保定","张家口","承德","沧州","廊坊","衡水");
UPDATE userbyjiayuan SET province="重庆" WHERE localhost in ("渝中","大渡口","江北","沙坪坝","九龙坡","南岸","北碚","綦江","大足","渝北","巴南","万州","涪陵","黔江","长寿","合川","永川","江津","南川");
UPDATE userbyjiayuan SET province="上海" WHERE localhost in ("黄浦","徐汇","长宁","静安","普陀","虹口","杨浦","闵行","宝山","嘉定","浦东新区","金山","松江","青浦","奉贤","崇明");
UPDATE userbyjiayuan SET province="天津" WHERE localhost in ("和平","河东","河西","南开","河北","红桥","滨海新区","东丽","西青","津南","北辰","武清","宝坻","宁河","静海","蓟州");
UPDATE userbyjiayuan SET province="北京" WHERE localhost in ("东城","西城","朝阳","丰台","石景山","海淀","门头沟","房山","通州","顺义","昌平","大兴","怀柔","平谷","密云","延庆");

UPDATE userbyjiayuan SET province = "重庆" WHERE localhost in ("万盛","云阳","奉节","巫山");
UPDATE userbyjiayuan SET province = "内蒙古" WHERE localhost in ("乌兰察布盟");
UPDATE userbyjiayuan SET province = "新疆" WHERE localhost in ("伊犁","塔城","昌吉","石河子");
UPDATE userbyjiayuan SET province = "上海" WHERE localhost in ("卢湾","闸北");
UPDATE userbyjiayuan SET province = "湖南" WHERE localhost in ("吉首","湘西");
UPDATE userbyjiayuan SET province = "天津" WHERE localhost in ("塘沽","大港");
UPDATE userbyjiayuan SET province = "云南" WHERE localhost in ("大理","德宏","文山","楚雄","红河");
UPDATE userbyjiayuan SET province = "北京" WHERE localhost in ("宣武","崇文");
UPDATE userbyjiayuan SET province = "吉林" WHERE localhost in ("延吉","延边","梅河口");
UPDATE userbyjiayuan SET province = "湖北" WHERE localhost in ("恩施");
UPDATE userbyjiayuan SET province = "福建" WHERE localhost in ("福建");
UPDATE userbyjiayuan SET province = "台湾" WHERE localhost in ("钓鱼岛");
UPDATE userbyjiayuan SET province = "广东" WHERE localhost in ("顺德");
UPDATE userbyjiayuan SET province = "贵州" WHERE localhost in ("黔东南","黔南");
