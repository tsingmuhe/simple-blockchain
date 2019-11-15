package com.sunchangpeng.simple.blockchain;

import java.util.ArrayList;


public class BlockChain extends ArrayList<Block> {

    public Boolean isChainValid() {
        for (int i = 1; i < size(); i++) {
            Block currentBlock = get(i);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            Block previousBlock = get(i - 1);
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                return false;
            }
        }

        return true;
    }
}
