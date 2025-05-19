
class Solution(object):
    def rangeSumBST(self, root, low, high):
        self.summ=0
        def traversal(root):
            
            if root==None:

                return 0

            
            traversal(root.left)
            if root.val>=low and root.val<=high:

                self.summ+=root.val

            traversal(root.right)

        traversal(root)
        return self.summ

            
