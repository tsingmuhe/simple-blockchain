package com.sunchangpeng.simple.blockchain;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class Block {
    public static int DIFFICULTY = 6;

    private String hash;
    private String data;
    private long timeStamp;
    private String previousHash;
    private int nonce;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = System.currentTimeMillis();
        mineBlock();
    }

    public String calculateHash() {
        return Hashing.sha256().hashString(previousHash + timeStamp + nonce + data, Charsets.UTF_8).toString();
    }

    public void mineBlock() {
        //Create a string with difficulty * "0"
        String target = new String(new char[DIFFICULTY]).replace('\0', '0');
        this.hash = calculateHash();
        while (!this.hash.substring(0, DIFFICULTY).equals(target)) {
            nonce++;
            this.hash = calculateHash();
        }
    }

    public String getHash() {
        return hash;
    }

    public String getData() {
        return data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    @Override
    public String toString() {
        return "Block{" +
                "hash='" + hash + '\'' +
                ", data='" + data + '\'' +
                ", timeStamp=" + timeStamp +
                ", previousHash='" + previousHash + '\'' +
                ", nonce=" + nonce +
                '}';
    }
}
