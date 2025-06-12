package com.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.net.URI;

/**
 * 1.获取HDFS中nameNode服务器  hdfs://hadoop102:8020
 * 2.创建文件系统对象
 * 3.使用文件系统对象   对HDFS上的文件进行操作(创建目录，上传文件，下载文件，复制，移动，删除，授权等等)
 * 4.关闭文件系统对象
 * nameNode
 * dataNode
 * secondaryNameNode
 */
public class HDFSClient {

    private FileSystem fs;//文件系统对象（空对象）

    @Before
    public void initConn() throws Exception {
        /*
          参数：
          URI uri：连接地址
          Configuration conf：配置文件对象
          String user：用户名
         */
        URI uri = new URI("hdfs://hadoop102:8020");
        Configuration conf = new Configuration();
        conf.set("fs.replication", "2");//设置副本数
        fs = FileSystem.get(uri, conf, "oyxp");
    }

    @After
    public void closeConn() throws Exception {
        fs.close();
    }

    //创建目录
    @Test
    public void testMkdirs() throws Exception {

        Path path = new Path("/sanguo/shuguo");
        if (fs.mkdirs(path)) {
            System.out.println("mkdirs success!");
        }

    }

    @Test
    public void put() throws Exception {

        Path src = new Path("D:/hadoop-3.1.0/files/liubei.txt");
        Path dst = new Path("/sanguo/shuguo");
        /**
         * delSrc:
         * overwrite
         * Path src
         * Path dst
         */
        fs.copyFromLocalFile(false, true, src, dst);
    }


    @Test
    public void get() throws Exception {
        // 2 执行下载操作
        // boolean delSrc 指是否将原文件删除
        // Path src 指要下载的文件路径
        // Path dst 指将文件下载到的路径
        // boolean useRawLocalFileSystem 是否开启文件校验
        Path src = new Path("/sanguo/shuguo/liubei.txt");
        Path dst = new Path("D:/hadoop-3.1.0/files/");
        fs.copyToLocalFile(false, src, dst, true);
    }

    @Test//移动
    public void remove() throws Exception {
        Path src = new Path("/sanguo/shuguo/liubei.txt");
        Path dst = new Path("/");
        fs.rename(src, dst);
    }

    @Test
    public void del() throws Exception {
        Path src = new Path("/sanguo");
        /**
         * 第二个是否递归删除
         */
        fs.delete(src, true);
    }

    //文件详情
    @Test
    public void list() throws Exception {
        Path src = new Path("/");
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(src, true);

        while (listFiles.hasNext()) {
            LocatedFileStatus fileStatus = listFiles.next();

            System.out.println(fileStatus.getPermission() + "\t" + fileStatus.getOwner()
                    + "\t" + fileStatus.getGroup() + "\t" + fileStatus.getLen()
                    + "\t" + fileStatus.getModificationTime() + "\t" + fileStatus.getReplication()
                    + "\t" + fileStatus.getBlockSize() + "\t" + fileStatus.getPath().getName());
        }
    }

    /**
     * 查看是目录还是文件
     */
    @Test
    public void fileStatus() throws Exception {
        FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
        for (FileStatus file : fileStatuses) {
            if (file.isDirectory()) {
                System.out.println("目录:" + file.getPath().getName());
            } else {
                System.out.println("文件:" + file.getPath().getName());
            }
        }
    }

}
