package skew.heap;

/**
 * Created by yaros on 13.04.18.
 */
public class SkewHeap {
    public int root;
    public SkewHeap left;
    public SkewHeap right;
    public static String buffer = "";

    public SkewHeap(int root){
        this.root = root;
    }

    public SkewHeap(int root, SkewHeap left, SkewHeap right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }
    public SkewHeap(){}

    public void merge(SkewHeap heap){
        if (heap == null) {
            return;
        }
        log("Merge " + this.root + " with " + heap.root);
        if (this.root > heap.root) {
            heap = this.swapTopRoot(heap);
            log("Swap " + this.root + " with " + heap.root);
        }
        if (this.right != null) {
            log("Right of " + this.root + " is not empty");
            this.right.merge(heap);
        } else {
            this.right = heap;
            log("End of merge");
        }
        this.swapChildrens();
        log("Swap childrens of " + this.root);
    }

    public void add(int value) {
        this.merge(new SkewHeap(value));
    }

    public void log(String comment){
        buffer += comment + ": ";
        inorder();
        buffer += '\n';
    }

    public void inorder()
    {
        if (this.left != null)
            this.left.inorder();
        buffer += root + " ";
        if (this.right != null)
            this.right.inorder();
    }

    public void deleteMin(){
        log("Delete min element");
        if (this.left == null && this.right == null){
            this.swapTopRoot(new SkewHeap());
            log("Heap is empty now");
            return;
        }
        if (this.left == null){
            this.swapTopRoot(this.right);
            log("Left of previous root is empty, " + this.root +" is new root");
            return;
        }
        if (this.right == null){
            this.swapTopRoot(this.left);
            log("Right of previous root is empty, " + this.root +" is new root");
            return;
        }
        if (this.right.root > this.left.root){
            log("Left of " + this.root + " is less");
            this.left.merge(this.right);
            this.swapTopRoot(this.left);
            return;
        }
        log("Right of " + this.root + " is less");
        this.right.merge(this.left);
        this.swapTopRoot(this.right);
    }

    public void swapChildrens () {
        SkewHeap swap = this.left;
        this.left = this.right;
        this.right = swap;
    }

    public SkewHeap swapTopRoot(SkewHeap newRoot){
        SkewHeap swaped = new SkewHeap(this.root, this.left, this.right);
        this.root = newRoot.root;
        this.left = newRoot.left;
        this.right = newRoot.right;
        return swaped;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkewHeap)) return false;

        SkewHeap skewHeap = (SkewHeap) o;

        if (root != skewHeap.root) return false;
        if (left != null ? !left.equals(skewHeap.left) : skewHeap.left != null) return false;
        return right != null ? right.equals(skewHeap.right) : skewHeap.right == null;
    }

    @Override
    public int hashCode() {
        int result = root;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }
}
