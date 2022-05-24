import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyBST {
    BSTNode root;
    int size;
    int height = 0;

    public MyBST() {
        size = 0;
        root = null;
    }

    private class BSTNode {
        Integer val;
        BSTNode left, right;

        public BSTNode(Integer val) {
            this.val = val;
            left = right = null;
        }

        @Override
        public String toString() {
            return "" + this.val;
        }
    }

    public int size() {
        return size;
    }

    public void insert(Integer n) {
        if (root == null) {
            root = new BSTNode(n);
            size++;
            return;
        }
        insert(root, n);
        size++;
    }

    private void insert(BSTNode root, Integer num) {
        if (root.val < num) {
            if (root.right == null) {
                root.right = new BSTNode(num);
                return;
            } else {
                insert(root.right, num);
            }
        } else if (root.val > num) {
            if (root.left == null) {
                root.left = new BSTNode(num);
                return;
            } else {
                insert(root.left, num);
            }
        } else {
            return;
        }
        height = height();
    }

    public boolean contains(Integer n) {
        return contains(root, n);
    }

    private boolean contains(BSTNode root, Integer n) {
        if (root == null) {
            return false;
        } else if (root.val == n) {
            return true;
        } else {
            if (root.val > n) {
                return contains(root.left, n);
            }
            return contains(root.right, n);
        }
    }

    public Integer getMax() {
        return getMax(root);
    }

    private Integer getMax(BSTNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root.val;
        }
        return getMax(root.right);
    }

    public Integer getMin() {
        return getMin(root);
    }

    private Integer getMin(BSTNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.val;
        }
        return getMin(root.left);
    }

    public void delete(Integer n) {
        if (size <= 1 && root.val == n) {
            root = null;
            size = 0;
            return;
        }
        delete(root, n);
    }

    private void delete(BSTNode root, Integer n) {
        if (root == null) {
            return;
        } else if (root.val > n) {
            if (root.left == null) {
                return;
            }
            if (root.left.val == n) {
                root.left = replace(root.left.left, root.left.right);
                return;
            }
                delete(root.left,n);
        } else if (root.val < n) {
            if (root.right == null) {
                return;
            }
            if (root.right.val == n) {
                root.right = replace(root.right.left, root.right.right);
                return;
            }
            delete(root.right,n);
        }
        height = height();
    }

    private BSTNode replace(BSTNode nodeLeft, BSTNode nodeRight) {
        size--;
        if (nodeLeft == null && nodeRight == null) {
            return null;
        } else if (nodeLeft == null) {
            return nodeRight;
        } else if (nodeRight == null) {
            return nodeLeft;
        } else {
            BSTNode n = new BSTNode(getMinRep(nodeRight));
            n.left = nodeLeft;
            n.right = nodeRight;
            if(n.val == nodeRight.val){
                n.right = nodeRight.right;
            }
            return n;
        }
    }

    private Integer getMinRep(BSTNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.val;
        }
        Integer n = getMin(root.left);
        if(n!=null){
            root.left = root.left.left;
        }
        return n;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(BSTNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public void print() {
        print(root,0);
    }

    private void print(BSTNode root, int currentHeight) {
        if(root==null){
            return;
        }
        print(root.right,currentHeight+1);
        for(int i=currentHeight*4;i>0;i--) System.out.print(" ");
        System.out.println(root.val);
        print(root.left,currentHeight+1);
    }

    private int height() {
        return height(root, 1);
    }

    private int height(BSTNode root, int level) {
        if (root == null) {
            return level - 1;
        }
        return Math.max(height(root.left, level + 1), height(root.right, level + 1));
    }
}
