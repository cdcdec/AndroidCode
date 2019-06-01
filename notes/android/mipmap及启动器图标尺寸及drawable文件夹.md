#  mipmap及启动器图标尺寸及drawable文件夹

## 1. 启动器图标的存放位置
应该将所有启动器图标都置于 res/mipmap-[density]/ 文件夹而非 drawable/ 文件夹内，以确保启动器应用使用最佳分辨率图标.

* xxxhdpi   4.0
* xxhdpi    3.0
* xhdpi：  2.0
* hdpi：  1.5
* mdpi： 1.0（基准）
* ldpi：   0.75

## 2. 启动器图标的尺寸

* xxxhdpi   192x192
* xxhdpi    144x144
* xhdpi      96x96
* hdpi       72x72
* mdpi      48x48

## 3. 其它图标资源仍然放在drawable文件夹下

## 4.  Android Studio 新建drawable-hdpi、drawable-mdpi等

1) 在“res”文件夹上右键“New”->”Android Resource Directory”

2)从资源类型列表中选择“drawable”选项

3)在左窗格中选择“Density”并点击“>>”按钮

4)在右侧的“Density”列表中选择对应的资源项即可，例如选择“Medium Density”则对应的是“drawable-mdpi”，点击“OK”新建完毕





