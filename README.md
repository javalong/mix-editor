####github地址

https://github.com/javalong/mix-editor

####前言

该项目主要是为了方便客户端进行图文编辑。当前版本1.1
如果大家需要的话，会持续更新。

####界面效果

v1.1

![拖拽文本](http://img.blog.csdn.net/20161023173900345)
![拖拽图片](http://img.blog.csdn.net/20161023173917268)

v1.0

![添加文本和图片](http://img.blog.csdn.net/20161016184827700)
![删除item提示](http://img.blog.csdn.net/20161016190759769)
![默认缺省页](http://img.blog.csdn.net/20161016190829133)

####版本更新内容

	v1.1

		实现可拖拽功能。

	v1.0

		基础功能实现，添加图片，文本。


####代码结构介绍

其实只是一个非常简单的图文编辑，我这里主要介绍下项目结构。

demo

    ---MainActivity  测试界面入口
lib

	--activity
		--EditMediaActivity  ***图文编辑界面***
	--adapter
		--MediaAdapter  ***图文编辑列表的adapter***
	--bean
		--Media  ***存储文本和图片信息的自定义类***
	--recyclerview
		--EditMediaRecyclerView ***图文编辑列表，继承RecyclerView***
		--SimpleItemTouchCallback ***拖拽功能回调类***
	--ui
		--EmptyView   ***默认缺省界面***
		--ImageMediaView  ***图片item***
		--ImageTextButton
		--MediaBottomLayout  ***底部按钮栏***
		--MediaButton
		--TextMediaView  ***文本item***
	--utils
		--DisplayUtils
		--StringUtils
		--ToastUtils
		--ViewUtils
	--viewholder
		--ViewHolder  ***万能的viewholder***

####其他
   目前只有简单的添加文本和图片功能，后续如果有需要的话，可能会添加以下功能：
   

 1. 整体预览
 2. 图片裁剪
 3. 视频添加
 4. 图片上传
 5. 图文编辑

等等～～

大家如果喜欢的可以点赞哦～～

