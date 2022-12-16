package com.ysten.netty;

import com.ysten.netty.bean.HostInfo;

import java.util.Map;

public class TcpClientFactory {

    public Map<HostInfo, TcpClient> mClientMap;
    public TcpClient getClient(HostInfo hostInfo) {
        return mClientMap.get(hostInfo);
    }
}
