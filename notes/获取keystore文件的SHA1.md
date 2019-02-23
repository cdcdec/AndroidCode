打开terminal或者cmd进入到keystore目录下，然后在终端中输入keytool -v -list -keystore key文件名.jks

```
输入密钥库口令:
密钥库类型: JKS
密钥库提供方: SUN

您的密钥库包含 1 个条目

别名: androidcode
创建日期: 2019年2月23日
条目类型: PrivateKeyEntry
证书链长度: 1
证书[1]:
所有者: CN=androidcode, OU=china, O=androidcode, L=beijing, ST=beijing, C=86
发布者: CN=androidcode, OU=china, O=androidcode, L=beijing, ST=beijing, C=86
序列号: 4916592c
生效时间: Sat Feb 23 06:22:23 CST 2019, 失效时间: Fri Feb 16 06:22:23 CST 2046
证书指纹:
         SHA1: 3B:03:D6:E5:06:BA:8A:37:C4:D4:D6:29:E9:89:DE:7C:FA:C2:66:D5
         SHA256: 7D:8F:AB:E8:A3:9E:18:04:23:07:81:E2:CE:D9:E3:21:B7:AE:F5:4C:FA:44:26:CB:7C:97:11:95:8E:29:5C:B0
签名算法名称: SHA256withRSA
主体公共密钥算法: 2048 位 RSA 密钥
版本: 3

扩展:

#1: ObjectId: 2.5.29.14 Criticality=false
SubjectKeyIdentifier [
KeyIdentifier [
0000: A3 2E 3B 64 AB FC 48 11   B0 56 58 37 D1 4A CD E0  ..;d..H..VX7.J..
0010: 1C 24 31 03                                        .$1.
]
]



*******************************************
*******************************************



Warning:
JKS 密钥库使用专用格式。建议使用 "keytool -importkeystore -srckeystore AndroidCode.jks -destkeystore AndroidCode.jks -deststoretype pkcs12" 迁移到行业标准格式 PKCS12。


```

