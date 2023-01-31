public class BlockChain {
    Block genesis;
    int counter;

    public BlockChain() {
        counter = 0;
        genesis = null;
    }

    public void addBlock(String data) {
        if(genesis == null) {
            Block b = new Block(data, "0");
            genesis = b;
        } else {
            Block current = genesis;
            while (current.next != null) {
                current = current.next;
            }
            Block b = new Block(data, current.hash);
            current.next = b;
        }
        counter++;
    }

    public boolean IsValid() {
        int i=0;
        Block curr=genesis;
        Block prev;

        if(!(genesis.prevHash.equals("0")&&genesis.hash.equals(genesis.getSHA(genesis.data+genesis.timeStamp+genesis.prevHash)))) {

            return false;
        }
        while(curr.next!=null) {
            i++;
            prev=curr;
            curr=curr.next;
            if(!curr.hash.equals(curr.getSHA(curr.data+curr.timeStamp+curr.prevHash))) {
                return false;
            }
            if(!curr.prevHash.equals(prev.hash)) {
                return false;
            }
        }
        return true;

    }

    public void traverseBlockChain() {
        Block current = genesis;
        int i=1;
        while (current != null) {
            System.out.println("Block " + i);
            System.out.println("Data: " + current.data);
            System.out.println("Hash: " + current.hash);
            System.out.println("PrevHash: " + current.prevHash);
            System.out.println("TimeStamp: " + current.timeStamp);
            System.out.println();
            i++;
            current = current.next;
        }
        System.out.println();
    }

}
