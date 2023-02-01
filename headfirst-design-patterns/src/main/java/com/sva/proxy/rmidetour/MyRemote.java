package com.sva.proxy.rmidetour;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author: vsa
 * @date: 22.10.16
 */
public interface MyRemote extends Remote {

    String sayHello() throws RemoteException;
}
