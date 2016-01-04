# TopAutoRefreshListView

一个可以到顶自动加载更多的ListView，实现该控件的目的是用于im聊天页面场景，一些第三方实现的下拉加载更多也可以实现类似功能，但是由于他们实现的功能普遍比较复杂，效率相对较低，所以自己实现了该控件。

## 使用方法
普通的使用方法和ListView一样，额外添加了两个方法

### 设置Listener:

```
       mListView.setOnTopRefreshListener(new TopAutoRefreshListView.OnTopRefreshListener() {
            @Override
            public void onTopRefresh() {
                
            }
        });

```

你可以在onTopRefresh（）方法中，添加数据加载的方法.

### 停止刷新：

```
 mListView.onTopRefreshFinished();
```


## 问题
有什么问题，可以直接提交issus
或则联系我 email <763736665@qq.com>
