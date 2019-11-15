package com.sunchangpeng.simple.blockchain;


import com.google.gson.GsonBuilder;
import org.junit.Test;

public class BlockTest {
    @Test
    public void block() {
        Block genesisBlock = new Block("Hi im the first block", "0");
        System.out.println("block 1 : " + genesisBlock);

        Block secondBlock = new Block("Yo im the second block", genesisBlock.getHash());
        System.out.println("block 2 : " + secondBlock);

        Block thirdBlock = new Block("Hey im the third block", secondBlock.getHash());
        System.out.println("block 3 : " + thirdBlock);
    }

    @Test
    public void block_json() {
        long start,end;
        BlockChain blockchain = new BlockChain();


        start = System.currentTimeMillis();
        Block genesisBlock = new Block("Hi im the first block", "0");
        blockchain.add(genesisBlock);
        end = System.currentTimeMillis();
        System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");

        start = System.currentTimeMillis();
        Block secondBlock = new Block("Yo im the second block", genesisBlock.getHash());
        blockchain.add(secondBlock);
        end = System.currentTimeMillis();
        System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");

        start = System.currentTimeMillis();
        Block thirdBlock = new Block("Hey im the third block", secondBlock.getHash());
        blockchain.add(thirdBlock);
        end = System.currentTimeMillis();
        System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");


        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
        System.out.println(blockchain.isChainValid());
    }
}