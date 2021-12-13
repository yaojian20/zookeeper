package com.yao.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.*;

/**
 * Created by yaojian on 2021/12/13 9:25
 *
 * @author
 */
public class CuratorDemo {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorUtil.getInstance();
        CuratorCache curatorCache = CuratorCache.builder(curatorFramework,"/node").build();
        PathChildrenCacheListener listener = new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                System.out.println("hello,eventType is :" + pathChildrenCacheEvent.getType());
            }
        };
        CuratorCacheListener cacheListener = CuratorCacheListener.builder().forPathChildrenCache("/node",curatorFramework,listener).build();
        curatorCache.listenable().addListener(cacheListener);
        curatorCache.listenable().addListener(new CuratorCacheListener() {
            @Override
            public void event(Type type, ChildData oldData, ChildData data) {
                System.out.println("==================================================");
                System.out.println(type);
            }
        });
        curatorCache.start();
        curatorFramework.create().creatingParentsIfNeeded().forPath("/node","value".getBytes());
        curatorFramework.setData().forPath("/node","value2".getBytes());
        curatorFramework.create().creatingParentsIfNeeded().forPath("/node/child","123".getBytes());
        curatorFramework.delete().deletingChildrenIfNeeded().forPath("/node");
        System.in.read();
    }

}
