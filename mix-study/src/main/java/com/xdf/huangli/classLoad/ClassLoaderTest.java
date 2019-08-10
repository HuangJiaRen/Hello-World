package com.xdf.huangli.classLoad;

import java.net.URL;

/**
 * @author huangli
 * @version 1.0
 * @description 获得根类加载器所加载的核心类库
 * @date 2019-08-09 15:06
 */
public class ClassLoaderTest {
    public static void main(String[] args) {

        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(URL url : urls){
            System.out.println(url.toExternalForm());
        }
    }

}
