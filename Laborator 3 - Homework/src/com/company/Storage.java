package com.company;

public interface Storage {
    int getStorageCapacity();
    default int StorageByte(int cap){
        return cap * 1_000;
    }
    default int StorageKilobyte(int cap){
        return cap * 100_000;
    }
    default int StorageMegabyte(int cap){
        return cap * 1_000_000;
    }
}