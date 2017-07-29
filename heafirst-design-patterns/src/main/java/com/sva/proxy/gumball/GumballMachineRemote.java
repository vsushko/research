package com.sva.proxy.gumball;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author: vsa
 * @date: 23.10.16
 */
public interface GumballMachineRemote extends Remote {
    int getCount() throws RemoteException;

    String getLocation() throws RemoteException;

    State getState() throws RemoteException;
}
