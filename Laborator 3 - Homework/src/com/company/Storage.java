package com.company;

public interface Storage {
    int getStorageCapacity();
    default int StorageByte(){
        return getStorageCapacity() * 1_024 * 1_024 * 1_024;
    }
    default int StorageKilobyte(){
        return getStorageCapacity() * 1_024 * 1_024;
    }
    default int StorageMegabyte(){
        return getStorageCapacity() * 1_024;
    }
}